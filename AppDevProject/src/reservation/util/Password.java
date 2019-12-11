package reservation.util;

public class Password {
	
	/**
	 * The User class composes Password
	 */
	
	//Data field
	private String password;
	private String securityQuestion;
	private String answer;

	//Constructors
	public Password() {
	}
	
	public Password(String password) {
		this.password = password;
	}
	
	public Password(String passWord, String securityQuestion, String answer) {
		this.password = passWord;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
	}

	
	//Method returns the security question for this password
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	
	//Method sets the security question for this password
	public void setSecurityQuestion(String question) {
		this.securityQuestion = question;
	}

	//returns answer to this password's security question
	public String getAnswer() {
		return answer;
	}

	//sets answer to this password's security question
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	//displays this password's security question
	public void printSecurityQuestion() {
		System.out.println(securityQuestion);
	}
	
	@Override
	public String toString() {
		return password;
	}

}
