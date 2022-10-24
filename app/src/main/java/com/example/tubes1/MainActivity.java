package com.example.tubes1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;


import android.Manifest;
import android.os.Bundle;

import com.example.tubes1.contract.MainUI;
import com.example.tubes1.databinding.ActivityMainBinding;
import com.example.tubes1.presenter.MainPresenter;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements MainUI{
    private ActivityMainBinding binding;
    private HomeFragment hf;
    private FormPertemuanFragment fpf;
    private MainPresenter mp;
    public static final int WRITE_REQUEST_CODE =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        hf= new HomeFragment();
        fpf= new FormPertemuanFragment();
        mp = new MainPresenter(this);
        hf.setMp(mp);
        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        this.requestPermissions(permissions,WRITE_REQUEST_CODE);
        this.getSupportFragmentManager().setFragmentResultListener(
                "changePage", this,new FragmentResultListener(){
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result){
                        String page = result.getString("page");
                        changePage(page);
                        binding.drawerLayout.closeDrawers();
                    }


                }
        );
        this.getSupportFragmentManager().setFragmentResultListener(
                "closeApp", this,new FragmentResultListener(){
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result){
                        closeApp();
                    }


                }
        );

    }


    @Override
    public void changePage(String page) {
        FragmentTransaction ft=this.getSupportFragmentManager().beginTransaction();
        this.closeAllPage(ft);
        switch(page){
            case "Pertemuan Form":
                if(this.fpf.isAdded()){
                    ft.show(this.fpf);
                }else{
                    ft.add(binding.fragmentContainer.getId(),this.fpf).addToBackStack(null);
                }
                break;
            default:
                if(this.hf.isAdded()){
                    ft.show(this.hf);
                }else{
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
        if(this.fpf.isAdded()){
            ft.hide(this.fpf);
        }
    }

    @Override
    public void closeApp() {
        this.moveTaskToBack(true);
        this.finish();
    }


}