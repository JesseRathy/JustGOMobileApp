package com.example.android.moranlee.justgo.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.moranlee.justgo.R;
import com.example.android.moranlee.justgo.activity.sql_interaction.Diet_Repo;

public class confirm_diet_nutrient_activity extends AppCompatActivity {
    String data;

    int id;

    TextView result;

    Button confirm;

    Button reselect;

    Diet_Repo diet_repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_food_activity);
        data = getIntent().getStringExtra("data");
        id = getIntent().getIntExtra("id",0);
        result = (TextView)findViewById(R.id.result_diet_from_database);
        result.setText(data);
        confirm = (Button) findViewById(R.id.submit_diet_change);
        reselect = (Button)findViewById(R.id.go_back_diet_select);
        reselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_back = new Intent(getItSelf(),select_diet_option_activity.class);
                startActivity(go_back);
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diet_repo.insert(diet_repo.create_diet(id));
                Intent unit_intent = new Intent(getItSelf(), main_menu_activity.class);
                startActivity(unit_intent);
            }
        });
    }

    private Activity getItSelf(){
        return this;
    }
}
