package com.example.android.moranlee.justgo.activity.activity.diet_usage;

/**
 * Created by yugu on 2017-10-10.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.moranlee.justgo.R;
import com.example.android.moranlee.justgo.activity.activity.food_usage.search_food_name_activity;

public class select_diet_option extends AppCompatActivity {

    /*
    button go to select food activity
     */
    Button select_from_old_diet;

    /**
     * initialize activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_diet_option_activity);
        select_from_old_diet = (Button)findViewById(R.id.select_from_old_food);
        select_from_old_diet.setOnClickListener(select_from_old_food());
    }

    /**
     *  go to select from form old food activity
     * @return
     */
    private View.OnClickListener select_from_old_food(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(),NormalExpandDietActivity.class);
                startActivity(unit_intent);
            }
        };
    }

    /**
     *  go to search food by it`s name
     * @return
     */
    private View.OnClickListener search_food_name(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(),search_food_name_activity.class);
                startActivity(unit_intent);
            }
        };
    }

    /**
     *
     * @return self because other function need
     */
    private Activity getItSelf(){
        return this;
    }

}
