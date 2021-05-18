package com.example.needadrink.data;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.needadrink.R;
import com.example.needadrink.ui.result.ResultActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder>
    {
        private final LayoutInflater inflater;
        private List<Drink> drinks = new ArrayList<>();
        private OnListItemClickListener onListItemClickListener;

        public interface OnListItemClickListener
            {
                void onClick(int position);
            }

        public void setOnListItemClickListener(OnListItemClickListener listener)
            {
                onListItemClickListener = listener;
            }


        public DrinkAdapter(Context context)
            {
                this.inflater = LayoutInflater.from(context);
            }

        @NonNull
        @Override
        public DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
            {
                View itemView = inflater.from(parent.getContext()).inflate(R.layout.drink_item, parent, false);
                DrinkViewHolder drinkViewHolder = new DrinkViewHolder(itemView, onListItemClickListener);
                return new DrinkViewHolder(itemView, onListItemClickListener);
            }

        @Override
        public void onBindViewHolder(@NonNull DrinkViewHolder holder, int position)
            {
                Drink currentDrink = drinks.get(position);
                holder.textViewName.setText(currentDrink.getStrDrink());
                holder.textViewAlcoholic.setText(currentDrink.getStrAlcoholic());
                holder.loadImage(currentDrink.getStrDrinkThumb());
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

                public DrinkViewHolder(@NonNull View itemView, OnListItemClickListener listener)
                    {
                        super(itemView);
                        textViewName = itemView.findViewById(R.id.drink_Name);
                        textViewAlcoholic = itemView.findViewById(R.id.drink_alcoholic);
                        img = itemView.findViewById(R.id.imageView2);
                        itemView.setOnClickListener(new View.OnClickListener()
                            {
                                @Override
                                public void onClick(View v)
                                    {

                                        if (listener != null)
                                            {
                                                int position = getAdapterPosition();
                                                if (position != RecyclerView.NO_POSITION)
                                                    {
                                                        onListItemClickListener.onClick(position);
                                                        Intent intent = new Intent(v.getContext(), ResultActivity.class);
                                                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                                                        Drink drink = drinks.get(position);
                                                        String jsonString = gson.toJson(drink);
                                                        intent.putExtra("drink", jsonString);
                                                        v.getContext().startActivity(intent);
                                                    }
                                            }
                                    }
                            });
                    }
                public void loadImage(String url)
                    {
                        new DownloadImageTask(img).execute(url);
                    }
            }
    }
