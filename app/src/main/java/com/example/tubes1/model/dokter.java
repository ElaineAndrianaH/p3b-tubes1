package com.example.tubes1.model;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class dokter implements Comparable<dokter>{
    private String nama;
    private String sp;
    private String tlp;
    private static String filename = "dokter.data";

    public dokter(String nama, String sp, String tlp) {
        this.nama = nama;
        this.sp = sp;
        this.tlp = tlp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public String getTlp() {
        return tlp;
    }

    public void setTlp(String tlp) {
        this.tlp = tlp;
    }

    @Override
    public String toString() {
        return this.nama + "," + this.sp + "," + this.tlp + ";";
    }
    public static void saveData(Context context, List<dokter>list) {
        File file;
        FileOutputStream fot= null;
        try {
            file= new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES),filename);
            fot= new FileOutputStream(file);
            if(!file.exists()){
                file.createNewFile();
            }
            String textToWrite="";
            for (int i = 0; i < list.size(); i++) {
                textToWrite+=list.get(i).toString();
            }
            fot.write(textToWrite.getBytes());
            fot.flush();
            fot.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static List<dokter> loadData(Context context){
        List<dokter>list=new LinkedList<dokter>();
        //load external storage
        File file= new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES),filename);
        try{
            if(!file.exists()){
                file.createNewFile();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader inputStreamReader =
                new InputStreamReader(fis, StandardCharsets.UTF_8);
        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line = reader.readLine();
            if(line!=null){
                String[] res=line.split(";");
                for (int i = 0; i < res.length; i++) {
                    String[] resData=res[i].split(",");
                    list.add(new dokter(resData[0],resData[1],resData[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(list);
        return list;
    }

    @Override
    public int compareTo(dokter dokter) {
        return this.getNama().compareTo(dokter.getNama());
    }
}
