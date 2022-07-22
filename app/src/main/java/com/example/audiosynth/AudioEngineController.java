package com.example.audiosynth;
import android.util.Log;

public class AudioEngineController {
    // Static variable reference of single_instance
    // of type Singleton
    private static AudioEngineController single_instance = null;
    public static boolean distortionOn = false;
    public static boolean engineOn = false;
    public static int inputDevice = -1;
    public static int outputDevice = -1;
    // Constructor
    // Here we will be creating private constructor
    // restricted to this class itself
    public AudioEngineController(){}

    // Static method
    // Static method to create instance of Singleton class
    public static AudioEngineController getInstance()
    {
        if (single_instance == null)
            single_instance = new AudioEngineController();
        return single_instance;
    }



    public void startAudioEngine() {
        createAudioEngine();
        engineOn=true;
      //  if ((inputDevice == -1) | (outputDevice == -1)) {
      //    engineOn = true;
      //    createAudioEngine();//default input output devices of both are
      //}//not defined
      //else {//once devices have been selected
      //    createAudioEngineWithDevices(inputDevice, outputDevice);
      //}
    }

    private void createAudioEngineWithDevices(int inputDevice, int outputDevice) {
         createAudioEngineWithDevices();
    }

    public void stopAudioEngine(){
        destroyAudioEngine();
        engineOn = false;
    }

    public void updateInputDevice(int in){
        this.inputDevice=in;
    }
    public void updateOutputDevice(int in){
        this.outputDevice=in;
    }
    public int getOutputDevice(){return this.outputDevice;}
    public int getInputDevice(){return this.inputDevice;}

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
    public native void createAudioEngineWithDevices();

}



