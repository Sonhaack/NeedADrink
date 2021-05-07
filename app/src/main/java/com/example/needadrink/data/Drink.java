package com.example.needadrink.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "drink_table")
public class Drink
    {
        @PrimaryKey
        @NonNull
        private String ID;
        private String name;
        private String alcoholic;
        private String instructions;
        private String ingredient1;
        private String ingredient2;
        private String ingredient3;
        private String ingredient4;
        private String ingredient5;
        private String ingredient6;
        private String ingredient7;
        private String ingredient8;
        private String img;

        public Drink(String ID, String name, String alcoholic, String instructions, String ingredient1, String ingredient2, String ingredient3, String ingredient4, String img)
            {
                this.ID = ID;
                this.name = name;
                this.alcoholic = alcoholic;
                this.instructions = instructions;
                this.ingredient1 = ingredient1;
                this.ingredient2 = ingredient2;
                this.ingredient3 = ingredient3;
                this.ingredient4 = ingredient4;
                this.ingredient5 = null;
                this.ingredient6 = null;
                this.ingredient7 = null;
                this.ingredient8 = null;
                this.img = img;
            }

        public String getID()
            {
                return ID;
            }

        public void setID(String ID)
            {
                this.ID = ID;
            }

        public String getName()
            {
                return name;
            }

        public void setName(String name)
            {
                this.name = name;
            }

        public String getAlcoholic()
            {
                return alcoholic;
            }

        public void setAlcoholic(String alcoholic)
            {
                this.alcoholic = alcoholic;
            }

        public String getInstructions()
            {
                return instructions;
            }

        public void setInstructions(String instructions)
            {
                this.instructions = instructions;
            }

        public String getIngredient1()
            {
                return ingredient1;
            }

        public void setIngredient1(String ingredient1)
            {
                this.ingredient1 = ingredient1;
            }

        public String getIngredient2()
            {
                return ingredient2;
            }

        public void setIngredient2(String ingredient2)
            {
                this.ingredient2 = ingredient2;
            }

        public String getIngredient3()
            {
                return ingredient3;
            }

        public void setIngredient3(String ingredient3)
            {
                this.ingredient3 = ingredient3;
            }

        public String getIngredient4()
            {
                return ingredient4;
            }

        public void setIngredient4(String ingredient4)
            {
                this.ingredient4 = ingredient4;
            }

        public String getIngredient5()
            {
                return ingredient5;
            }

        public void setIngredient5(String ingredient5)
            {
                this.ingredient5 = ingredient5;
            }

        public String getIngredient6()
            {
                return ingredient6;
            }

        public void setIngredient6(String ingredient6)
            {
                this.ingredient6 = ingredient6;
            }

        public String getIngredient7()
            {
                return ingredient7;
            }

        public void setIngredient7(String ingredient7)
            {
                this.ingredient7 = ingredient7;
            }

        public String getIngredient8()
            {
                return ingredient8;
            }

        public void setIngredient8(String ingredient8)
            {
                this.ingredient8 = ingredient8;
            }

        public String getImg()
            {
                return img;
            }

        public void setImg(String img)
            {
                this.img = img;
            }
    }
