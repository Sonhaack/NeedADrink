package com.example.needadrink.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.needadrink.R;
import com.example.needadrink.data.ServiceGenerator;

public class HomeFragment extends Fragment
    {
        private HomeViewModel homeViewModel;


        public View onCreateView(@NonNull LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState)
            {
                homeViewModel = new ViewModelProvider(getActivity()).get(HomeViewModel.class);
                View root = inflater.inflate(R.layout.fragment_home, container, false);




                 EditText name = root.findViewById(R.id.editTextTextPersonName);

                 Button buttonSearch = root.findViewById(R.id.button_search);


                buttonSearch.setOnClickListener(v ->
                {
                    homeViewModel.searchDrink(name.getText().toString());

                });
                return root;
            }
    }