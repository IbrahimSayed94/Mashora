package com.lawyer.mashowra;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;
 
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
public class ReqMashourModelActivity extends Activity {
	private static final String SERVICE_URL = "http://mashowra.com/oapi/sendmashowra.php";
	public static String LOG_TAG = "net.binnova.planmanager.activities.Login";
    private static final String TAG = "AndroidRESTClientActivity";
    String ltitle="";
    String lmail="";
    String lphone="";
    String Lname="";
    String lwasf="";
    ProgressDialog prgDialog;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_req_mashour_model);
		
		
		prgDialog = new ProgressDialog(this);
        // Set Progress Dialog Text
        prgDialog.setMessage("Please wait...");
        // Set Cancelable as False
        prgDialog.setCancelable(false);
        
        EditText  title=(EditText)findViewById(R.id.com);
		 ltitle= title.getText().toString();
//		
		EditText mail=(EditText)findViewById(R.id.editText2);
		 lmail= mail.getText().toString();
		
		EditText phone=(EditText)findViewById(R.id.editText3);
		 lphone= phone.getText().toString();
		
		EditText nmae=(EditText)findViewById(R.id.editText1);
		 Lname= nmae.getText().toString();
		
		EditText wasf=(EditText)findViewById(R.id.editText5);
		 lwasf= wasf.getText().toString();
//		
		
		Intent i=getIntent();
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#070012")));
		getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); 
	    getActionBar().setCustomView(R.layout.menu_example);
	    

		
//	EditText com=(EditText)findViewById(R.id.com);
		Bundle b = i.getExtras();
		String name=(String) b.get("pq");
		if(name.equals("other")){
			title.setText("               ");
			
		}else{
			title.setText("  "+name+"  ");
			title.setEnabled(false);
		
		}
		Button bb=(Button)findViewById(R.id.textView4);
		bb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			postData();
				
			}
		});
	}
	
	
     
//    public void postData(View vw) {
// 
//        
// 
//        WebServiceTask wst = new WebServiceTask(WebServiceTask.POST_TASK, this, "Posting data...");
// 
//        wst.addNameValuePair("ltitle", ltitle);
//        wst.addNameValuePair("lname", Lname);
//        wst.addNameValuePair("lmail", lmail);
//        wst.addNameValuePair("lphone", lphone);
//        wst.addNameValuePair("act", "mashowra");
//        wst.addNameValuePair("lnotes", lwasf);
//        // the passed String is the URL we will POST to
//        wst.execute(new String[] { SERVICE_URL });
// 
//    }
    
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
	        	Intent i=new Intent(ReqMashourModelActivity.this,MainActivity.class);
	        	startActivity(i);
	            return true;
	           
	        case R.id.back:
	            //NavUtils.navigateUpFromSameTask(this);
	        	Intent ia=new Intent(ReqMashourModelActivity.this,ReqMashourActivity.class);
	        	startActivity(ia);
	            return true;
	            
	        default:
	            return super.onOptionsItemSelected(item);
        }
	}
//	private class WebServiceTask extends AsyncTask<String, Integer, String> {
//		 
//        public static final int POST_TASK = 1;
//        public static final int GET_TASK = 2;
//         
//        private static final String TAG = "WebServiceTask";
// 
//        // connection timeout, in milliseconds (waiting to connect)
//        private static final int CONN_TIMEOUT = 3000;
//         
//        // socket timeout, in milliseconds (waiting for data)
//        private static final int SOCKET_TIMEOUT = 5000;
//         
//        private int taskType = POST_TASK;
//        private Context mContext = null;
//        private String processMessage = "Processing...";
// 
//        private ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
// 
//        private ProgressDialog pDlg = null;
// 
//        public WebServiceTask(int taskType, Context mContext, String processMessage) {
// 
//            this.taskType = taskType;
//            this.mContext = mContext;
//            this.processMessage = processMessage;
//        }
// 
//        public void addNameValuePair(String name, String value) {
// 
//            params.add(new BasicNameValuePair(name, value));
//        }
// 
//        private void showProgressDialog() {
//             
//            pDlg = new ProgressDialog(mContext);
//            pDlg.setMessage(processMessage);
//            pDlg.setProgressDrawable(mContext.getWallpaper());
//            pDlg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//            pDlg.setCancelable(false);
//            pDlg.show();
// 
//        }
// 
//        @Override
//        protected void onPreExecute() {
// 
//            hideKeyboard();
//            showProgressDialog();
// 
//        }
// 
//        protected String doInBackground(String... urls) {
// 
//            String url = urls[0];
//            String result = "";
// 
//            HttpResponse response = doResponse(url);
// 
//            if (response == null) {
//                return result;
//            } else {
// 
//                try {
// 
//                    result = inputStreamToString(response.getEntity().getContent());
// 
//                } catch (IllegalStateException e) {
//                    Log.e(TAG, e.getLocalizedMessage(), e);
// 
//                } catch (IOException e) {
//                    Log.e(TAG, e.getLocalizedMessage(), e);
//                }
// 
//            }
// 
//            return result;
//        }
// 
//        @Override
//        protected void onPostExecute(String response) {
//             
//            handleResponse(response);
//            pDlg.dismiss();
//             
//        }
//         
//        // Establish connection and socket (data retrieval) timeouts
//        private HttpParams getHttpParams() {
//             
//            HttpParams htpp = new BasicHttpParams();
//             
//            HttpConnectionParams.setConnectionTimeout(htpp, CONN_TIMEOUT);
//            HttpConnectionParams.setSoTimeout(htpp, SOCKET_TIMEOUT);
//             
//            return htpp;
//        }
//         
//        private HttpResponse doResponse(String url) {
//             
//            // Use our connection and data timeouts as parameters for our
//            // DefaultHttpClient
//            HttpClient httpclient = new DefaultHttpClient(getHttpParams());
// 
//            HttpResponse response = null;
// 
//            try {
//                switch (taskType) {
// 
//                case POST_TASK:
//                    HttpPost httppost = new HttpPost(url);
//                    // Add parameters
//                    httppost.setEntity(new UrlEncodedFormEntity(params));
// 
//                    response = httpclient.execute(httppost);
//                    break;
//                case GET_TASK:
//                    HttpGet httpget = new HttpGet(url);
//                    response = httpclient.execute(httpget);
//                    break;
//                }
//            } catch (Exception e) {
// 
//                Log.e(TAG, e.getLocalizedMessage(), e);
// 
//            }
// 
//            return response;
//        }
//         
//        private String inputStreamToString(InputStream is) {
// 
//            String line = "";
//            StringBuilder total = new StringBuilder();
// 
//            // Wrap a BufferedReader around the InputStream
//            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
// 
//            try {
//                // Read response until the end
//                while ((line = rd.readLine()) != null) {
//                    total.append(line);
//                }
//            } catch (IOException e) {
//                Log.e(TAG, e.getLocalizedMessage(), e);
//            }
// 
//            // Return full string
//            return total.toString();
//        }
// 
//    }
//	private void hideKeyboard() {
//		 
//        InputMethodManager inputManager = (InputMethodManager) ReqMashourModelActivity.this
//                .getSystemService(Context.INPUT_METHOD_SERVICE);
// 
//        inputManager.hideSoftInputFromWindow(
//                ReqMashourModelActivity.this.getCurrentFocus()
//                        .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
//    }
//	public void handleResponse(String response) {
//        
//		EditText title=(EditText)findViewById(R.id.com);
//		
//		
//		EditText mail=(EditText)findViewById(R.id.editText2);
//		
//		
//		EditText phone=(EditText)findViewById(R.id.editText3);
//		
//		
//		EditText nmae=(EditText)findViewById(R.id.editText1);
//
//		
//		EditText wasf=(EditText)findViewById(R.id.editText5);
//		
//		title.setText("");
//        mail.setText("");
//        phone.setText("");
//        nmae.setText("");
//        wasf.setText("");
//        Toast.makeText(ReqMashourModelActivity.this, response, Toast.LENGTH_LONG).show();
////		
//        try {
//             
//            JSONObject jso = new JSONObject(response);
//             
//            
//           
//            Toast.makeText(ReqMashourModelActivity.this, response, Toast.LENGTH_LONG).show();
////			
//             
//        } catch (Exception e) {
//            Log.e(TAG, e.getLocalizedMessage(), e);
//        }
//         
//    }
//	
//	
	
	
	
	
	
	
	
	
	
	
	public void postData() {
		Log.i(LOG_TAG,
				" Post  is succesifule and —»‰« Ì” — Ì«—» Ê ﬂÊ‰ „—Â Ê«ÕœÂ= ");
		
//		String userNameStr = username.getText().toString();
//	    String passwordStr = password.getText().toString();

		WebServiceTask wst = new WebServiceTask(WebServiceTask.POST_TASK, this,
				"Posting data...");

		wst.addNameValuePair("ltitle", ltitle);
        wst.addNameValuePair("lname", Lname);
        wst.addNameValuePair("lmail", lmail);
        wst.addNameValuePair("lphone", lphone);
        wst.addNameValuePair("act", "mashowra");
        wst.addNameValuePair("lnotes", lwasf);
        // the passed String is the URL we will POST to
        wst.execute(new String[] { SERVICE_URL });
		
		// the passed String is the URL we will POST to
//		wst.execute(new String[] { RestUrlHelper
//				.getLoginPostRestUrl(GlobalClass.getAppContext()) });

		Log.i(LOG_TAG, " Thanks so much ");

	}
	private class WebServiceTask extends AsyncTask<String, Integer, String> {

		public static final int POST_TASK = 1;
		public static final int GET_TASK = 2;

		private static final String TAG = "WebServiceTask";

		// connection timeout, in milliseconds (waiting to connect)
		private static final int CONN_TIMEOUT = 11000;

		// socket timeout, in milliseconds (waiting for data)
		private static final int SOCKET_TIMEOUT = 11000;

		private int taskType = GET_TASK;
		private Context mContext = null;
		private String processMessage = "Processing...";

		private ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();

		private ProgressDialog pDlg = null;

		public WebServiceTask(int taskType, Context mContext,
				String processMessage) {

			this.taskType = taskType;
			this.mContext = mContext;
			this.processMessage = processMessage;
		}

		public void addNameValuePair(String name, String value) {

			params.add(new BasicNameValuePair(name, value));
		}

		private void showProgressDialog() {

			pDlg = new ProgressDialog(mContext);
			pDlg.setMessage(processMessage);
			pDlg.setProgressDrawable(mContext.getWallpaper());
			pDlg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			pDlg.setCancelable(false);
			pDlg.show();

		}

		@Override
		protected void onPreExecute() {

			prgDialog.show() ;

		}

		protected String doInBackground(String... urls) {

			String url = urls[0];
			String result = "";

			HttpResponse response = doResponse(url);

			if (response == null) {
				return result;
			} else {

				try {

					result = inputStreamToString(response.getEntity()
							.getContent());

				} catch (IllegalStateException e) {
					Log.e(TAG, e.getLocalizedMessage(), e);

				} catch (IOException e) {
					Log.e(TAG, e.getLocalizedMessage(), e);
				}

			}

			return result;
		}

		@Override
		protected void onPostExecute(String response) {
//
//			handleResponse(response);
//	pDlg.dismiss();
			prgDialog.hide();
			if (response.equals("message sent")) {
				Toast.makeText(getApplicationContext(),
						" Successfully !", Toast.LENGTH_LONG).show();
//				Intent intent=new Intent(Login.this,Activites.class);
//				intent.putExtra("username",username.getText().toString() );
//				startActivity(intent);
				
			} else {
				Toast.makeText(getApplicationContext(), " Invalid username or pass !", Toast.LENGTH_LONG).show();
//				  attempts.setBackgroundColor(Color.RED);	
//			        counter--;
//			        attempts.setText(Integer.toString(counter));
//			        if(counter==0){
//			           login.setEnabled(false);
//			        }
				
				

			}

		}

		// Establish connection and socket (data retrieval) timeouts
		private HttpParams getHttpParams() {

			HttpParams htpp = new BasicHttpParams();

			HttpConnectionParams.setConnectionTimeout(htpp, CONN_TIMEOUT);
			HttpConnectionParams.setSoTimeout(htpp, SOCKET_TIMEOUT);

			return htpp;
		}

		private HttpResponse doResponse(String url) {

			// Use our connection and data timeouts as parameters for our
			// DefaultHttpClient
			HttpClient httpclient = new DefaultHttpClient(getHttpParams());

			HttpResponse response = null;

			try {
				switch (taskType) {

				case POST_TASK:
					HttpPost httppost = new HttpPost(url);
					// Add parameters
					httppost.setEntity(new UrlEncodedFormEntity(params));

					response = httpclient.execute(httppost);
					Log.i(LOG_TAG, " her is POST_TASK ");
					Log.i(LOG_TAG, " response is  "+response);
					break;
				case GET_TASK:
					HttpGet httpget = new HttpGet(url);
					response = httpclient.execute(httpget);
					Log.i(LOG_TAG, " her is GET_TASK ");
					break;
				}
			} catch (Exception e) {

				Log.e(TAG, e.getLocalizedMessage(), e);

			}
			Log.i(LOG_TAG, " her is response "+response);
			return response;
		}

		private String inputStreamToString(InputStream is) {

			String line = "";
			StringBuilder total = new StringBuilder();

			// Wrap a BufferedReader around the InputStream
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));

			try {
				// Read response until the end
				while ((line = rd.readLine()) != null) {
					total.append(line);
				}
			} catch (IOException e) {
				Log.e(TAG, e.getLocalizedMessage(), e);
			}
			Log.i(LOG_TAG, " her is total "+total.toString());
			// Return full string
			return total.toString();
		}

	}

}
