package com.lawyer.mashowra.mashowra;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class reqlawyer extends ActionBarActivity {

    Button lawyer , mostshar ,mo7kem ,mosek ,moderb ,lawyermotaderb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reqlawyer);


        lawyer=(Button)findViewById(R.id.lawyer);
        final Intent intent=new Intent(this , lawyer_req.class);
        lawyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
///////////////////////////////////////////////////////////////////////
        mostshar=(Button)findViewById(R.id.mostshar);
        final Intent intent1=new Intent(this , mostshar_req.class);
        mostshar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        });
///////////////////////////////////////////////////////////////////////


        mo7kem=(Button)findViewById(R.id.mo7kem);
        final Intent intent2=new Intent(this , mo7kem_req.class);
        mo7kem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
            }
        });
///////////////////////////////////////////////////////////////////////

        mosek=(Button)findViewById(R.id.mosek);
        final Intent intent4=new Intent(this , mosek_req.class);
        mosek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent4);
            }
        });
///////////////////////////////////////////////////////////////////////

        moderb=(Button)findViewById(R.id.moderb);
        final Intent intent5=new Intent(this , modreblaw_req.class);
        moderb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent5);
            }
        });
///////////////////////////////////////////////////////////////////////

        lawyermotaderb=(Button)findViewById(R.id.lawyermotaderb);
        final Intent intent6=new Intent(this , lawyermotderb_req.class);
        lawyermotaderb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent6);
            }
        });
///////////////////////////////////////////////////////////////////////
    }
}
