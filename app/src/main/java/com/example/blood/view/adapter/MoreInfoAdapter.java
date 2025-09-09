package com.example.blood.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blood.databinding.ItemMoreInfoBinding;
import com.example.blood.model.MoreInfo;

import java.util.ArrayList;
import java.util.List;

public class MoreInfoAdapter extends RecyclerView.Adapter<MoreInfoAdapter.ViewHolder> {

    private List<MoreInfo> data = new ArrayList<>();

    public void setData(List<MoreInfo> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemMoreInfoBinding binding = ItemMoreInfoBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MoreInfo moreInfo = data.get(position);
        holder.bindView(moreInfo);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemMoreInfoBinding binding;

        public ViewHolder(ItemMoreInfoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindView(MoreInfo moreInfo) {
            binding.imgHearthealth.setImageResource(moreInfo.getImg());
            binding.bgListInfo.setBackgroundColor(moreInfo.getBgColor());
            binding.txtSystolic.setText(moreInfo.getSystolic());
            binding.txtDiastolic.setText(moreInfo.getDiastolic());
            binding.txtStatus.setText(moreInfo.getStatus());
            binding.txtAnd.setText(moreInfo.getAndOr());
        }


    }
}

