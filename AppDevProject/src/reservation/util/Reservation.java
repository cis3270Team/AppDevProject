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
	
	public Reservation() {
		this("Username not found!", 0, "Not found",0);
	}
	
	public Reservation(String username, int busNumber, String departureDate, int ticketNumber) {
		int lastCount = Check.getReservationCount();
		reservationCount = ++lastCount;
		this.reservationNumber = ++reservationCount;
		this.dateCreated = new Date().toString();
		this.username = username;
		this.busNumber = busNumber;
		this.departureDate = departureDate;
		this.ticketNumber = ticketNumber;
		this.result = createReservation();
		Check.setReservationCount(reservationCount);
	}
	
	public Reservation(int reservationNumber, String dateCreated, String username, int busNumber, String
			departureDate, int ticketNumber) {
		this.reservationNumber = reservationNumber;
		this.dateCreated = dateCreated;
		this.username = username;
		this.busNumber = busNumber;
		this.departureDate = departureDate;
		this.ticketNumber = ticketNumber;
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
	
	public String createReservation() {
		String output = "";
		try {
			output = Messenger.createReservation(this.reservationNumber,this.dateCreated,this.username,
					this.busNumber,this.departureDate,this.ticketNumber);
		}
		catch (SQLException sql) {
			output = sql.getMessage();
		}
		catch (Exception e) {
			output = e.getMessage();
		}
		
		return output;
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
