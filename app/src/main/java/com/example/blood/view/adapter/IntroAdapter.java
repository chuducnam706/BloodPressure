package com.example.blood.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blood.databinding.ItemIntroBinding;
import com.example.blood.model.Intro;

import java.util.ArrayList;
import java.util.List;

public class IntroAdapter extends RecyclerView.Adapter<IntroAdapter.ViewHolder> {
    private List<Intro> data = new ArrayList<>();

    public void setData(List<Intro> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemIntroBinding binding = ItemIntroBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Intro intro = data.get(position);
        holder.bindView(intro);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemIntroBinding binding;

        public ViewHolder(ItemIntroBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindView(Intro intro) {
            binding.imgSlide.setImageResource(intro.getImageSrc());
            binding.txtTitle.setText(intro.getTitle());
            binding.txtContent.setText(intro.getContent());
        }
    }
}
