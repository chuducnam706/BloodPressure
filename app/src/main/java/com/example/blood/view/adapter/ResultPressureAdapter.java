package com.example.blood.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blood.databinding.ItemBloodPressuredDetailsBinding;
import com.example.blood.model.ResultPressure;

import java.util.ArrayList;
import java.util.List;

public class ResultPressureAdapter extends RecyclerView.Adapter<ResultPressureAdapter.ViewHolder> {

    private List<ResultPressure> data = new ArrayList<>();

    public void setData(List<ResultPressure> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemBloodPressuredDetailsBinding binding = ItemBloodPressuredDetailsBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ResultPressure resultPressure = data.get(position);
        holder.bindView(resultPressure);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ItemBloodPressuredDetailsBinding binding;
        public ViewHolder(ItemBloodPressuredDetailsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindView(ResultPressure pressure){
            binding.txtTitle.setText(pressure.getTitle());
            binding.txtContent.setText(pressure.getContent());
        }
    }
}
