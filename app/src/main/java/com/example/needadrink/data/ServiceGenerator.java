package com.example.needadrink.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator
    {
        private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create());

        private static Retrofit retrofit = retrofitBuilder.build();

        private static DrinkApi drinkApi = retrofit.create(DrinkApi.class);

        public static DrinkApi getDrinkApi()
            {
                return drinkApi;
            }
    }
