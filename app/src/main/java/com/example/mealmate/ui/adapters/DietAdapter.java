package com.example.mealmate.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mealmate.R;
import com.example.mealmate.model.DietModel;

import java.util.ArrayList;
import java.util.List;

public class DietAdapter extends RecyclerView.Adapter<DietAdapter.DietViewHolder> {
    private List<DietModel> diets = new ArrayList<>();
    private OnDietClickListener listener;

    public interface OnDietClickListener {
        void onDietClick(DietModel diet);
    }

    public DietAdapter(OnDietClickListener listener) {
        this.listener = listener;
    }

    public void setDiets(List<DietModel> diets) {
        this.diets = diets;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DietViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_diet, parent, false);
        return new DietViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DietViewHolder holder, int position) {
        DietModel diet = diets.get(position);
        holder.nameTextView.setText(diet.getName());
        holder.itemView.setOnClickListener(v -> listener.onDietClick(diet));
    }

    @Override
    public int getItemCount() {
        return diets.size();
    }

    static class DietViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;

        public DietViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.diet_name);
        }
    }
}