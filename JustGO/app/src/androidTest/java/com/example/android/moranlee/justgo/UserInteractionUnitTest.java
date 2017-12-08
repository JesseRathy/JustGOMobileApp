package com.example.android.moranlee.justgo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.RenamingDelegatingContext;

import org.junit.Test;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.android.moranlee.justgo.activity.datatype.User;
import com.example.android.moranlee.justgo.activity.sql.SQLiteInterface;
import com.example.android.moranlee.justgo.activity.sql_interaction.UserRepo;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Integer.parseInt;
import static org.junit.Assert.*;

/**
 * Created by yugu on 2017-11-23.
 */

//@RunWith(AndroidJUnit4.class)
public class UserInteractionUnitTest {


    Context mMockContext;

    @Before
    public void setUp() {
        mMockContext = new RenamingDelegatingContext(InstrumentationRegistry.getTargetContext(), "test_");
    }

    //@Parameter
    UserRepo f1;
    //@parameter
    UserRepo f2;

    private SQLiteInterface sql;

    User f3;

    User f4;

    SQLiteDatabase db;

    //SET ID TO Avoid id = 0, which is the id of administrator in this case
    final private int testID = 100;

    final private String test_name= "test";

    final private String test_password = "test";

    final private double test_height = 0.0;

    final private String test_gender = "M";

    final private String test_birthday = "2015-01-01";

    final private int testID1 = 101;

    final private String test_name1= "test3";

    final private String test_password1 = "test2";

    final private double test_height1 = 50.0;

    final private String test_gender1 = "M";

    final private String test_birthday1 = "2015-01-02";

    Context context;

    @Test
    public void setup() throws Exception{
        assertNull(f1);
        assertNull(f2);
        f3 = new User();
        f4 = new User();
        this.setData();

        sql = new SQLiteInterface(mMockContext);
        db = sql.getWritableDatabase();
        f1 = new UserRepo(mMockContext);
        //f2 = new UserRepo(mMockContext);

        this.insertdata();

        ArrayList<HashMap<String, String>> test_user_list = this.get_user_by_user_id(testID);

        assertNotNull(test_user_list);
        Log.d("myTag", test_user_list.toString());
        String testUserID = test_user_list.get(0).get("id");
        String testName = test_user_list.get(0).get("name");
        String testPassword = test_user_list.get(0).get("password");
        String testHeight = test_user_list.get(0).get("height");
        String testGender = test_user_list.get(0).get("gender");
        String testBirthday = test_user_list.get(0).get("birthday");

        assertEquals(parseInt(testUserID),testID);
        assertEquals(testName,test_name);
        assertEquals(testPassword,test_password);
        assertEquals(Double.parseDouble(testHeight),test_height,0);
        assertEquals(testGender, test_gender);
        assertEquals(testBirthday, test_birthday);
        assertEquals(1,test_user_list.size());

        insertdata2();
        ArrayList<HashMap<String, String>> test_user_list1 = this.get_user_by_user_id(testID1);
        Log.d("myTag", test_user_list1.toString());
        assertEquals(1,test_user_list1.size());

        //sincce we should only have one user per id, if we grab the second id for a different thing, it will be the same.

        Log.d("myTag", "End of testing");
        db.close();
    }

    public void setData(){
        f3.setId(testID);
        f3.setName(test_name);
        f3.setBirthday(test_birthday);
        f3.setGender(test_gender);
        f3.setHeight(test_height);
        f3.setPassword(test_password);

        f4.setId(testID1);
        f4.setName(test_name1);
        f4.setBirthday(test_birthday1);
        f4.setGender(test_gender1);
        f4.setHeight(test_height1);
        f4.setPassword(test_password1);
    }

    public void insertdata() { f1.insert(f3); }
    public void insertdata2(){ f1.insert(f4); }

    public ArrayList<HashMap<String, String>> get_user_by_user_id(int id)
    {
        SQLiteDatabase db = sql.getReadableDatabase();
        ArrayList<HashMap<String, String>> resultSet = new ArrayList<>();
        String selectQuery =  "select * from user where id = " + id;
        Cursor cursor = db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> food = new HashMap<String, String>();
                food.put("id", cursor.getString(cursor.getColumnIndex("id")));
                food.put("name", cursor.getString(cursor.getColumnIndex("name")));
                food.put("password", cursor.getString(cursor.getColumnIndex("password")));
                food.put("height", cursor.getString(cursor.getColumnIndex("height")));
                food.put("gender", cursor.getString(cursor.getColumnIndex("gender")));
                food.put("birthday", cursor.getString(cursor.getColumnIndex("birthday")));
                resultSet.add(food);

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return resultSet;
    }

}



