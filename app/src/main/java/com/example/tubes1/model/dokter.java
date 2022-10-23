package com.example.tubes1.model;

public class dokter {
private String nama;
private String sp;
private String tlp;

    public dokter(String nama, String sp, String tlp) {
        this.nama = nama;
        this.sp = sp;
        this.tlp = tlp;
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

    public String getTlp() {
        return tlp;
    }

    public void setTlp(String tlp) {
        this.tlp = tlp;
    }
}
