package com.example.needadrink.data;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DrinkRepository
    {
        private DrinkRoomDao drinkRoomDao;
        private LiveData<List<Drink>> getAllDrinks;
        private LiveData<List<Drink>> getFavDrinks;
        private MutableLiveData<List<Drink>> getSearchDrinks;
        private MutableLiveData<List<ApiResponseDrink>> listSearchDrink;
        private MutableLiveData<List<ApiResponseDrink>> randomDrink;


        public DrinkRepository(Application application)
            {
                listSearchDrink = new MutableLiveData<>();
                randomDrink = new MutableLiveData<>();
                DrinkDatabase Database = DrinkDatabase.getDatabase(application);
                drinkRoomDao = Database.drinkRoomDao();
                getAllDrinks = drinkRoomDao.getAllDrinks();
                getFavDrinks = drinkRoomDao.getFavDrinks();
                getSearchDrinks = new MutableLiveData<>();
            }


        public void insert(Drink drink)
            {
                new InsertDrinkAsyncTask(drinkRoomDao).execute(drink);
            }



        public void setSearchDrinks(String search)
            {
                getSearchDrinks.setValue(drinkRoomDao.getSearchDrinks(search).getValue());
            }

        public LiveData<List<Drink>> getSearchDrinks()
            {
                return getSearchDrinks;
            }

        public LiveData<List<Drink>> getAllDrinks()
            {
                return getAllDrinks;
            }


        public LiveData<List<Drink>> getFavDrinks()
            {
                return getFavDrinks;
            }


        //api calls
        public void searchDrink(String drink)
            {

                Call<ApiResponseContainer> call = ServiceGenerator.getDrinkApi().searchDrink(drink);
                call.enqueue(new Callback<ApiResponseContainer>()
                    {

                        @Override
                        public void onResponse(Call<ApiResponseContainer> call, Response<ApiResponseContainer> response)
                            {
                                ArrayList<Drink> drinkslist = new ArrayList<>();
                                listSearchDrink.setValue(response.body().getDrinks());
                                Log.i("Retrofit","search for drink list found");
                                getAllDrinks = drinkRoomDao.getSearchDrinks(drink);
                                for (ApiResponseDrink ard: response.body().getDrinks())
                                    {
                                        drinkslist.add(new Drink(ard));
                                        insert(new Drink(ard));
                                    }
                                getSearchDrinks.setValue(drinkslist);
                            }

                        @Override
                        public void onFailure(Call<ApiResponseContainer> call, Throwable t)
                            {
                                Log.e("Retrofit", "Retrofit Failure:" + t.getMessage());
                            }
                    });
            }
        public void randomDrink()
            {

                Call<ApiResponseContainer> call = ServiceGenerator.getDrinkApi().randomDrink();
                call.enqueue(new Callback<ApiResponseContainer>()
                    {
                        @Override
                        public void onResponse(Call<ApiResponseContainer> call, Response<ApiResponseContainer> response)
                            {
                                randomDrink.setValue(response.body().getDrinks());
                                Log.i("Retrofit",response.body().getDrinks().get(0).getStrDrink());
                            }

                        @Override
                        public void onFailure(Call<ApiResponseContainer> call, Throwable t)
                            {
                                Log.e("Retrofit", "Retrofit Failure random: " + t.getMessage());
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

        public void setFavDrink(String drinkID)
            {
                drinkRoomDao.setFav(drinkID);
            }

        public LiveData<List<ApiResponseDrink>> getDrinkRandom()
            {
                return randomDrink;
            }
    }
