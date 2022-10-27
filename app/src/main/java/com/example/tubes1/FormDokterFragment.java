package com.example.tubes1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tubes1.adapter.dokter_adapter;
import com.example.tubes1.contract.DokterFormUI;
import com.example.tubes1.databinding.BuatDokterBinding;
import com.example.tubes1.databinding.DaftarDokterBinding;
import com.example.tubes1.model.dokter;
import com.example.tubes1.presenter.DokterPresenter;
import com.example.tubes1.presenter.FormDokterPresenter;

public class FormDokterFragment extends Fragment implements View.OnClickListener, DokterFormUI {
    private BuatDokterBinding binding;
    private FormDokterPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = BuatDokterBinding.inflate(inflater, container, false);
        binding.idBtnSubmitFormDokter.setOnClickListener(this);
        presenter=new FormDokterPresenter(this,getContext());
        loadData();
        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        if(view == binding.idBtnSubmitFormDokter){
            presenter.addDokter(new dokter(binding.etNamaDokter.getText().toString(),binding.etSpesialis.getText().toString(),binding.etTelepon.getText().toString()));
        }
    }
    @Override
    public void loadData() {
        presenter.loadData();
    }

    @Override
    public void resetForm() {
        binding.etNamaDokter.setText("");
        binding.etSpesialis.setText("");
        binding.etTelepon.setText("");
    }

    @Override
    public void listenerOnClick(String page) {
        Bundle res = new Bundle();
        res.putString("page", page);
        this.getParentFragmentManager().setFragmentResult("changePage", res);
    }
}
