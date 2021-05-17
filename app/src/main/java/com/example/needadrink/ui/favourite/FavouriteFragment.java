package com.example.needadrink.ui.favourite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.needadrink.R;
import com.google.android.material.navigation.NavigationView;

public class FavouriteFragment extends Fragment
    {

        private FavouriteViewModel favouriteViewModel;

        public View onCreateView(@NonNull LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState)
            {
                favouriteViewModel = new ViewModelProvider(this).get(FavouriteViewModel.class);
                View root = inflater.inflate(R.layout.fragment_favourite, container, false);
                final TextView textView = root.findViewById(R.id.text_gallery);
                final Button button = root.findViewById(R.id.change_fragment_button);
                final FrameLayout frameLayout = root.findViewById(R.id.framelayout_gallery);

                button.setOnClickListener(v ->
                {
                    NavigationView.inflate(getContext(),R.layout.fragment_slideshow,container);

                });


                favouriteViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>()
                    {
                        @Override
                        public void onChanged(@Nullable String s)
                            {
                                textView.setText(s);
                            }
                    });
                return root;
            }
    }