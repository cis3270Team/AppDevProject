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
	private String busType;
	private int busNumber;
	private int busCapacity;
	private int seatsAvailable;
	private int seatsOccupied;
	private String originCity;
	private String destinationCity;
	private Time departureTime;
	private Time arrivalTime;
	private Date departureDate;
	private Date arrivalDate;
	private boolean isFull;
	private Timestamp time;
	 
	public Bus (){
		
	}

	public Bus(String bus, int busNumber, String originCity, String destinationCity) {
		super();
		this.busType = busType;
		this.busNumber = busNumber;
		this.originCity = originCity;
		this.destinationCity = destinationCity;
	}

	public Bus( int busNumber,String busType, String originCity, String destinationCity, Date departureDate, Time departureTime, Date arrivalDate, Time arrivalTime,int seatsAvailable, Timestamp time) {
		super();
		this.busType = busType;
		this.busNumber = busNumber;
		this.originCity = originCity;
		this.destinationCity = destinationCity;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.seatsAvailable = seatsAvailable;
		this.time = time;
	}
	public Bus( int busNumber,String busType, String originCity, String destinationCity, Date departureDate, Time departureTime, Date arrivalDate, Time arrivalTime,int seatsAvailable) {
		super();
		this.busType = busType;
		this.busNumber = busNumber;
		this.originCity = originCity;
		this.destinationCity = destinationCity;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.seatsAvailable = seatsAvailable;
	}


	public Bus( int busNumber,String busType, String originCity, String destinationCity, Date departureDate, Time departureTime, Date arrivalDate, Time arrivalTime) {
		super();
		this.busType = busType;
		this.busNumber = busNumber;
		this.originCity = originCity;
		this.destinationCity = destinationCity;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;

	}
    // Get bus make/type
	public String getBusType() {
		return busType;
	}
    // Return the bus make/type
	public void setbusType(String bus) {
		this.busType = busType;
	}
    // Get Bus ID/Number
	public int getBusNumber() {
		return busNumber;
	}
    // Return Bus ID/Number
	public void setBusNumber(int busNumber) {
		this.busNumber = busNumber;
	}
    
	public int getBusCapacity() {
		return busCapacity;
	}

	public void setBusCapacity(int busCapacity) {
		this.busCapacity = busCapacity;
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

	public String getOriginCity() {
		return originCity;
	}

	public void setOriginCity(String originCity) {
		this.originCity = originCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public Time getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}

	public Time getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public boolean isFull() {
		return isFull;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}

	@Override
	public String toString() {
		return "Bus [busType=" + bus + ", busNumber=" + busNumber + ", busCapacity=" + busCapacity
				+ ", seatsAvailable=" + seatsAvailable + ", seatsOccupied=" + seatsOccupied + ", originCity=" + originCity
				+ ", destinationCity=" + destinationCity + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + ", isFull=" + isFull
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