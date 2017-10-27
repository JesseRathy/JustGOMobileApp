package com.example.android.moranlee.justgo.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.moranlee.justgo.R;
import com.example.android.moranlee.justgo.activity.global_value;
import com.example.android.moranlee.justgo.activity.sql.SQLite_Interface;
import com.example.android.moranlee.justgo.activity.sql_interaction.User_Repo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class login_activity extends AppCompatActivity {

    Button login;

    Button register;

    String username;

    String password;

    SQLite_Interface sql;

    User_Repo current_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        this.deleteDatabase("JustGo");
        current_user = new User_Repo(this);
        int past_user = current_user.get_user_num();
        for(int i=1;i<=past_user;i++){
            current_user.delete_by_id(i);
        }
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(login());
        register = (Button)findViewById(R.id.signup);
        register.setOnClickListener(signup());
        if(global_value.getCurrent_max_food_id()<25) {
            global_value.setCurrent_max_food_id(25);
        }
        if(global_value.getCurrent_max_user_id() <= 0){
            global_value.setCurrent_max_user_id(1);
        }
        if(global_value.getCurrent_max_diet_id()<= 0){
            global_value.setCurrent_max_diet_id(0);
        }
        //current_user.get_user_age();
    }

    private View.OnClickListener login(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pattern input_type = Pattern.compile("^[A-Za-z]*$");
                username = ((TextView)findViewById(R.id.username)).getText().toString();
                password = ((TextView)findViewById(R.id.password)).getText().toString();
                Matcher username_matcher = input_type.matcher(username);
                Matcher password_matcher = input_type.matcher(password);
                if(username.length()<= 0 || password.length()<=0){
                    Toast.makeText(getApplicationContext(), "You must enter the user and the password",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    if(!username_matcher.matches() || !password_matcher.matches()){
                        Toast.makeText(getApplicationContext(), "Invalid input of username / password",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                    int id = current_user.check_user_login(username,password);
                    if (id >= 0) {
                        global_value.setCurrent_user_id(id);
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

    private View.OnClickListener signup(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(),register_activity.class);
                startActivity(unit_intent);
            }
        };
    }

    private Activity getItSelf(){
        return this;
    }

}
