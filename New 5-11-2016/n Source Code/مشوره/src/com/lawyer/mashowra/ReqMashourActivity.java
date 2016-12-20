package com.lawyer.mashowra;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class ReqMashourActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_req_mashour);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#070012")));
		
		ImageView pq=(ImageView)findViewById(R.id.pq);
		pq.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(ReqMashourActivity.this,ReqMashourModelActivity.class);
				i.putExtra("pq","قضيه عامه");
				startActivity(i);
				
			}
		});
		ImageView pq2=(ImageView)findViewById(R.id.pq2);
		pq2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(ReqMashourActivity.this,ReqMashourModelActivity.class);
				i.putExtra("pq","قضيه عامه");
				startActivity(i);
				
			}
		});
		
		ImageView gna2yaq=(ImageView)findViewById(R.id.gna2yaq);
		gna2yaq.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(ReqMashourActivity.this,ReqMashourModelActivity.class);
				i.putExtra("pq","قضيه جنائيه");
				startActivity(i);
				
			}
		});
		ImageView gna2yaq2=(ImageView)findViewById(R.id.gna2yaq2);
		gna2yaq2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(ReqMashourActivity.this,ReqMashourModelActivity.class);
				i.putExtra("pq","قضيه جنائيه");
				startActivity(i);
				
			}
		});
		
		
		
		
		ImageView comicialq=(ImageView)findViewById(R.id.comicialq);
		comicialq.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(ReqMashourActivity.this,ReqMashourModelActivity.class);
				i.putExtra("pq","قضيه تجاريه");
				startActivity(i);
				
			}
		});
		ImageView comicialq2=(ImageView)findViewById(R.id.comicialq2);
		comicialq2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(ReqMashourActivity.this,ReqMashourModelActivity.class);
				i.putExtra("pq","قضيه تجاريه");
				startActivity(i);
				
			}
		});

		
		
		
		ImageView q2darya=(ImageView)findViewById(R.id.q2darya);
		q2darya.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(ReqMashourActivity.this,ReqMashourModelActivity.class);
				i.putExtra("pq","قضيه اداريه");
				startActivity(i);
				
			}
		});
		ImageView q2darya2=(ImageView)findViewById(R.id.q2darya2);
		q2darya2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(ReqMashourActivity.this,ReqMashourModelActivity.class);
				i.putExtra("pq","قضيه اداريه");
				startActivity(i);
				
			}
		});

		
		
		
		ImageView personal=(ImageView)findViewById(R.id.personal);
		personal.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(ReqMashourActivity.this,ReqMashourModelActivity.class);
				i.putExtra("pq","احوال شحصيه");
				startActivity(i);
				
			}
		});
		ImageView personal2=(ImageView)findViewById(R.id.personal2);
		personal2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(ReqMashourActivity.this,ReqMashourModelActivity.class);
				i.putExtra("pq","احوال شحصيه");
				startActivity(i);
				
			}
		});

		
		
		
		ImageView globalq=(ImageView)findViewById(R.id.globalq);
		globalq.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(ReqMashourActivity.this,ReqMashourModelActivity.class);
				i.putExtra("pq","قضيه عماليه");
				startActivity(i);
				
			}
		});
		ImageView globalq2=(ImageView)findViewById(R.id.globalq2);
		globalq2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(ReqMashourActivity.this,ReqMashourModelActivity.class);
				i.putExtra("pq","قضيه عماليه");
				startActivity(i);
				
			}
		});

		
		
		
		ImageView tanfyz=(ImageView)findViewById(R.id.tanfyz);
		tanfyz.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(ReqMashourActivity.this,ReqMashourModelActivity.class);
				i.putExtra("pq","تنفيذ");
				startActivity(i);
				
			}
		});
		ImageView tanfyz2=(ImageView)findViewById(R.id.tanfyz2);
		tanfyz2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(ReqMashourActivity.this,ReqMashourModelActivity.class);
				i.putExtra("pq","تنفيذ");
				startActivity(i);
				
			}
		});

		
		
		
		ImageView tarekat=(ImageView)findViewById(R.id.tarekat);
		tarekat.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(ReqMashourActivity.this,ReqMashourModelActivity.class);
				i.putExtra("pq","تركات");
				startActivity(i);
				
			}
		});
		ImageView tarekat2=(ImageView)findViewById(R.id.tarekat2);
		tarekat2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(ReqMashourActivity.this,ReqMashourModelActivity.class);
				i.putExtra("pq","تركات");
				startActivity(i);
				
			}
		});

		
		
		
		ImageView awqaf=(ImageView)findViewById(R.id.awqaf);
		awqaf.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(ReqMashourActivity.this,ReqMashourModelActivity.class);
				i.putExtra("pq","أوقاف");
				startActivity(i);
				
			}
		});
		ImageView awqaf2=(ImageView)findViewById(R.id.awqaf2);
		awqaf2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(ReqMashourActivity.this,ReqMashourModelActivity.class);
				i.putExtra("pq","أوقاف");
				startActivity(i);
				
			}
		});

		
		
		
		ImageView gm3iat=(ImageView)findViewById(R.id.gm3iat);
		gm3iat.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(ReqMashourActivity.this,ReqMashourModelActivity.class);
				i.putExtra("pq","الجمعيات والمؤسسات الاهليه");
				startActivity(i);
				
			}
		});
		ImageView gm3iat2=(ImageView)findViewById(R.id.gm3iat2);
		gm3iat2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(ReqMashourActivity.this,ReqMashourModelActivity.class);
				i.putExtra("pq","الجمعيات والمؤسسات الاهليه");
				startActivity(i);
				
			}
		});

		
		
		
		ImageView other=(ImageView)findViewById(R.id.other);
		other.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(ReqMashourActivity.this,ReqMashourModelActivity.class);
				i.putExtra("pq","other");
				startActivity(i);
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main1, menu);
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
	        	Intent i=new Intent(ReqMashourActivity.this,MainActivity.class);
	        	startActivity(i);
	            return true;
	           
	        case R.id.back:
	            //NavUtils.navigateUpFromSameTask(this);
	        	Intent ia=new Intent(ReqMashourActivity.this,MainActivity.class);
	        	startActivity(ia);
	            return true;
	            
	        default:
	            return super.onOptionsItemSelected(item);
	        }
	}
}
