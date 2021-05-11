package com.example.needadrink.data;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DrinkRepository
    {
        private DrinkRoomDao drinkRoomDao;
        private LiveData<List<Drink>> getAllDrinks;
        private MutableLiveData<List<DrinkResponse>> listSearchDrink;

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
                Call<List<DrinkResponse>> call = ServiceGenerator.getDrinkApi().searchDrink(drink);
                call.enqueue(new Callback<List<DrinkResponse>>()
                    {
                        @Override
                        public void onResponse(Call<List<DrinkResponse>> call, Response<List<DrinkResponse>> response)
                            {
                                if(response.isSuccessful())
                                    {
                                        listSearchDrink.setValue(response.body());
                                    }
                            }

                        @Override
                        public void onFailure(Call<List<DrinkResponse>> call, Throwable t)
                            {
                                Log.i("Retrofit", "Something went wrong with retrofit :(");
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
