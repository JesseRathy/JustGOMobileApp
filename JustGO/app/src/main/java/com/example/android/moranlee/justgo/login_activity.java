package com.example.android.moranlee.justgo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class login_activity extends AppCompatActivity {

    Button login;

    String username;

    String password;

    User_Repo current_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        current_user = new User_Repo(this);
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(login());
    }

    private View.OnClickListener login(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = ((TextView)findViewById(R.id.username)).getText().toString();
                password = ((TextView)findViewById(R.id.password)).getText().toString();
                if(username.length()<= 0 || password.length()<=0){
                    Toast.makeText(getApplicationContext(), "You must enter the user and the password",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    if (current_user.check_user_login(username,password)) {
                        Intent unit_intent = new Intent(getItSelf(), main_menu_activity.class);
                        startActivity(unit_intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Invalid combination of user name and password",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
            }
        };
    }

    private Activity getItSelf(){
        return this;
    }

}
