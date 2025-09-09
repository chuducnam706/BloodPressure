package com.example.blood.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blood.databinding.ItemTrackerBinding;
import com.example.blood.model.Tracker;

import java.util.ArrayList;
import java.util.List;

public class TrackerAdapter extends RecyclerView.Adapter<TrackerAdapter.ViewHolder> {

    private List<Tracker> data = new ArrayList<>();

    private onClickItemInfo onClickItemInfo;

    public void setOnClickItemInfo(com.example.blood.view.adapter.onClickItemInfo onClickItemInfo) {
        this.onClickItemInfo = onClickItemInfo;
    }

    public void setData(List<Tracker> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemTrackerBinding binding = ItemTrackerBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tracker tracker = data.get(position);
        holder.bindView(tracker);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemTrackerBinding binding;

        public ViewHolder(ItemTrackerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.btnAddRecordBlood.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickItemInfo.onClickItem(getAdapterPosition());
                }
            });
        }

        public void bindView(Tracker tracker) {
            binding.imgBloodSugare.setImageResource(tracker.getSrc());
            binding.txtBlood.setText(tracker.getTitle());
        }

    }
}