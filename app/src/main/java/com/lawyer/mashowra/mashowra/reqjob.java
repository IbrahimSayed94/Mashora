package com.lawyer.mashowra.mashowra;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class reqjob extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reqjob);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        WebView webView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webView.loadUrl("http://mashowra.com/oapi/reqjob.php");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
