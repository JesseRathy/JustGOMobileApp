package com.example.android.moranlee.justgo.activity;

import android.app.Application;

/**
 * Created by yul04 on 2017/10/10.
 */

public class global_value extends Application {
    static int current_user_id;
    static int current_max_food_id;
    static int current_max_user_id;
    static int current_max_diet_id;

    /*
        @Return the id of user currently using the system
     */
    public static int getCurrent_user_id() {
        return current_user_id;
    }

    /*
        Set current user id
     */
    public static void setCurrent_user_id(int current_user_id) {
        global_value.current_user_id = current_user_id;
    }

    /*
        @Return the maximum id avialable in food database,
        count the number of items available for select in food table
     */
    public static int getCurrent_max_food_id() {
        return current_max_food_id;
    }

    /*
        Set the maximum food id
     */
    public static void setCurrent_max_food_id(int current_max_food_id) {
        global_value.current_max_food_id = current_max_food_id;
    }

    /*
       @Return the maximum id avialable in food database,
       count the number of items available for select in food table
    */
    public static int get_and_set_Current_max_food_id() {
        current_max_food_id+=1;
        return current_max_food_id;
    }

    /*
        @Return the maximum id avialable in user database,
        count the number of users available in user table
     */
    public static int getCurrent_max_user_id() {
        return current_max_user_id;
    }

    /*
        Set the maximum the maximum user id
     */
    public static void setCurrent_max_user_id(int current_max_user_id) {
        global_value.current_max_user_id = current_max_user_id;
    }

    /*
        @Return the maximum id avialable in diet table,
        count the numebr of diets available in diet table
     */
    public static int getCurrent_max_diet_id() {
        return current_max_diet_id;
    }

    /*
        Set maximum diet id available in diet table
     */
    public static void setCurrent_max_diet_id(int current_max_diet_id) {
        global_value.current_max_diet_id = current_max_diet_id;
    }
}
