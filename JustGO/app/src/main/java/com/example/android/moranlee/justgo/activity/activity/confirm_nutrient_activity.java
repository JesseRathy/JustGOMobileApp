package com.example.android.moranlee.justgo.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.moranlee.justgo.R;

public class confirm_nutrient_activity extends AppCompatActivity {

    String data;

    TextView result;

    Button confirm;

    Button reselect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_activity);
        data = getIntent().getStringExtra("data");
        result = (TextView)findViewById(R.id.result_from_database);
        result.setText(data);
        confirm = (Button) findViewById(R.id.submit_change);
        reselect = (Button)findViewById(R.id.go_back_select);
        reselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_back = new Intent(getItSelf(),select_food_option_activity.class);
                startActivity(go_back);
            }
        });
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
