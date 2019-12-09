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
	private static int passengerCount;
	public String result;
	
	public Bus(int busNumber, String departureCity, String departureDate,
			String destinationCity, int capacity) {
		this.busNumber = busNumber;
		this.departureCity = departureCity;
		this.departureDate = departureDate;
		this.destinationCity = destinationCity;
		this.capacity = capacity;
		this.result = createBus();
	}
	
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
	
}