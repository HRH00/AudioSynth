package com.example.audiosynth.AudioDevice;

import java.util.ArrayList;

//class for converting int device id to human readable string
public class DeviceInfoToString {

//Converts individual deviceId ints to Device name, returns string value
    public static String deviceTypeToString(int type){
        String outputString = "";
        switch (type){
            case AudioDeviceTypes.TYPE_AUX_LINE:
                outputString = "Aux Port";
                break;
            case AudioDeviceTypes.TYPE_BLE_HEADSET:
                outputString = "Bluetooth Low Energy Headset";
                break;
            case AudioDeviceTypes.TYPE_DOCK:
                outputString = "Audio Dock";
                break;
            case AudioDeviceTypes.TYPE_BLE_SPEAKER:
                outputString = "Bluetooth Low Energy Speaker";
                break;
            case AudioDeviceTypes.TYPE_BLUETOOTH_A2DP:
                outputString = "Bluetooth A2DP";
                break;
            case AudioDeviceTypes.TYPE_BLUETOOTH_SCO:
                outputString = "Bluetooth Telephony";
                break;
            case AudioDeviceTypes.TYPE_BUILTIN_EARPIECE:
                outputString = "Build in Earpiece Speaker";
                break;
            case AudioDeviceTypes.TYPE_BUILTIN_MIC:
                outputString = "Built in Microphone";
                break;
            case AudioDeviceTypes.TYPE_BUILTIN_SPEAKER:
                outputString = "Build in Speaker";
                break;
            case AudioDeviceTypes.TYPE_BUILTIN_SPEAKER_SAFE:
                outputString = "Built in Speaker Safe";
                break;
            case AudioDeviceTypes.TYPE_BUS:
                outputString = "Bus";
                break;
            case AudioDeviceTypes.TYPE_FM:
                outputString = "FM";
                break;
            case AudioDeviceTypes.TYPE_FM_TUNER:
                outputString = "FM Tuner";
                break;
            case AudioDeviceTypes.TYPE_HDMI:
                outputString = "HDMI";
                break;
            case AudioDeviceTypes.TYPE_HDMI_ARC:
                outputString = "HDMI Audio Return Channel";
                break;
            case AudioDeviceTypes.TYPE_HDMI_EARC:
                outputString = "HDMI Enhanced Audio return Channel";
                break;
            case AudioDeviceTypes.TYPE_HEARING_AID:
                outputString = "Hearing Aid";
                break;
            case AudioDeviceTypes.TYPE_IP:
                outputString = "Audio over IP";
                break;
            case AudioDeviceTypes.TYPE_LINE_ANALOG:
                outputString = "Line Analog";
                break;
            case AudioDeviceTypes.TYPE_LINE_DIGITAL:
                outputString = "Line Digital";
                break;
            case AudioDeviceTypes.TYPE_REMOTE_SUBMIX:
                outputString = "Remote Submix";
                break;
            case AudioDeviceTypes.TYPE_USB_ACCESSORY:
                outputString = "USB Accessory";
                break;
            case AudioDeviceTypes.TYPE_TELEPHONY:
                outputString = "Telephony Net";
                break;
            case AudioDeviceTypes.TYPE_UNKNOWN:
                outputString = "Unknown Device";
                break;
            case AudioDeviceTypes.TYPE_TV_TUNER:
                outputString = "TV Tuner";
                break;
            case AudioDeviceTypes.TYPE_USB_DEVICE:
                outputString = "USB Device";
                break;
            case AudioDeviceTypes.TYPE_USB_HEADSET:
                outputString = "USB Headset";
                break;
            case AudioDeviceTypes.TYPE_WIRED_HEADSET:
                outputString = "Wired Headset";
                break;
            case AudioDeviceTypes.TYPE_WIRED_HEADPHONES:
                outputString = "Wired Headphones";
                break;
            default:
                outputString = "Error Unrecognised, DeviceId = " + String.valueOf(type);
        }
        return outputString;
    }

//method for converting ArrayLists<Integer> (deviceId) to ArrayList<String> for human readable format
    public static ArrayList<String> deviceIdListToStringList(ArrayList devList){
        ArrayList<String> listStringOut = new ArrayList<>();
        for (Object device : devList){
            listStringOut.add(deviceTypeToString((Integer) device));
        }
        return listStringOut;
    }

//Takes ArrayList<Integer> of device ids to return a single String containing all text values
// of device name
    public static String deviceIdListToSingleStr(ArrayList intList){
        String stringOut = "";
        ArrayList<String>strList = deviceIdListToStringList(intList);
                for (String deviceName : strList){
            stringOut += deviceName + "\n";
        }
        return stringOut;
    }
}
