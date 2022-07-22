#include <jni.h>
#include "string"
#include "logging_macros.h"
#include "AudioEngine.h"
#include "AudioCallback.h"

// JNI Utility functions and globals
static AudioEngine *enginePtr = nullptr;

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
extern "C"{
JNIEXPORT void JNICALL
Java_com_example_audiosynth_AudioEngineController_destroyAudioEngine(JNIEnv *env, jobject thiz) {
    if (!enginePtr) return;
    delete enginePtr;
    enginePtr = nullptr;
    LOGI("destroyAudioEngine has been Called");
}}

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
extern "C"
JNIEXPORT void JNICALL
Java_com_example_audiosynth_AudioEngineController_createAudioEngineWithDevices(JNIEnv *env,
                                                                               jobject thiz) {
    // TODO: implement createAudioEngineWithDevices()
}