package com.lawyer.mashowra.mashowra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class qganya extends AppCompatActivity {


    Button sendqganya;
    String  qganya="قضية جنائية";

    String connectionparameter;
    byte[] parametersbyte;
    EditText name_qganya,mail_qganya,mob_qganya,des_qganya;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qganya);

        sendqganya=(Button)findViewById(R.id.send_qganya);
        sendqganya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name_qganya=(EditText)findViewById(R.id.name_qganya);
                mail_qganya=(EditText)findViewById(R.id.mail_qganya);
                mob_qganya=(EditText)findViewById(R.id.mob_qganya);
                des_qganya=(EditText)findViewById(R.id.des_qganya);


                String fk,tk,dk,tik,mk;
                fk=name_qganya.getText().toString();
                tk=mail_qganya.getText().toString();
                dk=mob_qganya.getText().toString();
                tik=des_qganya.getText().toString();
                mk=qganya;

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

                internetconnection con=new internetconnection(qganya.this);
                con.connect(createtrip_url,parametersbyte);

            }
        });
    }
}
