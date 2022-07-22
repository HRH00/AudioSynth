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
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import com.example.audiosynth.databinding.ActivityMainBinding;
import android.media.AudioManager;
import com.example.audiosynth.AudioDevice.*;

public class MainActivity extends AppCompatActivity {
    // Used to load the 'audiosynth' library on application startup.
    static {
        System.loadLibrary("audiosynth");
    }
    private ActivityMainBinding binding;

    @Override public Window getWindow() {
        return super.getWindow();
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
        onOffBtn.setOnClickListener(this::onOffButtonClicked);


    }
    @Override
    protected void onPause() {
        super.onPause();
        AudioEngineController singleton = AudioEngineController.getInstance();
        singleton.stopAudioEngine();
        Button btn = binding.onOffButton;
        btn.setText("Enable Audio Engine");

    }
    protected void onStop() {
        super.onStop();
        AudioEngineController singleton = AudioEngineController.getInstance();
        singleton.stopAudioEngine();
        Button btn = binding.onOffButton;
        btn.setText("Enable Audio Engine");
    }
    protected void onResume() {
        super.onResume();
        AudioEngineController singleton = AudioEngineController.getInstance();
        singleton.stopAudioEngine();
        Button btn = binding.onOffButton;
        btn.setText("Enable Audio Engine");

    }


        public void onOffButtonClicked(View view){
            Log.d("engine java controller", "onOffButtonClicked: ");
        Button onOffBtn = binding.onOffButton;
        AudioEngineController singleton = AudioEngineController.getInstance();
        if (singleton.engineOn==true){
            singleton.stopAudioEngine();
            onOffBtn.setText("Enable Audio Engine");
        }
        else{
            singleton.startAudioEngine();
            onOffBtn.setText("Disable Audio Engine");
            }

        }
        public AudioDeviceLists getDevices(){
            AudioDeviceLists devices = AudioDeviceLists.getInstance();
            devices.setInput((AudioManager) getSystemService(Context.AUDIO_SERVICE));

            return devices;
        }
    }
