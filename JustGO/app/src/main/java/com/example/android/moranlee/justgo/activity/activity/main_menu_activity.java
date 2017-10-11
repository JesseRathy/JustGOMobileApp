package com.example.android.moranlee.justgo.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.moranlee.justgo.R;
import com.example.android.moranlee.justgo.activity.diet_suggestion;

public class main_menu_activity extends AppCompatActivity {

    Button go_add_diet;
    Button go_body_analysis;
    Button go_add_exercise;
    Button go_nutrition_suggestion;
    Button go_exercies_recommendation;
    Button go_diet_management;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_activity);
        go_add_diet = (Button) findViewById(R.id.go_add_diet);
        go_add_diet.setOnClickListener(go_add_diet());
        go_body_analysis = (Button) findViewById(R.id.go_body_analysis);
        go_body_analysis.setOnClickListener(go_body_analysis());
        go_add_exercise = (Button) findViewById(R.id.go_add_exercise);
        go_add_exercise.setOnClickListener(go_add_exercise());
        go_nutrition_suggestion = (Button) findViewById(R.id.go_nutrition_suggestion);
        go_nutrition_suggestion.setOnClickListener(go_nutrition_suggestion());
        go_exercies_recommendation = (Button) findViewById(R.id.go_exercies_recommendation);
        go_exercies_recommendation.setOnClickListener(go_exercies_recommendation());

        go_diet_management = (Button) findViewById(R.id.diet_management);
        go_diet_management.setOnClickListener(go_diet_management());

    }



    private View.OnClickListener go_add_diet(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(),select_food_option_activity.class);
                startActivity(unit_intent);
            }
        };
    }

    private View.OnClickListener go_body_analysis(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(),add_new_body_status_activity.class);
                startActivity(unit_intent);
            }
        };
    }

    private View.OnClickListener go_add_exercise(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(),add_new_exercise_activity.class);
                startActivity(unit_intent);
            }
        };
    }

    private View.OnClickListener go_nutrition_suggestion(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(),confirm_nutrient_activity.class);
                startActivity(unit_intent);
            }
        };
    }

    private View.OnClickListener go_exercies_recommendation(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(),diet_suggestion.class);
                startActivity(unit_intent);
            }
        };
    }

    private View.OnClickListener go_diet_management(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(),select_diet_option_activity.class);
                startActivity(unit_intent);
            }
        };
    }

    private Activity getItSelf(){
        return this;
    }

}