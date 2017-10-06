package com.example.android.moranlee.justgo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.android.moranlee.justgo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class select_from_food_database_activity extends AppCompatActivity {

    Food_Repo getFoods;

    TextView show_from_database;

    LinkedList<String> meats;

    String [] meat;

    LinkedList<String> vegetables;

    String [] vegetable;

    LinkedList<String> fruits;

    String [] fruit;

    LinkedList<String> grains;

    String [] grain;

    LinkedList<String> dairys;

    String [] dairy;

    LinkedList<String> fats;

    String [] fat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_from_food_database_activity);
        show_from_database = (TextView)findViewById(R.id.show_from_database);
        show_from_database.setMovementMethod(new ScrollingMovementMethod());
        getFoods = new Food_Repo(this);
        //String text = "";
        ArrayList defaults = getFoods.get_default_food_list();
        for(int i=0;i<defaults.size();i++){
            HashMap<String,String> current = (HashMap<String,String>)defaults.get(i);
            String category = current.get("category");
            if(category.equals("1")){
                meats.add(current.get("name"));
            }
            if(category.equals("2")){
                fruits.add(current.get("name"));
            }
            if(category.equals("3")){
                vegetables.add(current.get("name"));
            }
            if(category.equals("4")){
                dairys.add(current.get("name"));
            }
            if(category.equals("5")){
                grains.add(current.get("name"));
            }
            if(category.equals("6")){
                fats.add(current.get("name"));
            }
        }
        meat = (String [])meats.toArray();
        fruit = (String [])fruits.toArray();
        vegetable = (String [])vegetables.toArray();
        grain = (String [])grains.toArray();
        dairy = (String [])dairys.toArray();
        fat = (String [])fats.toArray();

        //show_from_database.setText(text);
    }



}
