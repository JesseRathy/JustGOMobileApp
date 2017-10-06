package com.example.android.moranlee.justgo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.android.moranlee.justgo.R;

import java.util.ArrayList;

public class select_from_food_database_activity extends AppCompatActivity {

    Food_Repo getFoods;

    TextView show_from_database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_from_food_database_activity);
        show_from_database = (TextView)findViewById(R.id.show_from_database);
        show_from_database.setMovementMethod(new ScrollingMovementMethod());
        getFoods = new Food_Repo(this);
        String text = "";
        ArrayList defaults = getFoods.get_default_food_list();
        for(int i=0;i<defaults.size();i++){
            text+=defaults.get(i);
            text+="\n";
        }
        show_from_database.setText(text);
    }



}
