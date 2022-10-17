package com.example.tubes1.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;
import com.example.tubes1.model.pertemuan;

public class pertemuan_adapter extends BaseAdapter {
    private List<pertemuan> list;
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public pertemuan getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
