package com.ilemelamncp.IMSDMS;

import android.content.*;

public class Session  
{

	private static Session session;
	private SharedPreferences preferences;
	private Database database;

	public static Session getInstance(Context context) {
		if (session == null)
		{
			session = new Session(context);
		}
		return session;
	}

	private Session(Context context) {
		this.database = Database.getInstance(context);
		this.preferences = context.getSharedPreferences(Values.PREFSNAME, 0);
	}

	public SharedPreferences getSharedPreferences() {
		return preferences;
	}

	public void addUser(UserModel model) {
		database.addUser(model);
	}
	
	public void addReport(ReportModel model) {
		database.addReport(model);
	}

	public boolean isLoggedIn(String username) {
		return username.equalsIgnoreCase(Values.REGISTEREDEMAIL) && preferences.getBoolean(Values.ISREGISTERED, true);
	}

	public boolean isRegisteredUser(String userName, String password) {
		return database.userExists(userName, password);
	}
}
