package com.example.android.moranlee.justgo.activity.activity.exercise_usage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.moranlee.justgo.R;
import com.example.android.moranlee.justgo.activity.activity.main_menu_activity;
import com.example.android.moranlee.justgo.activity.sql_interaction.Exercise_daily_Repo;

public class ConfirmExerciseDataActivity extends AppCompatActivity {

    /*
    store info transfer from other activity
     */
    String data;

    /*
    store info transfer from another activity
    */
    int exerciseId;

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

    /*
    sql interface
     */
    Exercise_daily_Repo exerciseDailyRepo;

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
        exerciseId = getIntent().getIntExtra("id",0);
        exerciseDailyRepo = new Exercise_daily_Repo(this);
        // connect field to interface
        result = (TextView)findViewById(R.id.result_from_database);
        result.setText(data);
        confirm = (Button) findViewById(R.id.submit_change);
        reselect = (Button)findViewById(R.id.go_back_select);
        // if user want to insert data to sql
        reselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(getItSelf(),SelectExerciseOptionActivity.class);
                startActivity(goBack);
            }
        });
        // if user want to select another
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exerciseDailyRepo.insert(exerciseDailyRepo.create_exercise(0,1.0));
                Intent unitIntent = new Intent(getItSelf(), main_menu_activity.class);
                startActivity(unitIntent);
            }
        });
    }

    private Activity getItSelf(){
        return this;
    }
}
