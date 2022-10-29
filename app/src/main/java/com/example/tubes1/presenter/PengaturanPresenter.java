package com.example.tubes1.presenter;

import com.example.tubes1.contract.PengaturanUI;

public class PengaturanPresenter {
    private PengaturanUI ui;

    public PengaturanPresenter(PengaturanUI ui) {
        this.ui = ui;
    }


    public void changeListener(String page){
        this.ui.listenerOnClick(page);
    }
}
