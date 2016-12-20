package com.lawyer.mashowra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;



public class GetJsonFromUrlTask extends AsyncTask<Void, Void, String> {
	public static String LOG_TAG = "net.binnova.planmanager.activities.Activities";
	private Activity activity;
	private String url;
	private ProgressDialog dialog;
	private final static String TAG = GetJsonFromUrlTask.class.getSimpleName();
 
	public GetJsonFromUrlTask(Activity activity, String url) {
		super();
		this.activity = activity;
		this.url = url;
	}
 
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		// Create a progress dialog
		dialog = new ProgressDialog(activity); 
		// Set progress dialog title
		dialog.setTitle("Getting Notification");
		// Set progress dialog message
		dialog.setMessage("Loading...");
		dialog.setIndeterminate(false);
		// Show progress dialog
		dialog.show(); 
	}
	Handler h;
	private static final int DELAY = 33000; // milis

	protected String getASCIIContentFromEntity(HttpEntity entity)
			throws IllegalStateException, IOException {
		InputStream in = entity.getContent();
		StringBuffer out = new StringBuffer();
		int n = 1;
		while (n > 0) {
			byte[] b = new byte[4096];
			n = in.read(b);
			if (n > 0)
				out.append(new String(b, 0, n));
		}
		return out.toString();
	}
	@Override
	protected String doInBackground(Void... params) {
 
		// call load JSON from url method
		//return loadJSON(this.url).toString();
		HttpClient httpClient = new DefaultHttpClient();
		HttpContext localContext = new BasicHttpContext();
		HttpGet httpGet = new HttpGet("http://mashowra.com/oapi/news.php");
		String text = null;
		try {
			HttpResponse response = httpClient.execute(httpGet,
					localContext);
			HttpEntity entity = response.getEntity();
			text = getASCIIContentFromEntity(entity);
		} catch (Exception e) {
			return e.getLocalizedMessage();
		}
		Log.i(LOG_TAG, "End call the activities rest url with response = "
				+ text);
		return text;
	}
 
	@Override
	protected void onPostExecute(String result) {
		((NotifiPageActivity) activity).parseJsonResponse(result);
		dialog.dismiss();
		Log.i(TAG, result);
	}
 

}
