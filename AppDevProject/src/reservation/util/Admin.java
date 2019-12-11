package reservation.util;

public class Admin extends User {

	// Main constructor for creating an Administrator
	public Admin(String username, String password, String userType, String firstName, String lastName, 
			String address, String city, String state, String zipCode, String email, String ssn, 
			String securityQuestion, String securityAnswer) {
		
		// Pass registration information to the super class
		super(username, password, userType, firstName, lastName, address, city, state, zipCode, email, ssn,
				securityQuestion, securityAnswer);
	}
	

	/** Methods such as createBus, updateTrip, and deleteBus are temporarily implemented in the GUI package
	 * it must be reversed after testing and re-test the class.
	 */
	
}