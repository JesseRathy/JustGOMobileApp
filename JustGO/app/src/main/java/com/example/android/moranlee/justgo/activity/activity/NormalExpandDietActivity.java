package com.example.android.moranlee.justgo.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.moranlee.justgo.R;
import com.example.android.moranlee.justgo.activity.adapter.NormalExpandAdapter;
import com.example.android.moranlee.justgo.activity.adapter.OnGroupExpandedListener;
import com.example.android.moranlee.justgo.activity.sql_interaction.Food_Repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by yul04 on 2017/10/17.
 */

public class NormalExpandDietActivity extends AppCompatActivity {
    private static final String TAG = "ExpandDietActivity";

    Food_Repo getFoods;

    TextView show_from_database;

    LinkedList<String> meats;

    String [] meat;

    LinkedList<String> vegetables;

    String [] vegetable;

    LinkedList<String> fruits;

    String [] fruit;

    LinkedList<String> grains;

    String [] grain;

    LinkedList<String> dairys;

    String [] dairy;

    LinkedList<String> fats;

    String [] fat;

    LinkedList<String> users;

    String [] user;

    LinkedList<String> datas;

    public static String[] general = {"meats","fruits","vegetables","dairys","grains","fats","users"};

    public static String[][] specific;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand);
        getFoods = new Food_Repo(this);
        ArrayList defaults = getFoods.get_default_food_list();
        meats = new LinkedList<>();
        vegetables = new LinkedList<>();
        fruits = new LinkedList<>();
        grains = new LinkedList<>();
        fats = new LinkedList<>();
        dairys = new LinkedList<>();
        users = new LinkedList<>();
        datas = new LinkedList<>();
        for(int i=0;i<defaults.size();i++){
            HashMap<String,String> current = (HashMap<String,String>)defaults.get(i);
            System.out.println(current.toString());
            //Log.d(TAG, "onCreate() returned: " + current.toString());
            String category = current.get("category");
            if(category.equals(null)){
                Toast.makeText(NormalExpandDietActivity.this,"no thing find in map",Toast.LENGTH_SHORT);
            }
            //Toast.makeText(this,category, Toast.LENGTH_SHORT).show();
            if(category.equals("1")){
                meats.add(current.get("name"));
            }
            if(category.equals("2")){
                fruits.add(current.get("name"));
            }
            if(category.equals("3")){
                vegetables.add(current.get("name"));
            }
            if(category.equals("4")){
                dairys.add(current.get("name"));
            }
            if(category.equals("5")){
                grains.add(current.get("name"));
            }
            if(category.equals("6")){
                fats.add(current.get("name"));
            }
            if(category.equals("7")){
                users.add(current.get("name"));
            }
            datas.add(current.toString())
            ;        }
        meat = new String [meats.size()];
        for(int i=0;i<meats.size();i++){
            meat[i] = meats.get(i);
        }
        fruit = new String[fruits.size()];
        for (int i=0;i<fruits.size();i++){
            fruit[i] = fruits.get(i);
        }
        vegetable = new String [vegetables.size()];
        for(int i=0;i<vegetables.size();i++){
            vegetable[i] = vegetables.get(i);
        }
        grain = new String[grains.size()];
        for (int i=0;i<grains.size();i++){
            grain[i] = grains.get(i);
        }
        dairy = new String [dairys.size()];
        for(int i=0;i<dairys.size();i++){
            dairy[i] = dairys.get(i);
        }
        fat = new String[fats.size()];
        for (int i=0;i<fats.size();i++){
            fat[i] = fats.get(i);
        }
        user = new String[users.size()];
        for (int i=0;i<users.size();i++){
            user[i] = users.get(i);
        }
        specific = new String[][]{meat,fruit,vegetable,dairy,fat,grain,user};
        final ExpandableListView listView = (ExpandableListView) findViewById(R.id.expandable_list);
        final NormalExpandAdapter adapter = new NormalExpandAdapter(general, specific);
        adapter.setOnGroupExpandedListener(new OnGroupExpandedListener() {


            @Override

            public void onGroupExpanded(int groupPosition) {
                expandOnlyOne(listView, groupPosition, general.length);
            }
        });

        listView.setAdapter(adapter);
        //  set on group listener
        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Log.d(TAG, "onGroupClick: groupPosition:" + groupPosition + ", id:" + id);
                // must return false
                return false;
            }
        });

        //  set child on child listener
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(NormalExpandDietActivity.this, specific[groupPosition][childPosition], Toast.LENGTH_SHORT).show();
                Intent go_to_confirm = new Intent(getItSelf(),confirm_food_nutrient_activity.class);
                int pos = 0;
                for(int i=0;i<groupPosition;i++){
                    pos+=specific[i].length;
                }
                pos+=childPosition;
                go_to_confirm.putExtra("data",datas.get(pos));
                go_to_confirm.putExtra("id",pos);
                startActivity(go_to_confirm);
                return true;
            }
        });
    }

    //close other if one is expand
    private boolean expandOnlyOne(ExpandableListView view, int expandedPosition, int groupLength) {
        boolean result = true;
        for (int i = 0; i < groupLength; i++) {
            if (i != expandedPosition && view.isGroupExpanded(i)) {
                result &= view.collapseGroup(i);
            }
        }
        return result;
    }

    private Activity getItSelf(){
        return this;
    }

}