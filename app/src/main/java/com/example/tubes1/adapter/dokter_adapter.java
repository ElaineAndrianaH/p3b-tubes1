package com.example.tubes1.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.example.tubes1.model.dokter;
import com.example.tubes1.presenter.DokterPresenter;

import java.util.List;

public class dokter_adapter extends BaseAdapter {
    private List<dokter> list;
    private DokterPresenter presenter;
    public void update(List<dokter> list){
        this.list=list;
        this.notifyDataSetChanged();
    }

    public void setPresenter(DokterPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
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
