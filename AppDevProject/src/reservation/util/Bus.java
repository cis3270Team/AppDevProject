package reservation.util;


	import java.sql.Date;
	import java.sql.Time;
	import java.sql.Timestamp;
	import java.util.Collection;
	import java.util.Iterator;
	import java.util.List;
	import java.util.ListIterator;

	import javafx.beans.InvalidationListener;
	import javafx.collections.ListChangeListener;
	import javafx.collections.ObservableList;

	public class Bus implements ObservableList {	
	private String bus;
	private int busNumber;
	private String departureCity;
	private String destinationCity;
	private Date departureDate;
	private int capacity;
	private int passengerCount;
	private int seatsAvailable;
	private int seatsOccupied;
	private String departureTime;
	private Time arrivalTime;
	private boolean isFull;
	 
	public Bus (){
		
	}

	public Bus(String bus, int busNumber, String departureCity, String destinationCity) {
		super();
		this.busNumber = busNumber;
		this.departureCity = departureCity;
		this.destinationCity = destinationCity;
	}

	public Bus( int busNumber, String departureCity, String destinationCity, Date departureDate, String departureTime, Date arrivalDate, Time arrivalTime,int seatsAvailable, Timestamp time) {
		super();
		this.busNumber = busNumber;
		this.departureCity = departureCity;
		this.destinationCity = destinationCity;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.seatsAvailable = seatsAvailable;
	}
	public Bus( int busNumber, String departureCity, String destinationCity, Date departureDate, String departureTime, Date arrivalDate, Time arrivalTime,int seatsAvailable) {
		super();
		this.busNumber = busNumber;
		this.departureCity = departureCity;
		this.destinationCity = destinationCity;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.seatsAvailable = seatsAvailable;
	}


	public Bus( int busNumber, String departureCity, String destinationCity, Date departureDate, String departureTime, Date arrivalDate) {
		super();
		this.busNumber = busNumber;
		this.departureCity = departureCity;
		this.destinationCity = destinationCity;
		this.departureDate = departureDate;
		this.departureTime = departureTime;

	}

	public int getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(int busNumber) {
		this.busNumber = busNumber;
	}
	
	public String getdepartureCity() {
		return departureCity;
	}

	public void setdepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	
	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	
	}
    
	public int setcapacity() {
		return capacity;
	}
	
	public void getcapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public boolean isFull() {
		return isFull;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}
	
	public int getpassengerCount() {
		return passengerCount;
		
	}
	
	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public int getSeatsOccupied() {
		return seatsOccupied;
	}

	public void setSeatsOccupied(int seatsOccupied) {
		this.seatsOccupied = seatsOccupied;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public Time getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	@Override
	public String toString() {
		return "Bus" + bus + ", busNumber=" + busNumber + ", busCapacity=" + capacity
				+ ", seatsAvailable=" + seatsAvailable + ", seatsOccupied=" + seatsOccupied + ", originCity=" + departureCity
				+ ", destinationCity=" + destinationCity + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + ", departureDate=" + departureDate + ", arrivalDate=" + ", isFull=" + isFull
				+ "]";
	}

	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addAll(Object... arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addListener(ListChangeListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean removeAll(Object... arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ListChangeListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean retainAll(Object... arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setAll(Object... arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}