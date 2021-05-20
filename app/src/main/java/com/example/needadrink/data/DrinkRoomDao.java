package com.example.needadrink.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

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

        @Query("Select * from drink_table where strDrink LIKE :search")
        LiveData<List<Drink>> getSearchDrinks(String search);

        @Query("Update drink_table set isFav = 1 Where idDrink = :drinkID ")
        void setFav(String drinkID);

        @Query("Update drink_table set isFav = 0 Where idDrink = :drinkID ")
        void removeFav(String drinkID);


        @Query("SELECT * FROM drink_table where isFav = 1")
        LiveData<List<Drink>> getFavDrinks();
    }
