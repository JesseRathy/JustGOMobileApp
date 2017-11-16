package com.example.android.moranlee.justgo.activity.sql_interaction;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.moranlee.justgo.activity.datatype.Exercise_daily;
import com.example.android.moranlee.justgo.activity.global_value;
import com.example.android.moranlee.justgo.activity.sql.SQLite_Interface;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yul04 on 2017/10/13.
 */

public class Exercise_daily_Repo {

    private SQLite_Interface sql;

    public Exercise_daily_Repo(Context context){
        sql = new SQLite_Interface(context);
    }

    /**
     *  insert a diet type data to database
     * @param exercise_daily diet data contain all information about diet
     * @return diet_id represent if the data is insert successfully
     */
    public int insert(Exercise_daily exercise_daily) {
        SQLiteDatabase db = sql.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",exercise_daily.getId());
        values.put("user_id",exercise_daily.getUser_id());
        values.put("exercise_id",exercise_daily.getExercise_id());
        values.put("date",exercise_daily.getDate());
        values.put("duration",exercise_daily.getDuration());
        long diet_Id = db.insert("diet", null, values);
        db.close();
        return (int) diet_Id;
    }

    /**
     *  return current date as a string for usage when insert diet
     * @return date string contain current date
     */
    public String current_date(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        return date;
    }


    public Exercise_daily create_exercise(int exercise_id, double duration){
        Exercise_daily exercise_daily = new Exercise_daily();
        exercise_daily.setId(global_value.getCurrent_max_exercise_daily_id());
        global_value.setCurrent_max_exercise_daily_id(global_value.getCurrent_max_exercise_daily_id()+1);
        exercise_daily.setUser_id(global_value.getCurrent_user_id());
        exercise_daily.setDate(current_date());
        exercise_daily.setExercise_id(exercise_id);
        exercise_daily.setDuration(duration);
        return exercise_daily;
    }

    /**
     * Calculate total calories consumed by a given user
     *
     * @return total_calories
     */
    public double total_calorie_consumption(){
        SQLiteDatabase db = sql.getReadableDatabase();
        String selectQuery =  "select exercise_id from exercise_daily where id = "+ global_value.getCurrent_user_id();
        String selectCalorieQuery = null;
        int exercise_id = 0;
        double calories = 0;
        double total_calories = 0;

        Cursor dietcursor = db.rawQuery(selectQuery, null);
        if (dietcursor.moveToFirst()){
            do{
                exercise_id = Integer.parseInt(dietcursor.getString(dietcursor.getColumnIndex("exercise_id")));
                selectCalorieQuery = "select energy_consumption from exercise where id = "+ exercise_id;
                Cursor foodcursor = db.rawQuery(selectCalorieQuery,null);
                calories = Double.parseDouble(foodcursor.getString(foodcursor.getColumnIndex("calories")));
                total_calories += calories;
                foodcursor.close();
            } while (dietcursor.moveToNext());

        }
        dietcursor.close();
        db.close();
        return total_calories;
    }

}
