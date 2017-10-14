package com.example.android.moranlee.justgo.activity.sql_interaction;

import android.content.Context;

import com.example.android.moranlee.justgo.activity.datatype.Exercise_daily;
import com.example.android.moranlee.justgo.activity.sql.SQLite_Interface;

/**
 * Created by yul04 on 2017/10/13.
 */

public class Exercise_daily_Repo {

    private SQLite_Interface sql;

    public Exercise_daily_Repo(Context context){
        sql = new SQLite_Interface(context);
    }

    public int insert(Exercise_daily exercise_daily){
        return -1;
    }

    public int delete(Exercise_daily exercise_daily){
        return -1;
    }

    public int update(Exercise_daily exercise_daily){
        return -1;
    }

    public int select(Exercise_daily exercise_daily){
        return -1;
    }

}
