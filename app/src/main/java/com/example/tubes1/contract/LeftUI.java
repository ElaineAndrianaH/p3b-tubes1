package com.example.tubes1.contract;

import java.util.List;

public interface LeftUI {
    //untuk mengupdate smua list yang ada
    public void updateList(List<String> list);
    //buat manggil kom antara fragment
    public void listenerOnClick (String page);
}
