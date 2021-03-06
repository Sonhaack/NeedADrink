package com.example.needadrink.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DrinkApi
    {

        @GET("search.php")
        Call<ApiResponseContainer> searchDrink(@Query("s") String drink);

        @GET("random.php")
        Call<ApiResponseContainer> randomDrink();
    }
