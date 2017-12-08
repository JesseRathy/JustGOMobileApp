package com.example.android.moranlee.justgo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;
import android.test.RenamingDelegatingContext;
import android.util.Log;

import com.example.android.moranlee.justgo.activity.GlobalVariables;
import com.example.android.moranlee.justgo.activity.datatype.Exercise;
import com.example.android.moranlee.justgo.activity.datatype.Food;
import com.example.android.moranlee.justgo.activity.sql.SQLiteInterface;
import com.example.android.moranlee.justgo.activity.sql_interaction.ExerciseRepo;
import com.example.android.moranlee.justgo.activity.sql_interaction.FoodRepo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Integer.parseInt;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Jesse on 2017-12-01.
 */

public class ExcerciseInteractionUnitTest {

    Context mMockContext;

    @Before
    public void setUp() {
        mMockContext = new RenamingDelegatingContext(InstrumentationRegistry.getTargetContext(), "test_");
    }

    ExerciseRepo f1;

    ExerciseRepo f2;

    private SQLiteInterface sql;

    Exercise f3;

    Exercise f4;

    SQLiteDatabase db;

    final private int testID=5;

    final private String testName = "test";

    final private int testCategory = 1;

    final private double testConsumption = 50.0;


    final private int testID1=6;

    final private String testName1 = "test2";

    final private int testCategory1 = 2;

    final private double testConsumption1 = 75.0;






    Context context;

    @Test
    public void setup() throws Exception{
        assertNull(f1);
        assertNull(f2);
        f3 = new Exercise();
        f4 = new Exercise();
        this.setData();
        assertNotNull(f3);
        assertNotNull(f4);

        sql = new SQLiteInterface(mMockContext);
        db = sql.getWritableDatabase();
        f1 = new ExerciseRepo(mMockContext);


        //int numFood = GlobalVariables.getG_CurrentMaxFoodId();

        this.insertdata();

        ArrayList<HashMap<String, String>> test_food_list = this.get_food_by_user_id(testID);

        assertNotNull(test_food_list);

        Log.d("myTag", test_food_list.toString());
        String testExerciseID = test_food_list.get(0).get("id");
        String testExerciseCategory = test_food_list.get(0).get("category");
        String testExerciseName = test_food_list.get(0).get("name");
        String testExerciseEnergyUse = test_food_list.get(0).get("energy_consumption");


        assertEquals(testID,parseInt(testExerciseID));
        //assertEquals(parseInt(testUserID),test_userID);
        assertEquals(Double.parseDouble(testExerciseEnergyUse),testConsumption,0);
        assertEquals(parseInt(testExerciseCategory),testCategory);
        assertEquals(testName,testExerciseName);

        this.insertdata1();
        ArrayList<HashMap<String, String>> test_food_list1 = this.get_food_by_user_id(testID1);

        Log.d("myTag", test_food_list1.toString());
        assertEquals(1,test_food_list1.size());
        test_food_list1 = this.get_food_by_user_id(testID);
        assertEquals(1,test_food_list1.size());

        //int numFood1 = GlobalVariables.getG_CurrentMaxFoodId();
        //assertEquals(numFood,numFood1,2);
        Log.d("myTag", "End of testing");
        db.close();
    }

    public void setData(){
        f3.setId(testID);
        f3.setName(testName);
        f3.setCategory(testCategory);
        f3.setEnergy_consumption(testConsumption);

        f4.setId(testID1);
        f4.setName(testName1);
        f4.setCategory(testCategory1);
        f4.setEnergy_consumption(testConsumption1);

    }

    public void insertdata() { f1.insert(f3); }
    public void insertdata1() { f1.insert(f4);}


    public ArrayList<HashMap<String, String>> get_food_by_user_id(int id)
    {
        SQLiteDatabase db = sql.getReadableDatabase();
        ArrayList<HashMap<String, String>> resultSet = new ArrayList<>();
//        Cursor cursor = db.query("food", null, "name like '%" + input_name + "%'",
//                null, null, null, null);
        String selectQuery =  "select * from exercise where id = " + id;
        Cursor cursor = db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String>  exercise = new HashMap<String, String>();
                exercise.put("id", cursor.getString(cursor.getColumnIndex("id")));
                exercise.put("category", cursor.getString(cursor.getColumnIndex("category")));
                exercise.put("name", cursor.getString(cursor.getColumnIndex("name")));
                exercise.put( "energy_consumption", cursor.getString(cursor.getColumnIndex("energy_consumption")));
                resultSet.add(exercise);

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return resultSet;
    }

}

