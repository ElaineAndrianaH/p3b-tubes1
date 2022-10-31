package com.example.tubes1.model;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class pertemuan implements Comparable<pertemuan> {
    private String pasien;
    private dokter dokter;
    private String keluhan;
    private String tgl;
    private String wkt;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private static String filename = "pertemuan.data";
    public pertemuan(String pasien, dokter dokter, String keluhan, String tgl, String wkt) {
        this.pasien = pasien;
        this.dokter = dokter;
        this.keluhan = keluhan;
        this.tgl = tgl;
        this.wkt = wkt;
        this.status = false;
    }

    public String getPasien() {
        return pasien;
    }

    public void setPasien(String pasien) {
        this.pasien = pasien;
    }

    public dokter getDokter() {
        return dokter;
    }

    public void setDokter(dokter dokter) {
        this.dokter = dokter;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getWkt() {
        return wkt;
    }

    public void setWkt(String wkt) {
        this.wkt = wkt;
    }

    @Override
    public String toString() {
        return this.tgl + "," + this.wkt + "," + this.pasien + "," + this.keluhan + ","  + this.dokter.getNama() + "," + this.dokter.getSp()+ "," + this.dokter.getTlp() +"," + this.status+ ";";
    }
    public static void saveData(Context context, List<pertemuan> list) {
        File file;
        FileOutputStream fot= null;
        try {
            file= new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES),filename);
            fot= new FileOutputStream(file);
            if(!file.exists()){
                file.createNewFile();
            }
            String textToWrite="";
            Log.d( "saveData: ",list.size()+"");
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
    public static List<pertemuan> loadData(Context context){
        List<pertemuan>list=new LinkedList<pertemuan>();
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
                    pertemuan p=new pertemuan(resData[2],new dokter(resData[4],resData[5],resData[6]),resData[3],resData[0],resData[1] );
                    p.setStatus(Boolean.valueOf(resData[7]));
                    list.add(p);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(list);
        return list;
    }

    @Override
    public int compareTo(pertemuan pertemuan) {
        return this.getTgl().compareTo(pertemuan.getTgl());
    }
}
