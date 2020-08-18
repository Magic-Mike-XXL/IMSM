package com.ilemelamncp.IMSDMS;

import android.*;
import android.content.*;
import android.os.*;
import android.support.v7.app.*;
import android.view.*;
import android.widget.*;

public class RegisterActivity extends AppCompatActivity
{
	
	private EditText inputName, inputEmail, inputPass, inputRepass;
	private Session session;
	
	@Override
	protected void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		setContentView(R.layout.register);
		this.session = Session.getInstance(this);
		inputName = findViewById(R.id.et_name);
		inputEmail = findViewById(R.id.et_email);
		inputPass = findViewById(R.id.et_password);
		inputRepass = findViewById(R.id.et_repassword);
		Button register = findViewById(R.id.btn_register);
		register.setOnClickListener(new RegisterListener());
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
		if (!repass.equalsIgnoreCase((password))) {
			inputRepass.setError("Passwords Do Not Match");
			return false;
		}
		return true;
	}
	
	private class RegisterListener implements View.OnClickListener {

		@Override
		public void onClick(View p1) {
			if (infoIsValid()) {
				UserModel model = new UserModel();
				model.setUserName(inputName.getText().toString());
				model.setEmail(inputEmail.getText().toString());
				model.setPassword(inputPass.getText().toString());
				session.addUser(model);
				startActivity(new Intent(RegisterActivity.this, MainActivity.class));
				finish();
			}
		}
	}
}
