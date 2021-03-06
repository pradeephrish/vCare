package com.asu.vcare;



import com.asu.dao.DAOManager;
import com.asu.dao.LoginAsyncTask;
import com.asu.models.User;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends ActionBarActivity {
	private EditText txtMobile; 
	private Button btnLogin, btnRegister;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.loginTheme);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.banner));
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
		txtMobile = (EditText) findViewById(R.id.txtMobileNo);
		btnLogin = (Button) findViewById(R.id.btnLogin);
		btnLogin.setOnClickListener(login);
		
		btnRegister = (Button)findViewById(R.id.btnRegister);
		btnRegister.setOnClickListener(register);
		
		
		/*User user = new User();
		user.setBadgeCompassion(0);
		user.setBadgeKindness(0);
		user.setBadgeRespect(0);
		user.setBadgeSelfReflection(0);
		user.setEmailID("a@a.com");
		user.setMobileNumber("0");
		user.setName("Jon");
		user.setZipCode("85281");
		new DAOManager().registerUser(user);*/
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
		return super.onOptionsItemSelected(item);
	}
	
	View.OnClickListener login = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			/*Intent i = new Intent(LoginActivity.this, MainActivity.class);
			startActivity(i);*/
			String loginID = txtMobile.getText().toString();
			if(loginID!=null && loginID.length()>0){
				String inputs[] = {loginID};
				new LoginAsyncTask(LoginActivity.this).execute(inputs);
			}else{
				/*try {
					//Utils.showDialog("Invalid User !", getApplicationContext());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
		}
	};
	
	View.OnClickListener register = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent i = new Intent(LoginActivity.this, Register.class);
			startActivity(i);
		}
	};
}
