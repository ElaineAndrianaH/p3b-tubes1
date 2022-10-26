package com.example.tubes1;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tubes1.databinding.BuatPertemuanBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FormPertemuanFragment extends Fragment implements View.OnClickListener{
    private BuatPertemuanBinding binding;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormat;
    private EditText et;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=BuatPertemuanBinding.inflate(inflater,container,false);
        return binding.getRoot();

        this.binding.idEdtDate.setOnClickListener(this::onClick);
//            @Override
//            public void onClick(View view) {
//                datePickerDialog.show();
//            }

    }

    private void showDateDialog() {
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                binding.idEdtDate.setText(dateFormat.format(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onClick(View view) {

    }
}
