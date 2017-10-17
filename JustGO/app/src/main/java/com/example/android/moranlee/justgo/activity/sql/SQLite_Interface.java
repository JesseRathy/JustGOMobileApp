package com.example.android.moranlee.justgo.activity.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yul04 on 2017/9/23.
 */

public class SQLite_Interface extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;

    private static final String DATABASE_NAME = "JustGo";

    public SQLite_Interface (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String [] end = drop_table();
        for(int i=0;i<end.length;i++){
            db.execSQL(end[i]);
        }
        String [] start = do_create_table_string();
        for(int i=0;i<start.length;i++){
            db.execSQL(start[i]);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String [] end = drop_table();
        for(int i=0;i<end.length;i++){
            db.execSQL(end[i]);
        }
    }

    private String [] do_create_table_string(){
        String [] creating = new String [6];
        creating[0] =  "create table food (id int primary key not null, user_id int not null, category int not null, name char(50) not null, protein numeric not null, fat numeric not null, cholesterol numeric not null, calories numeric not null);";
        creating[1] = "create table user (id int primary key not null, name char(50) not null, password char(15) not null, height numeric not null, gender char(1) not null, birthday varchar(8) not null);";
        creating[2] = "create table weight (id int primary key not null, user_id int not null, date date not null, weight numeric not null);";
        creating[3] = "create table diet (id id int primary key not null, food_id int not null, user_id int not null, date date not null, meal_type char(1) not null);";
        creating[4] = "create table exercise_daily (id int primary key not null, exercise_id int not null, user_id int not null, time datetime not null, duration numeric not null);";
        creating[5] = "create table exercise (id int primary key not null, category int not null, name char(20) not null, energy_consumption numeric not null);";
        return creating;
    }

    private String [] drop_table(){
        String [] droping = new String [6];
        droping[0] = "drop table if exists food;";
        droping[1] = "drop table if exists user;";
        droping[2] = "drop table if exists weight;";
        droping[3] = "drop table if exists diet;";
        droping[4] = "drop table if exists Exercise_daily;";
        droping[5] = "drop table if exists exercise;";
        return droping;
    }
    /*
    private String do_Insert_String(String table_name, String [] values){
        switch (table_name){
            case "food":
                return "insert into JustGo.food values ("+values[0]+", "+values[1]+", "+values[2]+", "+values[3]+", "+values[4]+", "+values[5]+", "+values[6]+", "+values[7]+" );";
            case"user":
                return "insert into JustGo.user values ("+values[0]+", "+values[1]+", "+values[2]+", "+values[3]+", "+values[4]+", "+values[5]+" );";
            case "weight":
                return "insert into JustGo.weight values ("+values[0]+", "+values[1]+", "+values[2]+", "+values[3]+" );";
            case "diet":
                return "insert into JustGo.diet values ("+values[0]+", "+values[1]+", "+values[2]+", "+values[3]+", "+values[4]+" );";
            case "exercise":
                return "insert into JustGo.exercise values ("+values[0]+", "+values[1]+", "+values[2]+", "+values[3]+", "+values[4]+" );";
            case "exercise daily":
                return "insert into JustGo.Exercise_daily values ("+values[0]+", "+values[1]+", "+values[2]+" );";
            default:
                return "Invalid table name";
        }
    }

    private String do_Delete_String(String table_name,String field_name, String values){
        switch (table_name){
            case "food":
                return "delete from JustGo.food where "+field_name+" = "+values+" ;";
            case"user":
                return "delete from JustGo.user where "+field_name+" = "+values+" ;";
            case "weight":
                return "delete from JustGo.weight where "+field_name+" = "+values+" ;";
            case "diet":
                return "delete from JustGo.diet where "+field_name+" = "+values+" ;";
            case "exercise":
                return "delete from JustGo.exercise where "+field_name+" = "+values+" ;";
            case "exercise daily":
                return "delete from JustGo.Exercise_daily where "+field_name+" = "+values+" ;";
            default:
                return "Invalid table name";
        }
    }

    private String do_Update_String(String table_name,String update_field_name, String update_values, String find_field_name, String find_values){
        switch (table_name){
            case "food":
                return "update JustGo.food set "+update_field_name+" = "+update_values+" where "+find_field_name+" = "+find_values+" ;";
            case"user":
                return "update JustGo.user set "+update_field_name+" = "+update_values+" where "+find_field_name+" = "+find_values+" ;";
            case "weight":
                return "update JustGo.weight set "+update_field_name+" = "+update_values+" where "+find_field_name+" = "+find_values+" ;";
            case "diet":
                return "update JustGo.diet set "+update_field_name+" = "+update_values+" where "+find_field_name+" = "+find_values+" ;";
            case "exercise":
                return "update JustGo.exercise set "+update_field_name+" = "+update_values+" where "+find_field_name+" = "+find_values+" ;";
            case "exercise daily":
                return "update JustGo.Exercise_daily set "+update_field_name+" = "+update_values+" where "+find_field_name+" = "+find_values+" ;";
            default:
                return "Invalid table name";
        }
    }
    */


}
