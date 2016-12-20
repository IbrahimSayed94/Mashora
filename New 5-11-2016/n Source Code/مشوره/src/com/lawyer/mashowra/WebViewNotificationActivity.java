package com.lawyer.mashowra;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
public class WebViewNotificationActivity extends Activity {
	private WebView webView;


	

	@SuppressLint("JavascriptInterface") protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view_notification);
		Intent i=getIntent();
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#070012")));
    

		
//	EditText com=(EditText)findViewById(R.id.com);
		Bundle b = i.getExtras();
		String name=(String) b.get("url");
		webView = (WebView) findViewById(R.id.webView1);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.clearCache(true);
		webView.clearHistory();
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
		//webView.addJavascriptInterface(new WebAppInterface(this), "Android");
		webView.loadUrl(name);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main1, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
        switch (id) {
	        case android.R.id.home:
	            //NavUtils.navigateUpFromSameTask(this);
	        	Intent i=new Intent(WebViewNotificationActivity.this,MainActivity.class);
	        	startActivity(i);
	            return true;
	           
	        case R.id.back:
	            //NavUtils.navigateUpFromSameTask(this);
	        	Intent ia=new Intent(WebViewNotificationActivity.this,NotifiPageActivity.class);
	        	startActivity(ia);
	            return true;
	            
	        default:
	            return super.onOptionsItemSelected(item);
        }
}
}
