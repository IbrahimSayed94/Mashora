package com.lawyer.mashowra.mashowra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class awqaf extends AppCompatActivity {


    Button sendawqaf;
    String awqaf="اوقاف";

    String connectionparameter;
    byte[] parametersbyte;
    EditText name_awqaf,mail_awqaf,mob_awqaf,des_awqaf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awqaf);

        sendawqaf=(Button)findViewById(R.id.send_awqaf);
        sendawqaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name_awqaf=(EditText)findViewById(R.id.name_awqaf);
                mail_awqaf=(EditText)findViewById(R.id.mail_awqaf);
                mob_awqaf=(EditText)findViewById(R.id.mob_awqaf);
                des_awqaf=(EditText)findViewById(R.id.des_awqaf);


                String fk,tk,dk,tik,mk;
                fk=name_awqaf.getText().toString();
                tk=mail_awqaf.getText().toString();
                dk=mob_awqaf.getText().toString();
                tik=des_awqaf.getText().toString();
                mk=awqaf;

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

                internetconnection con=new internetconnection(awqaf.this);
                con.connect(createtrip_url,parametersbyte);

            }
        });
    }
}
