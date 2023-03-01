package com.example.appandroid.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appandroid.R;

import java.util.List;

public class TypeOfFoodAdapter extends RecyclerView.Adapter<TypeOfFoodAdapter.TypeOfFoodViewHolder> {

    private List<TypeOfFood> listTypeOfFood ;

    public TypeOfFoodAdapter(List<TypeOfFood> listTypeOfFood) {
        this.listTypeOfFood = listTypeOfFood;
    }
    @NonNull
    @Override
    public TypeOfFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type_of_food, parent, false);
        return new TypeOfFoodViewHolder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull TypeOfFoodViewHolder holder, int position) {
        TypeOfFood typeOfFood = listTypeOfFood.get(position);
        if(typeOfFood == null) {
            return;
        }
        holder.food_image.setImageResource(typeOfFood.getImg());
        holder.food_name.setText(typeOfFood.getName());
    }

    @Override
    public int getItemCount() {
        if(listTypeOfFood != null) {
            return  listTypeOfFood.size();
        }
        return 0;
    }

    public class TypeOfFoodViewHolder extends RecyclerView.ViewHolder {

        private ImageView food_image;
        private TextView food_name;
        public TypeOfFoodViewHolder(@NonNull View itemView) {
            super(itemView);
            food_image = itemView.findViewById(R.id.food_image);
            food_name = itemView.findViewById(R.id.food_name);
        }
    }
}
