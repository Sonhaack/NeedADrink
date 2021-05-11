package com.example.needadrink.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.needadrink.R;
import com.example.needadrink.data.DrinkApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResultActivity extends AppCompatActivity
    {

        @Override
        protected void onCreate(Bundle savedInstanceState)
            {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_result);

            }
    }