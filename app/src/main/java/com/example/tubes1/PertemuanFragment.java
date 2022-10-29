package com.example.tubes1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tubes1.adapter.pertemuan_adapter;
import com.example.tubes1.contract.PertemuanUI;
import com.example.tubes1.databinding.DaftarPertemuanBinding;
import com.example.tubes1.model.pertemuan;
import com.example.tubes1.presenter.DokterPresenter;
import com.example.tubes1.presenter.PertemuanPresenter;

import java.util.List;

public class PertemuanFragment extends Fragment implements PertemuanUI{
    private DaftarPertemuanBinding binding;
    private PertemuanPresenter presenter;
    private pertemuan_adapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DaftarPertemuanBinding.inflate(inflater,container,false);
        adapter= new pertemuan_adapter(inflater);
        presenter = new PertemuanPresenter(this,getContext());
        adapter.setPresenter(presenter);
        binding.idLVLanguages.setAdapter(adapter);
        return binding.getRoot();
    }

    @Override
    public void updateList(List<pertemuan> list) {
        adapter.update(list);
    }
}
