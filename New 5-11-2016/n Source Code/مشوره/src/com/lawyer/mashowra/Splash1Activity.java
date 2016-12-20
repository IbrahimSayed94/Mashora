package com.lawyer.mashowra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;


public class Splash1Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash1);

        
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
				.getBoolean("isfirstrun", true);

		if (isFirstRun) {
			// do some thing
			//Toast.makeText(MainActivity.this, "First Run", Toast.LENGTH_LONG)
			//		.show();

			getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
					.putBoolean("isfirstrun", false).commit();
			 new Handler().postDelayed(new Runnable(){
		            @Override
		            public void run() {
		                /* Create an Intent that will start the Menu-Activity. */
		                Intent mainIntent = new Intent(Splash1Activity.this,Splash2Activity.class);
		                Splash1Activity.this.startActivity(mainIntent);
		                Splash1Activity.this.finish();
		            }
		        }, 2000);
		}
		else{
			 new Handler().postDelayed(new Runnable(){
		            @Override
		            public void run() {
		                /* Create an Intent that will start the Menu-Activity. */
		                Intent mainIntent = new Intent(Splash1Activity.this,MainActivity.class);
		                Splash1Activity.this.startActivity(mainIntent);
		                Splash1Activity.this.finish();
		            }
		        }, 2000);
		}
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.splash1, menu);
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
