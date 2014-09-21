package com.asu.vcare;

import com.parse.Parse;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class SplashActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.splashTheme);
		Parse.initialize(this, "e0O1wPBh8qdsw5KhWhv5Xyc7D5gpv7gq9mGYosLh", "y8hOkkC4SfAegYxKMSN7eaZdHCNrYi1oW3rB2OY8"); 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		Thread loadingThread = new Thread(){
            @Override
            public void run(){
                try{
                    super.run();
                    sleep(5000);
                }catch(Exception e){

                }finally {

                    Intent i = new Intent(SplashActivity.this,
                    		LoginActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        loadingThread.start();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
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
