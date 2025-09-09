package com.example.blood.view.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

public abstract class BaseFragment<T extends ViewBinding> extends Fragment implements BaseView {

    protected T binding;

    protected abstract T inflateBinding(LayoutInflater inflater, ViewGroup container);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = inflateBinding(inflater, container);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initializeComponent();
        initializeData();
        initializeEvent();
        bindView();
    }

    @Override
    public void initializeComponent() {

    }

    @Override
    public void initializeEvent() {

    }

    @Override
    public void initializeData() {

    }

    @Override
    public void bindView() {

    }

}
