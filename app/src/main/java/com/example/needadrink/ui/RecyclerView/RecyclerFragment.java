package com.example.needadrink.ui.RecyclerView;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.needadrink.R;
import com.example.needadrink.data.DrinkAdapter;

public class RecyclerFragment extends Fragment
    {

        private RecyclerViewModel recyclerViewModel;

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState)
            {
                recyclerViewModel = new ViewModelProvider(this).get(RecyclerViewModel.class);
                View root = inflater.inflate(R.layout.fragment_recycler, container, false);

                final RecyclerView recyclerView = root.findViewById(R.id.r_v);
                recyclerView.hasFixedSize();
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                DrinkAdapter drinkAdapter = new DrinkAdapter(getContext());
                recyclerView.setAdapter(drinkAdapter);
                drinkAdapter.setOnListItemClickListener(new DrinkAdapter.OnListItemClickListener()
                    {
                        @Override
                        public void onClick(int position)
                            {
                                // DrinkAdapter
                            }
                    });
                recyclerViewModel.getAllDrinks().observe(getViewLifecycleOwner(), drinks ->
                {
                    drinkAdapter.setDrinks(drinks);
                });
                drinkAdapter.clearList();
                return root;
            }


    }