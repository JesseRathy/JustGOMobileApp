package com.example.android.moranlee.justgo.activity.activity.exercise_usage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.moranlee.justgo.R;
import com.example.android.moranlee.justgo.activity.sql_interaction.ExerciseDailyRepo;

public class ConfirmExerciseData extends AppCompatActivity
{

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
   collect amount user want to input
   */
    EditText amount;

    /*
    sql interface
     */
    ExerciseDailyRepo exerciseDailyRepo;

    /**
     * initialize activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_exercise_data_activity);
        // get info from other activity
        data = getIntent().getStringExtra("data");
        exerciseId = getIntent().getIntExtra("id", 0);
        exerciseDailyRepo = new ExerciseDailyRepo(this);
        // connect field to interface
        result = (TextView)findViewById(R.id.result_from_database);
        result.setText(data);
        confirm = (Button) findViewById(R.id.submit_change);
        reselect = (Button)findViewById(R.id.go_back_select);
        amount = (EditText)findViewById(R.id.submit_exercise_amount);
        // if user want to insert data to sql
        reselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(getItSelf(), NormalExpandExercise.class);

                goBack.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(goBack);
                finish();
            }
        });
        // if user want to select another
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double times = 1.0;
                try{
                    times = Double.parseDouble(amount.getText().toString());
                }
                catch (Exception e){
                    Toast.makeText(ConfirmExerciseData.this, "Invalid value or forget to input amount", Toast.LENGTH_SHORT).show();
                    return;
                }
                for(int i=0;i<times.intValue();i++){
                    exerciseDailyRepo.insert(exerciseDailyRepo.create_exercise(0, 1.0));
                }
                Intent return_exercise = new Intent(getItSelf(), SelectExerciseOption.class);
                return_exercise.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(return_exercise);
                finish();
            }
        });
    }

    private Activity getItSelf()
    {
        return this;
    }
}
