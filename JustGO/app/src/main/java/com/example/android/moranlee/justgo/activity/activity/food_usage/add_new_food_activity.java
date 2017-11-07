package com.example.android.moranlee.justgo.activity.activity.food_usage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.moranlee.justgo.R;
import com.example.android.moranlee.justgo.activity.datatype.Food;
import com.example.android.moranlee.justgo.activity.sql_interaction.Food_Repo;
import com.example.android.moranlee.justgo.activity.*;

public class add_new_food_activity extends AppCompatActivity {

    /*
    input field for name
     */
    EditText name;

    /*
   input field for protein
    */
    EditText protein;

    /*
   input field for calorie
    */
    EditText calorie;

    /*
   input field for cholesterol
    */
    EditText cholesterol;

    /*
   input field for fat
    */
    EditText fat;

    /*
   submit new food
    */
    Button submit;

    /*
    store data as a food type
     */
    Food new_food;

    /*
    connection to the SQLite
     */
    Food_Repo food_repo;

    /**
     *  initialize addnew food activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_diet_activity);
        // connect var to fields by id
        name = (EditText)findViewById(R.id.new_food_name);
        protein = (EditText) findViewById(R.id.new_food_protein);
        calorie = (EditText) findViewById(R.id.new_food_calories);
        cholesterol = (EditText)findViewById(R.id.new_food_cholesterol);
        fat = (EditText) findViewById(R.id.new_food_fat);
        submit = (Button) findViewById(R.id.submit_change);
        food_repo = new Food_Repo(this);
        // onclick listener for button to submit change
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new_food = new Food();
                new_food.setId(global_value.getCurrent_max_food_id()+1);
                global_value.setCurrent_max_food_id(global_value.getCurrent_max_food_id()+1);
                new_food.setUser_id(global_value.getCurrent_user_id());
                new_food.setCalories(Double.parseDouble(calorie.getText().toString()));
                new_food.setCategory(7);
                new_food.setCholesterol(Double.parseDouble(cholesterol.getText().toString()));
                new_food.setProtein(Double.parseDouble(protein.getText().toString()));
                new_food.setFat(Double.parseDouble(fat.getText().toString()));
                new_food.setName(name.getText().toString());
                food_repo.insert(new_food);
            }
        });
    }
}
