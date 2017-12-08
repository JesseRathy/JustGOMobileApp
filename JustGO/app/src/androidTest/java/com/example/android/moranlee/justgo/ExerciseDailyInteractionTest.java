package com.example.android.moranlee.justgo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;
import android.test.RenamingDelegatingContext;
import android.util.Log;

import com.example.android.moranlee.justgo.activity.datatype.Exercise;
import com.example.android.moranlee.justgo.activity.datatype.ExerciseDaily;
import com.example.android.moranlee.justgo.activity.sql.SQLiteInterface;
import com.example.android.moranlee.justgo.activity.sql_interaction.ExerciseDailyRepo;
import com.example.android.moranlee.justgo.activity.sql_interaction.ExerciseRepo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Integer.parseInt;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Jesse on 2017-12-02.
 */

public class ExerciseDailyInteractionTest {

    Context mMockContext;

    @Before
    public void setUp() {
        mMockContext = new RenamingDelegatingContext(InstrumentationRegistry.getTargetContext(), "test_");
    }

    ExerciseDailyRepo f1;

    ExerciseDailyRepo f2;

    private SQLiteInterface sql;

    ExerciseDaily f3;

    ExerciseDaily f4;

    SQLiteDatabase db;
    final private int testID = 3;
    final private int testUserID= 4;
    final private int testExerciseID = 2;
    final private String test_date = "2015-01-01";
    final private double testDuration = 20.0;

    final private int testID1 = 4;
    final private int testUserID1=5;
    final private int testExerciseID1 = 6;
    final private String test_date1 = "2015-01-02";
    final private double testDuration1 = 50.0;





    Context context;

    @Test
    public void setup() throws Exception{
//        assertNull(f1);
//        assertNull(f2);
//        f3 = new ExerciseDaily();
//        f4 = new ExerciseDaily();
//        this.setData();
//        assertNotNull(f3);
//        assertNotNull(f4);
//
//        sql = new SQLiteInterface(mMockContext);
//        db = sql.getWritableDatabase();
//        f1 = new ExerciseDailyRepo(mMockContext);
//        //int numFood = GlobalVariables.getG_CurrentMaxFoodId();
//
//        this.insertdata();
        //int value = f1.insert(f3);
        //Log.d("myTag",Integer.toString(value));

//        ArrayList<HashMap<String, String>> testExerciseList = this.get_exercise_by_user_id(testID);
//
//        assertNotNull(testExerciseList);
//
//        Log.d("myTag",testExerciseList.toString());
//
//        String testExerciseId = testExerciseList.get(0).get("id");
//        String testExerciseUserId = testExerciseList.get(0).get("user_id");
//        String testExerciseExcId = testExerciseList.get(0).get("exercise_id");
//        String testExerciseDate = testExerciseList.get(0).get("date");
//        String testExerciseDuration = testExerciseList.get(0).get("duration");
//
//        assertEquals(testID,parseInt(testExerciseId));
//        assertEquals(parseInt(testExerciseUserId),testExerciseUserId);
//        assertEquals(parseInt(testExerciseExcId),testExerciseID);
//        assertEquals(testExerciseDate, test_date);
//        assertEquals(Double.parseDouble(testExerciseDuration),testDuration,0);

       // this.insertdata1();
       // ArrayList<HashMap<String, String>> test_food_list1 = this.get_exercise_by_user_id(testID1);
       // assertEquals(1,test_food_list1);

        //int numFood1 = GlobalVariables.getG_CurrentMaxFoodId();
        //assertEquals(numFood,numFood1,2);
        Log.d("myTag", "End of testing");
        db.close();
    }

    public void setData(){
        f3.setId(testID);
        f3.setUser_id(testUserID);
        f3.setExercise_id(testExerciseID);
        f3.setDate(test_date);
        f3.setDuration(testDuration);

        f4.setId(testID1);
        f4.setUser_id(testUserID1);
        f4.setExercise_id(testExerciseID1);
        f4.setDate(test_date1);
        f4.setDuration(testDuration1);

    }

    public void insertdata() {  f1.insert(f3);}
    //public void insertdata1() { f1.insert(f4);}


    public ArrayList<HashMap<String, String>> get_exercise_by_user_id(int id)
    {
        SQLiteDatabase db = sql.getReadableDatabase();
        ArrayList<HashMap<String, String>> resultSet = new ArrayList<>();
//        Cursor cursor = db.query("food", null, "name like '%" + input_name + "%'",
//                null, null, null, null);
        String selectQuery =  "select * from exercise_daily where id = " + id;
        Cursor cursor = db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String>  exercise = new HashMap<String, String>();
                exercise.put("id", cursor.getString(cursor.getColumnIndex("id")));
                exercise.put("user_id", cursor.getString(cursor.getColumnIndex("user_id")));
                exercise.put("exercise_id", cursor.getString(cursor.getColumnIndex("exercise_id")));
                exercise.put("date", cursor.getString(cursor.getColumnIndex("date")));
                exercise.put("duration", cursor.getString(cursor.getColumnIndex("duration")));
                resultSet.add(exercise);

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return resultSet;
    }

}
