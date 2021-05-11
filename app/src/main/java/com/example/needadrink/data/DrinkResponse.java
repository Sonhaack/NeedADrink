package com.example.needadrink.data;

public class DrinkResponse
    {
        private String idDrink;
        private String strDrink;
        private String strAlcoholic;
        private String strInstructions;
        private String strDrinkThump;
        private String strIngredient1;
        private String strIngredient2;
        private String strIngredient3;
        private String strIngredient4;
        private String strIngredient5;
        private String strIngredient6;
        private String strIngredient7;
        private String strIngredient8;

        public DrinkResponse(String idDrink)
            {
                this.idDrink = idDrink;
                this.strDrink = "";
                this.strAlcoholic = "";
                this.strInstructions = "";
                this.strDrinkThump = "";
                this.strIngredient1 = "";
                this.strIngredient2 = "";
                this.strIngredient3 = "";
                this.strIngredient4 = "";
                this.strIngredient5 = "";
                this.strIngredient6 = "";
                this.strIngredient7 = "";
                this.strIngredient8 = "";
            }

        public DrinkResponse(String idDrink, String strDrink, String strAlcoholic, String strInstructions, String strDrinkThump, String strIngredient1, String strIngredient2, String strIngredient3, String strIngredient4, String strIngredient5, String strIngredient6, String strIngredient7, String strIngredient8)
            {
                this.idDrink = idDrink;
                this.strDrink = strDrink;
                this.strAlcoholic = strAlcoholic;
                this.strInstructions = strInstructions;
                this.strDrinkThump = strDrinkThump;
                this.strIngredient1 = strIngredient1;
                this.strIngredient2 = strIngredient2;
                this.strIngredient3 = strIngredient3;
                this.strIngredient4 = strIngredient4;
                this.strIngredient5 = strIngredient5;
                this.strIngredient6 = strIngredient6;
                this.strIngredient7 = strIngredient7;
                this.strIngredient8 = strIngredient8;
            }

        public String getIdDrink()
            {
                return idDrink;
            }

        public void setIdDrink(String idDrink)
            {
                this.idDrink = idDrink;
            }

        public String getStrDrink()
            {
                return strDrink;
            }

        public void setStrDrink(String strDrink)
            {
                this.strDrink = strDrink;
            }

        public String getStrAlcoholic()
            {
                return strAlcoholic;
            }

        public void setStrAlcoholic(String strAlcoholic)
            {
                this.strAlcoholic = strAlcoholic;
            }

        public String getStrInstructions()
            {
                return strInstructions;
            }

        public void setStrInstructions(String strInstructions)
            {
                this.strInstructions = strInstructions;
            }

        public String getStrDrinkThump()
            {
                return strDrinkThump;
            }

        public void setStrDrinkThump(String strDrinkThump)
            {
                this.strDrinkThump = strDrinkThump;
            }

        public String getStrIngredient1()
            {
                return strIngredient1;
            }

        public void setStrIngredient1(String strIngredient1)
            {
                this.strIngredient1 = strIngredient1;
            }

        public String getStrIngredient2()
            {
                return strIngredient2;
            }

        public void setStrIngredient2(String strIngredient2)
            {
                this.strIngredient2 = strIngredient2;
            }

        public String getStrIngredient3()
            {
                return strIngredient3;
            }

        public void setStrIngredient3(String strIngredient3)
            {
                this.strIngredient3 = strIngredient3;
            }

        public String getStrIngredient4()
            {
                return strIngredient4;
            }

        public void setStrIngredient4(String strIngredient4)
            {
                this.strIngredient4 = strIngredient4;
            }

        public String getStrIngredient5()
            {
                return strIngredient5;
            }

        public void setStrIngredient5(String strIngredient5)
            {
                this.strIngredient5 = strIngredient5;
            }

        public String getStrIngredient6()
            {
                return strIngredient6;
            }

        public void setStrIngredient6(String strIngredient6)
            {
                this.strIngredient6 = strIngredient6;
            }

        public String getStrIngredient7()
            {
                return strIngredient7;
            }

        public void setStrIngredient7(String strIngredient7)
            {
                this.strIngredient7 = strIngredient7;
            }

        public String getStrIngredient8()
            {
                return strIngredient8;
            }

        public void setStrIngredient8(String strIngredient8)
            {
                this.strIngredient8 = strIngredient8;
            }
    }
