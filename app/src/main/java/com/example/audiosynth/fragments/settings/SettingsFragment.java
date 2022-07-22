package com.example.audiosynth.fragments.settings;
import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.example.audiosynth.AudioDevice.AudioDeviceLists;
import com.example.audiosynth.AudioEngineController;
import com.example.audiosynth.MainActivity;
import com.example.audiosynth.R;
import java.util.ArrayList;


public class SettingsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.settings_fragment, parent, false);
    }
    @Override
    public void onResume() {
        super.onResume();
        fillDropdowns();
    }

    public void fillDropdowns() {
        //Spinner Filler
        AudioDeviceLists deviceLists = null;
        ArrayList outStr = null;
        ArrayList inStr = null;

        Activity mainAct = getActivity();
        if (mainAct instanceof MainActivity) {
            deviceLists = ((MainActivity) mainAct).getDevices();
        }
        outStr = deviceLists.outputStringNames;
        inStr = deviceLists.inputStringNames;

        Spinner InputDropdown = getView().findViewById(R.id.InputSpinner);
        Spinner OutputDropdown = getView().findViewById(R.id.OutputSpinner);
        if (inStr != null) {
            ArrayAdapter<String> inadapter = new ArrayAdapter<String>((getActivity().getBaseContext()), R.layout.support_simple_spinner_dropdown_item, inStr);
            InputDropdown.setAdapter(inadapter);
        }
        if (outStr != null) {
            ArrayAdapter<String> outadapter = new ArrayAdapter<String>((getActivity().getBaseContext()), R.layout.support_simple_spinner_dropdown_item, outStr);
            OutputDropdown.setAdapter(outadapter);
        }
        AudioDeviceLists finalDeviceLists = deviceLists;

        InputDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                AudioEngineController singleton = AudioEngineController.getInstance();
                singleton.updateInputDevice(finalDeviceLists.returnInputDevice((i)));
                Log.d("OnItemSelected", "Item Selected");
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.d("OnItemSelected", "Nothing Selected");
            //Do nothing
            }
        });
        OutputDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                AudioEngineController singleton = AudioEngineController.getInstance();
                singleton.updateOutputDevice(finalDeviceLists.returnOutputDevice((i)));
                Log.d("OnItemSelected", "Item Selected");
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.d("OnItemSelected", "Nothing Selected");
                //Do nothing
            }
        });
    }
}