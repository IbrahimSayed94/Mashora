package com.lawyer.mashowra;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class TestActivity extends Activity {
	 private Bitmap bmp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
//		Bitmap bmp = null;
		final ImageView v=(ImageView)findViewById(R.id.imageView1);
////		try {
////			URL	url = new URL("http://mashowra.com/wp-content/uploads/2016/05/placeholder.gif");
////			try {
////				 bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
////				 v.setImageBitmap(bm);
////			} catch (IOException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////		} catch (MalformedURLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		
//		
//	
//			URL url = null;
//			try {
//				url = new URL("http://mashowra.com/wp-content/uploads/2016/05/placeholder.gif");
//			} catch (MalformedURLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		
//		 
//		try {
//			Bitmap	bmp1 = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//			v.setImageBitmap(bmp1);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		


		   new AsyncTask<Void, Void, Void>() {                  
		        @Override
		        protected Void doInBackground(Void... params) {
		            try {
		                InputStream in = new URL("http://mashowra.com/wp-content/uploads/2016/05/placeholder.gif").openStream();
		                bmp = BitmapFactory.decodeStream(in);
		            } catch (Exception e) {
		               // log error
		            }
		            return null;
		        }

		        @Override
		        protected void onPostExecute(Void result) {
		            if (bmp != null)
		                v.setImageBitmap(bmp);
		        }

		   }.execute();
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test, menu);
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
