package com.example.android.moranlee.justgo.activity.activity;

/**
 * Created by yugu on 2017-10-05.
 */

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
 * Normal ExpandableListView, expand one child only
 */
public class NormalExpandExerciseActivity extends AppCompatActivity {
    private static final String TAG = "NormalExpandActivity";

    Food_Repo getFoods;

    TextView show_from_database;

    LinkedList<String> yogas;

    String [] yoga;

    LinkedList<String> cardios;

    String [] cardio;

    LinkedList<String> weightliftings;

    String [] weightlifting;

    LinkedList<String> datas;

    public static String[] general = {"yoga","cardio","weightlifting"};

    public static String[][] specific;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand);
        getFoods = new Food_Repo(this);
        ArrayList defaults = getFoods.get_default_food_list();
        yogas = new LinkedList<>();
        cardios = new LinkedList<>();
        weightliftings = new LinkedList<>();
        datas = new LinkedList<>();
        for(int i=0;i<defaults.size();i++){
            HashMap<String,String> current = (HashMap<String,String>)defaults.get(i);
            System.out.println(current.toString());
            //Log.d(TAG, "onCreate() returned: " + current.toString());
            String category = current.get("category");
            if(category.equals(null)){
                Toast.makeText(NormalExpandExerciseActivity.this,"no thing find in map",Toast.LENGTH_SHORT);
            }
            //Toast.makeText(this,category, Toast.LENGTH_SHORT).show();
            if(category.equals("1")){
                yogas.add(current.get("name"));
            }
            if(category.equals("2")){
                weightliftings.add(current.get("name"));
            }
            if(category.equals("3")){
                cardios.add(current.get("name"));
            }
            datas.add(current.toString())
            ;        }
        yoga = new String [yogas.size()];
        for(int i=0;i<yogas.size();i++){
            yoga[i] = yogas.get(i);
        }
        weightlifting = new String[weightliftings.size()];
        for (int i=0;i<weightliftings.size();i++){
            weightlifting[i] = weightliftings.get(i);
        }
        cardio = new String [cardios.size()];
        for(int i=0;i<cardios.size();i++){
            cardio[i] = cardios.get(i);
        }

        specific = new String[][]{yoga,weightlifting,cardio};
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
                Toast.makeText(NormalExpandExerciseActivity.this, specific[groupPosition][childPosition], Toast.LENGTH_SHORT).show();
                Intent go_to_confirm = new Intent(getItSelf(),confirm_nutrient_activity.class);
                int pos = 0;
                for(int i=0;i<groupPosition;i++){
                    pos+=specific[i].length;
                }
                pos+=childPosition;
                go_to_confirm.putExtra("data",datas.get(pos));
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
