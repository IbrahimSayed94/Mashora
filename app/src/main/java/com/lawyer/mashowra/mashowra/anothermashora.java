package com.lawyer.mashowra.mashowra;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class anothermashora extends ActionBarActivity {

    Button sendanothermashora;


    String connectionparameter;
    byte[] parametersbyte;
    EditText name_anothermashora,mail_anothermashora,mob_anothermashora,des_anothermashora,title_anothermashora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anothermashora);

        sendanothermashora=(Button)findViewById(R.id.send_anothermashora);
        sendanothermashora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name_anothermashora=(EditText)findViewById(R.id.name_anothermashora);
                mail_anothermashora=(EditText)findViewById(R.id.mail_anothermashora);
                mob_anothermashora=(EditText)findViewById(R.id.mob_anothermashora);
                des_anothermashora=(EditText)findViewById(R.id.des_anothermashora);
                title_anothermashora=(EditText)findViewById(R.id.title_anothermashora);


                String fk,tk,dk,tik,mk;
                fk=name_anothermashora.getText().toString();
                tk=mail_anothermashora.getText().toString();
                dk=mob_anothermashora.getText().toString();
                tik=des_anothermashora.getText().toString();
                mk=title_anothermashora.getText().toString();

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

                internetconnection con=new internetconnection(anothermashora.this);
                con.connect(createtrip_url,parametersbyte);

            }
        });
    }
}
