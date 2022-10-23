package com.example.tubes1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.tubes1.contract.MainUI;
import com.example.tubes1.databinding.ActivityMainBinding;
import com.example.tubes1.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainUI {
    private ActivityMainBinding binding;
    private HomeFragment hf;
    private MainPresenter mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        hf= new HomeFragment();
        mp = new MainPresenter(this);


    }


    @Override
    public void changePage(String page) {
        FragmentTransaction ft=this.getSupportFragmentManager().beginTransaction();
        this.closeAllPage(ft);
        if(page=="Home"){
            if(this.hf.isAdded()){
                ft.show(this.hf);
            }else{
                Log.d("masuk", "changePage: ");
                ft.add(binding.fragmentContainer.getId(),this.hf);
            }
        }
        ft.commit();
    }

    @Override
    public void closeAllPage(FragmentTransaction ft) {
        if(this.hf.isAdded()){
            ft.hide(this.hf);
        }
    }

    @Override
    public void closeApp() {
        this.moveTaskToBack(true);
        this.finish();
    }
}