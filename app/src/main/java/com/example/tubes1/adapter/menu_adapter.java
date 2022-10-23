package com.example.tubes1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tubes1.LeftFragment;
import com.example.tubes1.databinding.ItemMenuBinding;
import com.example.tubes1.presenter.LeftPresenter;

import java.util.ArrayList;
import java.util.List;

public class menu_adapter extends BaseAdapter {
    private List<String> list;
    private ItemMenuBinding item;
    private LayoutInflater layout;
    private LeftPresenter presenter;

    //butuh inisialisasi dl di leftfragment nya
    public void setPresenter(LeftPresenter presenter) {
        this.presenter = presenter;
    }

    public menu_adapter(LayoutInflater layout) {
        this.layout = layout;
        this.list = new ArrayList<>();
    }
    public void update(List<String> list){
        this.list=list;
        this.notifyDataSetChanged();
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
            item = ItemMenuBinding.inflate(layout);
            view=item.getRoot();
            vh=new viewHolder(presenter,item);
            view.setTag(vh);

        }else {
            vh=(viewHolder) view.getTag();
        }
        vh.updateView(getItem(i).toString());
        return view;
    }
    private class viewHolder{
        private LeftPresenter presenter;
        private ItemMenuBinding item;


        public viewHolder(LeftPresenter presenter, ItemMenuBinding item) {
            this.presenter = presenter;
            this.item = item;
        }
        public void updateView(String str){
            this.item.itemLeft.setText(str);
        }
    }
}
