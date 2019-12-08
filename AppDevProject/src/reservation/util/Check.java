package reservation.util;

import java.sql.SQLException;

import reservation.data.Messenger;

public class Check {
	
	private Check() {
		
	}
	
	/** method returns true if this user is valid */
	public static boolean isValidUser(String username, String password) {
		// Get user information from the database
		String[] result;
		try {
			result = Messenger.getUser(username, password);
		}
		catch (SQLException sql) {
			System.out.println(sql.getMessage());
			return false;
		}
		
		if (result[0] == null) {
			return false;
		}
		else
			return true;
		
	}
	
	/** method returns true if username exists */
	public static boolean usernameExists(String username) {
		// Check if username exists in the database
		String result;
		try {
			result = Messenger.getUsername(username);
		} catch (SQLException sql) {
			System.out.println(sql.getMessage());
			return false;
		}

		if (result.length() == 0) {
			return false;
		} else
			return true;
				
	}
	
}
