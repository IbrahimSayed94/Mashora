package com.lawyer.mashowra.mashowra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class qtogrya extends AppCompatActivity {


    Button sendqtogrya;
    String qtogrya="قضية تجارية";

    String connectionparameter;
    byte[] parametersbyte;
    EditText name_qtogrya,mail_qtogrya,mob_qtogrya,des_qtogrya;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qtogrya);

        sendqtogrya=(Button)findViewById(R.id.send_togrya);
        sendqtogrya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name_qtogrya=(EditText)findViewById(R.id.name_togrya);
                mail_qtogrya=(EditText)findViewById(R.id.mail_togrya);
                mob_qtogrya=(EditText)findViewById(R.id.mob_togrya);
                des_qtogrya=(EditText)findViewById(R.id.des_togrya);


                String fk,tk,dk,tik,mk;
                fk=name_qtogrya.getText().toString();
                tk=mail_qtogrya.getText().toString();
                dk=mob_qtogrya.getText().toString();
                tik=des_qtogrya.getText().toString();
                mk=qtogrya;

                final String createtrip_url = "http://mashowra.com/oapi/sendmashowra.php";
                String titlekey = "ltitle=";
                String namekey = "&lname=";
                String mailkey = "&lmail=";
                String phonekey = "&lphone=";
                String noteskey = "&lnotes=";



                try {
                    connectionparameter = titlekey + URLEncoder.encode(mk, "UTF-8") +
                            namekey + URLEncoder.encode(fk, "UTF-8")+
                            mailkey + URLEncoder.encode(tk, "UTF-8")+phonekey + URLEncoder.encode(dk, "UTF-8")
                            +noteskey + URLEncoder.encode(tik, "UTF-8");


                    parametersbyte=connectionparameter.getBytes("UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                internetconnection con=new internetconnection(qtogrya.this);
                con.connect(createtrip_url,parametersbyte);

            }
        });
    }
}
