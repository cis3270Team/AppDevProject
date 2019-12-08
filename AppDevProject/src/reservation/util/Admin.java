package reservation.util;

public class Admin extends User {

	public Admin(String username, String password, String userType, String firstName, String lastName, 
			String address, String city, String state, String zipCode, String email, String ssn, 
			String securityQuestion, String securityAnswer) {
		
		super(username, password, userType, firstName, lastName, address, city, state, zipCode, email, ssn,
				securityQuestion, securityAnswer);
	}

}