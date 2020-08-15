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
	private final String TABLENAME = "users";
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
		db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLENAME + "(User_Name TEXT PRIMARY KEY, Email TEXT, Password TEXT);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLENAME + ";");
		onCreate(db);
	}
	
	public void addUser(UserModel model) {
		sqldatabase.execSQL("INSERT INTO " + TABLENAME + model.getTableValues() + " VALUES" + model.getInsertionValues(model)+ ";");
	}
	
	public boolean userExists(String email, String password) {
		Cursor cursor = sqldatabase.rawQuery("SELECT * FROM " + TABLENAME + " WHERE Email = '" + email + "' AND Password ='" + password + "';", null);
		boolean exists = false;
		while (cursor.moveToNext()) {
			exists = cursor.getString(cursor.getColumnIndex(EMAIL)).equalsIgnoreCase(email);
		}
		return exists;
	}
}
