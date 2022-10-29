package com.example.tubes1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.tubes1.databinding.ItemDokterViewBinding;
import com.example.tubes1.model.dokter;
import com.example.tubes1.model.pertemuan;

import java.util.ArrayList;
import java.util.List;

public class DokterSpinner_adapter extends BaseAdapter {
    private List<dokter> list;
    private ItemDokterViewBinding binding;
    private LayoutInflater inflater;

    public DokterSpinner_adapter(LayoutInflater inflater) {
        this.inflater = inflater;
        this.list = new ArrayList<>();
    }
    public void updateList(List<dokter>list){
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public dokter getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        binding = ItemDokterViewBinding.inflate(inflater);
        binding.txtview.setText(getItem(i).getNama());
        return binding.getRoot();
    }
}
