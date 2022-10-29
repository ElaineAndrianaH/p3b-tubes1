package com.example.tubes1;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import com.example.tubes1.adapter.dokter_adapter;
import com.example.tubes1.adapter.pengaturan_adapter;
import com.example.tubes1.contract.PengaturanUI;
import com.example.tubes1.databinding.DaftarDokterBinding;
import com.example.tubes1.databinding.PengaturanBinding;
import com.example.tubes1.presenter.DokterPresenter;
import com.example.tubes1.presenter.PengaturanPresenter;

public class PengaturanFragment extends Fragment implements PengaturanUI, View.OnClickListener {
    private PengaturanBinding binding;
    private pengaturan_adapter adapter;
    private PengaturanPresenter presenter;
    SwitchCompat switchCompat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = PengaturanBinding.inflate(inflater, container, false);
        adapter = new pengaturan_adapter (inflater);
        binding.btSwitch.setOnClickListener(this);
        presenter = new PengaturanPresenter(this);
        //inisialisasi presenter di adapter, spy dapet si line 30

//        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
//        final SharedPreferences.Editor editor = sharedPreferences.edit();
//        final boolean isDarkModeOn = sharedPreferences.getBoolean("isDarkModeOn", false);
//
//        // When user reopens the app
//        // after applying dark/light mode
//        if (isDarkModeOn) {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//            btnToggleDark.setText("Disable Dark Mode");
//        }
//        else {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//            btnToggleDark.setText("Enable Dark Mode");
//        }
        return binding.getRoot();


    }

    @Override
    public void listenerOnClick(String page) {
        switch (page){
            case "Exit": this.getParentFragmentManager().setFragmentResult("closeApp",new Bundle());
                break;
            default:
                Bundle res = new Bundle();
                res.putString("page",page);
                this.getParentFragmentManager().setFragmentResult("changePage",res);}
    }

    @Override
    public void onClick(View view) {

    }

//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//        super.onCreate(hasCapture);
//    }
}
