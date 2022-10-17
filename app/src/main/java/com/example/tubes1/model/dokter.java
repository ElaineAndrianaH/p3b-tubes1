package com.example.tubes1.model;

public class dokter {
private String nama;
private String sp;

    public dokter(String nama, String sp) {
        this.nama = nama;
        this.sp = sp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }
}
