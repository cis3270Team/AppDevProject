package reservation.data;

import javafx.collections.*;

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

import javafx.collections.ObservableList;
import reservation.util.Bus;
import reservation.util.Reservation;

public class Messenger {
	// Data Field
	private Connection connection;
	static ObservableList<Bus> busSchedule;
	static ObservableList<Reservation> reservation;
	
	private Messenger() {//The constructor is deliberately private to avoid instantiation outside of this class
		
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
	
	/** method creates a new user */
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
	
	/** method returns userName */
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
	
	/** method creates a new Bus */
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
	
	/** method deletes a Bus */
	public static void deleteBus(int busNumber) {

		try {
			
		Messenger c = new Messenger();

		c.connection = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "cis3270", "project");

		String query = "delete from Bus where busNumber = ?";
		PreparedStatement statement = c.connection.prepareStatement(query);
		statement.setInt(1, busNumber);

		statement.executeUpdate();

		c.connection.close();
		
		}
		catch(SQLException sql) {
			
		}
		catch(Exception e) {
			
		}

	}
	
	/** method returns Bus details */
	public static ObservableList<Bus> getBus() {
		
		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "cis3270", "project");

			String query = "Select * from Bus";

			PreparedStatement statement = connection.prepareStatement(query);

			ResultSet result = statement.executeQuery();
			busSchedule = FXCollections.observableArrayList();
			while (result.next()) {
				busSchedule.addAll(new Bus(result.getInt(1),result.getString(2),result.getString(3),
					result.getString(4), result.getInt(5),result.getInt(6)));
				
			}
			return busSchedule;
		}
			
		catch (SQLException s) {
			System.out.println(s.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;
		
	}
	
	/** method creates new reservation */
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
	
	/** method returns reservation details */
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
	
	/** method returns an ObservableList of Reservation */
	public static ObservableList<Reservation> getReservation(String username) {

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "cis3270",
					"project");

			String query = "Select * from Reservation where username=?";

			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, username);

			ResultSet result = statement.executeQuery();
			reservation = FXCollections.observableArrayList();
			while (result.next()) {
				reservation.addAll(new Reservation(result.getInt(1), result.getString(2), result.getString(3),
						result.getInt(4), result.getString(5), result.getInt(6)));

			}
			return reservation;
		}

		catch (SQLException s) {
			System.out.println(s.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;

	}
	
	/** Overloaded method returns reservation details */
	public static String[] getReservation(String departureDate, String username) throws SQLException {
		Messenger c = new Messenger();

		String[] reservation = new String[6];

		c.connection = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "cis3270", "project");

		String query = "Select * from Reservation where departureDate =? and username=?";

		PreparedStatement statement = c.connection.prepareStatement(query);

		statement.setString(1, departureDate);
		statement.setString(2, username);

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
	
	/** method deletes a Reservation */
	public static void deleteReservation(int reservationNumber) {

		try {

			Messenger c = new Messenger();

			c.connection = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "cis3270", "project");

			String query = "delete from Reservation where reservationNumber = ?";
			PreparedStatement statement = c.connection.prepareStatement(query);
			statement.setInt(1, reservationNumber);

			statement.executeUpdate();

			c.connection.close();

		} catch (SQLException sql) {

		} catch (Exception e) {

		}

	}

	// gets the last reservation number from projectdb
	public static int getReservationCount() throws SQLException {

		Messenger c = new Messenger();

		c.connection = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "cis3270", "project");

		String query = "Select * from ReservationCount";

		PreparedStatement statement = c.connection.prepareStatement(query);

		ResultSet result = statement.executeQuery();

		int data = 0;

		if (result.next()) {
			data = result.getInt(1);
		}

		c.connection.close();

		return data;

	}
	
	// sets the last reservation number in projectdb
	public static void setReservationCount(int resCount) throws SQLException {

		Messenger c = new Messenger();

		c.connection = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "cis3270", "project");

		String query = "update ReservationCount set resCount=?";

		PreparedStatement statement = c.connection.prepareStatement(query);
		
		statement.setInt(1, resCount);

		statement.executeUpdate();
		
		c.connection.close();

	}
	
	// Method returns passengerCount
	public static int[] getPassengerCount(int busNumber) {

		Messenger c = new Messenger();

		try {

			c.connection = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "cis3270", "project");

			String query = "Select capacity,passengerCount from Bus where busNumber=?";

			PreparedStatement statement = c.connection.prepareStatement(query);
			statement.setInt(1, busNumber);

			ResultSet result = statement.executeQuery();

			int[] data = new int[2];

			if (result.next()) {
				data[0] = result.getInt(1);
				data[1] = result.getInt(2);
			}

			c.connection.close();

			return data;
		} catch (SQLException sql) {

		} catch (Exception e) {

		}
		
		return null;

	}
	
	// Method updates passengerCount
	public static void updatePassengerCount(int passengerCount, int busNumber) {

		try {

			Messenger c = new Messenger();

			c.connection = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "cis3270", "project");

			String query = "update Bus set passengerCount=? where busNumber=?";

			PreparedStatement statement = c.connection.prepareStatement(query);

			statement.setInt(1, passengerCount);
			statement.setInt(2, busNumber);

			statement.executeUpdate();

			c.connection.close();

		} catch (SQLException sql) {

		} catch (Exception e) {

		}

	}

}