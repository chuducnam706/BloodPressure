package com.example.blood.view.home;

import android.view.LayoutInflater;

import androidx.fragment.app.Fragment;

import com.example.blood.R;
import com.example.blood.databinding.ActivityHomeBinding;
import com.example.blood.view.base.BaseActivity;
import com.example.blood.view.history.HistoryFragment;
import com.example.blood.view.infofragment.InfoFragment;
import com.example.blood.view.setting.SettingFragment;
import com.example.blood.view.trackerfragmet.TrackerFragment;

public class HomeActivity extends BaseActivity<ActivityHomeBinding> {

    @Override
    protected ActivityHomeBinding inflateBinding(LayoutInflater inflater) {
        return ActivityHomeBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initializeEvent() {
        loadDefaultFragment();
        clickItemFragment();
    }

    private void clickItemFragment() {
        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.navTracker) {
                moveToFragment(new TrackerFragment());
                return true;
            } else if (id == R.id.navHistory) {
                moveToFragment(new HistoryFragment());
                return true;
            } else if (id == R.id.navInfo) {
                moveToFragment(new InfoFragment());
                return true;
            } else if (id == R.id.navSetting) {
                moveToFragment(new SettingFragment());
                return true;
            }
            return false;
        });
    }

    private void moveToFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragment).commit();

    }

    private void loadDefaultFragment() {
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView, new TrackerFragment()).commit();
    }


}