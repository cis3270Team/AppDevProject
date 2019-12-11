package reservation.util;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import reservation.data.Messenger;

public class Test {
	
	public static void main(String[] args) {
		
		//use this class to test other classes in this project
		
		
		// test registration
		String[] newUser = { "te", "test1", "Scot", "Will", "10102 Scot Rd", "Atlanta", "Georgia", "4",
				"scot@yahoo.com", "234567777", "Where were you born? ", "Nigeria" };

		String response = Menu.register(newUser);

		System.out.println(response);

		System.out.println(Check.getReservationCount());

		// test forgot password
		//String[] query = Menu.forgotPassword("te");
		//System.out.println(query[0]);

		String use = "ola";
		String pass = "ola123";
		
		//test forgot password
		String[] query1 = Menu.forgotPassword(use);
		if (query1.length != 3) {
			System.out.println("Invalid Username");
		}
		else 
			System.out.println(query1[2]);
		
		/**
		
		if (use.length() == 0) {
			
		}
		
		
		//test Login
		User user = null; // define a variable of User class to receive a user
		if (Check.isValidUser(use, pass)) {
			user = Menu.login(use, pass);
			System.out.println("Welcome " + user.getFirstName());
		}
		
		//Create a string to receive response from user's actions
		String response = "";
		
		// check if user is an admin
		if (Check.isValidUser(use, pass) && (user instanceof Admin)) {
			//display user first name
			System.out.println("Welcome " + user.getFirstName());
			
			// create departure date
			//LocalDateTime departureDate = LocalDateTime.of(2019,Month.DECEMBER,25,7,30);
			//String date = departureDate.format(
					//DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.MEDIUM));
			
			// create new reservation
			//user.makeNewReservation(1001, date, 2);
			//System.out.println(user.reservation.result);
			
			if (user instanceof Admin) {
				response = ((Admin)user).createBus(1006, "New York", "Dec 28, 2019, 7:00:00 AM",
														"Atlanta", 100);
			}
			
		}
		
		
		
		if (response.length() != 0) {
			System.out.println(response);
		}
		else
			System.out.println("Try again");
		
		//check if user is a Customer
		if (!(user instanceof Admin) && !(user instanceof Admin))
			System.out.println("invalid username");
		
		
		
		
		
		//test registration
		String[] newUser = {"te","test1","Scot","Will","10102 Scot Rd","Atlanta","Georgia","4",
				"scot@yahoo.com","234567777","Where were you born? ","Nigeria"};
		
		String response = Menu.register(newUser);
		
		System.out.println(response);
		
		System.out.println(Check.getReservationCount());
		
		
		
		//test forgot password
		String[] query = Menu.forgotPassword("te");
		System.out.println(query[0]);
		
		
		
		
		
		
		//tests if reservation exists
		
		// create departure date
		LocalDateTime departureDate = LocalDateTime.of(2019,Month.DECEMBER,25,7,30);
		String date = departureDate.format(
				DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.MEDIUM));
		
		System.out.println(Check.reservationExists(date, "ol"));
		
		
		*/
		
		
		/**
		
		//test bus creation
		Bus bus1 = new Bus(1004, "Atlanta", "Dec 27, 2019, 1:59:00 PM", "Sacramento", 100);
		if (bus1.result.isEmpty()) {
			System.out.println("Registration failed");
		}
		if (bus1.result.length() == 0) {
			System.out.println("Registration failed");
		}
		else {
			System.out.println(bus1.result);
		}
		
		*/
		
	}

}