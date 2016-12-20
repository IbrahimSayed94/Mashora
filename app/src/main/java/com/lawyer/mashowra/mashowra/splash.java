package com.lawyer.mashowra.mashowra;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splash extends AppCompatActivity {

    SharedPreferences mPrefs;
    final String welcomeScreenShownPref = "welcomeScreenShown";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();



        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        // second argument is the default to use if the preference can't be found
        Boolean welcomeScreenShown = mPrefs.getBoolean(welcomeScreenShownPref, false);

        if (!welcomeScreenShown) {

            Intent intent=new Intent(this , setupsplash.class);
            startActivity(intent);
        }
            SharedPreferences.Editor editor = mPrefs.edit();
            editor.putBoolean(welcomeScreenShownPref, true);
            editor.commit(); // Very important to save the preference


            int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(splash.this, homepage.class));
                finish();
            }
        }, secondsDelayed * 3000);
    }

}
