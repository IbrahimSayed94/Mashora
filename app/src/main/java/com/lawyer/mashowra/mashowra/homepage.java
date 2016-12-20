package com.lawyer.mashowra.mashowra;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homepage extends AppCompatActivity {


    Button reqjob , reqmashora , joinus ,notification , aboutus ,reqlawyer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);


        getSupportActionBar().hide();
        final Intent intent = new Intent(this, reqjob.class);
        reqjob=(Button)findViewById(R.id.reqjob);
        reqjob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  startActivity(intent);


                Intent browserIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://mashowra.com/oapi/reqjob.php"));
                startActivity(browserIntent1);
            }
        });

        final Intent intent1 = new Intent(this, reqmashora.class);
        reqmashora=(Button)findViewById(R.id.reqmashora);
        reqmashora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        });



        joinus=(Button)findViewById(R.id.joinus);
        joinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://mashowra.com/jointous"));
                startActivity(browserIntent);
            }
        });

        final Intent intent2 = new Intent(this, notificationslist.class);
        notification=(Button)findViewById(R.id.notification);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
            }
        });


        final Intent intent3 = new Intent(this, aboutus.class);
        aboutus=(Button)findViewById(R.id.aboutus);
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent3);
            }
        });


        final Intent intent4 = new Intent(this, reqlawyer.class);
        reqlawyer=(Button)findViewById(R.id.relawyer);
        reqlawyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent4);
            }
        });

    }
}
