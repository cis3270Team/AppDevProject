package reservation.GUI;

import java.util.NoSuchElementException;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import reservation.data.Messenger;
import reservation.util.Admin;
import reservation.util.Bus;
import reservation.util.Check;
import reservation.util.Customer;
import reservation.util.Reservation;

public class BookRides extends Application {

	Stage window;
	TableView<Bus> table;
	TableView<Reservation> reservation;
	static int count = 1;
	Scene scene;
	int[] busQuery;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		window.setTitle("Bus Reservation App");
		TableColumn<Bus, Integer> busIdColumn = new TableColumn<>("Bus Id");
		busIdColumn.setMinWidth(100);
		busIdColumn.setCellValueFactory(new PropertyValueFactory<>("busNumber"));

		// Departure City column
		TableColumn<Bus, String> originCityColumn = new TableColumn<>("Origin City");
		originCityColumn.setMinWidth(150);
		originCityColumn.setCellValueFactory(new PropertyValueFactory<>("departureCity"));

		// Destination City column
		TableColumn<Bus, String> departingCity = new TableColumn<>("Destination City");
		departingCity.setMinWidth(150);
		departingCity.setCellValueFactory(new PropertyValueFactory<>("destinationCity"));
		// Departure Time column
		TableColumn<Bus, String> departureColumn = new TableColumn<>("Departure Time");
		departureColumn.setMinWidth(150);
		departureColumn.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
		// Capacity City column
		TableColumn<Bus, Integer> capcityColumn = new TableColumn<>("Capacity");
		capcityColumn.setMinWidth(150);
		capcityColumn.setCellValueFactory(new PropertyValueFactory<>("capacity"));
		// Seats Available Time column
		TableColumn<Bus, String> remainingColumn = new TableColumn<>("Passanger Count");
		remainingColumn.setMinWidth(150);
		remainingColumn.setCellValueFactory(new PropertyValueFactory<>("passengerCount"));

		// Reservation Number column
		TableColumn<Reservation, Integer> reservationNumber = new TableColumn<>("Reservation ID");
		reservationNumber.setMinWidth(200);
		reservationNumber.setCellValueFactory(new PropertyValueFactory<>("reservationNumber"));

		// Date Created column
		TableColumn<Reservation, String> dateCreated = new TableColumn<>("Date Created");
		dateCreated.setMinWidth(150);
		dateCreated.setCellValueFactory(new PropertyValueFactory<>("dateCreated"));

		// Bus Number column
		TableColumn<Reservation, Integer> busNumber = new TableColumn<>("Bus Number");
		busNumber.setMinWidth(100);
		busNumber.setCellValueFactory(new PropertyValueFactory<>("busNumber"));
		// Departure Date column
		TableColumn<Reservation, String> departureDate = new TableColumn<>("Departure Date");
		departureDate.setMinWidth(150);
		departureDate.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
		// Ticket Number column
		TableColumn<Reservation, Integer> ticketNumber = new TableColumn<>("Ticket Number");
		ticketNumber.setMinWidth(150);
		ticketNumber.setCellValueFactory(new PropertyValueFactory<>("ticketNumber"));
		reservation = new TableView<Reservation>();
		
		// Add Button
		Button bookButton = new Button("Book");
		bookButton.setOnAction(e -> {
			addButtonClicked();
			
		});
		// Delete Button
		Button delete = new Button("Remove Reservation");
		delete.setOnAction(e -> {
			deleteButtonClicked();
		});

		// Back Button to return to admin main page
		Button back = new Button("Back");
		back.setOnAction(e -> {
			WelcomePage a = new WelcomePage();
			try {
				if(Login.user instanceof Admin) {
					AdminPage admin=new AdminPage();
					admin.start(window);
				}else {
					a.start(window);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
		HBox hBox = new HBox();
		Label book = new Label("Book a Bus Ride");
		Label space = new Label("   ");
		hBox.getChildren().addAll(book, space, bookButton);
		hBox.setAlignment(Pos.BASELINE_RIGHT);
		table = new TableView<>();

		table.getColumns().addAll(busIdColumn, originCityColumn, departureColumn, departingCity, capcityColumn,
				remainingColumn);
		table.setItems(getBusses());
		reservation.getColumns().addAll(reservationNumber, dateCreated, busNumber, departureDate,
				ticketNumber);
		reservation.setItems(Messenger.getReservation(Login.user.getUserName()));
		VBox vBox = new VBox();
		vBox.getChildren().addAll(table, hBox);
		VBox yu = new VBox();
		HBox hBack = new HBox();
		hBack.getChildren().addAll(delete, back);
		hBack.setAlignment(Pos.BASELINE_RIGHT);

		yu.getChildren().addAll(reservation, hBack);
		BorderPane lay = new BorderPane();
		lay.setCenter(yu);
		lay.setTop(vBox);
		 scene = new Scene(lay, 1200, 600);
		window.setScene(scene);
		window.show();
	}

	// Add button clicked
	public void addButtonClicked() {
		try {
			ObservableList<Bus> productSelected, allProducts;
			allProducts = table.getItems();
			productSelected = table.getSelectionModel().getSelectedItems();
			Bus bus=(Bus)table.getSelectionModel().getSelectedItem();
			
			if (Check.reservationExists(bus.getDepartureDate(), Login.user.getUserName())) {
				Alert.display("Manage Flight", "Reservation Already Exist");
			} else {
				busQuery = Messenger.getPassengerCount(bus.getBusNumber());
				if (busQuery.length != 0 && busQuery[0] == busQuery[1]) {
					Alert.display("Manage Flight", "This Bus is Full!");
				}else {
					Reservation reservation = new Reservation(Login.user.getUserName(), bus.getBusNumber(),
							bus.getDepartureDate(), count++);
					Messenger.updatePassengerCount(++busQuery[1], bus.getBusNumber());
					BookRides a = new BookRides();
					a.start(window);
				}
			}

		} catch (Exception ex) {
			Alert.display("Manage Flight", "Invalid Input please enter correct inputs!");

		}
	}
	

	// Delete button clicked
	public void deleteButtonClicked() {
		try {
			ObservableList<Reservation> productSelected, allProducts;
			allProducts = reservation.getItems();
			productSelected = reservation.getSelectionModel().getSelectedItems();
			Reservation res=(Reservation)reservation.getSelectionModel().getSelectedItem();
			Messenger.deleteReservation(res.getReservationNumber());
			productSelected.forEach(allProducts::remove);
			busQuery = Messenger.getPassengerCount(res.getBusNumber());
			if (busQuery.length != 0) {
				Messenger.updatePassengerCount(--busQuery[1], res.getBusNumber());
				BookRides updateRes=new BookRides();
				updateRes.start(window);
			}
			
			
		} catch (NoSuchElementException ex) {
			Alert.display("Manage Flight", "All your reservations have been removed");
		}catch(Exception ex) {
			Alert.display("Manage Flight", "You haven\'t made a selection");

		}
	}
	public ObservableList<Bus> getBusses(){
		ObservableList<Bus> bus= Messenger.getBus();
		return bus;
	}
}