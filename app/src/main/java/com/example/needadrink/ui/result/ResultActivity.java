package com.example.needadrink.ui.result;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.needadrink.R;
import com.example.needadrink.data.DownloadImageTask;
import com.example.needadrink.data.Drink;
import com.example.needadrink.data.DrinkAdapter;
import com.google.gson.Gson;

import java.io.InputStream;

public class ResultActivity extends AppCompatActivity
    {
        private ResultViewModel resultViewModel;

        @Override
        protected void onCreate(Bundle savedInstanceState)
            {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_result);
                Bundle extra = getIntent().getExtras();

                ImageView img = findViewById(R.id.result_image);
                ImageView fav = findViewById(R.id.result_heart);
                TextView drinkname = findViewById(R.id.result_drinkname);
                TextView alcoholic = findViewById(R.id.result_alcoholic);
                TextView ingredient = findViewById(R.id.result_ingredients);
                TextView instructions = findViewById(R.id.result_instructions);

                String drinkJson;
                if(extra != null)
                    {
                        drinkJson = extra.getString("drink");
                        Gson gson = new Gson();
                        Drink drink = gson.fromJson(drinkJson, Drink.class);


                        drinkname.setText(drink.getStrDrink());
                        alcoholic.setText(drink.getStrAlcoholic());

                        String ingredients = "";

                        if(drink.getStrIngredient1() != null)
                            ingredients += drink.getStrIngredient1() + ", ";
                        if(drink.getStrMeasure1() != null)
                            ingredients += " " + drink.getStrMeasure1() + "\n";

                        if(drink.getStrIngredient2() != null)
                            ingredients += drink.getStrIngredient2() + ", ";
                        if(drink.getStrMeasure2() != null)
                            ingredients += drink.getStrMeasure2() + "\n";;

                        if(drink.getStrIngredient3() != null)
                            ingredients += drink.getStrIngredient3() + ", ";
                        if(drink.getStrMeasure3() != null)
                            ingredients += drink.getStrMeasure3() + "\n";;

                        if(drink.getStrIngredient4() != null)
                            ingredients += drink.getStrIngredient4() + ", ";
                        if(drink.getStrMeasure4() != null)
                            ingredients += drink.getStrMeasure4() + "\n";

                        if(drink.getStrIngredient5() != null)
                            ingredients += drink.getStrIngredient5() + ", ";
                        if(drink.getStrMeasure5() != null)
                            ingredients += drink.getStrMeasure5() + "\n";;

                        if(drink.getStrIngredient6() != null)
                            ingredients += drink.getStrIngredient6() + ", ";
                        if(drink.getStrMeasure6() != null)
                            ingredients += drink.getStrMeasure6() + "\n";;

                        if(drink.getStrIngredient7() != null)
                            ingredients += drink.getStrIngredient7() + ", ";
                        if(drink.getStrMeasure7() != null)
                            ingredients += drink.getStrMeasure7() + "\n";;

                        if(drink.getStrIngredient8() != null)
                            ingredients += drink.getStrIngredient8() + ", ";
                        if(drink.getStrMeasure8() != null)
                            ingredients += drink.getStrMeasure8() + "\n";;

                        ingredient.setText(ingredients);
                        instructions.setText(drink.getStrInstructions());
                        new DownloadImageTask(img).execute(drink.strDrinkThumb);

                        fav.setOnClickListener(v ->
                        {
//                            resultViewModel.setFav(drink.idDrink);
                            Toast.makeText(this, "Added to favourites", Toast.LENGTH_SHORT).show();
                        });
                    }
            }
    }