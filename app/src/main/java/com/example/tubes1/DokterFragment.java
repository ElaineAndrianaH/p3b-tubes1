package com.example.tubes1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tubes1.adapter.dokter_adapter;
import com.example.tubes1.contract.DokterUI;
import com.example.tubes1.databinding.DaftarDokterBinding;
import com.example.tubes1.model.dokter;
import com.example.tubes1.presenter.DokterPresenter;

import java.util.List;

public class DokterFragment extends Fragment implements DokterUI,View.OnClickListener {
    private DaftarDokterBinding binding;
    private dokter_adapter adapter;
    private DokterPresenter presenter;
    ActivityResultLauncher<Intent> activityResultLauncher;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DaftarDokterBinding.inflate(inflater, container, false);
        adapter = new dokter_adapter(inflater);
        presenter = new DokterPresenter(this,getContext());
        //inisialisasi presenter di adapter, spy dapet si line 30
        adapter.setPresenter(presenter);
        binding.btn.setOnClickListener(this);
        binding.idLVLanguages.setAdapter(adapter);

        return binding.getRoot();
    }


    @Override
    public void updateList(List<dokter> list) {
        adapter.update(list);
    }

    @Override
    public void listenerOnClick(String page,int pos) {
        Bundle res = new Bundle();
        res.putString("page", page);
        res.putInt("pos",pos);
        this.getParentFragmentManager().setFragmentResult("changePage", res);
    }

    @Override
    public void onClick(View view) {
              if(view == binding.btn){
                  listenerOnClick("Dokter Form",-1);
              }
    }
}
