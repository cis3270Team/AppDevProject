package reservation.util;

public class Test {
	
	public static void main(String[] args) {
		
		//test Login
		
		User user = null;
		if (Menu.isValidUser("yomar", "123")) {
			user = Menu.login("yomar", "123");
		}
		
		if (user instanceof Customer) {
			System.out.println(user.getFirstName());
		}
		
		

		
		
		// test registration
		String[] newUser = {"tet","test1","Scot","Will","10102 Scot Rd","Atlanta","Georgia","30034",
				"scot@yahoo.com","234567","Where were you born? ","Nigeria"};
		
		String response = Menu.register(newUser);
		
		System.out.println(response);
		
		
		
		// test forgot password
		String[] query = Menu.forgotPassword("test");
		System.out.println(query[0]);
		
		
	}

}
