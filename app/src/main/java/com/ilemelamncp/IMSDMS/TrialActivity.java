package com.ilemelamncp.IMSDMS;

import android.content.*;
import android.os.*;
import android.support.v7.app.*;
import android.view.*;
import android.widget.*;

public class TrialActivity extends AppCompatActivity
{
	
	private EditText inputName, inputEmail, inputPass, inputRepass;
	
	@Override
	protected void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		setContentView(R.layout.trial);
		inputName = findViewById(R.id.et_name);
		inputEmail = findViewById(R.id.et_email);
		inputPass = findViewById(R.id.et_password);
		inputRepass = findViewById(R.id.et_repassword);
		Button register = findViewById(R.id.btn_register);
		register.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View p1)
				{
					if (infoIsValid()) {
						SharedPreferences prefs = getSharedPreferences(Values.PREFSNAME, 0);
						prefs.edit().putBoolean(Values.ISREGISTERED, true);
						prefs.edit().putString(Values.REGISTEREDEMAIL, inputEmail.getText().toString());
						startActivity(new Intent(TrialActivity.this, MainActivity.class));
					}
				}
		});
	}
	
	private boolean infoIsValid() {
		String name = inputName.getText().toString();
		String email = inputEmail.getText().toString();
		String password = inputPass.getText().toString();
		String repass = inputRepass.getText().toString();
		if (name.isEmpty()) {
			inputName.setError("Name Cannot Be Empty");
			return false;
		}
		if (email.isEmpty()) {
			inputEmail.setError("Email Cannot Be Empty");
			return false;
		}
		if (password.isEmpty()) {
			inputPass.setError("Password Cannot Be Empty");
			return false;
		}
		if (repass.isEmpty()) {
			inputRepass.setError("Password Cannot Be Empty");
			return false;
		}
		if (!inputRepass.equals(password)) {
			inputRepass.setError("Passwords Do Not Match");
			return false;
		}
		return true;
	}
}
