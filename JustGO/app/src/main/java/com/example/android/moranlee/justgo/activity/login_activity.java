package com.example.android.moranlee.justgo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.moranlee.justgo.R;

public class login_activity extends AppCompatActivity {

    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(login());
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
