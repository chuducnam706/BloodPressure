package com.example.blood.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blood.databinding.ItemLanguagesBinding;
import com.example.blood.model.Language;

import java.util.ArrayList;

public class LanguagesAdapter extends RecyclerView.Adapter<LanguagesAdapter.ViewHolder> {

    private ArrayList<Language> data = new ArrayList<>();

    public void setData(ArrayList<Language> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemLanguagesBinding binding = ItemLanguagesBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Language language = data.get(position);
        holder.bindView(language);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemLanguagesBinding binding;

        public ViewHolder(ItemLanguagesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindView(Language language){
            binding.imgLanguage.setImageResource(language.getImageSrc());
            binding.txtLanguages.setText(language.getNameLanguage());
        }

    }

}
