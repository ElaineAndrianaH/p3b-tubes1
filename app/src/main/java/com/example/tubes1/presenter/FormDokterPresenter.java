package com.example.tubes1.presenter;

import android.content.Context;
import android.util.Log;

import com.example.tubes1.contract.DokterFormUI;
import com.example.tubes1.model.dokter;

import java.util.LinkedList;
import java.util.List;

public class FormDokterPresenter {
    private DokterFormUI ui;
    private List<dokter> list;
    private Context context;
    private int pos=-1;


    public FormDokterPresenter(DokterFormUI ui,Context context) {
        this.ui = ui;
        this.list= new LinkedList<dokter>();
        this.context=context;
        this.pos=-1;
        loadData();
    }

    public FormDokterPresenter(DokterFormUI ui, Context context, int pos) {
        this.ui = ui;
        this.context = context;
        this.pos = pos;
        this.list= new LinkedList<dokter>();
        loadData();
        if(pos>=0)
        this.ui.loadDataEdit(this.list.get(pos));
    }

    public void loadData(){
        this.list=dokter.loadData(context);
    }
    public void saveData(){
        dokter.saveData(context,this.list);
    }
    public void addDokter(dokter newDokter){
        if(pos==-1){
            this.list.add(newDokter);
            saveData();
//        ui.resetForm();
            ui.listenerOnClick("Dokter");
        }else {
            editDokter(pos,newDokter);
        }

    }
    public void editDokter(int pos,dokter editDokter){

//        Log.d("edit",pos+"" );
        this.list.remove(pos);
        this.list.add(editDokter);
        saveData();
//        ui.resetForm();
        ui.listenerOnClick("Dokter");

    }




}
