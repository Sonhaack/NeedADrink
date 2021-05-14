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
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.needadrink.R;
import com.example.needadrink.data.ServiceGenerator;
import com.example.needadrink.ui.RecyclerView.RecyclerFragment;

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

                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    RecyclerFragment fragment = new RecyclerFragment();
                    fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
                    fragmentTransaction.addToBackStack( "tag" );
                    fragmentTransaction.commit();



                });
                return root;
            }
    }