package com.example.tubes1.presenter;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.example.tubes1.contract.DokterUI;
import com.example.tubes1.model.dokter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DokterPresenter {
    private DokterUI ui;
    private List<dokter> list;
    private Context context;

    public DokterPresenter(DokterUI ui, Context context) {
        this.ui = ui;
        this.list= new LinkedList<dokter>();
        this.context = context;
    }

    public void changeListener(String page){
        this.ui.listenerOnClick(page);
    }


    public void saveData(){
        dokter.saveData(context,this.list);
    }
    public void loadData() {
        this.list=dokter.loadData(context);
        this.ui.updateList(this.list);
    }
    public void hapusData(int position){
        Log.d("hapus", position+"");
        this.list.remove(position);
        this.saveData();
        this.ui.updateList(this.list);
    }

}
