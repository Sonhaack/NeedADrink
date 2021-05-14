package com.example.needadrink.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.needadrink.R;

import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder>
    {
        private final LayoutInflater inflater;
        private List<Drink> drinks = new ArrayList<>();
        OnListItemClickListener listItemClickListener;

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

                public DrinkViewHolder(@NonNull View itemView)
                    {
                        super(itemView);
                        textViewName = itemView.findViewById(R.id.drink_Name);
                        textViewAlcoholic = itemView.findViewById(R.id.drink_alcoholic);
                        img = itemView.findViewById(R.id.imageView2);
                    }
                public void loadImage(String url){
                    new DownloadImageTask(img).execute(url);
                }




                private class DownloadImageTask extends AsyncTask<String, Void, Bitmap>
                    {
                    ImageView bmImage;

                    public DownloadImageTask(ImageView bmImage) {
                        this.bmImage = bmImage;
                    }

                    protected Bitmap doInBackground(String... urls) {
                        String urldisplay = urls[0];
                        Bitmap mIcon11 = null;
                        try {
                            InputStream in = new java.net.URL(urldisplay).openStream();
                            mIcon11 = BitmapFactory.decodeStream(in);
                        } catch (Exception e) {
                            Log.e("Error", e.getMessage());
                            e.printStackTrace();
                        }
                        return mIcon11;
                    }

                    protected void onPostExecute(Bitmap result) {
                        bmImage.setImageBitmap(result);
                    }
                }

            }

        public interface OnListItemClickListener
            {
                void onClick();
            }


    }
