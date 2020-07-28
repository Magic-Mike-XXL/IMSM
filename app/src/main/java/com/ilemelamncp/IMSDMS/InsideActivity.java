package com.ilemelamncp.IMSDMS;

import android.content.*;
import android.os.*;
import android.support.v7.app.*;
import android.view.*;
import android.widget.*;

public class InsideActivity extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inside);
		Button PersonalInformation = findViewById(R.id.personal);
		PersonalInformation.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				startActivity(new Intent(InsideActivity.this, PersonalInformation.class));
			}
		});
		
		Button results = findViewById(R.id.staff);
		results.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v) {
					startActivity(new Intent(InsideActivity.this, ResultsActivity.class));
				}
			});
			
		Button finance = findViewById(R.id.finance);
		finance.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v) {
					startActivity(new Intent(InsideActivity.this, FinanceActivity.class));
				}
			});
			
		Button admin = findViewById(R.id.admin);
		admin.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v) {
					startActivity(new Intent(InsideActivity.this, AdminActivity.class));
				}
			});
			
		Button announce = findViewById(R.id.announce);
		announce.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v) {
					startActivity(new Intent(InsideActivity.this, AnnouncementActivity.class));
				}
			});
			
		Button statistics = findViewById(R.id.statistics);
		statistics.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v) {
					startActivity(new Intent(InsideActivity.this, StatisticsActivity.class));
				}
			});
	}
}
