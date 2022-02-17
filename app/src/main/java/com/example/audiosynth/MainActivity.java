package com.example.audiosynth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.example.audiosynth.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private int MY_PERMISSIONS_RECORD_AUDIO=17;

    // Used to load the 'audiosynth' library on application startup.
    static {
        System.loadLibrary("audiosynth");
    }


    private ActivityMainBinding binding;

    @Override public Window getWindow() {
        return super.getWindow();
    }

    @Override public void onResume(){
        super.onResume();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED
        ){
            createAudioEngine();
            enablePassthroughNative();
        }
    }
    @Override public void onPause() {
        destroyAudioEngine();
        super.onPause();
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

// Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());
// Navigation
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_main, R.id.nav_tuner, R.id.nav_settings)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
// Navigation end
// Permissions & window flag statement
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{(Manifest.permission.RECORD_AUDIO)}, MY_PERMISSIONS_RECORD_AUDIO);
        }
// Permissions end

// My native Calls
        createAudioEngine();
        enablePassthroughNative();
    }

    /**
     * A native method that is implemented by the 'audiosynth' native library,
     * which is packaged with this application.
     */
//Native Methods Declarations
    public native void createAudioEngine();
    public native String stringFromJNI();
    public native void destroyAudioEngine();
    public native void enablePassthroughNative();
//    public native void disablePassthroughNative();
}