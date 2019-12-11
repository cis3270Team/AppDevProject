package reservation.util;

import java.sql.SQLException;
import java.util.Date;

import reservation.data.Messenger;

public class Reservation {
	//Data Field
	private int reservationNumber; 
	private String dateCreated; 
	private String username;
	private int busNumber; 
	private String departureDate; 
	private int ticketNumber;
	private static int reservationCount;
	public String result;
	
	
	//No argument constructor creates a default reservation that can be altered eventually
	public Reservation() {
		this("Username not found!", 0, "Not found",0);
	}
	
	//Constructor creates a Reservation object with user input
	public Reservation(String username, int busNumber, String departureDate, int ticketNumber) {
		int lastCount = Check.getReservationCount();
		reservationCount = ++lastCount;
		this.reservationNumber = reservationCount;
		this.dateCreated = new Date().toString();
		this.username = username;
		this.busNumber = busNumber;
		this.departureDate = departureDate;
		this.ticketNumber = ticketNumber;
		this.result = createReservation();
		Check.setReservationCount(reservationCount);
	}
	
	//Constructor creates a Reservation object with user input
	public Reservation(int reservationNumber, String dateCreated, String username, int busNumber, String
			departureDate, int ticketNumber) {
		this.reservationNumber = reservationNumber;
		this.dateCreated = dateCreated;
		this.username = username;
		this.busNumber = busNumber;
		this.departureDate = departureDate;
		this.ticketNumber = ticketNumber;
	}
	
	// method stores this reservation in the database
	public String createReservation() {
		String output = "";// a string to save the result of this update
		try {// call database and save response in output
			output = Messenger.createReservation(this.reservationNumber, this.dateCreated, this.username,
					this.busNumber, this.departureDate, this.ticketNumber);
		} catch (SQLException sql) {
			output = sql.getMessage();// save any error message in output
		} catch (Exception e) {
			output = e.getMessage();// save any error message in output
		}

		return output;
	}

	public int getReservationNumber() {
		return reservationNumber;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public String getUsername() {
		return username;
	}

	public int getBusNumber() {
		return busNumber;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public static int getReservationCount() {
		return reservationCount;
	}

	public void setReservationNumber(int reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setBusNumber(int busNumber) {
		this.busNumber = busNumber;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public static void setReservationCount(int reservationCount) {
		Reservation.reservationCount = reservationCount;
	}

}
