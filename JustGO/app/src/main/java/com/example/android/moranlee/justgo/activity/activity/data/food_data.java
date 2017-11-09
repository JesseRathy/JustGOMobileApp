package com.example.android.moranlee.justgo.activity.activity.data;

import com.example.android.moranlee.justgo.activity.sql.SQLite_Interface;
import com.example.android.moranlee.justgo.activity.sql_interaction.Food_Repo;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by yugu on 2017-11-08.
 */

public class food_data {

    Food_Repo food;

    public food_data(Context context){
        food = new Food_Repo(context);
    }

    /*
        Collection of food/diet data
        Adding actual data into food table in the database
     */
    public void add_food_data(){
        //food (String name, double protein, double fat, double calories, double cholesterol)

        food.add_diary("MILK CREME MILK CHOCOLATE BARS WITH A CREAMY MILK FILLING",38.89,22.220,583,28);
        food.add_diary("WEIS, BETTER'N SKIM, A NON-FAT MILK WITH THE TASTE OF 2% MILK!, SKIM MILK",4.58,0,46,2);
        food.add_diary("MILK AND WHITE MILK CHOCOLATE TRUFFLES", 5.56, 36.110, 639, 14);
        food.add_diary("SPREADABLE CHEDDER",17.86,14.290,321,71);
        food.add_diary("MACARONI AND CHEESE DINNER, DELUXE, FOUR CHEESE, RICH & CREAMY CHEESE SAUCE",11.22,4.59,337,10);
        food.add_diary("WILLIAMS CHEESE, SHARP PINCONNING CHEESE",25,21.43,393,107);
        food.add_diary("CHEESE PLEASERS, MIXED CHEESE CURDS",25,17.86,393,107);
        food.add_diary("REAL MOZZARELLA CHEESE NESTLED IN A CRISPY GOLDEN COATING CHEESE STICKS",10.00,6.25,325,25);
        food.add_diary("DELICATE PETITE BLUE CHEESE, SOFT-RIPENED CHEESE",17.86,21.43,393,125);
        food.add_diary("GREAT VALUE, CHEESE PUFFS, REAL CHEESE",3.57,32.140,571,0);
        food.add_diary("IMPERIAL VALLEY CHEESE, SPICED MONTEREY JACK CHEESE, HOT PEPPER",25,17.86,393,107);
        food.add_diary("HERR'S, CHEESE CURLS, CHEESY CHEESE",3.57,12.5,571,0);
        food.add_diary("BEEHIVE CHEESE CO., HAND CRAFTED CHEESE",25,21.43,404,0);
        food.add_diary("OLD FASHIONED CHEESE, PASTEURIZED CHEESE SNACK, PEPPER JACK MELT",6.67,6.67,233,17);
        food.add_diary("MOON CHEESE, PEPPER JACK CHEESE",33.33,25.000,583,167);

        food.add_fruit("DEAN'S, FRUIT RUSH, FRUIT DRINK, FRUIT PUNCH",0,0,25,0);
        food.add_fruit("Apples, raw, with skin",0.26,0.1,52,0);
        food.add_fruit("Apples, raw, without skin",0.27,0.06,48,0);
        food.add_fruit("Blueberries, raw",0.74,0.2,57,0);
        food.add_fruit("Blueberries, wild, frozen",0,0.14,57,0);
        food.add_fruit("Bananas, raw",1.09,0.210,0,89);
        food.add_fruit("Blackberry juice, canned",0.3,0.4,0,38);
        food.add_fruit("Cherries, sour, red, raw",1.00,0.23,50,0);
        //food.add_fruit("Cranberries, dried, sweetened",0.17);
    }



}

