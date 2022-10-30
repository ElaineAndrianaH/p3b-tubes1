package com.example.tubes1;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tubes1.adapter.DokterSpinner_adapter;
import com.example.tubes1.contract.PertemuanFormUI;
import com.example.tubes1.databinding.BuatPertemuanBinding;
import com.example.tubes1.model.dokter;
import com.example.tubes1.model.pertemuan;
import com.example.tubes1.presenter.FormPertemuanPresenter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class FormPertemuanFragment extends Fragment implements View.OnClickListener, PertemuanFormUI {
    private BuatPertemuanBinding binding;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormat;
    private Calendar myCalendar = Calendar.getInstance();
    private DokterSpinner_adapter spinner;
    private FormPertemuanPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=BuatPertemuanBinding.inflate(inflater,container,false);

        //datepicker
        dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        binding.idEdtDate.setOnClickListener(this);

        //time picker
        binding.etWaktu.setOnClickListener(this);

        binding.btnSimpan.setOnClickListener(this);
        //buat spinner
        spinner = new DokterSpinner_adapter(inflater);
        presenter = new FormPertemuanPresenter(this,getContext());
        binding.spinner.setAdapter(spinner);
        return binding.getRoot();


    }
    private void showTime(){
        int hour = myCalendar.get(Calendar.HOUR_OF_DAY);
        int minute = myCalendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog;
        timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                binding.etWaktu.setText( selectedHour + ":" + selectedMinute);
            }
        }, hour, minute, true); // true means set 24hoursview to true
        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }

    private void showDateDialog() {
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {

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
        if(view==binding.idEdtDate){
            showDateDialog();
        }else if (view == binding.etWaktu) {
            showTime();
        }else if (view==binding.btnSimpan){
            //Log.d("masuk",binding.spinner.getSelectedItem().toString());
            presenter.addPertemuan(new pertemuan(binding.namaPasien.getText().toString(),(dokter) binding.spinner.getSelectedItem(),binding.keluhan.getText().toString(),binding.idEdtDate.getText().toString(),binding.etWaktu.getText().toString()));
        }
    }

    @Override
    public void updateList(List<dokter> dokter) {
        spinner.updateList(dokter);
    }

    @Override
    public void listenerOnClick(String page) {
        Bundle res = new Bundle();
        res.putString("page", page);
        this.getParentFragmentManager().setFragmentResult("changePage", res);
    }
}
