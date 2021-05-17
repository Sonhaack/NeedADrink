package com.example.needadrink.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DrinkRoomDao
    {
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertDrink(Drink... drinks);


        @Query("DELETE from drink_table")
        void clearTable();

        @Query("SELECT * FROM drink_table")
        LiveData<List<Drink>> getAllDrinks();

        @Query("Update drink_table set isFav = 'true' Where idDrink = :drinkID ")
        void setFav(String drinkID);


    }
