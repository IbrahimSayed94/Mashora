package com.lawyer.mashowra.mashowra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class a7wal extends AppCompatActivity {


    Button senda7wal;
    String a7wal="احوال شخصية";

    String connectionparameter;
    byte[] parametersbyte;
    EditText name_a7wal,mail_a7wal,mob_a7wal,des_a7wal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a7wal);

        senda7wal=(Button)findViewById(R.id.send_a7wal);
        senda7wal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name_a7wal=(EditText)findViewById(R.id.name_a7wal);
                mail_a7wal=(EditText)findViewById(R.id.mail_a7wal);
                mob_a7wal=(EditText)findViewById(R.id.mob_a7wal);
                des_a7wal=(EditText)findViewById(R.id.des_a7wal);


                String fk,tk,dk,tik,mk;
                fk=name_a7wal.getText().toString();
                tk=mail_a7wal.getText().toString();
                dk=mob_a7wal.getText().toString();
                tik=des_a7wal.getText().toString();
                mk=a7wal;

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

                internetconnection con=new internetconnection(a7wal.this);
                con.connect(createtrip_url,parametersbyte);

            }
        });
    }
}
