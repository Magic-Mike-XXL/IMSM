package com.ilemelamncp.IMSDMS;
import android.content.*;
import android.database.*;
import android.database.sqlite.*;
import java.sql.*;

public class Database extends SQLiteOpenHelper
{
	private static Database database;
	private SQLiteDatabase sqldatabase;
	private static final String DATABASENAME = "Users.db";
	private final String USERSTABLE = "users";
	private final String REPORTSTABLE = "reports";
	private final String USERNAME = "User_Name";
	private final String EMAIL = "Email";
	private final String PASSWORD = "Password";
	
	public static Database getInstance(Context context) {
		if (database == null) {
			database = new Database(context);
		}
		return database;
	}
	
	private Database(Context context) {
		super(context, DATABASENAME, null, 1);
		this.sqldatabase = this.getWritableDatabase();
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS " + USERSTABLE + "(User_Name TEXT PRIMARY KEY, Email TEXT, Password TEXT);");
		db.execSQL("CREATE TABLE IF NOT EXISTS " + REPORTSTABLE + "(TeacherName TEXT, SchoolName TEXT, WeeklyReport TEXT, ClassAttendance TEXT, TotalAbsent TEXT, AbsenteeNames TEXT)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + USERSTABLE + ";");
		db.execSQL("DROP TABLE IF EXISTS " + REPORTSTABLE + ";");
		onCreate(db);
	}
	
	public void addUser(UserModel model) {
		sqldatabase.execSQL("INSERT INTO " + USERSTABLE + model.getTableValues() + " VALUES" + model.getInsertionValues(model)+ ";");
	}
	
	public void addReport(ReportModel model) {
		sqldatabase.execSQL("INSERT INTO " + REPORTSTABLE + model.getTableValues() + " VALUES" + model.getInsertionValues(model)+ ";");
	}
	
	public boolean userExists(String email, String password) {
		Cursor cursor = sqldatabase.rawQuery("SELECT * FROM " + USERSTABLE + " WHERE Email = '" + email + "' AND Password ='" + password + "';", null);
		boolean exists = false;
		while (cursor.moveToNext()) {
			exists = cursor.getString(cursor.getColumnIndex(EMAIL)).equalsIgnoreCase(email);
		}
		return exists;
	}
}
