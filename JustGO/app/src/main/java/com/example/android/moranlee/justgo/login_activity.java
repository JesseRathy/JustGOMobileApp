package com.example.android.moranlee.justgo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class login_activity extends AppCompatActivity {
     Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        login = (Button)findViewById(R.id.login);
    }
     
    private View.OnClickListener login(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(),main_menu_activity.class);
                startActivity(unit_intent);
            }
        };
    }

    private Activity getItSelf(){
        return this;
    }
}
