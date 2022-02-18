package com.example.audiosynth.AudioDevice;

import java.util.ArrayList;

public class DeviceInfoToString {
    public static String deviceTypeToString(int type){
        switch (type){
            case AudioDeviceTypes.TYPE_AUX_LINE:
                return "Aux Port";
            case AudioDeviceTypes.TYPE_BLE_HEADSET:
                return "Bluetooth Low Energy Headset";
            case AudioDeviceTypes.TYPE_DOCK:
                return "Audio Dock";
            case AudioDeviceTypes.TYPE_BLE_SPEAKER:
                return "Bluetooth Low Energy Speaker";
            case AudioDeviceTypes.TYPE_BLUETOOTH_A2DP:
                return "Bluetooth A2DP";
            case AudioDeviceTypes.TYPE_BLUETOOTH_SCO:
                return "Bluetooth Telephony";
            case AudioDeviceTypes.TYPE_BUILTIN_EARPIECE:
                return "Build in Earpiece Speaker";
            case AudioDeviceTypes.TYPE_BUILTIN_MIC:
                return "Built in Microphone";
            case AudioDeviceTypes.TYPE_BUILTIN_SPEAKER:
                return "Build in Speaker";
            case AudioDeviceTypes.TYPE_BUILTIN_SPEAKER_SAFE:
                return "Built in Speaker Safe";
            case AudioDeviceTypes.TYPE_BUS:
                return "Bus";
            case AudioDeviceTypes.TYPE_FM:
                return "FM";
            case AudioDeviceTypes.TYPE_FM_TUNER:
                return "FM Tuner";
            case AudioDeviceTypes.TYPE_HDMI:
                return "HDMI";
            case AudioDeviceTypes.TYPE_HDMI_ARC:
                return "HDMI Audio Return Channel";
            case AudioDeviceTypes.TYPE_HDMI_EARC:
                return "HDMI Enhanced Audio Return Channel";
            case AudioDeviceTypes.TYPE_HEARING_AID:
                return "Hearing Aid";
            case AudioDeviceTypes.TYPE_IP:
                return "Audio over IP";
            case AudioDeviceTypes.TYPE_LINE_ANALOG:
                return "Line Analog";
            case AudioDeviceTypes.TYPE_LINE_DIGITAL:
                return "Line Digital";
            case AudioDeviceTypes.TYPE_REMOTE_SUBMIX:
                return "Remote Submix";
            case AudioDeviceTypes.TYPE_USB_ACCESSORY:
                return "USB Accessory";
            case AudioDeviceTypes.TYPE_TELEPHONY:
                return "Telephony Net";
            case AudioDeviceTypes.TYPE_UNKNOWN:
                return "Unknown Device";
            case AudioDeviceTypes.TYPE_TV_TUNER:
                return "TV Tuner";
            case AudioDeviceTypes.TYPE_USB_DEVICE:
                return "USB Device";
            case AudioDeviceTypes.TYPE_USB_HEADSET:
                return "USB Headset";
            case AudioDeviceTypes.TYPE_WIRED_HEADSET:
                return "Wired Headset";
            case AudioDeviceTypes.TYPE_WIRED_HEADPHONES:
                return "Wired Headphones";
            default:
                return "Error, Unrecognised Device in List";


        }
    }
    public static ArrayList<String> deviceListToString(ArrayList<Integer> devList){
        ArrayList<String> stringOut = new ArrayList<>();
        for (Integer device : devList){
            stringOut.add(deviceTypeToString(device));
        }
        return stringOut;
    }
}
