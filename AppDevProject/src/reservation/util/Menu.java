package reservation.util;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class Menu {
	/** The driver class for bus travel reservation system */

	// main method
	public static void main(String[] args) {

		// Display Main menu
		displayMenu();

		// Read user input
		int inputValue = readInput(2);

		// Perform user registration or login based on input value
		if (inputValue == 1) {
			try {
				Customer user = register(); // Customer registration
				System.out.println("Your registration was successful");
			}
			catch (Exception e) {// Display error message if registration is not successful
				System.out.println("Registration is incomplete. NO SPACES before and after input. Thanks.");
				System.out.println(e.getMessage());
			}
		} 
		
		else {
			try{
				Customer user = login();// Customer login
				System.out.println("Login successful");
				System.out.println("Welcome, " + user.getFirstName()); // Greet the user
			}
			catch (Exception e) {// Display error message if login is not successful
				System.out.println(e.getMessage());
			}
		}
		
		// User can now book trip (Work in progress)
		
	//END OF MAIN METHOD
	}
	
	/** method reads user input (integer value) */
	public static int readInput(int maxValue) {
		// Create a Scanner object
		Scanner input = new Scanner(System.in);
		
		// Initialize a variable to hold input value
		int inputValue = 0;

		// Check validity of input before continuing the program
		while (inputValue < 1 || inputValue > maxValue) {
			System.out.print("Enter your choice: ");
			String value = input.next(); // Read value from standard input
			if (!Character.isDigit(value.charAt(0))) // Check if value is digit
				System.out.println("Enter integer value");
			else if (value.length() == 1 && Character.isDigit(value.charAt(0))) // Validate value
				inputValue = Integer.parseInt(value); // convert input value to an integer
		}
		
		return inputValue;
		
	}

	/** method displays Main menu */
	public static void displayMenu() {
		System.out.println("Main menu:\n1 --> Register\n2 --> Login\n");
	}

	/** method for Customer login */
	public static Customer login() throws Exception {
		// Create a Scanner object
		Scanner systemInput = new Scanner(System.in);
		// Prompt the user
		System.out.print("Username: ");
		String username = systemInput.next();// Read username
		System.out.print("Password: ");
		String password = systemInput.next();// Read user's password

		File file = new File("test.txt"); // Mock database for Customer data
		
		// Create an array to store customer details
		String[] customerDetails = null; //To store retrieved customer login information from database
		String user = "", pass = ""; //To store username and password when retrieved

		try {
			Scanner input = new Scanner(file); // Read user information from database
			while (input.hasNext()) {
				customerDetails = (input.nextLine()).split(",");// Array of customer information
				if (customerDetails.length != 0) {
					user = customerDetails[customerDetails.length-2];// Get username from array
					pass = customerDetails[customerDetails.length-1];// Get password from array
				}
				// Display error message for wrong username or password
				if (!(username.equals(user)) || !(password.equals(pass))) {
					System.out.printf("\nInvalid %s: ",(username.equals(user)?"Password":"Username"));
					throw new Exception("Login failed! ");
				}
			}

			input.close(); // Close input

		} 
		
		catch (Exception e) {
			throw e; //For failed login, throw an exception to the caller
		}
		
		if (customerDetails.length != 10) {//For database error, throw an exception to the caller
			throw new Exception("Error reading file");
		}
		
		else
			// Return the customer's information to the caller
			return new Customer(customerDetails[0],customerDetails[1],customerDetails[2],
								customerDetails[3],customerDetails[4],customerDetails[5],
					customerDetails[6],customerDetails[7],customerDetails[8],customerDetails[9]);
		
	}

	/** method for Customer registration */
	public static Customer register() throws Exception {
		
		/*********************************************************************
		 *  Registration requires information such as first name, last name, * 
		 *  address, zip, state, username, password, email, SSN,             *
		 *  and a security question for password recovery                    *
		 * *******************************************************************/
		
		// Create a Scanner object
		Scanner input = new Scanner(System.in);
		
		// Prompt the user for registration information
		System.out.print("First Name: ");
		String[] name = input.nextLine().split("[ ]");// Read first Name for Customer data field
		// The first character in a customer's first name should be upper case
		// Convert possible lower case input to upper case
		String firstName = name[0].replace(name[0].charAt(0), Character.toUpperCase(name[0].charAt(0)));
		
		System.out.print("Last Name: ");
		name = input.nextLine().split("[ ]");// reads last Name for Customer data field
		// The first character in a customer's last name should be upper case
		// Convert possible lower case input to upper case
		String lastName = name[0].replace(name[0].charAt(0), Character.toUpperCase(name[0].charAt(0)));
		
		System.out.print("Street Address: ");
		String address = input.nextLine();// Read address for Customer data field
		System.out.print("City: ");
		String city = input.nextLine();// Read city for Customer data field
		System.out.print("State: ");
		/** state should be matched with database for correct input */
		String state = input.nextLine(); // Read state for Customer data field
		
		String zipCode = "";// stores the value of zip code for Customer data field
		
		// While ZIP code's length is less than or greater than five and it is not digits,
		// keep prompting the user for valid ZIP code
		while ((zipCode.length() < 5 || zipCode.length() > 5) && (!zipCode.matches("\\d{5}"))) {
			System.out.print("ZIP Code: ");
			zipCode = input.nextLine(); // Read ZIP Code for Customer data field
			// Display error message if ZIP code is not valid
			if ((zipCode.length() < 5 || zipCode.length() > 5) && (!zipCode.matches("\\d{5}"))) {
				System.out.println("Invalid ZIP code! Enter 5 digits U.S. postal code");
			}
			// Continue the loop until user enters valid ZIP code
		}
		
		String email = ""; //stores email for Customer data field
		do {
			System.out.print("Email address: ");
			/** email should be matched with database to avoid duplication and ensure unique identity */
			email = input.nextLine(); // Read email for Customer data field
		}while(!(email.contains("@") && email.contains(".com"))); //ensures that email is valid
		
		// Continue to prompt the user for registration information
		System.out.print("Social Security Number: ");
		String ssn = input.nextLine(); //reads SSN for Customer data field
		//Check if the SSN is valid. If not, prompt the user to enter valid SSN
		while(!ssn.matches("\\d{9}")) {//ensures that SSN is valid
			System.out.println("Enter 9 digits SSN: ");//prompt the user to enter valid SSN
			ssn = input.nextLine(); //read SSN for Customer data field
		}
		
		// Continue to prompt the user for registration information
		System.out.print("Username: ");
		/** user name should be matched with database to avoid duplication and ensure unique identity */
		String username = input.nextLine(); //read username for Customer data field
		System.out.print("Password: ");
		String password = input.nextLine();//read password for Customer data field
		
		// Create a new Customer
		Customer newCustomer = new Customer(firstName, lastName, address, city, state, zipCode,
				email, ssn, username, password);
		
		// display security questions and prompt the user for response
		int response = 0;//stores the corresponding integer value of security question
		while (response < 1 || response > 4) {
			newCustomer.printSecurityQuestions();//Display all the security questions
			// Prompt the user for response
			System.out.println("\nSelect a question by picking the corresponding number");
			response = readInput(4);// read response
		}
		
		// Set password security question for this new user
		newCustomer.setPasswordSecurityQuestion((response-1));
		
		// Display the user's choice of security question
		newCustomer.printSecurityQuestion((response-1));
		
		// Read and set security answer for this new user
		newCustomer.setSecurityAnswer(input.nextLine());
		
		// Insert (store) newCustomer's information in database
		File file = new File("test.txt"); // Mock database of Customer data
		
		// Format customer details as comma separated values (CSV)
		String customerDetails = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n", firstName, lastName,
				address, city, state, zipCode, email, ssn, username, password);

		try {
			PrintWriter output = new PrintWriter(file); // Create a PrintWriter object
			output.write(customerDetails);// Write user input in database
			output.close(); // Close standard output

		} 
		
		catch (Exception e) {
			System.out.println("Registration is incomplete");
			throw e;
		}
		
		return newCustomer;
		
	}

}
