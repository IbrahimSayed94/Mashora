package com.lawyer.mashowra.mashowra;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class profile_lawyer extends ActionBarActivity {
    static   boolean flag=false;
    int index;
    int profileid;
    TextView tvname,tvposition,tvtitle,tvinfo;
    CircleImageView ivimg;
    List<lawyer> profile_Lawyer=new ArrayList<>();
    lawyer_req l_r=new lawyer_req();
    lawyermotderb_req lm_r=new lawyermotderb_req();
    mo7kem_req mo7_r=new mo7kem_req();
    modreblaw_req modlaw_r=new modreblaw_req();
    mosek_req mos_r =new mosek_req();
    mostshar_req most_r =new mostshar_req();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_lawyer);

        tvname=(TextView)findViewById(R.id.profile_lawyer_name);
        tvposition=(TextView)findViewById(R.id.profile_lawyer_lakb);
        tvtitle=(TextView)findViewById(R.id.pro_tit);
        tvinfo=(TextView)findViewById(R.id.profile_lawyer_information);

        ivimg=(CircleImageView) findViewById(R.id.profile_lawyer_img);

        if(l_r.ID!=0)
        {
            profileid=l_r.ID;
        }
        if(lm_r.ID!=0)
        {
            profileid=lm_r.ID;
        }
        if(mo7_r.ID!=0)
        {
            profileid=mo7_r.ID;
        }
        if(modlaw_r.ID!=0)
        {
            profileid=modlaw_r.ID;
        }
        if(mos_r.ID!=0)
        {
            profileid=mos_r.ID;
        }
        if(most_r.ID!=0)
        {
            profileid=most_r.ID;
        }

        final String profile_lawyer_url="http://mashowra.com/oapi/singlelawyer.php?user="+profileid;
        Runnable run = new Runnable() {
            @Override
            public void run() {
                try {
                    URL viewprofileurl = new URL(profile_lawyer_url);
                    HttpURLConnection con = (HttpURLConnection) viewprofileurl.openConnection();
                    InputStreamReader resultStreamReader = new InputStreamReader(con.getInputStream());
                    BufferedReader resultReader = new BufferedReader(resultStreamReader);
                    final StringBuilder textbuilder= new StringBuilder();
                    String line;
                    while ((line=resultReader.readLine()) != null)
                    {
                        textbuilder.append(line);
                    }
                    String result=textbuilder.toString();

                    try {

                        JSONArray profilelawyersarray=new JSONArray(result);

                        for(int i=0;i<profilelawyersarray.length();i++)
                        {

                            JSONObject json_data = profilelawyersarray.getJSONObject(i);
                            lawyer l = new lawyer();
                            l.img= json_data.getString("limg");
                            l.name= json_data.getString("lname");
                            l.position= json_data.getString("f2a");
                            l.title= json_data.getString("title1");
                            l.ta5sos= json_data.getString("ta5sos");
                            l.mobilenumber= json_data.getString("lmobile");
                            l.city= json_data.getString("lcity");
                            l.country= json_data.getString("lcountry");

                            profile_Lawyer.add(l);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();

                    }

                    runOnUiThread(
                            new Runnable() {
                                @Override
                                public void run() {

                                    tvname.setText(profile_Lawyer.get(0).name);
                                    tvposition.setText(profile_Lawyer.get(0).position);
                                    tvtitle.setText(profile_Lawyer.get(0).title);
                                    tvinfo.setText("الاسم: "+profile_Lawyer.get(0).name+"\n\n"+"اللقب: "+profile_Lawyer.get(0).ta5sos+
                                            "\n\n"+"لجوال: "+profile_Lawyer.get(0).mobilenumber+"\n\n"+"المدينة: "+profile_Lawyer.get(0).city+
                                            "\n\n"+"الدولة: "+profile_Lawyer.get(0).country);

                                    Glide.with(profile_lawyer.this).load(profile_Lawyer.get(0).img).centerCrop().dontAnimate().into(ivimg);

                                }
                            });

                } catch (IOException e) {
                    e.printStackTrace();

                }

            }

        };


        Thread th = new Thread(run);
        th.start();

    }
}