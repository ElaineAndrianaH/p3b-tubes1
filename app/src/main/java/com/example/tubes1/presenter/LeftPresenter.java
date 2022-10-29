package com.example.tubes1.presenter;

import com.example.tubes1.contract.LeftUI;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeftPresenter {
    private LeftUI ui;
    private List<String> list;

    public LeftPresenter(LeftUI ui) {
        this.ui = ui;
        this.list = new LinkedList<>();
        String[] arr={"Home","Pertemuan","Dokter","Pengaturan","Exit"};
        this.loadData(arr);
    }
    public void changeListener(String page){
        this.ui.listenerOnClick(page);
    }
    public void loadData(String[] str){ //buat ngubah array jd list
        this.list.addAll(Arrays.asList(str));
        this.ui.updateList(list);
    }

}
