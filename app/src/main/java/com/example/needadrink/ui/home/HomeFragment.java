package com.example.needadrink.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.needadrink.MainActivity;
import com.example.needadrink.R;
import com.example.needadrink.data.Drink;
import com.example.needadrink.data.DrinkAdapter;
import com.example.needadrink.data.DrinkRepository;

import java.util.List;

public class HomeFragment extends Fragment
    {
        private HomeViewModel homeViewModel;


        public View onCreateView(@NonNull LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState)
            {
                homeViewModel = new ViewModelProvider(getActivity()).get(HomeViewModel.class);
                View root = inflater.inflate(R.layout.fragment_home, container, false);

                 EditText id = root.findViewById(R.id.editTextTextPersonName);
                 EditText name = root.findViewById(R.id.editTextTextPersonName2);
                 EditText alcoholic = root.findViewById(R.id.editTextTextPersonName3);
                 EditText instructions = root.findViewById(R.id.editTextTextPersonName4);
                 EditText ingredient1 = root.findViewById(R.id.editTextTextPersonName5);
                 EditText ingredient2 = root.findViewById(R.id.editTextTextPersonName6);
                 EditText ingredient3 = root.findViewById(R.id.editTextTextPersonName7);
                 EditText ingredient4 = root.findViewById(R.id.editTextTextPersonName8);
                 EditText img = root.findViewById(R.id.editTextTextImg);
                 Button buttonInsert = root.findViewById(R.id.buttonInsert);


                buttonInsert.setOnClickListener(v ->
                {

                    Drink drink = new Drink(
                            id.getText().toString(),
                            name.getText().toString(),
                            alcoholic.getText().toString(),
                            instructions.getText().toString(),
                            ingredient1.getText().toString(),
                            ingredient2.getText().toString(),
                            ingredient3.getText().toString(),
                            ingredient4.getText().toString(),
                            img.getText().toString()
                    );

                    homeViewModel.insert(drink);

                });
                return root;
            }
    }