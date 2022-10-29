package com.example.tubes1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.tubes1.contract.PengaturanUI;
import com.example.tubes1.databinding.ItemMenuBinding;
import com.example.tubes1.databinding.ItemPertemuanBinding;
import com.example.tubes1.databinding.PengaturanBinding;
import com.example.tubes1.model.pertemuan;
import com.example.tubes1.presenter.LeftPresenter;
import com.example.tubes1.presenter.PengaturanPresenter;

import java.util.List;

public class pengaturan_adapter extends BaseAdapter {
    private LayoutInflater inflater;
    private PengaturanBinding binding;
    private LayoutInflater layout;
    private PengaturanPresenter presenter;

    public pengaturan_adapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        pengaturan_adapter.viewHolder vh;
        if(view == null){
            //isi viewList nya
            binding = PengaturanBinding.inflate(layout);
            view=binding.getRoot();
            vh=new pengaturan_adapter.viewHolder(presenter,binding);
            view.setTag(vh);

        }else {
            vh=(pengaturan_adapter.viewHolder) view.getTag();
        }
        vh.updateView();
        return view;
    }
    private class viewHolder implements View.OnClickListener{
        private PengaturanPresenter presenter;
        private PengaturanBinding item;



        public viewHolder(PengaturanPresenter presenter, PengaturanBinding item) {
            this.presenter = presenter;
            this.item = item;
        }

        public void updateView(){
            this.item.btSwitch.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            this.presenter.changeListener(this.item.btSwitch.getText().toString());
        }
    }
}
