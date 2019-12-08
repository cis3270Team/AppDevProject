package reservation.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Messenger {
	// Data Field
	private Connection connection;
	
	private Messenger() {
		
	}
	
	public static void main(String[] args) {
	/*	
		try {
			String zipcode = 30349 +"";
			String city = Messenger.getCity(Integer.parseInt(zipcode));
			if (city.length()< 1) {
				System.out.println("Invalid zip code");
			}
			else {
				System.out.println(city);
				String[] user = getUser("obakare", "ola123");
				if (user.length != 0) {
					for (String use: user) {
						System.out.println(use + " ");
					}
				}
			}
			LocalDateTime departureDate = LocalDateTime.of(2019,Month.DECEMBER,25,7,30);
			String date = departureDate.format(
					DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.MEDIUM));
			createBus(1001, "Atlanta", date,"Alabama", 100, 0);
			
		}
		catch (SQLException sql) {
			System.out.println(sql.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		*/
		
		/*
		
		String[][] test = new String[2][2];
		for (String[] r: test)
			for (String q: r)
				System.out.println("");
		
		String[] result;
		
		try {
			result = getBus("Atlanta");
			if (result.length == 0) {
				System.out.println("No match");
			}
			else {
				for (String r: result)
					System.out.print(r + " | ");
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		*/
		
		try {
			String[] user = getReservation(1001);
			
			if (user[0] == null) {
				System.out.println("Invalid username or password");
			}
			else {
				for (int i = 0; i < user.length; ++i) {
					System.out.println(user[i]);
				}
			}
			
		}
		catch (SQLException sql) {
			System.out.println(sql.getMessage());
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	// Method returns ZipCode from the database
	public static String getCity(int zipCode) throws SQLException {

		Messenger c = new Messenger();

		c.connection = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "cis3270", "project");

		String city = "";
		String query = "select city from Zip where zipCode = ?";
		PreparedStatement statement = c.connection.prepareStatement(query);
		statement.setInt(1, zipCode);
		ResultSet result = statement.executeQuery();

		if (result.next()) {
			city = result.getString(1);
		}

		c.connection.close();

		return city;
	}
	
	public static String createUser(String username, String password, String userType, String firstName,
			String lastName, String address, String city, String state, String zipCode, String email,
			String ssn, String securityQuestion, String securityAnswer) throws SQLException {

		Messenger c = new Messenger();

		c.connection = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "cis3270", "project");

		String query = "insert into User values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = c.connection.prepareStatement(query);
		statement.setString(1, username);
		statement.setString(2, password);
		statement.setString(3, userType);
		statement.setString(4, firstName);
		statement.setString(5, lastName);
		statement.setString(6, address);
		statement.setString(7, city);
		statement.setString(8, state);
		statement.setString(9, zipCode);
		statement.setString(10, email);
		statement.setString(11, ssn);
		statement.setString(12, securityQuestion);
		statement.setString(13, securityAnswer);

		statement.executeUpdate();

		c.connection.close();

		return "Account created successfully";

	}
	
	/** method returns user information from the database */
	public static String[] getUser(String username) throws SQLException {

		Messenger c = new Messenger();

		c.connection = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "cis3270", "project");
		String[] user = new String[13];

		String query = "Select * from User where username=?";

		PreparedStatement statement = c.connection.prepareStatement(query);

		statement.setString(1, username);

		ResultSet result = statement.executeQuery();

		if (result.next()) {
			user[0] = result.getString(1);
			user[1] = result.getString(2);
			user[2] = result.getString(3);
			user[3] = result.getString(4);
			user[4] = result.getString(5);
			user[5] = result.getString(6);
			user[6] = result.getString(7);
			user[7] = result.getString(8);
			user[8] = result.getString(9);
			user[9] = result.getString(10);
			user[10] = result.getString(11);
			user[11] = result.getString(12);
			user[12] = result.getString(13);
		}

		c.connection.close();

		return user;

	}
	/** Overloaded method returns user information */
	public static String[] getUser(String username, String password) throws SQLException {

		Messenger c = new Messenger();

		c.connection = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "cis3270", "project");
		String[] user = new String[13];

		String query = "Select * from User where username=? and password=?";

		PreparedStatement statement = c.connection.prepareStatement(query);

		statement.setString(1, username);
		statement.setString(2, password);

		ResultSet result = statement.executeQuery();

		if (result.next()) {
			user[0] = result.getString(1);
			user[1] = result.getString(2);
			user[2] = result.getString(3);
			user[3] = result.getString(4);
			user[4] = result.getString(5);
			user[5] = result.getString(6);
			user[6] = result.getString(7);
			user[7] = result.getString(8);
			user[8] = result.getString(9);
			user[9] = result.getString(10);
			user[10] = result.getString(11);
			user[11] = result.getString(12);
			user[12] = result.getString(13);
		}

		c.connection.close();

		return user;

	}
	
	public static String getUsername(String username) throws SQLException {

		Messenger c = new Messenger();

		c.connection = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "cis3270", "project");

		String query = "Select username from User where username=?";

		PreparedStatement statement = c.connection.prepareStatement(query);

		statement.setString(1, username);

		ResultSet result = statement.executeQuery();
		
		String data = "";

		if (result.next()) {
			data = result.getString(1);
		}

		c.connection.close();

		return data;

	}
	
	public static void createBus(int busNumber, String departureCity, String departureDate,
			String destinationCity, int capacity, int passengerCount) throws SQLException {

		Messenger c = new Messenger();

		c.connection = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "cis3270", "project");

		String query = "insert into Bus values (?,?,?,?,?,?)";
		PreparedStatement statement = c.connection.prepareStatement(query);
		statement.setInt(1, busNumber);
		statement.setString(2, departureCity);
		statement.setString(3, departureDate);
		statement.setString(4, destinationCity);
		statement.setInt(5, capacity);
		statement.setInt(6, passengerCount);

		statement.executeUpdate();

		c.connection.close();

	}
	
	public static String[] getBus(String departureCity) throws SQLException {
		
		Messenger c = new Messenger();

		String[] bus = new String[6];

		c.connection = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "cis3270", "project");

		String query = "Select * from Bus where departureCity =?";

		PreparedStatement statement = c.connection.prepareStatement(query);

		statement.setString(1, departureCity);

		ResultSet result = statement.executeQuery();

		if (result.next()) {
			bus[0] = "" + result.getInt(1);
			bus[1] = result.getString(2);
			bus[2] = result.getString(3);
			bus[3] = result.getString(4);
			bus[4] = "" + result.getInt(5);
			bus[5] = "" + result.getInt(6);
		}

		c.connection.close();

		return bus;
		
	}
	
	public static String createReservation(int reservationNumber, String dateCreated, String username,
			int busNumber, String departureDate, int ticketNumber) throws SQLException {
		
		Messenger c = new Messenger();

		c.connection = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "cis3270", "project");

		String query = "insert into Reservation values (?,?,?,?,?,?)";
		PreparedStatement statement = c.connection.prepareStatement(query);
		statement.setInt(1, reservationNumber);
		statement.setString(2, dateCreated);
		statement.setString(3, username);
		statement.setInt(4, busNumber);
		statement.setString(5, departureDate);
		statement.setInt(6, ticketNumber);

		statement.executeUpdate();

		c.connection.close();

		return "Success!";
	}
	
	public static String[] getReservation(int reservationNumber) throws SQLException {
		Messenger c = new Messenger();

		String[] reservation = new String[6];

		c.connection = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "cis3270", "project");

		String query = "Select * from Reservation where reservationNumber =?";

		PreparedStatement statement = c.connection.prepareStatement(query);

		statement.setInt(1, reservationNumber);

		ResultSet result = statement.executeQuery();

		if (result.next()) {
			reservation[0] = "" + result.getInt(1);
			reservation[1] = result.getString(2);
			reservation[2] = result.getString(3);
			reservation[3] = "" + result.getInt(4);
			reservation[4] = result.getString(5);
			reservation[5] = "" + result.getInt(6);
		}

		c.connection.close();

		return reservation;
	}

}