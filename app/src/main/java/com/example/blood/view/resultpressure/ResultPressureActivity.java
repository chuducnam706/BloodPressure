package com.example.blood.view.resultpressure;

import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.blood.databloodpressure.PressureEntity;
import com.example.blood.databinding.ActivityResultBinding;
import com.example.blood.model.ResultPressure;
import com.example.blood.view.Utils;
import com.example.blood.view.adapter.ResultPressureAdapter;
import com.example.blood.view.base.BaseActivity;
import com.example.blood.view.editpressure.EditBloodPressureActivity;
import com.example.blood.view.moreinfo.MoreInfoActivity;
import com.google.gson.Gson;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ResultPressureActivity extends BaseActivity<ActivityResultBinding> {

    private ResultPressureAdapter adapter;
    private ResultPressureViewModel resultPressureViewModel;
    private PressureEntity pressureEntity;


    @Override
    protected ActivityResultBinding inflateBinding(LayoutInflater inflater) {
        return ActivityResultBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initializeComponent() {
        adapter = new ResultPressureAdapter();
        binding.lstBloodPressureDetails.setAdapter(adapter);

        resultPressureViewModel = new ViewModelProvider(this).get(ResultPressureViewModel.class);

        Intent intent = getIntent();
        String key = intent.getStringExtra(Utils.KEY_SAVE_PRESSURE);

        Gson gson = new Gson();
        pressureEntity = gson.fromJson(key, PressureEntity.class);

    }

    @Override
    public void initializeEvent() {
        binding.btnBack.setOnClickListener(v -> {
            finish();
        });

        binding.btnMoreInfo.setOnClickListener(v -> {
            Intent intent = new Intent(ResultPressureActivity.this, MoreInfoActivity.class);
            startActivity(intent);
        });

        binding.btnEdit.setOnClickListener(v -> {
            Gson gson = new Gson();
            String key = gson.toJson(pressureEntity);
            Intent intent  = new Intent(this, EditBloodPressureActivity.class);
            intent.putExtra("key1", key);
            startActivity(intent);

        });
    }

    @Override
    public void initializeData() {
        List<ResultPressure> data = resultPressureViewModel.intiData();
        adapter.setData(data);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void bindView() {
        binding.txtNumber.setText(String.format("%s/%s",pressureEntity.getSys() , pressureEntity.getDia()));

        binding.txtNote.setText(String.format("Note: %s", pressureEntity.getNote()));

        ResultPressure resultPressure = resultPressureViewModel.checkBloodPressure(pressureEntity.getSys() , pressureEntity.getDia());
        binding.imgHrart.setImageResource(resultPressure.getImgRes());
        binding.txtStateBloodPressure.setText(resultPressure.getStatus());
        binding.txtStateBloodPressure.setTextColor(
                ContextCompat.getColor(binding.txtStateBloodPressure.getContext(), resultPressure.getColorState())
        );

        long time = pressureEntity.getTime();
        LocalTime localTime = LocalTime.ofSecondOfDay(time / 1000);
        String formattedTime = localTime.format(DateTimeFormatter.ofPattern("HH:mm"));

        binding.txtContentMeasured.setText(String.format("%s - %s", pressureEntity.getDate() ,formattedTime ));

    }

}
