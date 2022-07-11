package com.example.audiosynth.fragments.settings;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.audiosynth.MainActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.audiosynth.R;

import java.util.ArrayList;

public class SettingsFragment extends Fragment {

    private SettingsViewModel mViewModel;
    private Spinner inputSpinner;
    private Spinner outputSpinner;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }
}