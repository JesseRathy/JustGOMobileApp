package com.example.android.moranlee.justgo.activity.data;

import com.example.android.moranlee.justgo.activity.sql_interaction.Exercise_Repo;
import android.content.Context;

/**
 * Created by yugu on 2017-11-10.
 */

public class exercise_data {

    private Exercise_Repo exercies;

    public exercise_data(Context context) {
        exercies = new Exercise_Repo(context);
        addExercise();
    }

    public void addExercise(){
        exercies.addExercise(0,"running",123);


    }


}
