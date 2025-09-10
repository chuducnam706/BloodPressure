package com.example.blood.view.intro;

import android.content.Intent;
import android.view.LayoutInflater;

import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.blood.databinding.ActivityIntroBinding;
import com.example.blood.view.language.LanguageActivity;
import com.example.blood.model.Intro;
import com.example.blood.view.adapter.IntroAdapter;
import com.example.blood.view.base.BaseActivity;

import java.util.List;

public class IntroActivity extends BaseActivity<ActivityIntroBinding> {

    private IntrolViewModel introlViewModel;
    private IntroAdapter adapter;

    @Override
    protected ActivityIntroBinding inflateBinding(LayoutInflater inflater) {
        return ActivityIntroBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initializeComponent() {
        // Create and config( setup)
        adapter = new IntroAdapter();
        binding.viewPagerIntro.setAdapter(adapter);


        introlViewModel = new ViewModelProvider(this).get(IntrolViewModel.class);
    }

    @Override
    public void initializeEvent() {

        binding.btnNext.setOnClickListener(view -> {
            nextIntro();
        });

        binding.viewPagerIntro.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                binding.viewPagerIntro.setCurrentItem(position);
                if (position == adapter.getItemCount() - 1) {
                    binding.btnNext.setText("Start");
                } else {
                    binding.btnNext.setText("Next");
                }
            }
        });

    }

    @Override
    public void initializeData() {
        List<Intro> data =introlViewModel.initData();
        adapter.setData(data);
    }

    @Override
    public void bindView() {
        introlViewModel.initData();
        binding.dotsIndicator.attachTo(binding.viewPagerIntro);
    }

    private void nextIntro() {
        if (binding.viewPagerIntro.getCurrentItem() == adapter.getItemCount() - 1) {
            Intent intent = new Intent(IntroActivity.this, LanguageActivity.class);
            startActivity(intent);
            finish();
        } else {
            int currentItem = binding.viewPagerIntro.getCurrentItem();
            binding.viewPagerIntro.setCurrentItem(currentItem + 1);
        }
    }

}
