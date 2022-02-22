/*
 * Copyright  2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

#include <oboe/Oboe.h>
#include "AudioEngine.h"
#include "AudioCallback.h"
#include "logging_macros.h"

static int SAMPLE_RATE = 48000;


AudioEngine::AudioEngine(){
    beginStreams();
}


//I16 signed 16 bit integer, float for AAudio
void AudioEngine::beginStreams() {
    LOGI("beginStreams has been called");
    openInStream();
    if (inStream->getFormat()==oboe::AudioFormat::Float) {
        functionList.emplace<FunctionList<float *>>();
        createCallback<float_t>();
    }else if (inStream->getFormat() == oboe::AudioFormat::I16){
        createCallback<int16_t>();
    }else{
        LOGI("stopStream has been called - REASON: bad oboe audio format");
        stopStreams();
    }

    SAMPLE_RATE = inStream->getSampleRate();
    openOutStream();

    oboe::Result result = startStreams();
    if (result != oboe::Result::OK)
    {
        stopStreams();
        LOGI("stopStreams has been called - REASON: Bad result");
    }
}

template<class numeric>
void AudioEngine::createCallback() {
    LOGI("createCallback has been called");
    mCallback = std::make_unique<AudioCallback<numeric>>(
            *inStream, [&functionStack = this->functionList](numeric *beg, numeric *end) {
                std::get<FunctionList<numeric *>>(functionStack)(beg, end);
            },
                    inStream->getBufferCapacityInFrames(),
                    std::bind(&AudioEngine::beginStreams, this));
}


oboe::AudioStreamBuilder AudioEngine::defaultBuilder() {
    LOGI("defaultBuilder has been called");
    return *oboe::AudioStreamBuilder()
            .setPerformanceMode(oboe::PerformanceMode::LowLatency)
            ->setSharingMode(oboe::SharingMode::Exclusive
              );
}

void AudioEngine::openInStream() {
    LOGI("openInStream has been called");
    defaultBuilder().setDirection(oboe::Direction::Input)
            ->setFormat(oboe::AudioFormat::Unspecified) // For now
            ->setChannelCount(1) // Mono in for effects processing
            ->openManagedStream(inStream);
}

void AudioEngine::openOutStream() {
    LOGI("openOutStream has been called");
    defaultBuilder().setCallback(mCallback.get())
            ->setDeviceId(3)//This is temp - so we can output audio direct to build in mic
            ->setSampleRate(inStream->getSampleRate())
            ->setFormat(inStream->getFormat())
            ->setChannelCount(2) // Stereo out
            ->openManagedStream(outStream);
}

oboe::Result AudioEngine::startStreams() {
    LOGI("startStreams has been called");
    oboe::Result result = outStream->requestStart();
    int64_t timeoutNanos = 500 * 1000000; //1/2 second
    auto currentState = outStream->getState();
    auto nextState = oboe::StreamState::Unknown;
    while (result == oboe::Result::OK && currentState != oboe::StreamState::Started){
        result = outStream->waitForStateChange(currentState, &nextState, timeoutNanos);
        currentState = nextState;
    }
    if (result != oboe::Result::OK) return result;
    return inStream->requestStart();
}

oboe::Result AudioEngine::stopStreams() {
    LOGI("stopStreams has been called");
    oboe::Result outputResult = inStream->requestStop();
    oboe::Result inputResult = outStream->requestStop();
    if (outputResult != oboe::Result::OK) return outputResult;
    return inputResult;
    }