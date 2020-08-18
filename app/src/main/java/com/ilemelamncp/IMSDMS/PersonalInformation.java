package com.ilemelamncp.IMSDMS;

import android.content.*;
import android.os.*;
import android.support.v7.app.*;
import android.view.*;
import android.widget.*;

public class PersonalInformation extends AppCompatActivity
{
	private EditText teacherName, schoolName, weeklyReport, classAttend, totalAbsent, absenteeNames;
	private Button submit;
	private Session session;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.personalinformation);
		session = Session.getInstance(this);
		teacherName = findViewById(R.id.et_name);
		schoolName = findViewById(R.id.school);
		weeklyReport = findViewById(R.id.daily);
		classAttend = findViewById(R.id.atend);
		totalAbsent = findViewById(R.id.absent);
		absenteeNames = findViewById(R.id.names);
		submit = findViewById(R.id.submitButton);
		submit.setOnClickListener(new SubmitListener());
	}
	
	private class SubmitListener implements View.OnClickListener {

		@Override
		public void onClick(View p1) {
			if (infoNotEmpty()) {
				String teacher = teacherName.getText().toString();
				String school = schoolName.getText().toString();
				String weekly = weeklyReport.getText().toString();
				String attend = classAttend.getText().toString();
				String total = totalAbsent.getText().toString();
				String names = absenteeNames.getText().toString();
				ReportModel model = new ReportModel();
				model.setTeacherName(teacher);
				model.setSchoolName(school);
				model.setWeeklyReport(weekly);
				model.setClassAttendance(attend);
				model.setTotalAbsent(total);
				model.setAbsenteeNames(names);
				session.addReport(model);
				startActivity(new Intent(PersonalInformation.this, InsideActivity.class));
				finish();
			}
		}
		
		private boolean infoNotEmpty() {
			String teacher = teacherName.getText().toString();
			String school = schoolName.getText().toString();
			String weekly = weeklyReport.getText().toString();
			String attend = classAttend.getText().toString();
			String total = totalAbsent.getText().toString();
			String names = absenteeNames.getText().toString();
			if (teacher.isEmpty()) {
				teacherName.setError("Required");
				return false;
			}
			if (school.isEmpty()) {
				schoolName.setError("Required");
				return false;
			}
			if (weekly.isEmpty()) {
				weeklyReport.setError("Required");
				return false;
			}
			if (attend.isEmpty()) {
				classAttend.setError("Required");
				return false;
			}
			if (total.isEmpty()) {
				totalAbsent.setError("Required");
				return false;
			}
			if (names.isEmpty()) {
				absenteeNames.setError("Required");
				return false;
			}
			return true;
		}
	}
}
