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

import com.example.needadrink.R;
import com.example.needadrink.ui.RecyclerView.RecyclerFragment;
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
                    Toast.makeText(getContext(), ":) ", Toast.LENGTH_SHORT).show();

                });

                return root;
            }
    }