package com.ilemelamncp.IMSDMS;

import android.os.*;
import android.support.v7.app.*;
import android.widget.*;

public class TrialActivity extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		setContentView(R.layout.trial);
		EditText inputName = findViewById(R.id.et_name);
		EditText inputEmail = findViewById(R.id.et_email);
	}
}
