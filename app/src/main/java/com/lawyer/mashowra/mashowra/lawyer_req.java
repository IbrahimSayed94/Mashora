package com.lawyer.mashowra.mashowra;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
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

public class lawyer_req extends ActionBarActivity  implements SearchView.OnQueryTextListener {
    RecyclerView recycleView;
    lawyer_req_adapter adapter;
    List<lawyer> lawyer_Req = new ArrayList<>();
    static int ID;
    boolean x=false;
    final String l_url = "http://mashowra.com/oapi/lawyers1.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawyer_req);


        recycleView = (RecyclerView) findViewById(R.id.RecyclerView_lawyer_req);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycleView.setLayoutManager(linearLayoutManager);
        final Intent i=new Intent(this,profile_lawyer.class);


        Runnable run = new Runnable() {
            @Override
            public void run() {
                try {
                    java.net.URL lawyerurl = new URL(l_url);
                    HttpURLConnection con = (HttpURLConnection) lawyerurl.openConnection();
                    InputStreamReader resultStreamReader = new InputStreamReader(con.getInputStream());
                    BufferedReader resultReader = new BufferedReader(resultStreamReader);
                    final StringBuilder textbuilder = new StringBuilder();
                    String line;
                    while ((line = resultReader.readLine()) != null) {
                        textbuilder.append(line);
                    }
                    String result = textbuilder.toString();

                    try {

                        JSONArray lawyerarray = new JSONArray(result);

                        for (int i = 0; i < lawyerarray.length(); i++) {

                            JSONObject json_data = lawyerarray.getJSONObject(i);
                            lawyer l = new lawyer();
                            l.id = json_data.getInt("lid");
                            l.name = json_data.getString("1");
                            l.position = json_data.getString("14");
                            l.city = json_data.getString("3");
                            l.img = json_data.getString("limg");
                            l.country =json_data.getString("2");
                            lawyer_Req.add(l);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();

                    }

                    runOnUiThread(
                            new Runnable() {
                                @Override
                                public void run() {

                                    adapter = new lawyer_req_adapter(lawyer_req.this, lawyer_Req);
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
                new RecyclerItemClickListener3(this, new RecyclerItemClickListener3.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        ID=adapter.lawyer_Req.get(position).id;
                        startActivity(i);
                    }
                })
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_actions, menu);


        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(
                new ComponentName(this, reqlawyer.class)));
        searchView.setIconifiedByDefault(false);
        searchView.setQueryHint("ابحث بالأسم او المدينة ..");






        return true;

    }

    @Override
    public boolean onQueryTextSubmit(final String query) {
        int size = adapter.lawyer_Req.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                adapter.lawyer_Req.remove(0);
            }

            adapter.notifyItemRangeRemoved(0, size);
        }

        Runnable run = new Runnable() {
            @Override
            public void run() {
                try {
                    java.net.URL lawyerurl = new URL(l_url);
                    HttpURLConnection con = (HttpURLConnection) lawyerurl.openConnection();
                    InputStreamReader resultStreamReader = new InputStreamReader(con.getInputStream());
                    BufferedReader resultReader = new BufferedReader(resultStreamReader);
                    final StringBuilder textbuilder = new StringBuilder();
                    String line;
                    while ((line = resultReader.readLine()) != null) {
                        textbuilder.append(line);
                    }
                    String result = textbuilder.toString();

                    try {

                        JSONArray lawyerarray = new JSONArray(result);

                        for (int i = 0; i < lawyerarray.length(); i++) {

                            JSONObject json_data = lawyerarray.getJSONObject(i);
                            lawyer l = new lawyer();
                            l.id = json_data.getInt("lid");
                            l.name = json_data.getString("1");
                            l.position = json_data.getString("14");
                            l.city = json_data.getString("3");
                            l.img = json_data.getString("limg");
                            l.country =json_data.getString("2");
                            if(l.name.equals(query) ||  l.city.equals(query) || l.country.equals(query)) {

                                lawyer_Req.add(l);
                                x=true;
                            }
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();

                    }

                    runOnUiThread(
                            new Runnable() {
                                @Override
                                public void run() {


                                    adapter = new lawyer_req_adapter(lawyer_req.this, lawyer_Req);
                                    recycleView.setAdapter(adapter);
                                    if(x==false)
                                    {          new AlertDialog.Builder(lawyer_req.this)
                                            .setTitle("البحث عن محامي/محامية")
                                            .setMessage("لم يتم العثور على نتائج")
                                            .setCancelable(true)
                                            .setPositiveButton("إغلاق", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.cancel();
                                                }
                                            }).create().show();

                                    }

                                }
                            });

                } catch (IOException e) {
                    e.printStackTrace();

                }

            }

        };
        x=false;


        Thread th = new Thread(run);
        th.start();


        recycleView.addOnItemTouchListener(
                new RecyclerItemClickListener3(this, new RecyclerItemClickListener3.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        final Intent i=new Intent(getApplicationContext(),profile_lawyer.class);
                        ID=adapter.lawyer_Req.get(position).id;
                        startActivity(i);
                    }
                })
        );
        return false;

    }

    @Override
    public boolean onQueryTextChange(String newText) {

        //adapter.getFilter().filter(newText);
        return true;
    }



}
class RecyclerItemClickListener3 implements RecyclerView.OnItemTouchListener {

    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }
    GestureDetector mGestureDetector;

    public RecyclerItemClickListener3(Context context, OnItemClickListener listener) {
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