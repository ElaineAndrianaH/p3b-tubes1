package com.example.tubes1.contract;

import com.example.tubes1.model.dokter;

public interface DokterFormUI {
    public  void loadData();
    public void resetForm();
    public void listenerOnClick (String page);
    public void loadDataEdit(dokter data);
}
