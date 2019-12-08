package reservation.util;

public class Customer extends User {
	
	//no-argument constructor
	public Customer() {
		
	}
	
	public Customer(String username, String password, String userType, String firstName,
			String lastName, String address, String city, String state, String zipCode, String email,
			String ssn, String securityQuestion, String securityAnswer) {
		super(username, password,userType,firstName,lastName,address,city,state,zipCode,
				email,ssn,securityQuestion,securityAnswer);
	}

}