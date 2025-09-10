package com.example.blood.view.language;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;

import androidx.lifecycle.ViewModelProvider;

import com.example.blood.databinding.ActivityLanguageBinding;
import com.example.blood.view.adapter.LanguagesAdapter;
import com.example.blood.view.base.BaseActivity;
import com.example.blood.view.home.HomeActivity;
import com.example.blood.view.language.LanguageViewModel;

public class LanguageActivity extends BaseActivity<ActivityLanguageBinding> {

    private LanguagesAdapter adapter;
    private LanguageViewModel languageViewModel;

    @Override
    protected ActivityLanguageBinding inflateBinding(LayoutInflater inflater) {
        return ActivityLanguageBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initializeComponent() {

        adapter = new LanguagesAdapter();
        languageViewModel = new ViewModelProvider(this).get(LanguageViewModel.class);

    }

    @Override
    public void initializeEvent() {
        binding.btnTick.setOnClickListener(view -> {
            intentHome();
        });
    }

    @Override
    public void bindView() {
        binding.lstLanguage.setAdapter(adapter);
        languageViewModel.getData().observe(this, languages -> {
            adapter.setData(languages);
        });

        languageViewModel.initData();
    }

    private void intentHome() {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isFirstRun", false);
        editor.putBoolean("isLanguageSelected", true);
        editor.apply();
        startActivity(new Intent(LanguageActivity.this, HomeActivity.class));
        finish();
    }


}
