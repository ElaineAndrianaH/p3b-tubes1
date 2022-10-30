package com.example.tubes1.presenter;

import android.content.Context;

import com.example.tubes1.contract.PertemuanFormUI;
import com.example.tubes1.model.dokter;
import com.example.tubes1.model.pertemuan;

import java.util.List;

public class FormPertemuanPresenter {
    private PertemuanFormUI ui;
    private List<dokter> list;
    private Context context;

    public FormPertemuanPresenter(PertemuanFormUI ui, Context context) {
        this.ui = ui;
        this.context = context;
        this.list=dokter.loadData(context);
        this.ui.updateList(list);
    }
    public void addPertemuan(pertemuan newPertemuan){
        List<pertemuan> temp=pertemuan.loadData(context);
        temp.add(newPertemuan);
        pertemuan.saveData(context,temp);
        this.ui.listenerOnClick("Pertemuan");
    }
    public void editPertemuan( pertemuan editPertemuan,int pos){
        List<pertemuan> temp = pertemuan.loadData(context);
        temp.remove(pos);
        temp.add(editPertemuan);
        pertemuan.saveData(context,temp);
        this.ui.listenerOnClick("Pertemuan");
    }

}
