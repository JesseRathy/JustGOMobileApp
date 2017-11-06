package com.example.android.moranlee.justgo.activity.activity;

/**
 * Created by homeyxue on 2017-11-04.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.example.android.moranlee.justgo.R;


public class welcome_screen_activity extends Activity {
    LinearLayout l1,l2;
    Animation uptodown,downtoup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        l1 = (LinearLayout) findViewById(R.id.l1);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        l1.setAnimation(uptodown);

        Thread myThread = new Thread(){
            @Override
            public void run(){
                try {
                    sleep(4000);
                    Intent intent = new Intent(getApplicationContext(), login_activity.class);
                    startActivity(intent);
                    finish();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        };
        myThread.start();
    }
}
