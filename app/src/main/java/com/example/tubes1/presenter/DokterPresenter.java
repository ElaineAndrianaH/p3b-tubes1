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
    private static String filename="dokter.data";
    private Context context;

    public DokterPresenter(DokterUI ui, Context context) {
        this.ui = ui;
        this.list= new LinkedList<dokter>();
        this.context = context;
        saveData();
        loadData();
    }

    public void changeListener(String page){
        this.ui.listenerOnClick(page);
    }

    public void loadData(){
        //load external storage
        File file= new File(this.context.getExternalFilesDir(Environment.DIRECTORY_PICTURES),filename);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader inputStreamReader =
                new InputStreamReader(fis, StandardCharsets.UTF_8);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append('\n');
                line = reader.readLine();
                Log.d("masuk","");
            }
        } catch (IOException e) {
            // Error occurred when opening raw file for reading.
        } finally {
            String contents = stringBuilder.toString();
        }
        this.ui.updateList(list);

    }

    public void saveData(){
        File file;
        FileOutputStream fot= null;
        try {
            file= new File(filename);
            fot= new FileOutputStream(file);
            if(!file.exists()){
                file.createNewFile();
            }
            String textToWrite="dr.a,a,123";
//            this.list.forEach((dokter)->{
//                Log.d("masuk", "saveData: ");
//            });
            fot.write(textToWrite.getBytes());
            fot.flush();
            fot.close();
            Log.d("masuk",file+"");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
