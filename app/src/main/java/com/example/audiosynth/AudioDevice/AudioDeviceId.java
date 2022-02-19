package com.example.audiosynth.AudioDevice;

import android.media.AudioManager;
import android.media.AudioDeviceInfo;
import java.util.ArrayList;


//This Class contains methods which are passed an Audio manager Object, which also passes the Main
//Activity Context to the methods without the need for inheritance (ie class a extends b).
//The methods then use the AudioManager class to return ArrayLists of connect audio device Ids
public class AudioDeviceId {

    public static ArrayList<Integer> getAvailableInputDevices(AudioManager audioManager) {
        ArrayList<Integer> deviceList = new ArrayList<>();
        if (audioManager != null) {
           for (AudioDeviceInfo deviceInfo : audioManager.getDevices(AudioManager.GET_DEVICES_INPUTS)) {
                deviceList.add(deviceInfo.getId());
            }
        }
        return deviceList;
    }
    public static ArrayList<Integer> getAvailableOutputDevices(AudioManager audioManager) {
        ArrayList<Integer> deviceList = new ArrayList<>();
        if (audioManager != null) {
            for (AudioDeviceInfo deviceInfo : audioManager.getDevices(AudioManager.GET_DEVICES_OUTPUTS)) {
                deviceList.add(deviceInfo.getId());
            }
        }
        return deviceList;
    }
}

