package com.example.android.moranlee.justgo.activity.sql_interaction;

import android.content.Context;

import com.example.android.moranlee.justgo.activity.datatype.Weight;
import com.example.android.moranlee.justgo.activity.sql.SQLite_Interface;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by yul04 on 2017/10/13.
 */

public class Weight_Repo {
    private SQLite_Interface sql;

    public Weight_Repo(Context context){
        sql = new SQLite_Interface(context);
    }

    public int insert(Weight weight){
        return -1;
    }

    public int delete(Weight weight){
        return -1;
    }

    public int update(Weight weight){
        return -1;
    }

    public int select(Weight weight){
        return -1;
    }

    public ArrayList<HashMap<String,String>> get_all_weight(){
        return null;
    }

}