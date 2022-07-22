package com.example.audiosynth.AudioDevice;

import android.media.AudioManager;

import com.example.audiosynth.AudioEngineController;

import java.util.ArrayList;

public class AudioDeviceLists {
    public ArrayList inputId;
    public ArrayList outputId;
    public ArrayList inputStringNames;
    public ArrayList outputStringNames;
    private static AudioDeviceLists single_instance = null;

    public static AudioDeviceLists getInstance() {
        if (single_instance == null) {
            single_instance = new AudioDeviceLists();
        }
        return single_instance;
    }
    public void setInput(AudioManager a){
        this.inputId=AudioDeviceId.getAvailableInputDevices(a);
        this.outputId=AudioDeviceId.getAvailableOutputDevices(a);;
        this.inputStringNames=DeviceInfoToString.deviceIdListToStringList(inputId);
        this.outputStringNames=DeviceInfoToString.deviceIdListToStringList(outputId);
    }
    public int returnInputDevice(int index){
        int output = (int) inputId.get(index);
        return output;
    }
    public int returnOutputDevice(int index){
        int output = (int) outputId.get(index);
        return output;
    }
}
