package com.example.android.moranlee.justgo.activity.activity.diet_usage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.moranlee.justgo.R;
import com.example.android.moranlee.justgo.activity.activity.main_menu_activity;
import com.example.android.moranlee.justgo.activity.sql_interaction.Diet_Repo;

public class ConfirmDietNutrient extends AppCompatActivity {
    /*
    store info transfer from other activity
     */
    String data;

    /*
    store info transfer from other activity
     */
    int id;

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
    SQLite interface
     */
    Diet_Repo diet_repo;

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
        id = getIntent().getIntExtra("id",0);
        // connect field to interface
        result = (TextView)findViewById(R.id.result_diet_from_database);
        result.setText(data);
        confirm = (Button) findViewById(R.id.submit_diet_change);
        reselect = (Button)findViewById(R.id.go_back_diet_select);
        // if user want to insert data to sql
        reselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBaCK = new Intent(getItSelf(),SelectDietOption.class);
                startActivity(goBaCK);
            }
        });
        // if user want to select another
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diet_repo.insert(diet_repo.create_diet(id));
                Intent unitIntent = new Intent(getItSelf(), main_menu_activity.class);
                startActivity(unitIntent);
            }
        });
    }

    private Activity getItSelf(){
        return this;
    }
}
