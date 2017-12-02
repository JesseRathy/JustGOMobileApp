package com.example.android.moranlee.justgo.activity.activity.diet_usage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.moranlee.justgo.R;
import com.example.android.moranlee.justgo.activity.activity.exercise_usage.NormalExpandExercise;
import com.example.android.moranlee.justgo.activity.activity.food_usage.NormalExpandFood;
import com.example.android.moranlee.justgo.activity.activity.food_usage.SelectFromFoodDatabase;
import com.example.android.moranlee.justgo.activity.sql_interaction.DietRepo;
import com.example.android.moranlee.justgo.activity.sql_interaction.FoodRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class DisplayDietHistory extends AppCompatActivity
{
    TextView name;

    Button goBack;

    String data;

    FoodRepo food_repo;

    DietRepo diet_repo;

    LinkedList datas;

    /**
     *  initialize addnew food activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_diet_history);
        food_repo = new FoodRepo(this);
        diet_repo = new DietRepo(this);
        name = (TextView) findViewById(R.id.result_diet_history);
        goBack = (Button) findViewById(R.id.go_back_select_diet_history);

        ArrayList defaults = diet_repo.get_default_diet_list();
        datas = new LinkedList<>();

        for (int i = 0; i < defaults.size(); i++) {
            HashMap<String, String> current = (HashMap<String, String>)defaults.get(i);
            ArrayList food_list = food_repo.get_food_by_food_id(Integer.parseInt(current.get("food_id")));
            food_list.add(current.get("date"));
            food_list.add(current.get("meal_type"));
            datas.add(food_list.toString());
        }

        name.setText(datas.toString());

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_back = new Intent(getItSelf(), SelectDietOption.class);
                go_back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(go_back);
                finish();
            }
        });

    }

    /**
     *
     * @return self because other function need
     */
    private Activity getItSelf()
    {
        return this;
    }


}