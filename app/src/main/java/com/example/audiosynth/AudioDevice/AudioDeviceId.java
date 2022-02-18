package com.example.audiosynth.AudioDevice;

import android.media.AudioManager;
import android.media.AudioDeviceInfo;

import java.util.ArrayList;



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
            for (AudioDeviceInfo deviceInfo : audioManager.getDevices(AudioManager.GET_DEVICES_INPUTS)) {
                deviceList.add(deviceInfo.getId());
            }
        }
        return deviceList;
    }
}

