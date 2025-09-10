package com.example.blood.view.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.bumptech.glide.Glide;
import com.example.blood.R;
import com.example.blood.databinding.ActivitySplashBinding;
import com.example.blood.view.base.BaseActivity;
import com.example.blood.view.home.HomeActivity;
import com.example.blood.view.intro.IntroActivity;

public class SplashActivity extends BaseActivity<ActivitySplashBinding> {


    @Override
    protected ActivitySplashBinding inflateBinding(LayoutInflater inflater) {
        return ActivitySplashBinding.inflate(inflater);
    }

    @Override
    public void initializeEvent() {
        splash();
    }

    @Override
    public void bindView() {
        Glide.with(this).load(R.drawable.img_splash).into(binding.imgSplash);
    }


    private void splash() {

        SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences", MODE_PRIVATE);
        boolean isFirstRun = sharedPreferences.getBoolean("isFirstRun", true);
        boolean isLanguageSelected = sharedPreferences.getBoolean("isLanguageSelected", false);


        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if(isFirstRun){
                Intent intent = new Intent(this, IntroActivity.class);
                startActivity(intent);
            } else {
                startActivity(new Intent(this, HomeActivity.class));
            }
        }, 1000);
    }

}
