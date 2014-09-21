package com.asu.vcare;

import com.asu.models.User;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends Activity{
	
		private EditText txtName,txtMobNumber,txtEmail,txtZip; 
		private Button btnReg;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_register);
			ActionBar actionBar = getActionBar();
			actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.banner));
			actionBar.setDisplayShowTitleEnabled(false);
			actionBar.setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));

			txtName = (EditText) findViewById(R.id.fname);
			txtMobNumber = (EditText) findViewById(R.id.phone);
			txtEmail = (EditText) findViewById(R.id.email);
			txtZip = (EditText) findViewById(R.id.zip);
			btnReg = (Button) findViewById(R.id.btnReg);
			btnReg.setOnClickListener(Register);
			
		}
		
	
View.OnClickListener Register = new View.OnClickListener() {
	@Override
	public void onClick(View v) {
		String name=txtName.getText().toString();
		name=(name==null)?" John":name;
		System.out.println(name);
		String mobNumber = txtMobNumber.getText().toString();
		mobNumber=(mobNumber==null)?"1":mobNumber;
		String email = txtEmail.getText().toString();
		email=(email==null)?"john@asu.edu":email;
		String zip = txtZip.getText().toString();
		zip=(zip==null)?"85281":zip;
		
		User user = new User();
		user.setName(name);
		user.setMobileNumber(mobNumber);
		user.setBadgeCompassion(0);
		user.setBadgeKindness(0);
		user.setBadgeRespect(0);
		user.setBadgeSelfReflection(0);
		user.setEmailID(email);
		user.setZipCode(zip);
		
		
		
		Intent in = new Intent(Register.this, CreateOrganization.class);
		startActivity(in);
	}
};
}
