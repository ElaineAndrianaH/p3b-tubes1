package com.example.tubes1.contract;

import com.example.tubes1.model.dokter;

import java.util.List;

public interface PertemuanFormUI {
    public void updateList(List<dokter> dokter);
    public void listenerOnClick (String page);
}
