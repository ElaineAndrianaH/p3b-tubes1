package com.example.tubes1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.tubes1.contract.MainUI;
import com.example.tubes1.databinding.ActivityMainBinding;
import com.example.tubes1.databinding.BuatPertemuanBinding;
import com.example.tubes1.presenter.MainPresenter;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements MainUI, View.OnClickListener {
    private ActivityMainBinding binding;
    private BuatPertemuanBinding binding2;
    private HomeFragment hf;
    private MainPresenter mp;
    private EditText dateEdt;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding2 = BuatPertemuanBinding.inflate(getLayoutInflater());
        setContentView(binding2.getRoot());

        hf= new HomeFragment();
        mp = new MainPresenter(this);

        //Buat date picker
        this.binding2.idEdtDate.setInputType(InputType.TYPE_NULL);
        dateEdt = this.binding2.idEdtDate;
        dateEdt.setOnClickListener(this::onClick);
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

    @Override
    public void onClick(View view) {
        final Calendar c = Calendar.getInstance();

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(
                MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // on below line we are setting date to our edit text.
                        dateEdt.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, year, month, day);
        datePickerDialog.show();
    }
}