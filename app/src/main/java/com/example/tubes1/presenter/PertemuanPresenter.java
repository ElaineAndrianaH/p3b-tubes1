package com.example.tubes1.presenter;

import android.content.Context;

import com.example.tubes1.contract.PertemuanUI;
import com.example.tubes1.model.dokter;
import com.example.tubes1.model.pertemuan;

import java.util.LinkedList;
import java.util.List;

public class PertemuanPresenter {
    private PertemuanUI ui;
    private List<pertemuan> list;
    private Context context;

    public PertemuanPresenter(PertemuanUI ui, Context context) {
        this.ui = ui;
        this.context = context;
        this.list= new LinkedList<pertemuan>();
        this.loadData();
    }
    public void loadData(){
        this.list = pertemuan.loadData(context);
        ui.updateList(list);
    }

    public void hapusData(int position){
        this.list.remove(position);
        pertemuan.saveData(context,this.list);
        this.ui.updateList(this.list);
    }
    public void callDokter(int pos){
        this.ui.callActivity(list.get(pos).getDokter().getTlp());
    }
}
