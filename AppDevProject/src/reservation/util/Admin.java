package reservation.util;

public class Admin extends User {

	public Admin(String username, String password, String userType, String firstName, String lastName, 
			String address, String city, String state, String zipCode, String email, String ssn, 
			String securityQuestion, String securityAnswer) {
		
		super(username, password, userType, firstName, lastName, address, city, state, zipCode, email, ssn,
				securityQuestion, securityAnswer);
	}
	
	public String createBus(int busNumber, String departureCity, String departureDate, String destinationCity,
			int capacity) {
		Bus bus1 = new Bus(busNumber, departureCity, departureDate, destinationCity, capacity);
		if (bus1.result.isEmpty()) {
			return "Registration failed";
		}
		if (bus1.result.length() == 0) {
			return "Registration failed";
		}
		else {
			return bus1.result;
		}
	}

}