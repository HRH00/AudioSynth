package com.example.audiosynth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.audiosynth.databinding.ActivityMainBinding;
import android.media.AudioManager;
import com.example.audiosynth.AudioDevice.*;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    //temp global variables for touch event driven methods
    boolean buttonClicked = false;
    boolean listButtonClicked = false;

    // Used to load the 'audiosynth' library on application startup.
    static {
        System.loadLibrary("audiosynth");
    }


    private ActivityMainBinding binding;

    @Override public Window getWindow() {
        return super.getWindow();
    }



//Find and output as string to tv - Audio devices
//used to pass the array list of devices, and pass the activity's context. Variables are an arraylist of audio device ob
//gets and sets tv to string of input device names, from device ids
    public void onClickDisplayOutStr(View view){
        String strAudioOutDevices;
        String strAudioInDevices;
        TextView tv = binding.sampleText;
        Button btn = binding.switchTextbutton;


        listButtonClicked = !listButtonClicked;

        if (listButtonClicked){
            ArrayList audioOutDevices = AudioDeviceId.getAvailableOutputDevices((AudioManager) getSystemService(Context.AUDIO_SERVICE));
            strAudioOutDevices = DeviceInfoToString.deviceIdListToSingleStr(audioOutDevices);
            //Adds a Title
            strAudioOutDevices= "AVAILABLE OUTPUT DEVICES\n" + strAudioOutDevices;
            tv.setText(strAudioOutDevices);
            btn.setText("VIEW INPUT DEVICES");

            //fillDropdown(audioInDevices,audioInDevices);
        }
        else{
            ArrayList audioInDevices = AudioDeviceId.getAvailableInputDevices((AudioManager) getSystemService(Context.AUDIO_SERVICE));
            strAudioInDevices = DeviceInfoToString.deviceIdListToSingleStr(audioInDevices);
            strAudioInDevices= "AVAILABLE INPUT DEVICES\n" + strAudioInDevices;
            tv.setText(strAudioInDevices);
            btn.setText("VIEW OUTPUT DEVICES");
        }
    }



    public void fillDropdown(ArrayList idNameString, ArrayList IdIntList){
        //Spinner Filler
        Spinner dropdown  = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, IdIntList);
        dropdown.setAdapter(adapter);
        }

    public void onOffButtonClicked(View view){
        Button btn = binding.onOffButton;
        buttonClicked = !buttonClicked;
        if (buttonClicked){
            destroyAudioEngine();
            btn.setText("Enable Audio Engine");
        }
        else{
            btn.setText("Disable Audio Engine");
            createAudioEngine();
            enablePassthroughNative();

        }
    }

    @Override public void onResume(){
        super.onResume();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED){
            createAudioEngine();
        }
    }
    @Override public void onPause() {
        destroyAudioEngine();
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final int MY_PERMISSIONS_RECORD_AUDIO = 17;
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    // Navigation
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_main, R.id.nav_tuner, R.id.nav_settings)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    // Navigation end




    // Permissions Record Audio & window flag statement
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{(Manifest.permission.RECORD_AUDIO)}, MY_PERMISSIONS_RECORD_AUDIO);
        }
    // Permissions end





    // Native Calls to start audio engine
        createAudioEngine();
        enablePassthroughNative();
    //End native Calls







    }



    /**
     * A native method that is implemented by the 'audiosynth' native library,
     * which is packaged with this application.
     */
//Native Methods Declarations
    public native void createAudioEngine();
    public native void destroyAudioEngine();
    public native void enablePassthroughNative();



}