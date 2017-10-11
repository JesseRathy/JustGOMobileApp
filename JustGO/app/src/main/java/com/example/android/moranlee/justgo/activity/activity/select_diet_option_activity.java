package com.example.android.moranlee.justgo.activity.activity;

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
import com.example.android.moranlee.justgo.activity.activity.*;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.moranlee.justgo.R;

public class select_diet_option_activity extends AppCompatActivity {

    Button select_from_old_diet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_diet_option_activity);
        select_from_old_diet = (Button)findViewById(R.id.select_from_old_food);
        select_from_old_diet.setOnClickListener(select_from_old_food());
    }

    private View.OnClickListener select_from_old_food(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(),NormalExpandActivity.class);
                startActivity(unit_intent);
            }
        };
    }

    private Activity getItSelf(){
        return this;
    }

}
