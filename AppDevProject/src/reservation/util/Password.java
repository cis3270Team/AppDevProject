package reservation.util;

public class Password {
private String password;
private String securityQuestion;
private String answer;

public Password(String passWord,String securityQuestion,String answer ) {
	this.password=passWord;
	this.securityQuestion=securityQuestion;
	this.answer=answer;
}

public String getPassword() {
	return password;
}

public String getSecurityQuestion() {
	return securityQuestion;
}

public String getAnswer() {
	return answer;
}

public void setAnswer(String answer) {
	this.answer = answer;
}


}
