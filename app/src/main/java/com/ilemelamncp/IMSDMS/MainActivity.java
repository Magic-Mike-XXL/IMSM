package com.ilemelamncp.IMSDMS;

import android.content.*;
import android.os.*;
import android.support.v7.app.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity
{
	private Button register, login;
	private EditText email, password;
	
	@Override
	protected void onCreate(Bundle savedInstance)
	{
		super.onCreate(savedInstance);
		setContentView(R.layout.main);
		register = findViewById(R.id.registerButton);
		login = findViewById(R.id.login);
		email = findViewById(R.id.et_email);
		password = findViewById(R.id.et_password);
		register.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View p1)
			{
				startActivity(new Intent(MainActivity.this, TrialActivity.class));
			}
		});
		login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view)
			{
				if (infoIsValid()) {
					startActivity(new Intent(MainActivity.this, InsideActivity.class));
				}
			}
		});
	}
	
	private boolean infoIsValid() {
		String emailString = email.getText().toString();
		String pass = password.getText().toString();
		if (emailString.isEmpty()) {
			email.setError("Email Cannot Be Empty");
			return false;
		}
		if (pass.isEmpty()) {
			password.setError("Password Cannot Be Empty");
			return false;
		}
		return true;
	}
}
