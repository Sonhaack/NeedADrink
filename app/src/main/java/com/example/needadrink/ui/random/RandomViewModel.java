package com.example.needadrink.ui.random;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.needadrink.MainActivity;
import com.example.needadrink.data.Drink;
import com.example.needadrink.data.DrinkRepository;
import com.example.needadrink.ui.result.ResultActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RandomViewModel extends AndroidViewModel
    {
        private DrinkRepository repository;
        private Drink randomDrink;


        public RandomViewModel(@NonNull @NotNull Application application)
            {
                super(application);
                repository = new DrinkRepository(application);
            }

        public void getRandomDrink()
            {
                repository.randomDrink();
                Intent intent = new Intent(getApplication(), ResultActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
                intent.putExtra("drink", "random");
                getApplication().getApplicationContext().startActivity(intent);
            }
    }