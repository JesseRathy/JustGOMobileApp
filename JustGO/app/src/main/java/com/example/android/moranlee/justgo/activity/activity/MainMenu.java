package com.example.android.moranlee.justgo.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.moranlee.justgo.R;
import com.example.android.moranlee.justgo.activity.activity.analysis_usage.Analysis;
import com.example.android.moranlee.justgo.activity.activity.diet_usage.SelectDietOption;
import com.example.android.moranlee.justgo.activity.activity.exercise_usage.SelectExerciseOption;
import com.example.android.moranlee.justgo.activity.activity.food_usage.SelectFoodOption;
import com.example.android.moranlee.justgo.activity.activity.recommandition_usage.GetRecommendation;
import com.example.android.moranlee.justgo.activity.activity.user_usage.EditProfile;
import com.example.android.moranlee.justgo.activity.activity.weight_usage.past_and_new_weight_activity;

public class MainMenu extends AppCompatActivity
{

    /*
    buttons to switch activity
     */
    Button go_add_diet;
    Button go_body_analysis;
    Button exercise;
    Button go_exercies_recommendation;
    Button go_diet_management;
    Button go_weight;
    Button analysis;

    /**
     * initialize activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_activity);
        // connect field and interface and set listener
        go_add_diet = (Button) findViewById(R.id.go_add_diet);
        go_add_diet.setOnClickListener(go_check_food_nutrient());

        go_body_analysis = (Button) findViewById(R.id.go_body_analysis);
        go_body_analysis.setOnClickListener(go_edit_profile());

        exercise = (Button) findViewById(R.id.go_add_exercise);
        exercise.setOnClickListener(go_exercise());

        go_exercies_recommendation = (Button) findViewById(
                                         R.id.go_exercies_recommendation);
        go_exercies_recommendation.setOnClickListener(go_recommendation());

        go_diet_management = (Button) findViewById(R.id.diet_management);
        go_diet_management.setOnClickListener(go_add_diet());

        go_weight = (Button) findViewById(R.id.main_weight);
        go_weight.setOnClickListener(go_weight());


        // Analysis button listener
        analysis = (Button) findViewById(R.id.mainAnalysisBtn);
        analysis.setOnClickListener(goAnalysis());

        //   new FoodData(this);
    }

    /**
     *  switch activity to weight activity
     * @return OnClickListener
     */
    private View.OnClickListener go_weight()
    {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(),
                                                past_and_new_weight_activity.class);
                startActivity(unit_intent);
            }
        };
    }

    /**
     *  switch activity to add diet activity
     * @return OnClickListener
     */
    private View.OnClickListener go_check_food_nutrient()
    {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(), SelectFoodOption.class);
                startActivity(unit_intent);
            }
        };
    }

    /**
     *  switch activity to analysis activity
     * @return OnClickListener
     */
    private View.OnClickListener go_edit_profile()
    {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(), EditProfile.class);
                startActivity(unit_intent);
            }
        };
    }

    /**
     *  switch activity to exercise activity
     * @return OnClickListener
     */
    private View.OnClickListener go_exercise()
    {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(), SelectExerciseOption.class);
                startActivity(unit_intent);
            }
        };
    }

    /**
     *  switch activity to analysis
     * @return OnClickListener
     */
    private View.OnClickListener goAnalysis()
    {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(), Analysis.class);
                startActivity(unit_intent);
            }
        };
    }

    /**
     *  switch activity to recommendation
     * @return OnClickListener
     */
    private View.OnClickListener go_recommendation()
    {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(), GetRecommendation.class);
                startActivity(unit_intent);
            }
        };
    }

    /**
     *  switch activity to add diet
     * @return OnClickListener
     */
    private View.OnClickListener go_add_diet()
    {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(), SelectDietOption.class);
                startActivity(unit_intent);
            }
        };
    }

    /**
     *
     * @return self for some function need
     */
    private Activity getItSelf()
    {
        return this;
    }

}
