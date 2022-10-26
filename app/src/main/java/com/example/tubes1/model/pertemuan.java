package com.example.tubes1.model;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.time.LocalDateTime;
import java.util.Date;

public class pertemuan {
    private String pasien;
    private dokter dokter;
    private String keluhan;
    private Date tgl;
    private LocalDateTime wkt;

    public pertemuan(String pasien, dokter dokter, String keluhan, Date tgl, LocalDateTime wkt) {
        this.pasien = pasien;
        this.dokter = dokter;
        this.keluhan = keluhan;
        this.tgl = tgl;
        this.wkt = wkt;
    }

    public String getPasien() {
        return pasien;
    }

    public void setPasien(String pasien) {
        this.pasien = pasien;
    }

    public dokter getDokter() {
        return dokter;
    }

    public void setDokter(dokter dokter) {
        this.dokter = dokter;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

    public LocalDateTime getWkt() {
        return wkt;
    }

    public void setWkt(LocalDateTime wkt) {
        this.wkt = wkt;
    }


}
