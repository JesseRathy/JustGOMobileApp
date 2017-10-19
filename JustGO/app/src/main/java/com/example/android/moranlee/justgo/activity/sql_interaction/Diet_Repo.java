package com.example.android.moranlee.justgo.activity.sql_interaction;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.moranlee.justgo.activity.datatype.Diet;
import com.example.android.moranlee.justgo.activity.global_value;
import com.example.android.moranlee.justgo.activity.sql.SQLite_Interface;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by yul04 on 2017/10/10.
 */

public class Diet_Repo {
    private SQLite_Interface sql;

    public Diet_Repo(Context context){
        sql = new SQLite_Interface(context);
    }

    public int insert(Diet diet) {
        SQLiteDatabase db = sql.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",diet.getId());
        values.put("user_id",diet.getUser_id());
        values.put("food_id",diet.getFood_id());
        values.put("date",diet.getDate());
        values.put("meal_type",diet.getMeal_type().toString());
        long food_Id = db.insert("diet", null, values);
        db.close();
        return (int) food_Id;
    }

    public String current_date(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        return date;
    }


    public Diet create_diet(int food_id){
        Diet diet = new Diet();
        diet.setId(global_value.getCurrent_max_diet_id());
        global_value.setCurrent_max_diet_id(global_value.getCurrent_max_diet_id()+1);
        diet.setUser_id(global_value.getCurrent_user_id());
        diet.setDate(current_date());
        diet.setFood_id(food_id);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String current_time = sdf.format(cal.getTime());
        if (Integer.parseInt(current_time.substring(0,2))<10){
            diet.setMeal_type('B');
        }
        else if (Integer.parseInt(current_time.substring(0,2)) >17){
            diet.setMeal_type('S');
        }
        else{
            diet.setMeal_type('L');
        }
        return diet;
    }

    //public int total_calorie_intake()


}
