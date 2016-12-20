package com.lawyer.mashowra.mashowra;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class setupsplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(setupsplash.this, setupsplash2.class));
                finish();
            }
        }, secondsDelayed * 3000);

    }
}
