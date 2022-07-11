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
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
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

    //global variables for touch events and audio controller
    boolean engineOn = false;
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
        ArrayList<String> strListAudioOutDevices;
        ArrayList<String> strListAudioInDevices;
        TextView tv = binding.sampleText;
        Button onOffBtn = binding.onOffButton;
        Button deviceBtn = binding.switchTextbutton;

        listButtonClicked = !listButtonClicked;

        if (listButtonClicked){
            ArrayList audioOutDevices = AudioDeviceId.getAvailableOutputDevices((AudioManager) getSystemService(Context.AUDIO_SERVICE));
            strListAudioOutDevices = DeviceInfoToString.deviceIdListToStringList(audioOutDevices);
            fillDropdown(strListAudioOutDevices, audioOutDevices);//fills the drop down element\

            //Adds a Title
            deviceBtn.setText("VIEW INPUT DEVICES");
            tv.setText("AVAILABLE INPUT DEVICES\n" + DeviceInfoToString.deviceIdListToSingleStr(audioOutDevices));
        }

        else{
            ArrayList audioInDevices = AudioDeviceId.getAvailableInputDevices((AudioManager) getSystemService(Context.AUDIO_SERVICE));
            strListAudioInDevices = DeviceInfoToString.deviceIdListToStringList(audioInDevices);
            fillDropdown(strListAudioInDevices, audioInDevices);//fills the drop down element\
            tv.setText("AVAILABLE INPUT DEVICES\n" +DeviceInfoToString.deviceIdListToSingleStr(audioInDevices));
            deviceBtn.setText("VIEW OUTPUT DEVICES");




        }
    }



    public void fillDropdown(ArrayList idNameString, ArrayList IdIntList){
        //Spinner Filler
        Spinner dropdown  = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, idNameString);
        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int index, long l) {
                Log.d("Dropdown", String.valueOf(index));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //do nothing
            }
        });}

    public void onOffButtonClicked(View view){
        Button onOffBtn = binding.onOffButton;
        engineOn = !engineOn;
        if (engineOn==false){
            Log.d("Button","Button  clicked");

            AudioEngineController singleton = AudioEngineController.getInstance();
            singleton.destroyAudioEngine();
            onOffBtn.setText("Enable Audio Engine");
        }
        else{
            AudioEngineController singleton = AudioEngineController.getInstance();
            singleton.createAudioEngine();
            onOffBtn.setText("Disable Audio Engine");
        }
    }

    @Override public void onResume(){
        super.onResume();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED){

            Log.d("ME","RESUME HAS RUN");
        }
    }
    @Override public void onPause() {
        super.onPause();
        Button onOffBtn = binding.onOffButton;
        onOffBtn.setText("Enable Audio Engine");
        AudioEngineController singleton = AudioEngineController.getInstance();
        singleton.destroyAudioEngine();
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

    //Set the start audio engine button text to correct string
        Button onOffBtn = binding.onOffButton;
        onOffBtn.setText("Enable Audio Engine");
    }

    public void cycleDistortion(View view) {
        AudioEngineController singleton = AudioEngineController.getInstance();
        singleton.cycleDistortion();
    }
}