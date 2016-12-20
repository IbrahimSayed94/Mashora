package com.lawyer.mashowra.mashowra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class gm3yat extends AppCompatActivity {


    Button sendgm3yat;
    String gm3yat="الجمعيات والمؤسسات الأهلية";

    String connectionparameter;
    byte[] parametersbyte;
    EditText name_gm3yat,mail_gm3yat,mob_gm3yat,des_gm3yat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gm3yat);

        sendgm3yat=(Button)findViewById(R.id.send_gm3yat);
        sendgm3yat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name_gm3yat=(EditText)findViewById(R.id.name_gm3yat);
                mail_gm3yat=(EditText)findViewById(R.id.mail_gm3yat);
                mob_gm3yat=(EditText)findViewById(R.id.mob_gm3yat);
                des_gm3yat=(EditText)findViewById(R.id.des_gm3yat);


                String fk,tk,dk,tik,mk;
                fk=name_gm3yat.getText().toString();
                tk=mail_gm3yat.getText().toString();
                dk=mob_gm3yat.getText().toString();
                tik=des_gm3yat.getText().toString();
                mk=gm3yat;

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

                internetconnection con=new internetconnection(gm3yat.this);
                con.connect(createtrip_url,parametersbyte);

            }
        });
    }
}
