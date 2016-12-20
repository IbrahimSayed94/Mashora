package com.lawyer.mashowra.mashowra;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Ibrahim on 11/11/2016.
 */

public class setupsplash2  extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setupsplash);
        getSupportActionBar().hide();


        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(setupsplash2.this, homepage.class));
                finish();
            }
        }, secondsDelayed * 3000);

    }
}
