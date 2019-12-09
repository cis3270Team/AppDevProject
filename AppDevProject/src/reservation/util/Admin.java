package reservation.util;

import reservation.util.Customer;

public class Admin extends Customer{
	
		private  static String  adminPW="Admin000";
		private int updateBus;
		private int deleteBus;
	
		public Admin() {
			
		}

		public Admin(String firstName, String lastName, String address, String city,
				String state, String zipCode, String email, String ssn, String username, String password) 
		
		{
			
			super(firstName, lastName, address, city, state, zipCode, email, ssn, username, password);
			
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


		public int getupdateBus() {
			return updateBus;
		}

		public int customerCheckIn(int reservationNumber) {
			return reservationNumber;
			
		}
		
		public int getdeleteBus() {
			return deleteBus;
		}

		public static String getAdminPW() {
			return adminPW;
		}

		public static void setAdminPW(String adminPW) {
			Admin.adminPW = adminPW;
		}

	
	}