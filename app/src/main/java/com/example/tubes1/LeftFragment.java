package com.example.tubes1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.tubes1.adapter.menu_adapter;
import com.example.tubes1.contract.LeftUI;
import com.example.tubes1.databinding.LeftFragmentBinding;
import com.example.tubes1.presenter.LeftPresenter;

import java.util.List;

public class LeftFragment extends Fragment implements LeftUI {
    private menu_adapter adapter;
    private LeftFragmentBinding fragmentLeftBinding;
    private LeftPresenter presenter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentLeftBinding = LeftFragmentBinding.inflate(inflater,container,false);
        adapter = new menu_adapter(inflater);
        presenter = new LeftPresenter(this);
        adapter.setPresenter(presenter);
        //isi si listleft pake si adapternya
        fragmentLeftBinding.listLeft.setAdapter(adapter);

        return fragmentLeftBinding.getRoot();
    }


    @Override
    public void updateList(List<String> list) {
        adapter.update(list);
    }
}
