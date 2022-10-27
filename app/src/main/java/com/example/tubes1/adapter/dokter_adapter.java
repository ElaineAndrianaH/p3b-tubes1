package com.example.tubes1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.tubes1.databinding.ListDokterBinding;
import com.example.tubes1.model.dokter;
import com.example.tubes1.presenter.DokterPresenter;

import java.util.ArrayList;
import java.util.List;

public class dokter_adapter extends BaseAdapter {
    private List<dokter> list;
    private DokterPresenter presenter;
    private ListDokterBinding item;
    private LayoutInflater layout;

    public dokter_adapter(LayoutInflater layout) {
        this.list= new ArrayList<>();
        this.layout=layout;
    }

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
        viewHolder vh;
        if(view == null){
            //isi viewList nya
            item = ListDokterBinding.inflate(layout);
            view=item.getRoot();
            vh=new viewHolder(presenter,item);
            view.setTag(vh);

        }else {
            vh=(viewHolder) view.getTag();
        }
        vh.updateView((dokter) getItem(i));
        return view;
    }
    private class viewHolder implements View.OnClickListener{
        private DokterPresenter presenter;
        private ListDokterBinding item;

        public viewHolder(DokterPresenter presenter, ListDokterBinding item) {
            this.presenter = presenter;
            this.item = item;
        }
        public void updateView(dokter data){
            this.item.NamaDokter.setText(data.getNama());
            this.item.JenisDokter.setText(data.getSp());
        }

        @Override
        public void onClick(View view) {
        }
    }
}
