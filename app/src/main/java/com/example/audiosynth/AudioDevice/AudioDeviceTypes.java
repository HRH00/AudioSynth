package com.example.audiosynth.AudioDevice;

//This entire class is dedicated to Defining int types to names of Audio Devices as as per the
// AudioDeviceInformation Documentation (below)
//Data Source - https://developer.android.com/reference/android/media/AudioDeviceInfo
public final class AudioDeviceTypes {
    public static final int TYPE_AUX_LINE = 19;
    //A device type describing the auxiliary line-level connectors.
    //
    //Constant Value: 19 (0x00000013)
    public static final int TYPE_BLE_HEADSET = 26;
    //A device type describing a Bluetooth Low Energy (BLE) audio headset or headphones. Headphones
    // are grouped with headsets when the device is a sink: the features of headsets and headphones
    // with regard to playback are the same.
    //
    //Constant Value: 26 (0x0000001a)
    public static final int TYPE_BLE_SPEAKER = 27;
    //A device type describing a Bluetooth Low Energy (BLE) audio speaker.
    //
    //Constant Value: 27 (0x0000001b)
    public static final int TYPE_BLUETOOTH_A2DP = 8;
    //A device type describing a Bluetooth device supporting the A2DP profile.
    //
    //Constant Value: 8 (0x00000008)
    public static final int TYPE_BLUETOOTH_SCO = 7;
    //A device type describing a Bluetooth device typically used for telephony.
    //
    //Constant Value: 7 (0x00000007)
    public static final int TYPE_BUILTIN_EARPIECE = 1;
    //A device type describing the attached earphone speaker.
    //
    //Constant Value: 1 (0x00000001)
    public static final int TYPE_BUILTIN_MIC = 15;
    //A device type describing the microphone(s) built in a device.
    //
    //Constant Value: 15 (0x0000000f)
    public static final int TYPE_BUILTIN_SPEAKER = 2;
    //A device type describing the speaker system (i.e. a mono speaker or stereo speakers) built in
    // a device.
    //
    //Constant Value: 2 (0x00000002)
    public static final int TYPE_BUILTIN_SPEAKER_SAFE = 24;
    //A device type describing the speaker system (i.e. a mono speaker or stereo speakers) built in
    //a device, that is specifically tuned for outputting sounds like notifications and alarms
    // (i.e. sounds the user couldn't necessarily anticipate).
    //
    //Note that this physical audio device may be the same as TYPE_BUILTIN_SPEAKER but is driven
    // differently to safely accommodate the different use case.
    //
    //Constant Value: 24 (0x00000018)
    public static final int TYPE_BUS = 21;
    //A type-agnostic device used for communication with external audio systems
    //
    //Constant Value: 21 (0x00000015)
    public static final int TYPE_DOCK = 13;
    //A device type describing the audio device associated with a dock.
    //
    //Constant Value: 13 (0x0000000d)
    //
    //TYPE_FM
    public static final int TYPE_FM = 14;
    //A device type associated with the transmission of audio signals over FM.
    //
    //Constant Value: 14 (0x0000000e)
    public static final int TYPE_FM_TUNER = 16;
    //A device type for accessing the audio content transmitted over FM.
    //
    //Constant Value: 16 (0x00000010)
    public static final int TYPE_HDMI = 9;
    //A device type describing an HDMI connection .
    //
    //Constant Value: 9 (0x00000009)
    public static final int TYPE_HDMI_ARC = 10;
    //A device type describing the Audio Return Channel of an HDMI connection.
    //
    //Constant Value: 10 (0x0000000a)
    public static final int TYPE_HDMI_EARC = 29;
    //A device type describing the Enhanced Audio Return Channel of an HDMI connection.
    //
    //Constant Value: 29 (0x0000001d)
    public static final int TYPE_HEARING_AID = 23;
    //A device type describing a Hearing Aid.
    //
    //Constant Value: 23 (0x00000017)
    public static final int TYPE_IP = 20;
    //A device type connected over IP.
    //
    //Constant Value: 20 (0x00000014)
    public static final int TYPE_LINE_ANALOG = 5;
    //A device type describing an analog line-level connection.
    //
    //Constant Value: 5 (0x00000005)
    public static final int TYPE_LINE_DIGITAL = 6;
    //A device type describing a digital line connection (e.g. SPDIF).
    //
    //Constant Value: 6 (0x00000006)
    public static final int TYPE_REMOTE_SUBMIX = 25;
    //A device type for rerouting audio within the Android framework between mixes and system
    // applications. This type is for instance encountered when querying the output device of a
    //track (with AudioTrack#getRoutedDevice() playing from a device in screen mirroring mode,
    // where the audio is not heard on the device, but on the remote device.
    //
    //Constant Value: 25 (0x00000019)
    public static final int TYPE_TELEPHONY = 18;
    //A device type describing the transmission of audio signals over the telephony network.
    //
    //Constant Value: 18 (0x00000012)
    public static final int TYPE_TV_TUNER = 17;
    //A device type for accessing the audio content transmitted over the TV tuner system.
    //
    //Constant Value: 17 (0x00000011)
    public static final int TYPE_UNKNOWN = 0;
    //A device type associated with an unknown or uninitialized device.
    //
    //Constant Value: 0 (0x00000000)
    public static final int TYPE_USB_ACCESSORY = 12;
    //A device type describing a USB audio device in accessory mode.
    //
    //Constant Value: 12 (0x0000000c)
    public static final int TYPE_USB_DEVICE = 11;
    //A device type describing a USB audio device.
    //
    //Constant Value: 11 (0x0000000b)
    public static final int TYPE_USB_HEADSET = 22;
    //A device type describing a USB audio headset.
    //
    //Constant Value: 22 (0x00000016)
    public static final int TYPE_WIRED_HEADPHONES = 4;
    //A device type describing a pair of wired headphones.
    //
    //Constant Value: 4 (0x00000004)
    public static final int TYPE_WIRED_HEADSET = 3;
    //A device type describing a headset, which is the combination of a headphones and microphone.
    //
    //Constant Value: 3 (0x00000003)
}
