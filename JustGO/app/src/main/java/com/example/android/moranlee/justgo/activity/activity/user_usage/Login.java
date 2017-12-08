package com.example.android.moranlee.justgo.activity.activity.user_usage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.moranlee.justgo.R;
import com.example.android.moranlee.justgo.activity.GlobalVariables;
import com.example.android.moranlee.justgo.activity.activity.MainMenu;
import com.example.android.moranlee.justgo.activity.data.ExerciseData;
import com.example.android.moranlee.justgo.activity.data.FoodData;
import com.example.android.moranlee.justgo.activity.sql_interaction.DietRepo;
import com.example.android.moranlee.justgo.activity.sql_interaction.ExerciseDailyRepo;
import com.example.android.moranlee.justgo.activity.sql_interaction.ExerciseRepo;
import com.example.android.moranlee.justgo.activity.sql_interaction.FoodRepo;
import com.example.android.moranlee.justgo.activity.sql_interaction.UserRepo;
import com.example.android.moranlee.justgo.activity.sql_interaction.WeightRepo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity
{

    /*
    button to check user input and allow login
     */
    Button login;

    /*
    go to register a new account
     */
    Button register;

    /*
    field store username user enter
     */
    String username;

    /*
    field store password user enter
     */
    String password;

    /*
    SQLite interface
     */
    UserRepo currentUser;

    FoodRepo foodRepo;

    DietRepo dietRepo;

    ExerciseDailyRepo exerciseDailyRepo;

    ExerciseRepo exerciseRepo;

    WeightRepo weightRepo;

    /**
     * initialize activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        // reinstall databse everytime run, do not need when finish but useful when testing
        //this.deleteDatabase("JustGo");
        // connect interface with field, initialize sql interface
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(login());
        register = (Button)findViewById(R.id.signup);
        register.setOnClickListener(signup());
        currentUser = new UserRepo(this);
        foodRepo = new FoodRepo(this);
        exerciseDailyRepo = new ExerciseDailyRepo(this);
        exerciseRepo = new ExerciseRepo(this);
        weightRepo = new WeightRepo(this);
        dietRepo = new DietRepo(this);
        // delete past user each time reinstall, not need when finish
        ///int past_user = current_user.get_user_num();
        //for (int i = 1; i <= past_user; i++) {
        //    current_user.delete_by_id(i);
       // }
        int maxFood = foodRepo.getMaxFoodId();
        int maxExercise = exerciseRepo.getMaxExerciseId();
        GlobalVariables.setCurrent_max_exercise_id(maxExercise);
        GlobalVariables.setG_CurrentMaxWeightId(weightRepo.getMaxWeightId());
        GlobalVariables.setCurrent_max_exercise_daily_id(exerciseDailyRepo.getMaxExerciseDailyId());
        GlobalVariables.setG_CurrentMaxUserId(currentUser.getMaxUserId());
        GlobalVariables.setCurrent_max_diet_id(dietRepo.getMaxDietId());
        GlobalVariables.setG_CurrentMaxFoodId(maxFood);
        if(maxFood<20 && maxExercise<20) {
            new FoodData(this);
            new ExerciseData(this);
        }
    }

    /**
     * check if should allow user login
     * @return OnClickListener
     */
    private View.OnClickListener login()
    {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // initialize input data pattern, avoid illegal input
                Pattern input_type = Pattern.compile("^[A-Za-z]*$");
                username = ((TextView)findViewById(R.id.username)).getText().toString();
                password = ((TextView)findViewById(R.id.password)).getText().toString();
                Matcher usernameMatcher = input_type.matcher(username);
                Matcher passwordMatcher = input_type.matcher(password);
                // check user do input somthing in both field
                if (username.length() <= 0 || password.length() <= 0) {
                    Toast.makeText(getApplicationContext(),
                                   "You must enter the user and the password",
                                   Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    // check if user input if legal
                    if (!usernameMatcher.matches() || !passwordMatcher.matches()) {
                        Toast.makeText(getApplicationContext(), "Invalid input of username / password",
                                       Toast.LENGTH_SHORT).show();
                        return;
                    }
                    //check input with data from database to confirm user exist and legal
                    int id = currentUser.check_user_login(username, password);
                    // go to main activity
                    if (id >= 0) {
                        /* Yuhan -- Extract Method refactoring done here  */
                       goToMainMenu(id);
                    } else {
                        Toast.makeText(getApplicationContext(),
                                       "Invalid combination of user name and password",
                                       Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
            }
        };
    }

    /**
     *  go to register activity
     * @return
     */
    private View.OnClickListener signup()
    {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(), Register.class);
                startActivity(unit_intent);
            }
        };
    }

    /**
     *
     * @return self for some function need
     */
    private Activity getItSelf()
    {
        return this;
    }

    /* Yukun -- method added for Extract Method */
    private void goToMainMenu(int id){
        GlobalVariables.setG_CurrentUserId(id);
        Intent unit_intent = new Intent(getItSelf(), MainMenu.class);
        unit_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(unit_intent);
    }
}
