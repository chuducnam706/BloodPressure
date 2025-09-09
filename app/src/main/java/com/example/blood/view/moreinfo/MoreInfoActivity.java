package com.example.blood.view.moreinfo;

import android.view.LayoutInflater;

import androidx.lifecycle.ViewModelProvider;

import com.example.blood.databinding.ActivityMoreInfoBinding;
import com.example.blood.model.MoreInfo;
import com.example.blood.view.adapter.MoreInfoAdapter;
import com.example.blood.view.base.BaseActivity;

import java.util.List;

public class MoreInfoActivity extends BaseActivity<ActivityMoreInfoBinding> {

    private MoreInfoAdapter adapter;
    private MoreInfoViewModel moreInfoViewModel;

    @Override
    protected ActivityMoreInfoBinding inflateBinding(LayoutInflater inflater) {
        return ActivityMoreInfoBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initializeComponent() {
        adapter = new MoreInfoAdapter();
        binding.lstMoreInfo.setAdapter(adapter);

        moreInfoViewModel = new ViewModelProvider(this).get(MoreInfoViewModel.class);
    }

    @Override
    public void initializeEvent() {
        binding.btnGotIt.setOnClickListener(e -> finish());
    }

    @Override
    public void initializeData() {
        List<MoreInfo> data = moreInfoViewModel.initData();
        adapter.setData(data);
    }

    @Override
    public void bindView() {
        moreInfoViewModel.initData();
    }
}

