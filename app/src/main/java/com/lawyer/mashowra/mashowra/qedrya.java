package com.lawyer.mashowra.mashowra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class qedrya extends AppCompatActivity {


    Button sendqedrya;
    String qedrya="قضية إداراية";

    String connectionparameter;
    byte[] parametersbyte;
    EditText name_qedrya,mail_qedrya,mob_qedrya,des_qedrya;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qedrya);

        sendqedrya=(Button)findViewById(R.id.send_qedrya);
        sendqedrya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name_qedrya=(EditText)findViewById(R.id.name_qedrya);
                mail_qedrya=(EditText)findViewById(R.id.mail_qedrya);
                mob_qedrya=(EditText)findViewById(R.id.mob_qedrya);
                des_qedrya=(EditText)findViewById(R.id.des_qedrya);


                String fk,tk,dk,tik,mk;
                fk=name_qedrya.getText().toString();
                tk=mail_qedrya.getText().toString();
                dk=mob_qedrya.getText().toString();
                tik=des_qedrya.getText().toString();
                mk=qedrya;

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

                internetconnection con=new internetconnection(qedrya.this);
                con.connect(createtrip_url,parametersbyte);

            }
        });
    }
}
