package com.example.android.moranlee.justgo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by yul04 on 2017/9/23.
 */

public class Food_Repo {
    private String [] meats = {"beef","pork","mutton","chicken"};

    private SQLite_Interface sql;

    public Food_Repo(Context context){
        sql = new SQLite_Interface(context);
        add_default_food();
    }

    public int insert(Food food) {
        SQLiteDatabase db = sql.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",food.getId());
        values.put("user_id",food.getUser_id());
        values.put("category",food.getCategory());
        values.put("name",food.getName());
        values.put("protein",food.getProtein());
        values.put("fat",food.getFat());
        values.put("cholesterol",food.getCholesterol());
        values.put("calories",food.getCalories());
        long food_Id = db.insert("food", null, values);
        db.close();
        return (int) food_Id;
    }

    public void delete_by_id(int food_Id) {
        SQLiteDatabase db = sql.getWritableDatabase();

        db.delete("food", "id" + "= ?", new String[] { String.valueOf(food_Id) });
        db.close();
    }

    public void delete_by_name(String food_name) {
        SQLiteDatabase db = sql.getWritableDatabase();

        db.delete("food", "name" + "= ?", new String[] { food_name });
        db.close();
    }

    public void update(Food food) {

        SQLiteDatabase db = sql.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",food.getId());
        values.put("user_id",food.getUser_id());
        values.put("category",food.getCategory());
        values.put("name",food.getName());
        values.put("protein",food.getProtein());
        values.put("fat",food.getFat());
        values.put("cholesterol",food.getCholesterol());
        values.put("calories",food.getCalories());

        db.update("food", values, "id" + "= ?", new String[] { String.valueOf(food.getId()) });
        db.close();
    }

    private Food cretae_default_foods(int i){
        Food a_food = new Food();
        a_food.setId(0);
        a_food.setName(meats[i]);
        a_food.setCalories(Math.random());
        a_food.setCategory(1);
        a_food.setCholesterol(Math.random());
        a_food.setFat(Math.random());
        a_food.setUser_id(0);
        a_food.setProtein(Math.random());
        return a_food;
    }

    private void add_default_food(){
        for(int i=0;i<4;i++){
            insert(cretae_default_foods(i));
        }
    }

    public ArrayList<HashMap<String, String>>  get_default_food_list() {

        SQLiteDatabase db = sql.getReadableDatabase();
        String selectQuery =  "select * from food where user_id = 0";
        ArrayList<HashMap<String, String>> foodList = new ArrayList<HashMap<String, String>>();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> food = new HashMap<String, String>();
                food.put("id", cursor.getString(cursor.getColumnIndex("id")));
                food.put("name", cursor.getString(cursor.getColumnIndex("name")));
                foodList.add(food);

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return foodList;

    }


}
