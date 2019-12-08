package reservation.util;

	import java.sql.Date;

	import javafx.application.Application;

	public class Reservation extends Bus {

		private static int reservationNumber;
		private Date dateCreated;
		private Date departureDate;
		private int reservationCount;
		private Bus busDetail;
		private static int ticketNumber=0000;
		private String ssn;

		
		public Reservation() {
			
		}
				
		public Reservation( int reservationNumber, Date dateCreated, Date departureDate, int reservationCount, Bus busDetail, int ticketNumber, String ssn) {
			this.ticketNumber=reservationNumber++;

		}
		
		public int getreservationNumber() {
			return reservationNumber;
		
		}
		
		public Date getdateCreated() {
			return dateCreated;
		
		}
		
		public void setdateCreated(Date dateCreated) {
			this.dateCreated = dateCreated;
			
		}
		
		public Date getDepartureDate() {
			return departureDate;
		}

		public void setDepartureDate(Date departureDate) {
			this.departureDate = departureDate;
		
		}
		
		public int getreservationCount() {
			return reservationCount;
		
		}
		
		public Bus getbusDetail() {
			return busDetail;
		
		}
		
		public void setbusDetail( Bus busDetail) {
			this.busDetail = busDetail;
		}
		
		public int getticketNumber() {
			return ticketNumber;
		}
		
		public String getSsn() {
			return ssn;
		}

		public void setSsn(String ssn) {
			this.ssn = ssn;
		}

	}
