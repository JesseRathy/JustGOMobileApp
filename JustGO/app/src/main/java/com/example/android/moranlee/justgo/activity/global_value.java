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

    public static int getCurrent_user_id() {
        return current_user_id;
    }

    public static void setCurrent_user_id(int current_user_id) {
        global_value.current_user_id = current_user_id;
    }

    public static int getCurrent_max_food_id() {
        return current_max_food_id;
    }

    public static void setCurrent_max_food_id(int current_max_food_id) {
        global_value.current_max_food_id = current_max_food_id;
    }

    public static int getCurrent_max_user_id() {
        return current_max_user_id;
    }

    public static void setCurrent_max_user_id(int current_max_user_id) {
        global_value.current_max_user_id = current_max_user_id;
    }

    public static int getCurrent_max_diet_id() {
        return current_max_diet_id;
    }

    public static void setCurrent_max_diet_id(int current_max_diet_id) {
        global_value.current_max_diet_id = current_max_diet_id;
    }
}
