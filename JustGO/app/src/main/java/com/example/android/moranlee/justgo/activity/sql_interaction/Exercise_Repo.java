package com.example.android.moranlee.justgo.activity.sql_interaction;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.android.moranlee.justgo.activity.datatype.Exercise;
import com.example.android.moranlee.justgo.activity.sql.SQLite_Interface;

import java.util.ArrayList;
import java.util.HashMap;

import static android.content.ContentValues.TAG;


public class Exercise_Repo {
    private String [] slow = {"run","swim","dance"};
    private String [] fast = {"basketball","soccer","football"};
    private SQLite_Interface sql;

    public Exercise_Repo(Context context){
        sql = new SQLite_Interface(context);
        add_default_exercise();
    }

    private Exercise cretae_default_slow(int i){
        Exercise ex = new Exercise();
        ex.setId(i);
        ex.setCategory(0);
        ex.setName(slow[i]);
        ex.setEnergy_consumption(Math.random());
        return ex;
    }

    private Exercise cretae_default_fast(int i){
        Exercise ex = new Exercise();
        ex.setId(i);
        ex.setCategory(1);
        ex.setName(fast[i]);
        ex.setEnergy_consumption(Math.random());
        return ex;
    }

    public int insert(Exercise ex) {
        SQLiteDatabase db = sql.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", ex.getId());
        values.put("name", ex.getName());
        values.put("category", ex.getCategory());
        values.put("energy_consumption", ex.getEnergy_consumption());
        long ex_id = db.insert("exercise", null, values);
        db.close();
        return (int) ex_id;
    }

    private void add_default_exercise(){
        for(int i=0;i<3;i++){
            insert(cretae_default_slow(i));
        }
        for(int i=0;i<3;i++){
            insert(cretae_default_fast(i));
        }

    }

    public ArrayList<HashMap<String, String>>  get_default_food_list() {
        SQLiteDatabase db = sql.getReadableDatabase();
        String selectQuery =  "select * from exercise where user_id = 0";
        ArrayList<HashMap<String, String>> exList = new ArrayList<HashMap<String, String>>();
        Log.d(TAG, "get_default_exercise_list: "+db.toString());
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> exMap = new HashMap<String, String>();
                exMap.put("id", cursor.getString(cursor.getColumnIndex("id")));
                exMap.put("category",cursor.getString(cursor.getColumnIndex("category")));
                exMap.put("name", cursor.getString(cursor.getColumnIndex("name")));
                exMap.put("energy_consumption",cursor.getString(cursor.getColumnIndex("energy_consumption")));
                exList.add(exMap);

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return exList;
    }


}
