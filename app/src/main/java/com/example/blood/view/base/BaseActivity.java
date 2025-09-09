package com.example.blood.view.base;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

public abstract class BaseActivity<VB extends ViewBinding> extends AppCompatActivity implements BaseView {

    protected VB binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = inflateBinding(getLayoutInflater());
        setContentView(binding.getRoot());

        initializeComponent();
        initializeEvent();
        initializeData();
        bindView();
    }

    protected abstract VB inflateBinding(LayoutInflater inflater);


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
