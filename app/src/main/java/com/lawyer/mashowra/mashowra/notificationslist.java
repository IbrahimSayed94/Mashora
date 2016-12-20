package com.lawyer.mashowra.mashowra;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

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


public class notificationslist extends ActionBarActivity
{


    RecyclerView recycleView;
    notificationsadapter adapter;
    List<notification> notificationList=new ArrayList<>();
    static String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        recycleView = (RecyclerView) findViewById(R.id.RecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycleView.setLayoutManager(linearLayoutManager);
        //Make call to AsyncTask
        final String nl_url="http://mashowra.com/oapi/news.php";

        Runnable run = new Runnable() {
            @Override
            public void run() {
                try {
                    URL viewprofileurl = new URL(nl_url);
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

                        JSONArray notificationssarray=new JSONArray(result);

                        for(int i=0;i<notificationssarray.length();i++)
                        {

                            JSONObject json_data = notificationssarray.getJSONObject(i);
                            notification not = new notification();
                            not.id= json_data.getInt("id");
                            not.time= json_data.getString("time");
                            not.title= json_data.getString("title");
                            not.body= json_data.getString("body");
                            not.url= json_data.getString("url");
                            not.img= json_data.getString("img");
                            notificationList.add(not);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();

                    }

                    runOnUiThread(
                            new Runnable() {
                                @Override
                                public void run() {


                                    adapter = new notificationsadapter(notificationslist.this,notificationList);
                                    recycleView.setAdapter(adapter);

                                }
                            });

                } catch (IOException e) {
                    e.printStackTrace();

                }

            }

        };


        Thread th = new Thread(run);
        th.start();


        recycleView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {


                        URL= adapter.notificationList.get(position).url;
                        Intent urlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                        startActivity(urlIntent);

                    }
                })
        );
    }


}

class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }
    GestureDetector mGestureDetector;

    public RecyclerItemClickListener(Context context, OnItemClickListener listener) {
        mListener = listener;
        mGestureDetector = new GestureDetector(context,     new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        View childView = view.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
            mListener.onItemClick(childView, view.getChildAdapterPosition(childView));
        }
        return false;
    }


    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }


    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}//RecyclerItemClickListener class