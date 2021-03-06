package com.example.needadrink.ui.RecyclerView;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.needadrink.data.Drink;
import com.example.needadrink.data.DrinkRepository;

import java.util.List;

public class RecyclerViewModel extends AndroidViewModel
    {

        private DrinkRepository drinkRepository;
        private LiveData<List<Drink>> allDrinks;
        private LiveData<List<Drink>> searchDrinks;

        public RecyclerViewModel(Application application)
            {
                super(application);
                drinkRepository = new DrinkRepository(application);
                allDrinks = drinkRepository.getAllDrinks();
                searchDrinks = drinkRepository.getSearchDrinks();
            }
        public LiveData<List<Drink>> getAllDrinks()
            {
                return allDrinks;
            }

        public LiveData<List<Drink>> getSearchDrinks()
            {
                return drinkRepository.getSearchDrinks();
            }
    }