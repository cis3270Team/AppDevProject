package reservation.util;

public class Test {
	
	public static void main(String[] args) {
		
		//test Login
		User user = null;
		if (Check.isValidUser("yomar", "123")) {
			user = Menu.login("ola", "ola123");
		}
		
		if (Check.isValidUser("yomar", "123") && (user instanceof Customer)) {
			System.out.println(user.getFirstName());
		}
		
		
		
		
		// test registration
		String[] newUser = {"test","test1","Scot","Will","10102 Scot Rd","Atlanta","Georgia","30034",
				"scot@yahoo.com","234567","Where were you born? ","Nigeria"};
		
		String response = Menu.register(newUser);
		
		System.out.println(response);
		
		
		
		// test forgot password
		String[] query = Menu.forgotPassword("te");
		System.out.println(query[0]);
		
		
	}

}