package com.example.tubes1.presenter;

import com.example.tubes1.contract.MainUI;

public class MainPresenter {
    private MainUI mainUI;

    public MainPresenter(MainUI mainUI) {
        this.mainUI = mainUI;
        //inisialisasi page pertama yang kebuka di home
        this.mainUI.changePage("Home");
    }
}
