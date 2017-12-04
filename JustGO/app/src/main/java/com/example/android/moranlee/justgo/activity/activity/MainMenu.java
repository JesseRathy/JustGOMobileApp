package com.example.android.moranlee.justgo.activity.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.android.moranlee.justgo.R;
import com.example.android.moranlee.justgo.activity.activity.analysis_usage.Analysis;
import com.example.android.moranlee.justgo.activity.activity.diet_usage.SelectDietOption;
import com.example.android.moranlee.justgo.activity.activity.exercise_usage.SelectExerciseOption;
import com.example.android.moranlee.justgo.activity.activity.food_usage.SelectFoodOption;
import com.example.android.moranlee.justgo.activity.activity.recommandition_usage.GetRecommendation;
import com.example.android.moranlee.justgo.activity.activity.user_usage.EditProfile;
import com.example.android.moranlee.justgo.activity.activity.weight_usage.past_and_new_weight_activity;
import com.example.android.moranlee.justgo.activity.datatype.Weight;

public class MainMenu extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener
{

    /*
    buttons to switch activity
     */
    Button go_add_diet;
    Button go_body_analysis;
    Button exercise;
    Button go_exercies_recommendation;
    Button go_diet_management;
    Button go_weight;
    Button analysis;

    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mToggle;
    NavigationView mNavigation;

    /**
     * initialize activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_menu_activity);
        // connect field and interface and set listener
        go_add_diet = (Button) findViewById(R.id.go_add_diet);
        go_add_diet.setOnClickListener(go_check_food_nutrient());

        go_body_analysis = (Button) findViewById(R.id.go_body_analysis);
        go_body_analysis.setOnClickListener(go_edit_profile());

        exercise = (Button) findViewById(R.id.go_add_exercise);
        exercise.setOnClickListener(go_exercise());

        go_exercies_recommendation = (Button) findViewById(
                                         R.id.go_exercies_recommendation);
        go_exercies_recommendation.setOnClickListener(go_recommendation());

        go_diet_management = (Button) findViewById(R.id.diet_management);
        go_diet_management.setOnClickListener(go_add_diet());

        go_weight = (Button) findViewById(R.id.main_weight);
        go_weight.setOnClickListener(go_weight());


        // Analysis button listener
        analysis = (Button) findViewById(R.id.mainAnalysisBtn);
        analysis.setOnClickListener(goAnalysis());

        //   new FoodData(this);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mNavigation= (NavigationView) findViewById(R.id.nav_view);
        mNavigation.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {

            case R.id.food:
                Intent afood = new Intent(MainMenu.this, SelectFoodOption.class);
                startActivity(afood);
                break;
            case R.id.diet:
                Intent adiet = new Intent(MainMenu.this, SelectDietOption.class);
                startActivity(adiet);
                break;
            case R.id.weight:
                Intent aweight = new Intent(MainMenu.this, past_and_new_weight_activity.class);
                startActivity(aweight);
                break;
            case R.id.exercise:
                Intent aexercise = new Intent(MainMenu.this, SelectExerciseOption.class);
                startActivity(aexercise);
                break;
            case R.id.analyize:
                Intent aanalyize = new Intent(MainMenu.this, Analysis.class);
                startActivity(aanalyize);
                break;
            case R.id.profile:
                Intent aprofile = new Intent(MainMenu.this, EditProfile.class);
                startActivity(aprofile);
                break;
            case R.id.recommendation:
                Intent arecom = new Intent(MainMenu.this, GetRecommendation.class);
                startActivity(arecom);
                break;
            default:
                    Intent a = new Intent(MainMenu.this, MainMenu.class);
                    startActivity(a);
                    break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    /**
     *  switch activity to weight activity
     * @return OnClickListener
     */
    private View.OnClickListener go_weight()
    {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(),
                                                past_and_new_weight_activity.class);
                startActivity(unit_intent);
            }
        };
    }

    /**
     *  switch activity to add diet activity
     * @return OnClickListener
     */
    private View.OnClickListener go_check_food_nutrient()
    {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(), SelectFoodOption.class);
                startActivity(unit_intent);
            }
        };
    }

    /**
     *  switch activity to analysis activity
     * @return OnClickListener
     */
    private View.OnClickListener go_edit_profile()
    {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(), EditProfile.class);
                startActivity(unit_intent);
            }
        };
    }

    /**
     *  switch activity to exercise activity
     * @return OnClickListener
     */
    private View.OnClickListener go_exercise()
    {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(), SelectExerciseOption.class);
                startActivity(unit_intent);
            }
        };
    }

    /**
     *  switch activity to analysis
     * @return OnClickListener
     */
    private View.OnClickListener goAnalysis()
    {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(), Analysis.class);
                startActivity(unit_intent);
            }
        };
    }

    /**
     *  switch activity to recommendation
     * @return OnClickListener
     */
    private View.OnClickListener go_recommendation()
    {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(), GetRecommendation.class);
                startActivity(unit_intent);
            }
        };
    }

    /**
     *  switch activity to add diet
     * @return OnClickListener
     */
    private View.OnClickListener go_add_diet()
    {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(), SelectDietOption.class);
                startActivity(unit_intent);
            }
        };
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     *
     * @return self for some function need
     */
    private Activity getItSelf()
    {
        return this;
    }

}
