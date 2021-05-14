package com.example.needadrink.data;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import javax.security.auth.login.LoginException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DrinkRepository
    {
        private DrinkRoomDao drinkRoomDao;
        private LiveData<List<Drink>> getAllDrinks;
        private MutableLiveData<List<ApiResponseDrink>> listSearchDrink;

        public DrinkRepository(Application application)
            {
                listSearchDrink = new MutableLiveData<>();

                DrinkDatabase Database = DrinkDatabase.getDatabase(application);
                drinkRoomDao = Database.drinkRoomDao();
                getAllDrinks = drinkRoomDao.getAllDrinks();
            }


        public void insert(Drink drink)
            {
                new InsertDrinkAsyncTask(drinkRoomDao).execute(drink);
            }

        public LiveData<List<Drink>> getAllDrinks()
            {
                return getAllDrinks;
            }

        public void searchDrink(String drink)
            {
                //api call
                Call<ApiResponseContainer> call = ServiceGenerator.getDrinkApi().searchDrink(drink);
                call.enqueue(new Callback<ApiResponseContainer>()
                    {

                        @Override
                        public void onResponse(Call<ApiResponseContainer> call, Response<ApiResponseContainer> response)
                            {
                                listSearchDrink.setValue(response.body().getDrinks());
                                Log.e("Retrofit","Yes!");

                                for (ApiResponseDrink ard: response.body().getDrinks())
                                    {
                                        insert(new Drink(ard));
                                    }
                            }

                        @Override
                        public void onFailure(Call<ApiResponseContainer> call, Throwable t)
                            {
                                Log.i("Retrofit", "Retrofit Failure:" + t.getMessage());
                            }
                    });
            }

        private static class InsertDrinkAsyncTask extends AsyncTask<Drink, Void, Void>
            {

                private DrinkRoomDao drinkRoomDao;

                private InsertDrinkAsyncTask(DrinkRoomDao drinkRoomDao)
                    {
                        this.drinkRoomDao = drinkRoomDao;
                    }

                @Override
                protected Void doInBackground(final Drink... drinks)
                    {
                        drinkRoomDao.insertDrink(drinks[0]);
                        return null;
                    }
            }

    }
