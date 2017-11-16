package com.example.android.moranlee.justgo.activity.activity.exercise_usage;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.android.moranlee.justgo.R;
import com.example.android.moranlee.justgo.activity.data.exercise_data;
public class SelectExerciseOptionActivity extends AppCompatActivity {

    Button selectFromDatabase;
    Button addNewExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_exercise_option);


        selectFromDatabase = (Button) findViewById(R.id.select_from_old_exercise);
        selectFromDatabase.setOnClickListener(select_from_database());

        addNewExercise = (Button) findViewById(R.id.select_create_new_exercise);
        addNewExercise.setOnClickListener(add_new_exercise());
    }



    private View.OnClickListener select_from_database(){
        new exercise_data(this);
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unitIntent = new Intent(getItSelf(),NormalExpandExerciseActivity.class);
                startActivity(unitIntent);
            }
        };
    }

    private View.OnClickListener add_new_exercise(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unitIntent = new Intent(getItSelf(), AddNewExercise.class);
                startActivity(unitIntent);
            }
        };
    }

    private Activity getItSelf(){
        return this;
    }

}
