package com.example.android.moranlee.justgo.activity.data;

import com.example.android.moranlee.justgo.activity.sql_interaction.ExerciseRepo;
import android.content.Context;

/**
 * Created by yugu on 2017-11-10.
 */

public class ExerciseData {

    private ExerciseRepo exercises;

    public ExerciseData(Context context) {
        exercises = new ExerciseRepo(context);
        addExercise();
    }

    public void addExercise(){
        exercises.addExercise(0,"Hiking",367);
        exercises.addExercise(0,"Dancing",331);
        exercises.addExercise(0," Golf (walking - carrying clubs)",331);
        exercises.addExercise(0,"Bicycling",294);
        exercises.addExercise(0,"Walking",279);
        exercises.addExercise(0,"Weightlifting",220);
        exercises.addExercise(0,"Stretching",184);
        exercises.addExercise(0,"Running/jogging (5 mph)",588);
        exercises.addExercise(0," Bicycling (>10mph)",588);
        exercises.addExercise(0,"Swimming (slow freestyle laps)",514);
        exercises.addExercise(0,"Basketball (vigorous)",441);
        
    }

    

}
