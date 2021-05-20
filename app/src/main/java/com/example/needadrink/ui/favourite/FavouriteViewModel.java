package com.example.needadrink.ui.favourite;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.needadrink.data.Drink;
import com.example.needadrink.data.DrinkRepository;

import java.util.List;

public class FavouriteViewModel extends AndroidViewModel
    {

        private DrinkRepository drinkRepository;
        private LiveData<List<Drink>> allFavDrinks;

        public FavouriteViewModel(Application application)
            {
                super(application);
                drinkRepository = new DrinkRepository(application);
                allFavDrinks = drinkRepository.getFavDrinks();
            }

        public LiveData<List<Drink>> getAllFavDrinks()
            {
                return allFavDrinks;
            }
    }