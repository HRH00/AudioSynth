# AudioSynth
This project aims to bring low latency (realtime) guitar effect synthesis to Android devices.
The project takes advantage of the oboe C++ audio wrapper library to achieve low latency audio.

This app should be able to support any kind of audio interface which your mobile device supports, 
including digital and analogue audio interfaces. USB Digital to Analogue converters are preferred for 
higher quality audio conversions with lower latency.

At this time it is not recommended to use this application with bluetooth devices, due to the enormous
amount of latency it introduces.

The Oboe C++ library is built from source in this project, to run this project yourself clone the oboe repo from https://github.com/google/oboe
and set the path of oboe's root folder on your local machine using CMkakeLists.txt 
FOR EXAMPLE  'set(OBOE_DIR C:/your/Directory/Here)'

- HRH00
- https://github.com/HRH00
