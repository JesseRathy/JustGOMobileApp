package com.example.android.moranlee.justgo.activity.sql_interaction;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.android.moranlee.justgo.activity.datatype.Food;
import com.example.android.moranlee.justgo.activity.sql.SQLite_Interface;
import com.example.android.moranlee.justgo.activity.global_value;
import com.example.android.moranlee.justgo.activity.data.food_data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import static android.content.ContentValues.TAG;

/**
 * Created by yul04 on 2017/9/23.
 */

public class Food_Repo {
    /**
     default exercise type name string []
     */


    private LinkedList<String> meat_type;
    private LinkedList<String> vegetable_type;
    private LinkedList<String> fruit_type;
    private LinkedList<String> dairy_type;
    private LinkedList<String> fat_type;
    private LinkedList<String> grain_type;

    food_data dataCollection;

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
        dataCollection = new food_data(context);
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
        a_food.setName(meat_type.get(i));
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
        a_food.setId(i+meat_type.size());
        a_food.setName(fruit_type.get(i));
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
        a_food.setId(i+meat_type.size()+fruit_type.size());
        a_food.setName(vegetable_type.get(i));
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
        a_food.setId(i+meat_type.size()+fruit_type.size()+vegetable_type.size());
        a_food.setName(dairy_type.get(i));
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
        a_food.setId(i+meat_type.size()+fruit_type.size()+vegetable_type.size()+dairy_type.size());
        a_food.setName(grain_type.get(i));
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
        a_food.setId(i+meat_type.size()+fruit_type.size()+vegetable_type.size()+dairy_type.size()+grain_type.size());
        a_food.setName(fat_type.get(i));
        a_food.setCalories(Math.random());
        a_food.setCategory(6);
        a_food.setCholesterol(Math.random());
        a_food.setFat(Math.random());
        a_food.setUser_id(0);
        a_food.setProtein(Math.random());
        return a_food;
    }


    public void add_meat(String name, double protein, double fat, double calories, double cholesterol){
        Food new_meat = new Food();
        new_meat.setName(name);
        new_meat.setCategory(1);
        new_meat.setUser_id(0);
        new_meat.setId(global_value.get_and_set_Current_max_food_id());
        new_meat.setCalories(calories);
        new_meat.setCholesterol(cholesterol);
        new_meat.setProtein(protein);
        new_meat.setFat(fat);
        this.insert(new_meat);
    }

    public void add_vegetable(String name, double protein, double fat, double calories, double cholesterol){
        Food new_meat = new Food();
        new_meat.setName(name);
        new_meat.setCategory(3);
        new_meat.setUser_id(0);
        new_meat.setId(global_value.get_and_set_Current_max_food_id());
        new_meat.setCalories(calories);
        new_meat.setCholesterol(cholesterol);
        new_meat.setProtein(protein);
        new_meat.setFat(fat);
        this.insert(new_meat);
    }

    public void add_fruit(String name, double protein, double fat, double calories, double cholesterol){
        Food new_meat = new Food();
        new_meat.setName(name);
        new_meat.setCategory(2);
        new_meat.setUser_id(0);
        new_meat.setId(global_value.get_and_set_Current_max_food_id());
        new_meat.setCalories(calories);
        new_meat.setCholesterol(cholesterol);
        new_meat.setProtein(protein);
        new_meat.setFat(fat);
        this.insert(new_meat);
    }

    public void add_diary(String name, double protein, double fat, double calories, double cholesterol){
        Food new_meat = new Food();
        new_meat.setName(name);
        new_meat.setCategory(4);
        new_meat.setUser_id(0);
        new_meat.setId(global_value.get_and_set_Current_max_food_id());
        new_meat.setCalories(calories);
        new_meat.setCholesterol(cholesterol);
        new_meat.setProtein(protein);
        new_meat.setFat(fat);
        this.insert(new_meat);
    }

    public void add_grain(String name, double protein, double fat, double calories, double cholesterol){
        Food new_meat = new Food();
        new_meat.setName(name);
        new_meat.setCategory(5);
        new_meat.setUser_id(0);
        new_meat.setId(global_value.get_and_set_Current_max_food_id());
        new_meat.setCalories(calories);
        new_meat.setCholesterol(cholesterol);
        new_meat.setProtein(protein);
        new_meat.setFat(fat);
        this.insert(new_meat);
    }


    /**
     *  add default food datas to database
     */
    private void add_default_food(){
        meat_type = new LinkedList<>();
        vegetable_type = new LinkedList<>();
        fruit_type = new LinkedList<>();
        dairy_type = new LinkedList<>();
        fat_type = new LinkedList<>();
        grain_type = new LinkedList<>();

        String [] meats = {"beef","pork","mutton","chicken"};
        String [] vegetables = {"cabbage","eggplant","cucumber","mushroom"};
        String [] fruits = {"apple","pear","peach","berry"};
        String [] dairys = {"milk","yogurt","ice cream","cream"};
        String [] fats = {"canola oil","corn oil","peanut oil","butter"};
        String [] grains= {"wheat","rice","barley","oat"};
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
                food.put("fat",cursor.getString(cursor.getColumnIndex("fat")));
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
