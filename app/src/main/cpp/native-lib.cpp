
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
#include "AudioCallback.h"

// JNI Utility functions and globals
static AudioEngine *enginePtr = nullptr;
//static AudioCallback dist


extern "C"{
JNIEXPORT void JNICALL
Java_com_example_audiosynth_AudioEngineController_destroyAudioEngine(JNIEnv *env, jobject thiz) {
    if (!enginePtr) return;
    delete enginePtr;
    enginePtr = nullptr;
    LOGI("destroyAudioEngine has been Called");
}}

extern "C"{
JNIEXPORT void JNICALL
Java_com_example_audiosynth_AudioEngineController_createAudioEngine(JNIEnv *env, jobject thiz) {
    LOGI("startAudioEngine has been Called");
    enginePtr = new AudioEngine();
}}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_audiosynth_AudioEngineController_enableDistortion(JNIEnv *env, jobject thiz) {
    LOGI("enableDistortion has been Called");

}
extern "C"
JNIEXPORT void JNICALL
Java_com_example_audiosynth_AudioEngineController_disableDistortion(JNIEnv *env, jobject thiz) {
    LOGI("disableDistortion has been Called");

}
extern "C"
JNIIMPORT void JNICALL
Java_com_example_audiosynth_AudioEngineController_streamDisconnected(JNIEnv *env, jobject thiz) {
    //TODO
    //jclass local_class = env->FindClass("com/example/audiosynth/AudioEngineController");
    //jobject local_object = env->CallObjectMethod("AudioEngineController");

    // MUST cleanup local references since these references were not given to you by the JVM, but rather created by you in native code.

    //env->DeleteLocalRef(local_object);
   // env->DeleteLocalRef(local_class);

    // TODO: implement streamDisconnected()
}