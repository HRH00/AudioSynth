package com.example.audiosynth.AudioDevice;

public class DeviceId {

    public static int[] getTest(){
        int[] intArray = new int[4];
        intArray[0]=11;
        intArray[1]=12;
        intArray[2]=13;
        intArray[3]=14;
        return intArray;
    }

    public static int[] getAvailableDeviceTypes(){
        return new int[1];
    }
}
