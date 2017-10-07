package com.example.android.moranlee.justgo.activity;

/**
 * Created by yugu on 2017-10-05.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.moranlee.justgo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import adapter.NormalExpandAdapter;
import adapter.OnGroupExpandedListener;

/**
 * 普通 ExpandableListView，支持只展开一个子项
 */
public class NormalExpandActivity extends AppCompatActivity {
    private static final String TAG = "NormalExpandActivity";

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

    public static String[] general = {"meats","fruits","vegetables","dairys","grains","fats"};

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
        for(int i=0;i<defaults.size();i++){
            HashMap<String,String> current = (HashMap<String,String>)defaults.get(i);
            System.out.println(current.toString());
            //Log.d(TAG, "onCreate() returned: " + current.toString());
            String category = current.get("category");
            if(category.equals(null)){
                Toast.makeText(NormalExpandActivity.this,"no thing find in map",Toast.LENGTH_SHORT);
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
        }
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
        specific = new String[][]{meat,vegetable,fruit,dairy,fat,grain};
        final ExpandableListView listView = (ExpandableListView) findViewById(R.id.expandable_list);
        final NormalExpandAdapter adapter = new NormalExpandAdapter(general, specific);
        adapter.setOnGroupExpandedListener(new OnGroupExpandedListener() {


            @Override

            public void onGroupExpanded(int groupPosition) {
                expandOnlyOne(listView, groupPosition, Constant.BOOKS.length);
            }
        });

        listView.setAdapter(adapter);
        //  设置分组项的点击监听事件
        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Log.d(TAG, "onGroupClick: groupPosition:" + groupPosition + ", id:" + id);
                // 请务必返回 false，否则分组不会展开
                return false;
            }
        });

        //  设置子选项点击监听事件
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(NormalExpandActivity.this, Constant.FIGURES[groupPosition][childPosition], Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    // 每次展开一个分组后，关闭其他的分组
    private boolean expandOnlyOne(ExpandableListView view, int expandedPosition, int groupLength) {
        boolean result = true;
        for (int i = 0; i < groupLength; i++) {
            if (i != expandedPosition && view.isGroupExpanded(i)) {
                result &= view.collapseGroup(i);
            }
        }
        return result;
    }

}
