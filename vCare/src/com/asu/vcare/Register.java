package com.asu.vcare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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
	Intent in = new Intent(Register.this, MainActivity.class);
	startActivity(in);
	}
};
}