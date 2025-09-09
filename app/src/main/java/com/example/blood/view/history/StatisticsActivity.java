package com.example.blood.view.history;

import android.view.LayoutInflater;
import android.graphics.Color;

import com.example.blood.R;
import com.example.blood.databinding.ActivityStatisticsBinding;
import com.example.blood.view.base.BaseActivity;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class StatisticsActivity extends BaseActivity<ActivityStatisticsBinding> {

    private ArrayList<BarEntry> entries;
    private BarDataSet dataSet;
    private BarData data;

    @Override
    protected ActivityStatisticsBinding inflateBinding(LayoutInflater inflater) {
        return ActivityStatisticsBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initializeComponent() {
        entries = new ArrayList<>();
    }

    @Override
    public void initializeEvent() {
        super.initializeEvent();
    }

    @Override
    public void initializeData() {
        // Thêm nhiều cột (ví dụ: 7 ngày)
        entries.add(new BarEntry(0, 110));
        entries.add(new BarEntry(1, 120));
        entries.add(new BarEntry(2, 100));
        entries.add(new BarEntry(3, 130));
        entries.add(new BarEntry(4, 140));
        entries.add(new BarEntry(5, 115));
        entries.add(new BarEntry(6, 125));

        // Tạo dataset
        dataSet = new BarDataSet(entries, "Huyết áp (mmHg)");
        dataSet.setColor(getResources().getColor(R.color.Normal)); // màu cột
        dataSet.setValueTextSize(14f); // cỡ chữ trên cột

        // Tạo dữ liệu cho chart
        data = new BarData(dataSet);
    }

    @Override
    public void bindView() {
        binding.chart.setData(data);

        // Gán label cho trục X
        String[] labels = {"T2", "T3", "T4", "T5", "T6", "T7", "CN"};
        XAxis xAxis = binding.chart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); // label nằm dưới
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));

        data.setBarWidth(0.4f);

        // Xóa đường grid dọc
        xAxis.setDrawGridLines(false);

        binding.chart.getAxisLeft().enableGridDashedLine(10f, 10f, 0f);
        binding.chart.getAxisRight().setEnabled(false);

        // Refresh chart
        binding.chart.invalidate();
    }
}
