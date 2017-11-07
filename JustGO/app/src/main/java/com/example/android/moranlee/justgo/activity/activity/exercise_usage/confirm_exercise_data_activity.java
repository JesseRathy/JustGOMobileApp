package com.example.android.moranlee.justgo.activity.activity.exercise_usage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.moranlee.justgo.R;
import com.example.android.moranlee.justgo.activity.activity.food_usage.select_food_option_activity;
import com.example.android.moranlee.justgo.activity.activity.main_menu_activity;

public class confirm_exercise_data_activity extends AppCompatActivity {

    /*
    store info transfer from other activity
     */
    String data;

    /*
    print info transfer from other activity
     */
    TextView result;

    /*
    collect input to determine next step
     */
    Button confirm;

    /*
   collect input to determine next step
    */
    Button reselect;

    /**
     * initialize activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_food_activity);
        // get info from other activity
        data = getIntent().getStringExtra("data");
        // connect field to interface
        result = (TextView)findViewById(R.id.result_from_database);
        result.setText(data);
        confirm = (Button) findViewById(R.id.submit_change);
        reselect = (Button)findViewById(R.id.go_back_select);
        // if user want to insert data to sql
        reselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_back = new Intent(getItSelf(),select_exercise_option_activity.class);
                startActivity(go_back);
            }
        });
        // if user want to select another
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(), main_menu_activity.class);
                startActivity(unit_intent);
            }
        });
    }

    private Activity getItSelf(){
        return this;
    }
}
