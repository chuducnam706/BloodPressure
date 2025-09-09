package com.example.blood.view.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blood.databinding.ItemStatusAddPressureBinding;
import com.example.blood.model.Pressure;

import java.util.ArrayList;
import java.util.List;

public class PressureAdapter extends RecyclerView.Adapter<PressureAdapter.ViewHolder> {

    private List<Pressure> data = new ArrayList<>();
    private int state = 0;

    public void setData(List<Pressure> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void setState(int state) {
        this.state = state;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemStatusAddPressureBinding binding = ItemStatusAddPressureBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pressure pressure = data.get(position);
        holder.bindView(pressure);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemStatusAddPressureBinding binding;

        public ViewHolder(ItemStatusAddPressureBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindView(Pressure pressure) {
            binding.bgStatus.setBackgroundColor(Color.parseColor(pressure.getBackground()));
            if (state == getAdapterPosition()) {
                binding.imgHeart.setVisibility(View.VISIBLE);
            } else {
                binding.imgHeart.setVisibility(View.GONE);
            }
        }
    }
}
