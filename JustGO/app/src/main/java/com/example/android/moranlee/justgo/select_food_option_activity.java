package com.example.android.moranlee.justgo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class select_food_option_activity extends AppCompatActivity {

    Button select_from_old_food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_food_opition_activity);
        select_from_old_food = (Button)findViewById(R.id.select_from_old_food);
        select_from_old_food.setOnClickListener(select_from_old_food());
    }

    private View.OnClickListener select_from_old_food(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(),select_from_food_database_activity.class);
                startActivity(unit_intent);
            }
        };
    }

    private Activity getItSelf(){
        return this;
    }

}
