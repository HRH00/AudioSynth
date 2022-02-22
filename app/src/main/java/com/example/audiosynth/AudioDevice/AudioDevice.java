package com.example.audiosynth.AudioDevice;

import java.util.ArrayList;

class audioDevice {
    private String deviceName;
    private int deviceIndex;

   public audioDevice(String deviceName, int deviceIndex){
       this.deviceIndex = deviceIndex;
       this.deviceName = deviceName;
   }

    public int getId(){
       return (deviceIndex);
   }
   public String getDeviceName(){
       return deviceName;
   }
}
