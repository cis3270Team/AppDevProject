package reservation.util;

public class Customer {
	
	//Data field
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String email;
	private String ssn;
	private String userName;
	private Password password;
	private String[] securityQuestions =   {"1. What is your favorite pet's name? ",
						"2. Where is your mom from?  ",
						"3. Where were you born? ",
						"4. What is the name of your 2nd grade teacher? "};
	
	//no-argument constructor creates a default customer
	public Customer() {
		
	}
	
	//this constructor creates a Customer object with user input
	public Customer(String firstName, String lastName, String address, String city, String state, 
			String zipCode, String email, String ssn, String username, String password) {
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setCity(city);
		setState(state);
		setZipCode(zipCode);
		setEmail(email);
		setSsn(ssn);
		setUserName(username);
		setPassword(password);
	}

	//returns first name
	public String getFirstName() {
		return firstName;
	}
	
	//sets first name
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	//returns last name
	public String getLastName() {
		return lastName;
	}

	//sets last name
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	//returns address
	public String getAddress() {
		return address;
	}

	//sets address
	public void setAddress(String address) {
		this.address = address;
	}

	//returns ZIP code
	public String getZipCode() {
		return zipCode;
	}

	//sets ZIP code
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	//returns city
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = new Password(password);
	}

	//returns this user's password
	public String getPassword() {
		return password.toString();
	}

	//sets this user's password
	public void setPassword(String password, String securityQuestion, String Answer) {
		new Password(password, securityQuestion, Answer);

	}
	
	// Method displays the security questions
	public void printSecurityQuestions() {
		System.out.println("\nSelect a security question: ");
		for (String question: securityQuestions)
			System.out.println(question);
	}
	
	//sets this user's password security question
	public void setPasswordSecurityQuestion(int value) {
		this.password.setSecurityQuestion(securityQuestions[value]);
	}
	
	//displays this user's security question
	public void printSecurityQuestion(int value) {
		System.out.println(securityQuestions[value]);
	}
	
	//sets this user's password security answer
	public void setSecurityAnswer(String answer) {
		password.setAnswer(answer);
	}

}
