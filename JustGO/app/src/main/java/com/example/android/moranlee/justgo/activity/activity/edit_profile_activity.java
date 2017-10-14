package com.example.android.moranlee.justgo.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.android.moranlee.justgo.R;
import com.example.android.moranlee.justgo.activity.sql_interaction.User_Repo;

/**
 * Created by Jesse on 10/12/2017.
 */


public class edit_profile_activity extends AppCompatActivity {

    EditText height;

    EditText weight;

    RadioGroup gender;

    boolean height_change;

    boolean weight_change;

    Button submit;

    Button passwordBtn;

    User_Repo user_repo;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        height = (EditText)findViewById(R.id.input2);
        weight = (EditText)findViewById(R.id.input1);
        gender = (RadioGroup)findViewById(R.id.gender_change_group);
        submit = (Button)findViewById(R.id.button4);
        passwordBtn = (Button) findViewById(R.id.profile_change_password);
        user_repo = new User_Repo(this);
        passwordBtn.setOnClickListener(changePassword());
        }


    private View.OnClickListener changePassword() {
       return new View.OnClickListener() {
          @Override
            public void onClick(View v) {
               Intent unit_intent = new Intent(getItSelf(), change_password_activity.class);
               startActivity(unit_intent);
          }
       };
    }

    private View.OnClickListener submit_change(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String new_weight = weight.getText().toString();
                String new_height = height.getText().toString();
                if(new_height.length()==0){
                    height_change = false;
                }
                else{
                    height_change = true;
                }
                if(new_weight.length() == 0){
                    weight_change = false;
                }
                else{
                    height_change = true;
                }
                if(height_change){
                    user_repo.update_height(Double.parseDouble(new_height));
                }
                if(weight_change){
                    user_repo.update_height(Double.parseDouble(new_weight));
                }
                RadioButton genders = (RadioButton)findViewById( gender.getCheckedRadioButtonId());
                user_repo.update_gender(genders.getText().toString());
                Intent unit_intent = new Intent(getItSelf(), main_menu_activity.class);
                startActivity(unit_intent);
            }
        };
    }

    private Activity getItSelf(){ return this; }
}


