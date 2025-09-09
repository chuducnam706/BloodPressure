package com.example.blood.view.trackerfragmet;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProvider;

import com.example.blood.databinding.FragmentTrackerBinding;
import com.example.blood.model.Tracker;
import com.example.blood.view.adapter.TrackerAdapter;
import com.example.blood.view.adapter.onClickItemInfo;
import com.example.blood.view.addpressure.AddBloodPressureActivity;
import com.example.blood.view.base.BaseFragment;

import java.util.List;

public class TrackerFragment extends BaseFragment<FragmentTrackerBinding> implements onClickItemInfo {

    private TrackerAdapter adapter;
    private TrackerViewModel viewModel;

    @Override
    protected FragmentTrackerBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentTrackerBinding.inflate(inflater, container, false);
    }

    @Override
    public void initializeComponent() {
        adapter = new TrackerAdapter();
        adapter.setOnClickItemInfo(this);
        binding.lstmenuTracker.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(TrackerViewModel.class);
    }


    @Override
    public void initializeData() {
        List<Tracker> trackers = viewModel.initData();
        adapter.setData(trackers);
    }

    @Override
    public void bindView() {

        viewModel.initData();
    }

    @Override
    public void onClickItem(int position) {
        switch (position) {
            case 0:
                Intent intentSurger = new Intent(getActivity(), AddBloodPressureActivity.class);
                intentSurger.putExtra("Pressure", "Add Blood Pressure");
                startActivity(intentSurger);
                break;
        }
    }

}
