package reservation.util;

public abstract class User {
	
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
	private String password;
	private String securityQuestion;
	private String securityAnswer;
	private String type;
	
	//no-argument constructor creates a default customer
	public User() {
		
	}
	
	//this constructor creates a User object with user input
	public User(String username, String password, String userType, String firstName,
			String lastName, String address, String city, String state, String zipCode, String email,
			String ssn, String securityQuestion, String securityAnswer) {
		type = userType;
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
		setSecurityQuestion(securityQuestion);
		setSecurityAnswer(securityAnswer);
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
		this.password = password;
	}

	//returns this user's password
	public String getPassword() {
		return password.toString();
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	//sets this user's password security question
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	
	//sets this user's password security answer
	public void setSecurityAnswer(String answer) {
		this.securityAnswer = answer;
	}
	
	public String getSecurityQuestion() {
		return this.securityQuestion;
	}
	
	public String getSecurityAnswer() {
		return this.securityAnswer;
	}

}