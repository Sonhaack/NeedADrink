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
       private LiveData<List<Drink>> allDrinks;


        public HomeViewModel(@NonNull Application application)
            {
                super(application);
                repository = new DrinkRepository(application);
                allDrinks = repository.getAllDrinks();

            }

        LiveData<List<Drink>> getAllDrinks()
            {
                return allDrinks;
            }

//        public void insert(Drink drink)
//            {
//                repository.insert(drink);
//            }
//
        public void searchDrink(String drink)
            {
                repository.searchDrink(drink);
            }


    }