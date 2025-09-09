package com.example.blood.view.setting;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.blood.databinding.FragmentSettingBinding;
import com.example.blood.view.base.BaseFragment;

public class SettingFragment extends BaseFragment<FragmentSettingBinding> {
    @Override
    protected FragmentSettingBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentSettingBinding.inflate(inflater, container, false);
    }
}