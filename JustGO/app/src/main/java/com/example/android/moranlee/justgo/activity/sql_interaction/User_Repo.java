package com.example.android.moranlee.justgo.activity.sql_interaction;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.android.moranlee.justgo.activity.datatype.User;
import com.example.android.moranlee.justgo.activity.global_value;
import com.example.android.moranlee.justgo.activity.sql.SQLite_Interface;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import static android.content.ContentValues.TAG;

public class User_Repo {

    private SQLite_Interface sql;

    public User_Repo(Context context){
        sql = new SQLite_Interface(context);
        add_admin_user();
    }

    public int insert(User user) {
        SQLiteDatabase db = sql.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",user.getId());
        values.put("name",user.getName());
        values.put("password",user.getPassword());
        values.put("height",user.getHeight());
        values.put("gender",user.getGender());
        values.put("birthday",user.getBirthday());
        long user_Id = db.insert("user", null, values);
        db.close();
        return (int) user_Id;
    }

    public User create_admin_user(int id){
        User admin = new User();
        admin.setId(id);
        admin.setName("admin");
        admin.setPassword("admin");
        admin.setHeight((Math.random())*100);
        admin.setGender("M");
        admin.setBirthday("19991231");
        return admin;
    }

    public void delete_by_id(int user_Id) {
        SQLiteDatabase db = sql.getWritableDatabase();

        db.delete("user", "id" + "= ?", new String[] { String.valueOf(user_Id) });
        db.close();
    }

    public void add_admin_user(){
        insert(create_admin_user(0));
    }

    public int check_user_login(String input_name,String input_password) {
        SQLiteDatabase db = sql.getReadableDatabase();
        String selectQuery =  "select * from user where name == '"+input_name+"'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                System.out.println(cursor.getString(cursor.getColumnIndex("name")));
                String Password = cursor.getString(cursor.getColumnIndex("password"));
                if(Password.equals(input_password)){
                    int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                    cursor.close();
                    db.close();
                    return id;
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return -1;
    }

    public ArrayList<HashMap<String, String>>  get_user_list() {
        SQLiteDatabase db = sql.getReadableDatabase();
        String selectQuery =  "select * from user";
        ArrayList<HashMap<String, String>> foodList = new ArrayList<HashMap<String, String>>();
        Log.d(TAG, "get_default_user_list: "+db.toString());
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> food = new HashMap<String, String>();
                food.put("id", cursor.getString(cursor.getColumnIndex("id")));
                food.put("name", cursor.getString(cursor.getColumnIndex("name")));
                food.put("password",cursor.getString(cursor.getColumnIndex("password")));
                food.put("height",cursor.getString(cursor.getColumnIndex("height")));
                food.put("gender",cursor.getString(cursor.getColumnIndex("gender")));
                food.put("birthday",cursor.getString(cursor.getColumnIndex("birthday")));
                foodList.add(food);

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return foodList;
    }

    public int  get_user_num() {
        SQLiteDatabase db = sql.getReadableDatabase();
        String selectQuery =  "select * from user";
        int num = 0;
        //ArrayList<HashMap<String, String>> foodList = new ArrayList<HashMap<String, String>>();
        //Log.d(TAG, "get_default_user_list: "+db.toString());
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                num++;
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return num;
    }

    public double get_current_user_height() {
        SQLiteDatabase db = sql.getReadableDatabase();
        String selectQuery =  "select height from user where id = "+global_value.getCurrent_user_id();
        double height = 0.0;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                height = Double .parseDouble(cursor.getString(cursor.getColumnIndex("height")));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return height;
    }

    public int get_user_age (){
        SQLiteDatabase db = sql.getReadableDatabase();
        String selectQuery =  "select birthday from user where id = "+global_value.getCurrent_user_id();
        String birthday = "";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                birthday = cursor.getString(cursor.getColumnIndex("birthday"));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        int y1 = Integer.parseInt(birthday.substring(0,4));
        int y2 = Integer.parseInt(timeStamp.substring(0,4));
        int m1 = Integer.parseInt(timeStamp.substring(4,6));
        int m2 = Integer.parseInt(birthday.substring(4,6));
        int d1 = Integer.parseInt(birthday.substring(6));
        int d2 = Integer.parseInt(timeStamp.substring(6));
        int age = (y2-y1);
        if(m2<m1){
            age-=1;
        }
        else{
            if(d2<d1){
                age-=1;
            }
        }
        return age;
    }

    public void update_password (String password) {
        SQLiteDatabase db = sql.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", global_value.getCurrent_user_id());
        values.put("password",password);
        db.update("user", values, "id" + "= ?", new String[] { String.valueOf(global_value.getCurrent_user_id()) });
        db.close();
    }

    public void update_height (Double height) {
        SQLiteDatabase db = sql.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", global_value.getCurrent_user_id());
        values.put("height",height);
        db.update("user", values, "id" + "= ?", new String[] { String.valueOf(global_value.getCurrent_user_id()) });
        db.close();
    }

    public void update_weight (Double weight) {
        SQLiteDatabase db = sql.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", global_value.getCurrent_user_id());
        values.put("weight",weight);
        db.update("user", values, "id" + "= ?", new String[] { String.valueOf(global_value.getCurrent_user_id()) });
        db.close();
    }

    public void update_gender (String gender) {
        SQLiteDatabase db = sql.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", global_value.getCurrent_user_id());
        values.put("gender",gender);
        db.update("user", values, "id" + "= ?", new String[] { String.valueOf(global_value.getCurrent_user_id()) });
        db.close();
    }

}
