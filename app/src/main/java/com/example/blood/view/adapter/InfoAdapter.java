package com.example.blood.view.adapter;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blood.R;
import com.example.blood.databinding.ItemInfoBinding;
import com.example.blood.model.Infomation;

import java.util.ArrayList;
import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ViewHolder> {

    private List<Infomation> data = new ArrayList<>();
    private onClickItemInfo onClickItemInfo;

    public void setData(List<Infomation> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void setOnClickItemInfo(com.example.blood.view.adapter.onClickItemInfo onClickItemInfo) {
        this.onClickItemInfo = onClickItemInfo;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemInfoBinding binding = ItemInfoBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Infomation infomation = data.get(position);
        holder.bindView(infomation);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemInfoBinding binding;

        public ViewHolder(ItemInfoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            clickItemInfo();

        }

        private void bindView(Infomation infomation) {
            binding.txtTitle.setText(infomation.getTitle());
            binding.icon.setBackgroundResource(R.drawable.bg_icon_info);
            binding.icon.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(infomation.getBackGroundColor())));
            binding.icon.setImageResource(infomation.getSrc());
        }

        private void clickItemInfo() {
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickItemInfo.onClickItem(getAdapterPosition());
                }
            });
        }
    }

}
