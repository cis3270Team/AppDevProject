package reservation.util;

import java.sql.SQLException;

import reservation.data.Messenger;

public class Check {
	
	private Check() {
		
	}
	
	/** method returns true if this user is valid */
	public static boolean isValidUser(String username, String password) {
		// Get user information from the database
		String[] result;// A string array to store user information when retrieved from database
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
	
	// returns the last reservationCount
	public static int getReservationCount() {
		int result = 0;
		
		try {
			result = Messenger.getReservationCount();
		}
		catch (SQLException s) {
			
		}
		catch (Exception e) {
			
		}
		
		return result;
	}
	
	// returns the last reservationCount
	public static void setReservationCount(int resCount) {

		try {
			Messenger.setReservationCount(resCount);
		} catch (SQLException s) {

		} catch (Exception e) {

		}

		System.out.println("Success!");
	}
	
	// returns true if reservation exists
	public static boolean reservationExists(String departureDate, String username) {
		String[] result = null; // A string array to store user information when retrieved from database
		try {
			result = Messenger.getReservation(departureDate, username);
		}
		
		catch (SQLException sql) {
			return true;
		}
		catch (Exception e) {
			return true;
		}
		
		if (result.equals(null) || result[0] == null) {
			return false;
		}
		else
			return true;
		
	}

}
