package com.lawyer.mashowra.mashowra;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class aboutus extends AppCompatActivity {

    Button snap , website , ins , twitter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);


        snap=(Button)findViewById(R.id.bt_snap);
        twitter=(Button)findViewById(R.id.bt_twitter);
        ins=(Button)findViewById(R.id.bt_instigram);
        website=(Button)findViewById(R.id.bt_website);

        snap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent browserIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.snapchat.com/add/mashowra1"));
                startActivity(browserIntent1);
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent browserIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/mashowra"));
                startActivity(browserIntent1);
            }
        });

        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent browserIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/mashowra1/"));
                startActivity(browserIntent1);
            }
        });

        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent browserIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://mashowra.com/"));
                startActivity(browserIntent1);
            }
        });


    }
}
