package com.example.needadrink.ui.result;


import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.needadrink.data.ApiResponseDrink;
import com.example.needadrink.data.Drink;
import com.example.needadrink.data.DrinkRepository;

import java.util.List;

public class ResultViewModel extends AndroidViewModel
    {

        private DrinkRepository drinkRepository;
        private LiveData<List<Drink>> allDrinks;

        public ResultViewModel(Application application)
            {
                super(application);
                drinkRepository = new DrinkRepository(application);
                allDrinks = drinkRepository.getAllDrinks();

            }

        public void removeFav(String drinkID)
            {
                drinkRepository.removeFavDrink(drinkID);
            }

        public void setFav(String drinkID)
            {
                drinkRepository.setFavDrink(drinkID);
            }

        public LiveData<List<ApiResponseDrink>> getRandomDrink()
            {
                return drinkRepository.getDrinkRandom();
            }

        public void getRandomDrinkFromApi()
            {
                drinkRepository.randomDrink();
            }
    }
