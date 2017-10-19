package com.example.android.moranlee.justgo.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.moranlee.justgo.R;
import com.example.android.moranlee.justgo.activity.sql_interaction.Food_Repo;

public class search_food_name_activity extends AppCompatActivity {

    EditText name;

    Button submit;

    Food_Repo food_repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_food_name_activity);
        name = (EditText)findViewById(R.id.object_food_name);
        submit = (Button) findViewById(R.id.submit_to_search_food_name);
        food_repo = new Food_Repo(this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = food_repo.get_food_by_name(name.getText().toString());
                Intent go_to_confirm = new Intent(getItSelf(),confirm_food_nutrient_activity.class);
                go_to_confirm.putExtra("data",data);
                startActivity(go_to_confirm);
            }
        });
    }
    private Activity getItSelf(){
        return this;
    }
}
