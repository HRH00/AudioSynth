
/*
 * Copyright 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
#include <jni.h>
#include "string"
#include "logging_macros.h"
#include "AudioEngine.h"

// JNI Utility functions and globals
static AudioEngine *enginePtr = nullptr;


extern "C" {
JNIEXPORT jstring JNICALL
Java_com_example_audiosynth_MainActivity_stringFromJNI(JNIEnv *env, jobject   /*this*/) {
    // TODO: implement stringFromJNI()
    std::string hello = "Hello from C++";
    LOGI("stringFromJni has been Called");
    return env->NewStringUTF(hello.c_str());
}


JNIEXPORT void JNICALL
Java_com_example_audiosynth_MainActivity_createAudioEngine(JNIEnv *env, jobject /*this*/) {
    LOGI("startAudioEngine has been Called");
    enginePtr = new AudioEngine();
}

JNIEXPORT void JNICALL
Java_com_example_audiosynth_MainActivity_destroyAudioEngine(JNIEnv *env, jobject /*this*/) {
    if (!enginePtr) return;
    delete enginePtr;
    enginePtr = nullptr;
    LOGI("destroyAudioEngine has been Called");
}

JNIEXPORT void JNICALL
Java_com_example_audiosynth_MainActivity_enablePassthroughNative(
        JNIEnv *env, jobject /*this*/) {

    LOGI("enablePassthroughNative has been called");
    if (!enginePtr) return;
    std::visit([enable = static_cast<bool>(true)](auto &&args) {
        args.mute(!enable);
    }, enginePtr->functionList);
}



//Unused method 01/02/2022
JNIEXPORT void JNICALL
Java_com_example_audiosynth_MainActivity_disablePassthroughNative(JNIEnv *env, jobject /*this*/) {
// TODO: implement disablePassthroughNative()
    LOGI("disablePassthroughNative has been called");
    if (!enginePtr) return;
    std::visit([enable = static_cast<bool>(true)](auto &&args) {
        args.mute(enable);
    }, enginePtr->functionList);
}
}
