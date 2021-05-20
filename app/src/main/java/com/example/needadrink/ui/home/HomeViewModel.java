package com.example.needadrink.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.needadrink.data.Drink;
import com.example.needadrink.data.DrinkDatabase;
import com.example.needadrink.data.DrinkRepository;

import java.util.List;

public class HomeViewModel extends AndroidViewModel
    {
       private DrinkRepository repository;



        public HomeViewModel(@NonNull Application application)
            {
                super(application);
                repository = new DrinkRepository(application);
            }
        public void searchDrink(String drink)
            {
                repository.setSearchDrinks(drink);
                repository.searchDrink(drink);

            }



    }