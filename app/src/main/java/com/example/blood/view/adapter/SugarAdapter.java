package com.example.blood.view.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blood.R;
import com.example.blood.databinding.ItemAddBloodSugarBinding;
import com.example.blood.model.AddSugar;

import java.util.ArrayList;
import java.util.List;

public class SugarAdapter extends RecyclerView.Adapter<SugarAdapter.ViewHolder> {

    private List<AddSugar> data = new ArrayList<>();

    public void setData(List<AddSugar> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemAddBloodSugarBinding binding = ItemAddBloodSugarBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AddSugar sugar = data.get(position);
        holder.bindView(sugar);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemAddBloodSugarBinding binding;

        public ViewHolder(ItemAddBloodSugarBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindView(AddSugar sugar) {
            binding.txtStateBloodSugar.setText(sugar.getState());
            binding.txtStateBloodSugar.setTextColor(Color.parseColor(sugar.getStateColor()));
            binding.imgState.setBackgroundColor(Color.parseColor(sugar.getImgState()));
            binding.txtGlucoseLevel.setText(sugar.getGlucoseLevel());
        }
    }
}
