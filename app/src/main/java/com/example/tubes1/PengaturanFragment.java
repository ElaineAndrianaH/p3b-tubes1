package com.example.tubes1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import com.example.tubes1.databinding.PengaturanBinding;

public class PengaturanFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {
    private PengaturanBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = PengaturanBinding.inflate(inflater, container, false);

        //binding.btSwitch.setChecked(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_NO);
        int currentNightMode = getResources().getConfiguration().uiMode;
        Log.d(currentNightMode+"", "onCreateView: ");
        binding.btSwitch.setChecked(currentNightMode==33);
        binding.btSwitch.setOnCheckedChangeListener(this);
        return binding.getRoot();


    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

}
