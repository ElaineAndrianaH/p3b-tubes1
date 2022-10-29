package com.example.tubes1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import com.example.tubes1.databinding.ItemPertemuanBinding;
import com.example.tubes1.model.dokter;
import com.example.tubes1.model.pertemuan;
import com.example.tubes1.presenter.PertemuanPresenter;

public class pertemuan_adapter extends BaseAdapter {
    private List<pertemuan> list;
    private ItemPertemuanBinding binding;
    private PertemuanPresenter presenter;
    private LayoutInflater inflater;

    public pertemuan_adapter(LayoutInflater inflater) {
        this.inflater = inflater;
        this.list=new ArrayList<pertemuan>();
    }
    public void update(List<pertemuan> list){
        this.list=list;
        this.notifyDataSetChanged();
    }

    public void setPresenter(PertemuanPresenter presenter) {
        this.presenter = presenter;
    }

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
        viewHolder vh;
        if(view==null){
            binding = ItemPertemuanBinding.inflate(inflater);
            vh = new viewHolder(binding,presenter);
            view = binding.getRoot();
            view.setTag(vh);
        }else{
            vh=(viewHolder) view.getTag();
        }
        vh.updateView((pertemuan) list.get(i),i);
        return view;
    }

    public class viewHolder implements View.OnClickListener{
        private ItemPertemuanBinding binding;
        private PertemuanPresenter presenter;
        private int pos;

        public viewHolder(ItemPertemuanBinding binding, PertemuanPresenter presenter) {
            this.binding = binding;
            this.presenter = presenter;
        }
        public void updateView(pertemuan pertemuan, int pos){
            this.pos=pos;
            this.binding.datePertemuan.setText(pertemuan.getTgl());
            this.binding.waktuPertemuan.setText(pertemuan.getWkt());
            this.binding.NamaDokter.setText(pertemuan.getDokter().getNama());
            this.binding.btnContact.setOnClickListener(this);
            this.binding.btnDelete.setOnClickListener(this);
            this.binding.btnEdit.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if(view == binding.btnDelete){
                this.presenter.hapusData(pos);
            }
        }
    }
}
