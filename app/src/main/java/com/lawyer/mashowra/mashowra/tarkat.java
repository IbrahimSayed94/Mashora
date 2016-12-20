package com.lawyer.mashowra.mashowra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class tarkat extends AppCompatActivity {


    Button sendtarkat;
    String tarkat="تركات";

    String connectionparameter;
    byte[] parametersbyte;
    EditText name_tarkat,mail_tarkat,mob_tarkat,des_tarkat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarkat);

        sendtarkat=(Button)findViewById(R.id.send_tarkat);
        sendtarkat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name_tarkat=(EditText)findViewById(R.id.name_tarkat);
                mail_tarkat=(EditText)findViewById(R.id.mail_tarkat);
                mob_tarkat=(EditText)findViewById(R.id.mob_tarkat);
                des_tarkat=(EditText)findViewById(R.id.des_tarkat);


                String fk,tk,dk,tik,mk;
                fk=name_tarkat.getText().toString();
                tk=mail_tarkat.getText().toString();
                dk=mob_tarkat.getText().toString();
                tik=des_tarkat.getText().toString();
                mk=tarkat;

                final String createtrip_url = "http://mashowra.com/oapi/sendmashowra.php";
                String titlekey = "ltitle=";
                String namekey = "&lname=";
                String mailkey = "&lmail=";
                String phonekey = "&lphone=";
                String noteskey = "&lnotes=";



                try {
                    connectionparameter = "act" + URLEncoder.encode("mashowra", "UTF-8") +titlekey + URLEncoder.encode(mk, "UTF-8") +
                            namekey + URLEncoder.encode(fk, "UTF-8")+
                            mailkey + URLEncoder.encode(tk, "UTF-8")+phonekey + URLEncoder.encode(dk, "UTF-8")
                            +noteskey + URLEncoder.encode(tik, "UTF-8");


                    parametersbyte=connectionparameter.getBytes("UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                internetconnection con=new internetconnection(tarkat.this);
                con.connect(createtrip_url,parametersbyte);

            }
        });
    }
}
