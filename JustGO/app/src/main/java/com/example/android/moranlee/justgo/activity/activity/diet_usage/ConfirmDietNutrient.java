package com.example.android.moranlee.justgo.activity.activity.diet_usage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.moranlee.justgo.R;
import com.example.android.moranlee.justgo.activity.sql_interaction.DietRepo;

public class ConfirmDietNutrient extends AppCompatActivity
{
    /*
    store info transfer from other activity
     */
    String data;

    /*
    store info transfer from other activity
     */
    int id;

    /*
    print info transfer from other activity
     */
    TextView result;

    /*
    collect input to determine next step
     */
    Button confirm;

    /*
    collect input to determine next step
    */
    Button reselect;

    /*
    collect amount user want to input
    */
    EditText amount;

    /*
    SQLite interface
     */
    DietRepo diet_repo;

    /**
     * initialize activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_diet_nutrient_activity);
        diet_repo = new DietRepo(this);
        // get info from other activity
        data = getIntent().getStringExtra("data");
        id = getIntent().getIntExtra("id", 0);
        // connect field to interface
        result = (TextView)findViewById(R.id.result_diet_from_database);
        result.setText(data);
        confirm = (Button) findViewById(R.id.submit_diet_change);
        reselect = (Button)findViewById(R.id.go_back_diet_select);
        amount = (EditText)findViewById(R.id.submit_diet_amount);
        // if user want to insert data to sql
        reselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBaCK = new Intent(getItSelf(), SelectDietOption.class);
                startActivity(goBaCK);
            }
        });
        // if user want to select another
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double times = 1.0;
                try{
                    times = Double.parseDouble(amount.getText().toString());
                }
                catch (Exception e){
                    Toast.makeText(ConfirmDietNutrient.this, "Invalid value or forget to input amount", Toast.LENGTH_SHORT).show();
                    return;
                }
                for(int i=0;i<times.intValue();i++){
                    diet_repo.insert(diet_repo.create_diet(id));
                }
                Intent return_diet = new Intent(getItSelf(), SelectDietOption.class);
                return_diet.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(return_diet);
                finish();
            }
        });
    }

    private Activity getItSelf()
    {
        return this;
    }
}
