package com.example.needadrink.ui.result;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.needadrink.R;
import com.example.needadrink.data.ApiResponseDrink;
import com.example.needadrink.data.DownloadImageTask;
import com.example.needadrink.data.Drink;
import com.google.gson.Gson;

import java.util.List;


public class ResultActivity extends AppCompatActivity
    {
        private ResultViewModel resultViewModel;
        MutableLiveData<Drink> drink;
        ImageView img;
        ImageView fav;
        TextView drinkname;
        TextView alcoholic;
        TextView ingredient;
        TextView instructions;
        @Override
        protected void onCreate(Bundle savedInstanceState)
            {
                resultViewModel = new ViewModelProvider(this).get(ResultViewModel.class);
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_result);
                Bundle extra = getIntent().getExtras();

                drink = new MutableLiveData<>();
                img = findViewById(R.id.result_image);
                fav = findViewById(R.id.result_heart);
                drinkname = findViewById(R.id.result_drinkname);
                alcoholic = findViewById(R.id.result_alcoholic);
                ingredient = findViewById(R.id.result_ingredients);
                instructions = findViewById(R.id.result_instructions);


                String drinkJson;
                if(extra != null)
                    {
                        drinkJson = extra.getString("drink");
                        if(drinkJson.equals("random"))
                            {
                                resultViewModel.getRandomDrink().observeForever(new Observer<List<ApiResponseDrink>>()
                                    {
                                        @Override
                                        public void onChanged(List<ApiResponseDrink> apiResponseDrinks)
                                            {
                                                drink.setValue(new Drink(apiResponseDrinks.get(0)));
                                                setView();
                                            }
                                    });
                            }
                        else
                            {
                                Gson gson = new Gson();
                                drink.setValue(gson.fromJson(drinkJson, Drink.class));
                                setView();
                            }
                    }
                resultViewModel.getRandomDrinkFromApi();
            }
        private void setView()
            {
                drinkname.setText(drink.getValue().getStrDrink());
                alcoholic.setText(drink.getValue().getStrAlcoholic());

                String ingredients = "";

                if(drink.getValue().getStrIngredient1() != null)
                    ingredients += drink.getValue().getStrIngredient1() + ", ";
                if(drink.getValue().getStrMeasure1() != null)
                    ingredients += " " + drink.getValue().getStrMeasure1() + "\n";

                if(drink.getValue().getStrIngredient2() != null)
                    ingredients += drink.getValue().getStrIngredient2() + ", ";
                if(drink.getValue().getStrMeasure2() != null)
                    ingredients += drink.getValue().getStrMeasure2() + "\n";;

                if(drink.getValue().getStrIngredient3() != null)
                    ingredients += drink.getValue().getStrIngredient3() + ", ";
                if(drink.getValue().getStrMeasure3() != null)
                    ingredients += drink.getValue().getStrMeasure3() + "\n";;

                if(drink.getValue().getStrIngredient4() != null)
                    ingredients += drink.getValue().getStrIngredient4() + ", ";
                if(drink.getValue().getStrMeasure4() != null)
                    ingredients += drink.getValue().getStrMeasure4() + "\n";

                if(drink.getValue().getStrIngredient5() != null)
                    ingredients += drink.getValue().getStrIngredient5() + ", ";
                if(drink.getValue().getStrMeasure5() != null)
                    ingredients += drink.getValue().getStrMeasure5() + "\n";;

                if(drink.getValue().getStrIngredient6() != null)
                    ingredients += drink.getValue().getStrIngredient6() + ", ";
                if(drink.getValue().getStrMeasure6() != null)
                    ingredients += drink.getValue().getStrMeasure6() + "\n";;

                if(drink.getValue().getStrIngredient7() != null)
                    ingredients += drink.getValue().getStrIngredient7() + ", ";
                if(drink.getValue().getStrMeasure7() != null)
                    ingredients += drink.getValue().getStrMeasure7() + "\n";;

                if(drink.getValue().getStrIngredient8() != null)
                    ingredients += drink.getValue().getStrIngredient8() + ", ";
                if(drink.getValue().getStrMeasure8() != null)
                    ingredients += drink.getValue().getStrMeasure8() + "\n";;

                ingredient.setText(ingredients);
                instructions.setText(drink.getValue().getStrInstructions());
                new DownloadImageTask(img).execute(drink.getValue().strDrinkThumb);

                fav.setOnClickListener(v ->
                {


                    if(drink.getValue().isFav == 0)
                        {
                            Toast.makeText(getBaseContext(), "Added to favorites", Toast.LENGTH_SHORT).show();
                            resultViewModel.setFav(drink.getValue().idDrink);
                        }
                    else
                        {
                            resultViewModel.removeFav(drink.getValue().idDrink);
                            Toast.makeText(getBaseContext(), "Removed from favorites", Toast.LENGTH_SHORT).show();
                        }
                });
            }
    }