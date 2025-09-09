package com.example.blood.history;

import android.view.LayoutInflater;

import com.example.blood.databinding.FragmentHistoryBinding;
import com.example.blood.view.base.BaseActivity;

public class HistoryFragment extends BaseActivity<FragmentHistoryBinding> {
    @Override
    protected FragmentHistoryBinding inflateBinding(LayoutInflater inflater) {
        return FragmentHistoryBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initializeComponent() {
        super.initializeComponent();
    }
}
