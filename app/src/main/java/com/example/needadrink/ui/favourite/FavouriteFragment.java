package com.example.needadrink.ui.favourite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.needadrink.R;
import com.example.needadrink.data.DrinkAdapter;
import com.example.needadrink.ui.RecyclerView.RecyclerFragment;
import com.example.needadrink.ui.RecyclerView.RecyclerViewModel;
import com.google.android.material.navigation.NavigationView;

public class FavouriteFragment extends Fragment
    {

        private FavouriteViewModel favouriteViewModel;

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState)
            {
                favouriteViewModel = new ViewModelProvider(this).get(FavouriteViewModel.class);
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
                                //adapter
                            }
                    });

                favouriteViewModel.getAllFavDrinks().observe(getViewLifecycleOwner(), drinks -> drinkAdapter.setDrinks(drinks));
                return root;
            }
    }