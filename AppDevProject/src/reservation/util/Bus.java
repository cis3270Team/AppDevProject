package reservation.util;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import reservation.data.Messenger;

public class Bus {
	//Data Field
	private int busNumber;
	private String departureCity;
	private String departureDate;
	private String destinationCity; 
	private int capacity;
	private int passengerCount;
	

	// no argument constructor
	public Bus() {
		
	}
	
	// Constructor
	public Bus(int busNumber, String departureCity, String departureDate,
			String destinationCity, int capacity,int passengerCount) {
		super();
		this.busNumber = busNumber;
		this.departureCity = departureCity;
		this.departureDate = departureDate;
		this.destinationCity = destinationCity;
		this.capacity = capacity;
		this.passengerCount = passengerCount;
	}
	
	// method stores this bus in the database
	public String createBus() {
		try {
			Messenger.createBus(this.busNumber, this.departureCity, this.departureDate,
					this.destinationCity, this.capacity, passengerCount);
		}
		catch (SQLException sql) {
			return sql.getMessage() + "Bus not registered";
		}
		catch (Exception e) {
			return e.getMessage() + "Bus not registered";
		}
		
		return "Bus successfully registered";
	}

	//getter
	public int getBusNumber() {
		return busNumber;
	}

	//setter
	public void setBusNumber(int busNumber) {
		this.busNumber = busNumber;
	}

	//getter
	public String getDepartureCity() {
		return departureCity;
	}

	//setter
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}

	
}