package com.lawyer.mashowra;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
public class NotifiPageActivity extends Activity {

	private ListView listview;
	private ArrayList<Book> books;
	private ArrayAdapter<Book> adapter;

	private final static String TAG = NotifiPageActivity.class.getSimpleName();
	private final static String url = "http://mashowra.com/oapi/news.php";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notifi_page);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#070012")));
		listview = (ListView) findViewById(R.id.listview);
		setListViewAdapter();
		getDataFromInternet();
	}

	private void getDataFromInternet() {
		new GetJsonFromUrlTask(this, url).execute();
	}

	private void setListViewAdapter() {
		books = new ArrayList<Book>();
		adapter = new CustomListViewAdapter(this, R.layout.item_listview, books);
		listview.setAdapter(adapter);
		//list.setAdapter(adapter);
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

             @Override
             public void onItemClick(AdapterView<?> parent, View view,
                                     int position, long id) {
                 Toast.makeText(NotifiPageActivity.this, "You Clicked at " +books.get(position).getUrl().toString(), Toast.LENGTH_SHORT).show();
Intent i=new Intent(NotifiPageActivity.this,WebViewNotificationActivity.class);
i.putExtra("url", books.get(position).getUrl().toString());
startActivity(i);
             }
         });
	}

	public void parseJsonResponse(String result) {
		Log.i(TAG, result);
		try {
			//JSONObject json = new JSONObject(result);
			JSONArray jArray = new JSONArray(result);
			for (int i = 0; i < jArray.length(); i++) {

				JSONObject jObject = jArray.getJSONObject(i);
				
				Book book = new Book();
				book.setTitle(jObject.getString("title"));
				book.setImageUrl(jObject.getString("img"));
				book.setBody(jObject.getString("body"));
				book.setTime(jObject.getString("time"));
				book.setUrl(jObject.getString("url"));
				books.add(book);
			}

			adapter.notifyDataSetChanged();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.search, menu);
//	    MenuItem searchItem = menu.findItem(R.id.action_search);
//	    final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
//	    searchView.setOnQueryTextListener(new OnQueryTextListener() {
//	       @Override
//	       public boolean onQueryTextSubmit(String query) {
//	            // perform query here
//	      
//	            // workaround to avoid issues with some emulators and keyboard devices firing twice if a keyboard enter is used
//	            // see https://code.google.com/p/android/issues/detail?id=24599
//	            searchView.clearFocus();
//
//	            return true;
//	       }
//
//	       @Override
//	       public boolean onQueryTextChange(String newText) {
//	           return false;
//	       }
//	   });
//	   return super.onCreateOptionsMenu(menu);


//		SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//
//        SearchView search = (SearchView) menu.findItem(R.id.action_search).getActionView();
//
//        search.setSearchableInfo(manager.getSearchableInfo(getComponentName()));
//
//        search.setOnQueryTextListener(new OnQueryTextListener() { 
//
//          
//
//			@Override
//			public boolean onQueryTextChange(String arg0) {
//				// TODO Auto-generated method stub
//				return false;
//			}
//
//			@Override
//			public boolean onQueryTextSubmit(String query) {
//				for(int i=0;i<books.size();i++){
//					if(books.get(i).getTitle().equals(query)){
//						books.clear();
//						Book book = new Book();
//						book.setTitle(books.get(i).getTitle().toString());
//						book.setImageUrl(books.get(i).getImageUrl().toString());
//						book.setBody(books.get(i).getBody().toString());
//						book.setTime(books.get(i).getTime().toString());
//						book.setUrl(books.get(i).getUrl().toString());
//						books.add(book);
//					}
//				}
//				adapter.notifyDataSetChanged();
//				return false;
//			} 
//
//        });
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();
        switch (id) {
	        case android.R.id.home:
	            //NavUtils.navigateUpFromSameTask(this);
	        	Intent i=new Intent(NotifiPageActivity.this,MainActivity.class);
	        	startActivity(i);
	            return true;
	           
	        case R.id.back:
	            //NavUtils.navigateUpFromSameTask(this);
	        	Intent ia=new Intent(NotifiPageActivity.this,MainActivity.class);
	        	startActivity(ia);
	            return true;
	            
	        case R.id.action_search:
	            //NavUtils.navigateUpFromSameTask(this);
	        	Intent ii=new Intent(NotifiPageActivity.this,NotifiPageActivity.class);
	        	startActivity(ii);
	            return true;
	            
	        default:
	            return super.onOptionsItemSelected(item);
	        }
	}
}
