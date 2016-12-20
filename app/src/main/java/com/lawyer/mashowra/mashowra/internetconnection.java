package com.lawyer.mashowra.mashowra;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by Ibrahim on 10/30/2016.
 */

public class internetconnection extends splash
{
    BufferedReader resultReader;
    String result;
    private static Context context;
    public internetconnection(Context c) {
        context = c;
    }
    void  connect(final String url, final byte[] parametersbytearray)
    {

        Runnable run = new Runnable() {
            @Override
            public void run() {
                try {
                    URL insertuserurl = new URL(url);
                    HttpURLConnection con = (HttpURLConnection) insertuserurl.openConnection();
                    con.setRequestMethod("POST");
                    con.getOutputStream().write(parametersbytearray);


                    InputStreamReader resultStreamReader = new InputStreamReader(con.getInputStream());
                    resultReader = new BufferedReader(resultStreamReader);
                    result = resultReader.readLine();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {


                            Toast.makeText(context, result, LENGTH_SHORT).show();

                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();

                }

            }

        };//Runnable


        Thread th = new Thread(run);
        th.start();

    }//connect function

}//class internetconnection
