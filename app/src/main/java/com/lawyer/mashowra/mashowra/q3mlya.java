package com.lawyer.mashowra.mashowra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class q3mlya extends AppCompatActivity {

    Button sendq3mlya;
    String q3mlya="قضية عمالية";

    String connectionparameter;
    byte[] parametersbyte;
    EditText name_q3mlya,mail_q3mlya,mob_q3mlya,des_q3mlya;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q3mlya);

        sendq3mlya=(Button)findViewById(R.id.send_q3mlya);
        sendq3mlya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name_q3mlya=(EditText)findViewById(R.id.name_q3mlya);
                mail_q3mlya=(EditText)findViewById(R.id.mail_q3mlya);
                mob_q3mlya=(EditText)findViewById(R.id.mob_q3mlya);
                des_q3mlya=(EditText)findViewById(R.id.des_q3mlya);


                String fk,tk,dk,tik,mk;
                fk=name_q3mlya.getText().toString();
                tk=mail_q3mlya.getText().toString();
                dk=mob_q3mlya.getText().toString();
                tik=des_q3mlya.getText().toString();
                mk=q3mlya;

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

                internetconnection con=new internetconnection(q3mlya.this);
                con.connect(createtrip_url,parametersbyte);

            }
        });
    }
}
