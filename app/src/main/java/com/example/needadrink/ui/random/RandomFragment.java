package com.example.needadrink.ui.random;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.needadrink.R;
import com.example.needadrink.ui.result.ResultActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RandomFragment extends Fragment
    {

        private RandomViewModel randomViewModel;

        public View onCreateView(@NonNull LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState)
            {
                randomViewModel = new ViewModelProvider(this).get(RandomViewModel.class);
                View root = inflater.inflate(R.layout.fragment_random, container, false);
                Button random = root.findViewById(R.id.random_drink_button);

                random.setOnClickListener(v ->
                {

                    randomViewModel.getRandomDrink();
                });

                return root;
            }

    }