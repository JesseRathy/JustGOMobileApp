package com.example.android.moranlee.justgo.activity.activity.analysis_usage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.moranlee.justgo.R;
import com.example.android.moranlee.justgo.activity.sql_interaction.User_Repo;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.*;
import com.jjoe64.graphview.LegendRenderer;


public class Analysis extends AppCompatActivity {
    User_Repo user;

    /**
     *  initialize analysis activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        user = new User_Repo(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.analysis);

        // Get user information
        Double weight = user.getRecentWeight();
        String gender = user.getUserGender();
        Double height = user.getUserHeight();
        int age = user.getUserAge();

        // Display user information
        displayHeight(height);
        displayWeight(weight);
        displayGender(gender);
        displayAge(age);
        int bmi = displayBMI(weight, height);
        displayHealth(bmi);

        displayGraph();
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

    private void displayNutrition() {
        TextView calorieText = (TextView) findViewById(R.id.analysisCalorie);
        TextView proteinText = (TextView) findViewById(R.id.analysisProtein);
        TextView cholesterolText = (TextView) findViewById(R.id.analysisCholesterol);
    }

    private void displayGraph() {
        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);
        series.setTitle("user's weight change");
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
    }
}
