package com.example.tubes1;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tubes1.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private FragmentHomeBinding fh;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       fh = FragmentHomeBinding.inflate(inflater,container,false);
       fh.txtview.setMovementMethod(new ScrollingMovementMethod());
       fh.btn.setOnClickListener(this);
        return fh.getRoot();
    }

    @Override
    public void onClick(View view) {
       if(view==this.fh.btn){
           Bundle res = new Bundle();
           res.putString("page", "Pertemuan Form");
           this.getParentFragmentManager().setFragmentResult("changePage", res);
       }
    }

}
