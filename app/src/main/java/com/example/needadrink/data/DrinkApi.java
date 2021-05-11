package com.example.needadrink.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DrinkApi
    {
//        @GET("search.php?s={drink}")
//        Call<List<DrinkResponse>> searchDrink(@Path("drink") String drink);

        @GET("search.php")
        Call<List<DrinkResponse>> searchDrink(@Query("s") String drink);

    }
