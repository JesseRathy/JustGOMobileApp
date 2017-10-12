package com.example.android.moranlee.justgo.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.moranlee.justgo.R;

public class main_menu_activity extends AppCompatActivity {

    Button go_add_diet;
    Button go_body_analysis;
    Button go_add_exercise;
    Button go_exercies_recommendation;
    Button go_diet_management;
    Button go_weight;

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

        go_exercies_recommendation = (Button) findViewById(R.id.go_exercies_recommendation);
        go_exercies_recommendation.setOnClickListener(go_exercies_recommendation());

        go_diet_management = (Button) findViewById(R.id.diet_management);
        go_diet_management.setOnClickListener(go_diet_management());

        go_weight = (Button) findViewById(R.id.main_weight);
        go_weight.setOnClickListener(go_weight());

    }

    private View.OnClickListener go_weight(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(),add_new_weight.class);
                startActivity(unit_intent);
            }
        };
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
                Intent unit_intent = new Intent(getItSelf(),get_exercise_recommendation_activity.class);
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
