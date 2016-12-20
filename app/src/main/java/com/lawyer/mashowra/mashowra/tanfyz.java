package com.lawyer.mashowra.mashowra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class tanfyz extends AppCompatActivity {


    Button sendtanfyz;
    String tanfyz="تنفيذ";

    String connectionparameter;
    byte[] parametersbyte;
    EditText name_tanfyz,mail_tanfyz,mob_tanfyz,des_tanfyz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanfyz);

        sendtanfyz=(Button)findViewById(R.id.send_tanfyz);
        sendtanfyz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name_tanfyz=(EditText)findViewById(R.id.name_tanfyz);
                mail_tanfyz=(EditText)findViewById(R.id.mail_tanfyz);
                mob_tanfyz=(EditText)findViewById(R.id.mob_tanfyz);
                des_tanfyz=(EditText)findViewById(R.id.des_tanfyz);


                String fk,tk,dk,tik,mk;
                fk=name_tanfyz.getText().toString();
                tk=mail_tanfyz.getText().toString();
                dk=mob_tanfyz.getText().toString();
                tik=des_tanfyz.getText().toString();
                mk=tanfyz;

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

                internetconnection con=new internetconnection(tanfyz.this);
                con.connect(createtrip_url,parametersbyte);

            }
        });
    }
}

