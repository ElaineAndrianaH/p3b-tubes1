package com.example.tubes1.presenter;

import android.content.Context;

import com.example.tubes1.contract.DokterFormUI;
import com.example.tubes1.model.dokter;

import java.util.LinkedList;
import java.util.List;

public class FormDokterPresenter {
    private DokterFormUI ui;
    private List<dokter> list;
    private Context context;

    public FormDokterPresenter(DokterFormUI ui,Context context) {
        this.ui = ui;
        this.list= new LinkedList<dokter>();
        this.context=context;

    }
    public void loadData(){
        this.list=dokter.loadData(context);
    }
    public void saveData(){
        dokter.saveData(context,this.list);
    }
    public void addDokter(dokter newDokter){
        this.list.add(newDokter);
        saveData();
        ui.resetForm();
        ui.listenerOnClick("Dokter");

    }
    public void editDokter(int pos,dokter editDokter){
        this.list.remove(pos);
        this.list.add(editDokter);
        ui.resetForm();
        ui.listenerOnClick("Dokter");

    }




}
