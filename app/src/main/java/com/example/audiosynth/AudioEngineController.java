package com.example.audiosynth;

import android.util.Log;

public class AudioEngineController {

    // Static variable reference of single_instance
    // of type Singleton
    private static AudioEngineController single_instance = null;
    private static boolean distortionOn = false;
    private static boolean engineOn = false;
    // Constructor
    // Here we will be creating private constructor
    // restricted to this class itself
    private AudioEngineController(){}

    // Static method
    // Static method to create instance of Singleton class
    public static AudioEngineController getInstance()
    {
        if (single_instance == null)
            single_instance = new AudioEngineController();
        return single_instance;
    }

    public void startAudioEngine(){
        createAudioEngine();
        engineOn = true;
    }

    public void stopAudioEngine(){
        destroyAudioEngine();
        engineOn = false;
    }

    public void cycleDistortion(){
        distortionOn=!distortionOn;
        Log.d("Distortion", "Distortion value is "+String.valueOf(distortionOn));
        if (distortionOn){enableDistortion();}
        else {disableDistortion();}
    }

    public void disconnect(){
    }

    //import native methods from JNI
    public native void createAudioEngine();
    public native void destroyAudioEngine();
    public native void enableDistortion();
    public native void disableDistortion();
    public native void streamDisconnected();
}



