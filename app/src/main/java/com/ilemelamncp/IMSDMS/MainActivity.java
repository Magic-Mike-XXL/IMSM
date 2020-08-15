package com.ilemelamncp.IMSDMS;

import android.content.*;
import android.os.*;
import android.support.v7.app.*;
import android.view.*;
import android.widget.*;
import android.view.View.*;

//Fix autologin

public class MainActivity extends AppCompatActivity
{
	private Button register, login;
	private EditText email, password;
	private Session session;
	
	@Override
	protected void onCreate(Bundle savedInstance)
	{
		super.onCreate(savedInstance);
		setContentView(R.layout.main);
		this.session = Session.getInstance(this);
		register = findViewById(R.id.registerButton);
		login = findViewById(R.id.login);
		email = findViewById(R.id.et_email);
		password = findViewById(R.id.et_password);
		if (session.isLoggedIn(email.getText().toString())) {
			startActivity(new Intent(MainActivity.this, InsideActivity.class));
			finish();
		}
		register.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View p1) {
					startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
					finish();
				}
		});
		login.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View p1) {
					if (infoIsValid()) {
						startActivity(new Intent(getApplicationContext(), InsideActivity.class));
						finish();
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
		if (!session.isRegisteredUser(emailString, pass)) {
			email.setError("Invalid Email or Password");
			return false;
		}
		return true;
	}
}
