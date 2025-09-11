package com.example.blood.view.addbloodsugar;

import android.view.LayoutInflater;

import androidx.lifecycle.ViewModelProvider;

import com.example.blood.databinding.ActivityAddBloodSugarBinding;
import com.example.blood.model.AddSugar;
import com.example.blood.view.adapter.SugarAdapter;
import com.example.blood.view.base.BaseActivity;

import java.util.List;

public class AddBloodSugarActivity extends BaseActivity<ActivityAddBloodSugarBinding> {

    private SugarAdapter adapter;
    private AddBloodSugarViewModel viewModel;

    @Override
    protected ActivityAddBloodSugarBinding inflateBinding(LayoutInflater inflater) {
        return ActivityAddBloodSugarBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initializeComponent() {
        adapter = new SugarAdapter();
        binding.lstStatusSugar.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(AddBloodSugarViewModel.class);
    }


    @Override
    public void initializeEvent() {
        super.initializeEvent();
    }

    @Override
    public void initializeData() {
        adapter.setData(viewModel.initData());
    }

    @Override
    public void bindView() {
        super.bindView();
    }
}
