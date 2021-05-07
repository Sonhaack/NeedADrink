package com.example.needadrink.data;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class DrinkRepository
    {
        private DrinkRoomDao drinkRoomDao;
        private LiveData<List<Drink>> getAllDrinks;

        public DrinkRepository(Application application)
            {
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

        private static class InsertDrinkAsyncTask extends AsyncTask<Drink,Void,Void>
            {

                private DrinkRoomDao drinkRoomDao;

                private InsertDrinkAsyncTask(DrinkRoomDao drinkRoomDao)
                    {
                        this.drinkRoomDao = drinkRoomDao;
                    }

                @Override
                protected Void doInBackground( final Drink... drinks)
                    {
                        drinkRoomDao.insertDrink(drinks[0]);
                        return null;
                    }
            }

    }
