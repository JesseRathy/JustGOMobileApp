package com.example.android.moranlee.justgo.activity.activity.food_usage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.moranlee.justgo.R;
import com.example.android.moranlee.justgo.activity.sql_interaction.FoodRepo;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchFoodName extends AppCompatActivity
{

    /*
    input field for name
     */
    EditText name;

    /*
    submit change
     */
    Button submit;

    /*
    sqlite interface
     */
    FoodRepo food_repo;

    /**
     *  initialize addnew food activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_food_name_activity);
        name = (EditText)findViewById(R.id.object_food_name);
        submit = (Button) findViewById(R.id.submit_to_search_food_name);
        food_repo = new FoodRepo(this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get data and transfer to next activity
                getDataAndTransfer();
               /* Hongyi -- Added new method via Extract method Idea */
            }
        });
    }
    /**
     *
     * @return self because other function need
     */
    private Activity getItSelf()
    {
        return this;
    }
    /* Hongyi --Created new method for Extract method */
    private void getDataAndTransfer(){
        ArrayList<HashMap<String, String>> result;
        result = food_repo.get_food_by_name(name.getText().toString());
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> datas = new ArrayList<String>();
        for (int i = 0; i < result.size(); i++) {
            names.add(result.get(i).get("name"));
            datas.add(result.get(i).toString());
        }
        Intent go_to_confirm = new Intent(getItSelf(), NormalExpandSearch.class);
        go_to_confirm.putExtra("data", datas);
        go_to_confirm.putExtra("name", names);

        go_to_confirm.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(go_to_confirm);
        finish();
    }
}

