package com.lawyer.mashowra.mashowra;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class reqmashora extends ActionBarActivity {

    Button q3ama,qtograya,qa7wal,qtanfeyz,qtarkat,qganya,qedrya,qawaf,qgm3yat,q3malya,anothermashora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reqmashora);

        q3ama=(Button)findViewById(R.id.q3ama);
        q3ama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(reqmashora.this, q3ama.class);
                startActivity(intent);
            }
        });
        //**********************************************************************
        qtanfeyz=(Button)findViewById(R.id.qtanfeyz);
        qtanfeyz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(reqmashora.this, tanfyz.class);
                startActivity(intent);
            }
        });
        //**********************************************************************
        qtograya=(Button)findViewById(R.id.qtogarya);
        qtograya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(reqmashora.this, qtogrya.class);
                startActivity(intent);
            }
        });
        //**********************************************************************
        qa7wal=(Button)findViewById(R.id.qa7wal);
        qa7wal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(reqmashora.this, a7wal.class);
                startActivity(intent);
            }
        });
        //**********************************************************************
        qtarkat=(Button)findViewById(R.id.qtarkat);
        qtarkat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(reqmashora.this, tarkat.class);
                startActivity(intent);
            }
        });
        //**********************************************************************
        qawaf=(Button)findViewById(R.id.qawaf);
        qawaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(reqmashora.this, awqaf.class);
                startActivity(intent);
            }
        });
        //**********************************************************************
        qganya=(Button)findViewById(R.id.qqnaya);
        qganya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(reqmashora.this, qganya.class);
                startActivity(intent);
            }
        });
        //**********************************************************************
        qedrya=(Button)findViewById(R.id.qedarya);
        qedrya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(reqmashora.this, qedrya.class);
                startActivity(intent);
            }
        });
        //**********************************************************************
        qgm3yat=(Button)findViewById(R.id.qqm3ayat);
        qgm3yat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(reqmashora.this, gm3yat.class);
                startActivity(intent);
            }
        });
        //**********************************************************************
        q3malya=(Button)findViewById(R.id.q3malya);
        q3malya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(reqmashora.this, q3mlya.class);
                startActivity(intent);
            }
        });
        //**********************************************************************


        anothermashora=(Button)findViewById(R.id.anothermashora);
        anothermashora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(reqmashora.this, anothermashora.class);
                startActivity(intent);
            }
        });
        //**********************************************************************


    }
}
