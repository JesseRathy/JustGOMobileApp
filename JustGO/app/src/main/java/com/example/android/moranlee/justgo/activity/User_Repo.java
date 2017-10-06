package com.example.android.moranlee.justgo.activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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

    public void add_admin_user(){
        insert(create_admin_user(0));
    }

    public boolean check_user_login(String input_name,String input_password) {
        SQLiteDatabase db = sql.getReadableDatabase();
        String selectQuery =  "select * from user where name == '"+input_name+"'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                String Password = cursor.getString(cursor.getColumnIndex("password"));
                if(Password.equals(input_password)){
                    cursor.close();
                    db.close();
                    return true;
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return false;
    }

}
