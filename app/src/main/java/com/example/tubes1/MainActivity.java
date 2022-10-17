package com.example.tubes1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tubes1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //buat button nya ngapain
        binding.btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //ngelakuin si btn ngapain
        if(view == binding.btn){
            //start activity
            Intent myintent= new Intent(MainActivity.this,HomeActivity.class);
            MainActivity.this.startActivity(myintent);
        }

    }
}