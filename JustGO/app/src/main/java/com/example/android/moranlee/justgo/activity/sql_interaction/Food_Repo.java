package com.example.android.moranlee.justgo.activity.sql_interaction;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.android.moranlee.justgo.activity.datatype.Food;
import com.example.android.moranlee.justgo.activity.sql.SQLite_Interface;

import java.util.ArrayList;
import java.util.HashMap;

import static android.content.ContentValues.TAG;

/**
 * Created by yul04 on 2017/9/23.
 */

public class Food_Repo {
    /**
     default exercise type name string []
     */
    private String [] meats = {"beef","pork","mutton","chicken"};
    private String [] vegetables = {"cabbage","eggplant","cucumber","mushroom"};
    private String [] fruits = {"apple","pear","peach","berry"};
    private String [] dairys = {"milk","yogurt","ice cream","cream"};
    private String [] fats = {"canola oil","corn oil","peanut oil","butter"};
    private String [] grains= {"wheat","rice","barley","oat"};

    /**
     *  sql interface to interact with database
     */
    private SQLite_Interface sql;

    /**
     *  constructor, add default exercise type
     * @param context context hold the database
     */
    public Food_Repo(Context context){
        sql = new SQLite_Interface(context);
        add_default_food();
    }

    /**
     *  insert a food type data to database
     * @param food food data contain all information about user
     * @return int food_id represent if the data is insert successfully
     */
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

    /**
     *  delete a food data by it`s id
     * @param food_Id id of food need to delete
     */
    public void delete_by_id(int food_Id) {
        SQLiteDatabase db = sql.getWritableDatabase();

        db.delete("food", "id" + "= ?", new String[] { String.valueOf(food_Id) });
        db.close();
    }

    /**
     *  delete a food data by it`s name
     * @param food_name name of food need to delete
     */
    public void delete_by_name(String food_name) {
        SQLiteDatabase db = sql.getWritableDatabase();

        db.delete("food", "name" + "= ?", new String[] { food_name });
        db.close();
    }

    /**
     * update food data
     * @param food the data of food want to update
     */
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

    /**
     *  create default food with type meats
     * @param i type id
     * @return a_food food type data
     */
    private Food cretae_default_meats(int i){
        Food a_food = new Food();
        a_food.setId(i);
        a_food.setName(meats[i]);
        a_food.setCalories(Math.random());
        a_food.setCategory(1);
        a_food.setCholesterol(Math.random());
        a_food.setFat(Math.random());
        a_food.setUser_id(0);
        a_food.setProtein(Math.random());
        return a_food;
    }

    /**
     *  create default food with type fruits
     * @param i type id
     * @return a_food food type data
     */
    private Food cretae_default_fruits(int i){
        Food a_food = new Food();
        a_food.setId(i+meats.length);
        a_food.setName(fruits[i]);
        a_food.setCalories(Math.random());
        a_food.setCategory(2);
        a_food.setCholesterol(Math.random());
        a_food.setFat(Math.random());
        a_food.setUser_id(0);
        a_food.setProtein(Math.random());
        return a_food;
    }

    /**
     *  create default food with type vegetables
     * @param i type id
     * @return a_food food type data
     */
    private Food cretae_default_vegetables(int i){
        Food a_food = new Food();
        a_food.setId(i+meats.length+fruits.length);
        a_food.setName(vegetables[i]);
        a_food.setCalories(Math.random());
        a_food.setCategory(3);
        a_food.setCholesterol(Math.random());
        a_food.setFat(Math.random());
        a_food.setUser_id(0);
        a_food.setProtein(Math.random());
        return a_food;
    }

    /**
     *  create default food with type dairys
     * @param i type id
     * @return a_food food type data
     */
    private Food cretae_default_dairys(int i){
        Food a_food = new Food();
        a_food.setId(i+meats.length+fruits.length+vegetables.length);
        a_food.setName(dairys[i]);
        a_food.setCalories(Math.random());
        a_food.setCategory(4);
        a_food.setCholesterol(Math.random());
        a_food.setFat(Math.random());
        a_food.setUser_id(0);
        a_food.setProtein(Math.random());
        return a_food;
    }

    /**
     *  create default food with type grains
     * @param i type id
     * @return a_food food type data
     */
    private Food cretae_default_grains(int i){
        Food a_food = new Food();
        a_food.setId(i+meats.length+fruits.length+vegetables.length+dairys.length);
        a_food.setName(grains[i]);
        a_food.setCalories(Math.random());
        a_food.setCategory(5);
        a_food.setCholesterol(Math.random());
        a_food.setFat(Math.random());
        a_food.setUser_id(0);
        a_food.setProtein(Math.random());
        return a_food;
    }

    /**
     *  create default food with type fats
     * @param i type id
     * @return a_food food type data
     */
    private Food cretae_default_fats(int i){
        Food a_food = new Food();
        a_food.setId(i+meats.length+fruits.length+vegetables.length+dairys.length+grains.length);
        a_food.setName(fats[i]);
        a_food.setCalories(Math.random());
        a_food.setCategory(6);
        a_food.setCholesterol(Math.random());
        a_food.setFat(Math.random());
        a_food.setUser_id(0);
        a_food.setProtein(Math.random());
        return a_food;
    }

    /**
     *  add default food datas to database
     */
    private void add_default_food(){
        for(int i=0;i<4;i++){
            insert(cretae_default_meats(i));
        }
        for(int i=0;i<4;i++){
            insert(cretae_default_fruits(i));
        }
        for(int i=0;i<4;i++){
            insert(cretae_default_vegetables(i));
        }
        for(int i=0;i<4;i++){
            insert(cretae_default_dairys(i));
        }
        for(int i=0;i<4;i++){
            insert(cretae_default_grains(i));
        }
        for(int i=0;i<4;i++){
            insert(cretae_default_fats(i));
        }
    }

    /**
     *  get a list of all data and it`s information
     * @return foodList list contain all food type info
     */
    public ArrayList<HashMap<String, String>>  get_default_food_list() {
        SQLiteDatabase db = sql.getReadableDatabase();
        String selectQuery =  "select * from food where user_id = 0";
        ArrayList<HashMap<String, String>> food_list = new ArrayList<HashMap<String, String>>();
        Log.d(TAG, "get_default_food_list: "+db.toString());
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> food = new HashMap<String, String>();
                food.put("id", cursor.getString(cursor.getColumnIndex("id")));
                food.put("category",cursor.getString(cursor.getColumnIndex("category")));
                food.put("name", cursor.getString(cursor.getColumnIndex("name")));
                food.put("protein",cursor.getString(cursor.getColumnIndex("protein")));
                food.put("fat",cursor.getString(cursor.getColumnIndex("protein")));
                food.put("calories",cursor.getString(cursor.getColumnIndex("calories")));
                food.put("cholesterol",cursor.getString(cursor.getColumnIndex("cholesterol")));
                food_list.add(food);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return food_list;
    }

    /**
     *  get specific food data by its name
     * @return food.toString() contain selected food info
     */
    public String get_food_by_name(String input_name) {
        SQLiteDatabase db = sql.getReadableDatabase();
        HashMap<String, String> food = new HashMap<String, String>();
        Cursor cursor = db.rawQuery(generateQuery(input_name), null);
        if (cursor.moveToFirst()) {
            do {
                food.put("id", cursor.getString(cursor.getColumnIndex("id")));
                food.put("category",cursor.getString(cursor.getColumnIndex("category")));
                food.put("name", cursor.getString(cursor.getColumnIndex("name")));
                food.put("protein",cursor.getString(cursor.getColumnIndex("protein")));
                food.put("fat",cursor.getString(cursor.getColumnIndex("protein")));
                food.put("calories",cursor.getString(cursor.getColumnIndex("calories")));
                food.put("cholesterol",cursor.getString(cursor.getColumnIndex("cholesterol")));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return food.toString();
    }


    /*
        Generate queries available for execution in SQLite database
     */
    public String generateQuery(String inputVar){
        String selectQuery =  "select * from food where name == '"+inputVar+"'";
        return selectQuery;
    }



}
