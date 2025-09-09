package com.example.blood.view.history;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.blood.databinding.FragmentHistoryBinding;
import com.example.blood.view.base.BaseFragment;

public class HistoryFragment extends BaseFragment<FragmentHistoryBinding> {
    @Override
    protected FragmentHistoryBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentHistoryBinding.inflate(inflater, container, false);
    }
}
