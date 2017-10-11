package com.example.android.moranlee.justgo.activity.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.android.moranlee.justgo.R;
import com.example.android.moranlee.justgo.activity.datatype.User;
import com.example.android.moranlee.justgo.activity.global_value;
import com.example.android.moranlee.justgo.activity.sql_interaction.User_Repo;
/**
 * Created by yugu on 2017-10-10.
 */

public class register_activity extends AppCompatActivity {

    EditText name;

    EditText password;

    EditText height;

    RadioGroup gender;

    DatePicker birthday;

    Button submit;

    int year;

    int month;

    int date;

    User user;

    User_Repo user_repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        name = (EditText)findViewById(R.id.username_textedit);
        password =(EditText)findViewById(R.id.password_register_layout);
        height = (EditText) findViewById(R.id.height_register_layout);
        gender = (RadioGroup)findViewById(R.id.choose_gender);
        birthday = (DatePicker)findViewById(R.id.birthday_Picker);
        submit = (Button)findViewById(R.id.submit_user_info);
    }

    private View.OnClickListener add_user (){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = new User();
                user.setId(global_value.getCurrent_max_user_id());
                global_value.setCurrent_max_user_id(global_value.getCurrent_max_user_id()+1);
                user.setName(name.getText().toString());
                user.setHeight(Double.parseDouble(height.getText().toString()));
                user.setPassword(password.getText().toString());
                int selectedId = gender.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(selectedId);
                if(radioButton.getText().toString().equals("male")){
                    user.setGender("M");
                }
                else{
                    user.setGender("F");
                }
                int day = birthday.getDayOfMonth();
                int month = birthday.getMonth() + 1;
                int year = birthday.getYear();
                String Day = String.valueOf(day);
                String Month;
                if(month<10){
                    Month = "0"+String.valueOf(month);
                }
                else{
                    Month = String.valueOf(month);
                }
                String Year = String.valueOf(year);
                user.setBirthday(Year+Month+Day);
                user_repo = new User_Repo(get_self());
                user_repo.insert(user);
            }
        };
    }

    private Context get_self(){
        return register_activity.this;
    }

}
