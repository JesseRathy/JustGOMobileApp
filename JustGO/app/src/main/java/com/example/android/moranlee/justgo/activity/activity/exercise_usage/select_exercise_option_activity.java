package com.example.android.moranlee.justgo.activity.activity.exercise_usage;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.android.moranlee.justgo.R;
import com.example.android.moranlee.justgo.activity.data.exercise_data;
public class select_exercise_option_activity extends AppCompatActivity {

    Button select_from_database;
    Button add_new_exercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_exercise_option);


        select_from_database = (Button) findViewById(R.id.select_from_old_exercise);
        select_from_database.setOnClickListener(select_from_database());

        add_new_exercise = (Button) findViewById(R.id.select_create_new_exercise);
        add_new_exercise.setOnClickListener(add_new_exercise());
    }



    private View.OnClickListener select_from_database(){
        new exercise_data(this);
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(),NormalExpandExerciseActivity.class);
                startActivity(unit_intent);
            }
        };
    }

    private View.OnClickListener add_new_exercise(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(), com.example.android.moranlee.justgo.activity.activity.exercise_usage.add_new_exercise.class);
                startActivity(unit_intent);
            }
        };
    }

    private Activity getItSelf(){
        return this;
    }

}
