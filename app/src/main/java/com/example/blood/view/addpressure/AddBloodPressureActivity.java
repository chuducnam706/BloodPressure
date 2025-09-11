package com.example.blood.view.addpressure;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProvider;

import com.example.blood.databloodpressure.PressureEntity;
import com.example.blood.databinding.ActivityAddBloodPressureBinding;
import com.example.blood.model.Pressure;
import com.example.blood.model.AddPressure;
import com.example.blood.view.Utils;
import com.example.blood.view.resultpressure.ResultPressureActivity;
import com.example.blood.view.adapter.PressureAdapter;
import com.example.blood.view.base.BaseActivity;
import com.example.blood.view.moreinfo.MoreInfoActivity;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.gson.Gson;

import java.util.Calendar;
import java.util.List;

public class AddBloodPressureActivity extends BaseActivity<ActivityAddBloodPressureBinding> {

    private PressureAdapter adapter;
    private AddPressureViewModel viewModel;
    private PressureEntity entity;
    private int year, month, day;
    private long hour, minute, selectionLastDate;
    private int sys, dia;


    @Override
    protected ActivityAddBloodPressureBinding inflateBinding(LayoutInflater inflater) {
        return ActivityAddBloodPressureBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initializeComponent() {

        adapter = new PressureAdapter();
        binding.lstStatus.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(AddPressureViewModel.class);

        entity = new PressureEntity();

        Calendar calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        selectionLastDate = MaterialDatePicker.todayInUtcMilliseconds();

    }

    @Override
    public void initializeEvent() {

        binding.btnBack.setOnClickListener(view -> {
            finish();
        });

        binding.btnMoreInfo.setOnClickListener(view -> {
            Intent intent = new Intent(AddBloodPressureActivity.this, MoreInfoActivity.class);
            startActivity(intent);
        });

        binding.numberPickerSystolic.setOnValueChangedListener((picker, oldVal, newVal) -> {
            sys = newVal;
            viewModel.insertPressureEntitySys(newVal);
            renderBloodPressureStatus();
            binding.txtSys.setText("SYS < " + newVal);
        });

        binding.numberPickerDiastolic.setOnValueChangedListener((picker, oldVal, newVal) -> {
            dia = newVal;
            viewModel.insertPressureEntityDia(newVal);
            renderBloodPressureStatus();
            binding.txtDia.setText("DIA < " + newVal);
        });

        binding.numberPickerPulse.setOnValueChangedListener((picker, oldVal, newVal) -> {
            viewModel.insertPressureEntityPul(newVal);
        });

        binding.btnCalendar.setOnClickListener(e -> showDatePicker());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            binding.btnClock.setOnClickListener(e -> showTimePicker());
        }

        binding.btnSave.setOnClickListener(v -> {
            updateNote();
            viewModel.insert(this);

        });

        viewModel.getPreMutableLiveData().observe(this, id -> {
            if (id > 0) {
                Toast.makeText(this, "Đã lưu huyết áp!", Toast.LENGTH_SHORT).show();
                viewModel.insertPressureEntityId(id);
                Gson gson = new Gson();
                String key = gson.toJson(viewModel.getEntity());
                Intent intent = new Intent(this, ResultPressureActivity.class);
                intent.putExtra(Utils.KEY_SAVE_PRESSURE, key);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Lưu thất bại", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void initializeData() {
        List<Pressure> data = viewModel.initData();
        adapter.setData(data);
    }

    private void renderBloodPressureStatus() {
        AddPressure addPressure = viewModel.checkBloodPressure(sys, dia);
        adapter.setState(addPressure.getState());
        binding.imgHeart.setImageResource(addPressure.getImgRes());
        binding.txtStateBloodPressure.setText(addPressure.getStatus());
    }

    private void showDatePicker() {
        MaterialDatePicker<Long> datePicker =
                MaterialDatePicker.Builder.datePicker()
                        .setTitleText("Select date")
                        .setSelection(selectionLastDate)
                        .build();

        datePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");

        datePicker.addOnPositiveButtonClickListener(selection -> {

            selectionLastDate = selection;

            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis((Long) selection);

            int yearSelected = calendar.get(Calendar.YEAR);
            int monthSelected = calendar.get(Calendar.MONTH);
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

            year = yearSelected;
            month = monthSelected + 1;
            day = dayOfMonth;

            String selectedDate = dayOfMonth + "/" + (monthSelected + 1) + "/" + yearSelected;

            viewModel.insertDate(selectedDate);
            binding.txtCalendar.setText(selectedDate);
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void showTimePicker() {

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                (TimePicker view, int hourOfDay, int minuteSelected) -> {

                    hour = hourOfDay;
                    minute = minuteSelected;

                    String selectedTime = String.format("%02d:%02d", hourOfDay, minuteSelected);
                    viewModel.updateTime(selectedTime);
                    binding.txtTime.setText(selectedTime);
                },
                (int) hour, (int) minute, true
        );

        timePickerDialog.show();
    }

    private void updateNote() {
        String note = binding.edtNote.getText().toString();
        viewModel.insertNote(note);
    }

}