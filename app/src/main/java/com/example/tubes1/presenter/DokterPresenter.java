package com.example.tubes1.presenter;

import com.example.tubes1.contract.DokterUI;
import com.example.tubes1.model.dokter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DokterPresenter {
    private DokterUI ui;
    private List<dokter> list;
    private static String filename="dokter.data";

    public DokterPresenter(DokterUI ui) {
        this.ui = ui;
        this.list= new LinkedList<dokter>();

    }
    public void changeListener(String page){
        this.ui.listenerOnClick(page);
    }
    public void loadData(){
        //load external storage
        this.ui.updateList(list);
    }

}
