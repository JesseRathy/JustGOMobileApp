package com.example.android.moranlee.justgo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class main_menu_activity extends AppCompatActivity {
    
    Button go_add_diet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_activity);
        go_add_diet = (Button) findViewById(R.id.go_add_diet);
        go_add_diet.setOnClickListener(go_add_diet());
    }
    
    private View.OnClickListener go_add_diet(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(),select_food_option_activity.class);
                startActivity(unit_intent);
            }
        };
    }

    private Activity getItSelf(){
        return this;
    }
    
}
