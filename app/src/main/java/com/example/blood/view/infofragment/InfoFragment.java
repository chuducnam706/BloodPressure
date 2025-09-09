package com.example.blood.view.infofragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProvider;

import com.example.blood.databinding.FragmentInfoBinding;
import com.example.blood.model.Infomation;
import com.example.blood.view.adapter.InfoAdapter;
import com.example.blood.view.adapter.onClickItemInfo;
import com.example.blood.view.base.BaseFragment;
import com.example.blood.view.language.LanguageActivity;

import java.util.ArrayList;
import java.util.List;

public class InfoFragment extends BaseFragment<FragmentInfoBinding> implements onClickItemInfo {

    private InfoAdapter adapter;
    private InfoViewModel infoViewModel;
    private ArrayList<Infomation> infomationArrayList = new ArrayList<>();
    private String title = "pressure";

    @Override
    protected FragmentInfoBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentInfoBinding.inflate(inflater, container, false);
    }

    @Override
    public void initializeComponent() {
        adapter = new InfoAdapter();
        binding.lstMenuItem.setAdapter(adapter);
        adapter.setOnClickItemInfo(this);

        infoViewModel = new ViewModelProvider(this).get(InfoViewModel.class);
    }

    @Override
    public void initializeData() {
        List<Infomation> infomations = infoViewModel.initData();
        adapter.setData(infomations);
    }

    @Override
    public void bindView() {
        infoViewModel.initData();
    }

    @Override
    public void onClickItem(int position) {
        switch (position) {
            case 0:
                title = "Pressure";
                Intent intent = new Intent(getActivity(), LanguageActivity.class);
                startActivity(intent);
                break;
            case 1:
                title = "Sugar";
                break;
            case 2:
                title = "Heart";
                break;
            case 3:
                title = "BMI";
                break;
        }

    }
}
