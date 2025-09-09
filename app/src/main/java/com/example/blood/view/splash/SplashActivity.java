package com.example.blood.view.splash;

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

public class SplashActivity extends BaseActivity<ActivitySplashBinding> {

    private MutableLiveData<String> mutableLiveData = new MutableLiveData<>();

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


        Log.d("abc", "1");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Log.d("abc", Thread.currentThread().getName());
                int a = 1 + 2;
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        binding.txtTitle.setText(a + "");
                        Log.d("abc", Thread.currentThread().getName());
                    }
                });
            }
        }).start();
        mutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d("Thread", Thread.currentThread().getName());
                binding.txtTitle.setText(s);
            }
        });
    }

}
