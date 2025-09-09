package com.example.blood.view.editpressure;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.blood.data.PressureEntity;
import com.example.blood.databinding.AcvityEditBloodPressureBinding;
import com.example.blood.model.AddPressure;
import com.example.blood.model.Pressure;
import com.example.blood.model.Tracker;
import com.example.blood.view.adapter.PressureAdapter;
import com.example.blood.view.base.BaseActivity;
import com.google.gson.Gson;
import com.shawnlin.numberpicker.NumberPicker;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

public class EditBloodPressureActivity extends BaseActivity<AcvityEditBloodPressureBinding> {

    private PressureAdapter adapter;
    private EditBloodPressureViewModel editBloodPressureViewModel;
    private PressureEntity pressureEntity;
    private int year, month, day;
    private long hour, minute;

    @Override
    protected AcvityEditBloodPressureBinding inflateBinding(LayoutInflater inflater) {
        return AcvityEditBloodPressureBinding.inflate(getLayoutInflater());
    }


    @Override
    public void initializeComponent() {
        adapter = new PressureAdapter();
        binding.lstStatus.setAdapter(adapter);

        editBloodPressureViewModel = new ViewModelProvider(this).get(EditBloodPressureViewModel.class);

        Intent intent = getIntent();
        String key = intent.getStringExtra("key1");

        Gson gson = new Gson();
        pressureEntity = gson.fromJson(key, PressureEntity.class);
        editBloodPressureViewModel.setEntity(pressureEntity);

        Calendar calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

    }

    @Override
    public void initializeEvent() {
        binding.numberPickerSystolic.setOnValueChangedListener((picker, oldVal, newVal) -> {
            editBloodPressureViewModel.updatePressureEntitySys(newVal);
            renderBloodPressureStatus();
        });

        binding.numberPickerDiastolic.setOnValueChangedListener((picker, oldVal, newVal) -> {
            editBloodPressureViewModel.updatePressureEntityDia(newVal);
            renderBloodPressureStatus();
        });

        binding.numberPickerPulse.setOnValueChangedListener((picker, oldVal, newVal) -> {
            editBloodPressureViewModel.updatePressureEntityPul(newVal);
        });

        binding.btnCalendar.setOnClickListener(v -> {
            showDatePicker();
        });

        binding.btnClock.setOnClickListener(v -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                showTimePicker();
            }
        });

        binding.btnSave.setOnClickListener(v -> {
            getEdtNote();
            editBloodPressureViewModel.updateBloodPressure(this);
            Toast.makeText(this, "update success", Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public void initializeData() {
        List<Pressure> data = editBloodPressureViewModel.initData();
        adapter.setData(data);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void bindView() {
        binding.numberPickerSystolic.setValue(pressureEntity.getSys());
        binding.numberPickerDiastolic.setValue(pressureEntity.getDia());
        binding.numberPickerPulse.setValue(pressureEntity.getPul());
        binding.edtNote.setText(pressureEntity.getNote());
        binding.txtCalendar.setText(pressureEntity.getDate());

        long time = pressureEntity.getTime();
        LocalTime localTime = LocalTime.ofSecondOfDay(time / 1000);
        String formattedTime = localTime.format(DateTimeFormatter.ofPattern("HH:mm"));

        binding.txtTime.setText(formattedTime);

        renderBloodPressureStatus();
    }

    private void renderBloodPressureStatus() {
        AddPressure addPressure = editBloodPressureViewModel.checkBloodPressure(pressureEntity.getSys(), pressureEntity.getDia());
        adapter.setState(addPressure.getState());
        binding.imgHrart.setImageResource(addPressure.getImgRes());
        binding.txtStateBloodPressure.setText(addPressure.getStatus());
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void showTimePicker() {

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                (TimePicker view, int hourOfDay, int minuteSelected) -> {

                    hour = hourOfDay;
                    minute = minuteSelected;

                    String selectedTime = String.format("%02d:%02d", hourOfDay, minuteSelected);
                    editBloodPressureViewModel.updateTime(selectedTime);
                    binding.txtTime.setText(selectedTime);
                },
                (int) hour, (int) minute, true
        );

        timePickerDialog.show();
    }

    private void showDatePicker() {

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (DatePicker view, int yearSelected, int monthSelected, int dayOfMonth) -> {
                    year = yearSelected;
                    month = monthSelected;
                    day = dayOfMonth;

                    String selectedDate = dayOfMonth + "/" + (monthSelected + 1) + "/" + yearSelected;
                    editBloodPressureViewModel.updateDate(selectedDate);
                    binding.txtCalendar.setText(selectedDate);
                },
                year, month, day);

        datePickerDialog.show();
    }

    private void getEdtNote() {
        String note = binding.edtNote.getText().toString();
        editBloodPressureViewModel.updateNote(note);
    }
}
