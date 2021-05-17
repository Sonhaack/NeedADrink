package com.example.needadrink.data;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.needadrink.ui.RecyclerView.RecyclerViewModel;

@Database(entities = {Drink.class}, version = 10, exportSchema = false)
public abstract class DrinkDatabase extends RoomDatabase
    {
        private static DrinkDatabase instance;

        public abstract DrinkRoomDao drinkRoomDao();

        public static synchronized DrinkDatabase getDatabase(final Context context)
            {
                if (instance == null)
                    {
                        synchronized (DrinkDatabase.class)
                            {
                                if (instance == null)
                                    {
                                        instance = Room.databaseBuilder(context.getApplicationContext(), DrinkDatabase.class, "drink_database")
                                                .fallbackToDestructiveMigration()
                                                .allowMainThreadQueries()
                                                .build();
                                    }
                            }
                    }
                return instance;
            }
    }
