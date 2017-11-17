package com.example.android.moranlee.justgo.activity.activity.analysis_usage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.moranlee.justgo.R;
import com.example.android.moranlee.justgo.activity.sql_interaction.Diet_Repo;
import com.example.android.moranlee.justgo.activity.sql_interaction.User_Repo;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


public class Analysis extends AppCompatActivity {
    User_Repo user;
    Diet_Repo diet;
    /**
     *  initialize analysis activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        user = new User_Repo(this);
        diet = new Diet_Repo(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.analysis);

        // Get user information
        Double weight = user.getRecentWeight();
        String gender = user.getUserGender();
        Double height = user.getUserHeight();
        int age = user.getUserAge();
        int calorie = diet.total_calorie_intake();

        // Display user information
        displayHeight(height);
        displayWeight(weight);
        displayGender(gender);
        displayAge(age);
        int bmi = displayBMI(weight, height);
        displayHealth(bmi);
        displayNutrition(calorie);
    }

    private void displayHeight(Double height) {
        TextView heightText = (TextView) findViewById(R.id.analysisHeight);
        heightText.setText("Height: "+height);
    }

    private void displayWeight(Double weight) {
        TextView weightText = (TextView) findViewById(R.id.analysisWeight);
        weightText.setText("Weight: "+weight);
    }

    private void displayAge(int age) {
        TextView ageText = (TextView) findViewById(R.id.analysisAge);
        ageText.setText("Age: "+age);
    }

    private void displayGender(String gender) {
        TextView genderText = (TextView) findViewById(R.id.analysisGender);
        if (gender.equals("M"))
            genderText.setText("Gender: Male");
        else
            genderText.setText("Gender: Female");
    }

    private int displayBMI(Double weight, Double height) {
        int bmi = (int)(weight/(height*height/10000));
        TextView BMIText = (TextView) findViewById(R.id.analysisBMI);
        BMIText.setText("BMI: "+bmi);
        return bmi;
    }

    private void displayHealth(int bmi) {
        TextView healthText = (TextView) findViewById(R.id.analysisHealth);
        if (bmi < 18.5)
            healthText.setText("Health Status: Underweight");
        else if (bmi < 25)
            healthText.setText("Health Status: Recommended");
        else if (bmi < 30)
            healthText.setText("Health Status: Overweight");
        else
            healthText.setText("Health Status: Obese");
    }

    private void displayNutrition(int calorie) {
        TextView calorieText = (TextView) findViewById(R.id.analysisCalorie);
        TextView proteinText = (TextView) findViewById(R.id.analysisProtein);
        TextView cholesterolText = (TextView) findViewById(R.id.analysisCholesterol);
        calorieText.setText("Calorie Intake: "+calorie);
    }

}
