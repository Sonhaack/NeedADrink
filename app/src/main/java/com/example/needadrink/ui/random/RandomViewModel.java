package com.example.needadrink.ui.random;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RandomViewModel extends ViewModel
    {

        private MutableLiveData<String> mText;

        public RandomViewModel()
            {
                mText = new MutableLiveData<>();
                mText.setValue("This is slideshow fragment");
            }

        public LiveData<String> getText()
            {
                return mText;
            }



    }