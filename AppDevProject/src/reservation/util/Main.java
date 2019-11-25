package reservation.util;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class Main {
	/** The driver class for bus travel reservation system */

	// main method
	public static void main(String[] args) {

		// Create a Scanner object
		Scanner input = new Scanner(System.in);

		// Display Main menu
		displayMenu();

		// Initialize a variable to hold input value
		int value = 0;

		// Check validity of input before continuing the program
		while (value < 1 || value > 2) {
			try {
				value = readIntValue(); // Read integer value from standard input
			} catch (InputMismatchException in) {
				System.out.println("\nEnter integer value\n");
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}

		if (value == 1) {
			login(new Customer()); // Customer login
			System.out.println("Login Successful");
		} else
			register(new Customer()); // Customer registration

	}

	/** method displays Main menu */
	public static void displayMenu() {
		System.out.println("Main menu:\n1 --> Register\n2 --> Login\n");
	}

	/** method reads integer value from standard input */
	public static int readIntValue() throws Exception {
		// Create a Scanner object
		Scanner input = new Scanner(System.in);
		// Prompt the user for input
		System.out.println("Enter your choice (1 or 2): ");
		return input.nextInt();
	}

	/** method for Customer login */
	public static void login(Customer customer) {
		// Create a Scanner object
		Scanner input = new Scanner(System.in);
		// Prompt the user
		System.out.println("Enter username: ");
		String username = input.next();
		System.out.println("Enter password: ");
		String password = input.next();

		input.close(); // Close input to avoid error

		File file = new File("test.txt"); // Mock database of Customer data

		try {
			input = new Scanner(file); // Read from database
			while (input.hasNext()) {
				String user = input.next();
				String pass = input.next();
				if (username != user || password != pass)
					System.out.println("Invalid Username or Password: try again");
			}

			input.close(); // Close input to avoid error

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/** method for Customer registration */
	public static void register(Customer customer) {
		// Create a Scanner object
		Scanner input = new Scanner(System.in);
		// Prompt the user
		System.out.println("Enter First Name: ");//Added a first Name for data field
		String firstName = input.next();
		customer.setFirstName(firstName);
		System.out.println("Enter Last Name: ");//Added a last Name for data field
		String lastName = input.next();
		customer.setLastName(lastName);
		System.out.println("Enter username: ");
		String username = input.next();
		customer.setUserName(username);
		System.out.println("Enter password: ");
		String password = input.next();
		//Created Security Question
		System.out.println("Select a security question ");
		System.out.println("1. Favorite pets name? ");
		System.out.println("2. Where your mom from?  ");
		System.out.println("3. Where you where born? ");
		System.out.println("4. Your 2nd grade teacher ? ");
		System.out.println("Select a question by picking the number");
		int a = input.nextInt();
		if(a==1) {
			System.out.println("Enter the Answer");
			String answer =input.nextLine();
			customer.setPassword(password,"Favorite pets name?",answer);

		}
		if(a==2) {
			System.out.println("Enter the Answer");
			String answer =input.nextLine();
			customer.setPassword(password,"Where your mom is from?",answer);

		}
		if(a==3) {
			System.out.println("Enter the Answer");
			String answer =input.nextLine();
			customer.setPassword(password,"Where you where born?",answer);

		}
		if(a==4) {
			System.out.println("Enter the Answer");
			String answer =input.nextLine();
			customer.setPassword(password,"Your 2nd grade teacher?",answer);

		}

	
		input.close(); // Close input to avoid error

		File file = new File("test.txt"); // Mock database of Customer data

		try {
			PrintWriter output = new PrintWriter(file); // Write user input in database
			output.print(username + " ");
			output.print(password + " ");
			output.print(username + " ");
			output.print(password + " ");
			input.close(); // Close input to avoid error
			System.out.println("Your registration was successful");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
