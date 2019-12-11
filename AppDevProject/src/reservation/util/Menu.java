package reservation.util;

import java.sql.SQLException;

import reservation.data.Messenger;

public interface Menu {
	
	/** abstract method makes new reservation for this user */
	public abstract void makeNewReservation(int busNumber,String departureDate,int ticketNumber);
	
	/** method for User login */
	public static User login(String username, String password) {
		// Get user information from the database
		String[] result = null; // Create a string array to store data
		try {
			result = Messenger.getUser(username, password); // query the database
		}
		catch (SQLException sql) {
			System.out.println(sql.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
		
			if (result[2].matches("Admin")) {//Check if this user is an administrator
				return new Admin(result[0], result[1], result[2], result[3], result[4], result[5], result[6],
					result[7], result[8], result[9], result[10], result[11], result[12]);
			}
			else //else log in as a Customer
				return new Customer(result[0], result[1], result[2], result[3], result[4], result[5], result[6],
					result[7], result[8], result[9], result[10], result[11], result[12]);
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Invalid user");
		}
		
		return new Customer();
		
	}

	/** method for User registration */
	public static String register(String[] newUser) {
		
		for (int i = 0; i < newUser.length; i++) {
			if (newUser[i] == null)
				return "Invalid Input";
		}
		
		// Check the parameter for complete registration information and valid Username
		if (newUser.length != 12) {
			return "Your registration information is incomplete";
		}
		// user name should be matched with database to avoid duplication and ensure unique identity
		else if (Check.usernameExists(newUser[0])) {
			return "Username exists";
		}
		
		// Convert zipCode to int
		int zipCode = 0;
		try {
			zipCode = Integer.parseInt(newUser[7]);
		}
		catch (NumberFormatException n) {
			return "Invalid zip code";
		}
		catch (Exception e) {
			return "Invalid zip code";
		}
		
		// check zip code validity
		String city;
		try {
			city = Messenger.getCity(zipCode).toUpperCase();
			if (city.length() == 0) {
				return "Invalid zip code";
			}
		}
		catch (SQLException sql) {
			sql.getMessage();
			return "Registration failure";
		}
		
		// Register new user
		String username = newUser[0], password = newUser[1],firstName = newUser[2].toUpperCase(), 
				lastName = newUser[3].toUpperCase(), address = newUser[4].toUpperCase(), 
				state = newUser[6].toUpperCase(), email = newUser[8], ssn = newUser[9], 
				securityQuestion = newUser[10], securityAnswer = newUser[11];
		
		//ensures that email is valid
		if (!(email.contains("@") && email.contains(".com"))) {
			return "Invalid email";
		}
		
		String userType = "";
		if (email.contains("@yorla.com")) { //if the user email contains "@yorla.com", register as an admin
			userType = "Admin";
		}
		else {
			userType = "Customer";
		}
		
		//Check if the SSN is valid. If not, prompt the user to enter valid SSN
		if (!ssn.matches("\\d{9}")) {//ensures that SSN is valid
			return "Enter 9 digits SSN";//prompt the user to enter valid SSN
		}
		
		String zip = zipCode +"";
	
		// Create a new User
		try {
			Messenger.createUser(username, password,userType,firstName,lastName,address,city,state,zip,
					email,ssn,securityQuestion,securityAnswer);
		}
		
		catch (SQLException sql) {
			sql.getMessage();
			return "Registration failure";
		}
		
		return "Your registration is successful";
		
	}
	
	/** method returns password */
	public static String[] forgotPassword(String username) {
		String[] query = null; String[] result = new String[3];
		// Check if username exists
		if (Check.usernameExists(username)) {
			try {
				query = Messenger.getUser(username);
			}
			catch (SQLException sql) {
				result[0] = sql.getMessage();
			}
			
			result[0] = query[11];
			result[1] = query[12];
			result[2] = query[1];
			
		}
		else {
			result[0] = "Username does not exist in database";
		}
		
		return result;
		
	}	

}