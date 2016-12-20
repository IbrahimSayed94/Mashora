package com.lawyer.mashowra;



import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageView aboutus =(ImageView)findViewById(R.id.aboutus);
		aboutus.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				  Intent intent = new Intent(MainActivity.this, TestActivity.class);
				    startActivity(intent);
			}
		});
		ImageView reqMashor =(ImageView)findViewById(R.id.reqmashowra);
		reqMashor.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				  Intent intent = new Intent(MainActivity.this, ReqMashourActivity.class);
				    startActivity(intent);
			}
		});
		ImageView notifi =(ImageView)findViewById(R.id.notifi);
		notifi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				  Intent intent = new Intent(MainActivity.this, NotifiPageActivity.class);
				    startActivity(intent);
			}
		});
		
		ImageView reqJob =(ImageView)findViewById(R.id.reqjob);
		reqJob.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				  Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
				    startActivity(intent);
			}
		});
		ImageView joinus=(ImageView)findViewById(R.id.joinus);
		joinus.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://mashowra.com/jointous"));
				startActivity(browserIntent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
