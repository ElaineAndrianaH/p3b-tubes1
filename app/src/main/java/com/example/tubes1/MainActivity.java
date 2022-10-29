package com.example.tubes1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import com.example.tubes1.contract.MainUI;
import com.example.tubes1.databinding.ActivityMainBinding;
import com.example.tubes1.databinding.DaftarPertemuanBinding;
import com.example.tubes1.presenter.MainPresenter;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements MainUI{
    private ActivityMainBinding binding;
//    private HomeFragment hf;
//    private FormPertemuanFragment fpf;
   private MainPresenter mp;
//    private DokterFragment df;
//    private PertemuanFragment pf;
//    private FormDokterFragment fd;
    public static final int WRITE_REQUEST_CODE =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        df=new DokterFragment();
//        hf= new HomeFragment();
//        fpf= new FormPertemuanFragment();
//        pf= new PertemuanFragment();
//        fd = new FormDokterFragment();
        mp = new MainPresenter(this);
//        hf.setMp(mp);
        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE};
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){

            this.requestPermissions(permissions,WRITE_REQUEST_CODE);
        }
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
//        this.closeAllPage(ft);
        switch(page){
            case "Dokter Form":
                ft.replace(binding.fragmentContainer.getId(),new FormDokterFragment());
                ft.addToBackStack(null);
//                if(this.fd.isAdded()){
//                    this.fd.loadData();
//                    ft.show(this.fd);
//                }else{
//                    ft.add(binding.fragmentContainer.getId(),this.fd).addToBackStack(null);
//                }
                break;
            case "Pertemuan Form":
                ft.replace(binding.fragmentContainer.getId(),new FormPertemuanFragment());
                ft.addToBackStack(null);
//                if(this.fpf.isAdded()){
//                    ft.show(this.fpf);
//                }else{
//                    ft.add(binding.fragmentContainer.getId(),this.fpf).addToBackStack(null);
//                }
                break;
            case "Dokter":
                ft.replace(binding.fragmentContainer.getId(),new DokterFragment());
                ft.addToBackStack(null);
//                if(this.df.isAdded()){
//                    this.df.loadData();
//                    ft.show(this.df);
//                }else{
//                    ft.add(binding.fragmentContainer.getId(),this.df).addToBackStack(null);
//                }
                break;
            case "Pertemuan":
                ft.replace(binding.fragmentContainer.getId(),new PertemuanFragment());
                ft.addToBackStack(null);
//                if(this.pf.isAdded()){
//                    ft.show(this.pf);
//                }else{
//                    ft.add(binding.fragmentContainer.getId(),this.pf).addToBackStack(null);
//                }
                break;
            default:
                ft.replace(binding.fragmentContainer.getId(),new HomeFragment(mp));
                ft.addToBackStack(null);
//                if(this.hf.isAdded()){
//                    ft.show(this.hf);
//                }else{
//                    ft.add(binding.fragmentContainer.getId(),this.hf);
//                }
        }

        ft.commit();
    }

//    @Override
//    public void closeAllPage(FragmentTransaction ft) {
//        if(this.hf.isAdded()){
//            ft.hide(this.hf);
//        }
//        if(this.fpf.isAdded()){
//            ft.hide(this.fpf);
//        }
//        if(this.df.isAdded()){
//            ft.hide(this.df);
//        }
//        if(this.pf.isAdded()){
//            ft.hide(this.pf);
//        }
//        if(this.fd.isAdded()){
//            ft.hide(this.fd);
//        }
//    }

    @Override
    public void closeApp() {
        this.moveTaskToBack(true);
        this.finish();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode== WRITE_REQUEST_CODE){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED ){
                Log.d("masuk","");
            }
        }
    }
}