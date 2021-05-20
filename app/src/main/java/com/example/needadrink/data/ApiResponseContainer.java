package com.example.needadrink.data;

import java.util.List;

public class ApiResponseContainer
    {
        private List<ApiResponseDrink> drinks;

        public ApiResponseContainer(){}

        public List<ApiResponseDrink> getDrinks()
            {
                return drinks;
            }

    }
