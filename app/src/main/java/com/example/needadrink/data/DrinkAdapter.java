package com.example.needadrink.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.needadrink.R;

import java.util.ArrayList;
import java.util.List;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder>
    {
        private final LayoutInflater inflater;
        private List<Drink> drinks = new ArrayList<>();

        public DrinkAdapter(Context context)
            {
                this.inflater = LayoutInflater.from(context);
            }

        @NonNull
        @Override
        public DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
            {
                View itemView = inflater.from(parent.getContext()).inflate(R.layout.drink_item,parent,false);
                return new DrinkViewHolder(itemView);
            }

        @Override
        public void onBindViewHolder(@NonNull DrinkViewHolder holder, int position)
            {
                Drink currentDrink = drinks.get(position);
                holder.textViewName.setText(currentDrink.getName());
                holder.textViewAlcoholic.setText(currentDrink.getAlcoholic());
            }

        @Override
        public int getItemCount()
            {
                return drinks.size();
            }

        public void setDrinks(List<Drink> drinks)
            {
                this.drinks = drinks;
                notifyDataSetChanged();
            }

        class DrinkViewHolder extends RecyclerView.ViewHolder
            {

                private TextView textViewName;
                private TextView textViewAlcoholic;
                private ImageView img;

                public DrinkViewHolder(@NonNull View itemView)
                    {
                        super(itemView);
                        textViewName = itemView.findViewById(R.id.drink_Name);
                        textViewAlcoholic = itemView.findViewById(R.id.drink_alcoholic);
                        img = itemView.findViewById(R.id.drink_Image);
                    }
            }
    }
