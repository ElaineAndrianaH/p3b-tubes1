package com.example.tubes1.contract;

import androidx.fragment.app.FragmentTransaction;

public interface MainUI {
    public void changePage(String page);
    public void closeAllPage(FragmentTransaction ft);
    public void closeApp();

}
