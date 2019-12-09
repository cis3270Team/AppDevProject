package UserInterFace;
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

public class BookRides extends Application {

    Stage window;
    TableView<Bus> table;
    TableView<Reservation> reservation;
   

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
      
    	window = primaryStage;
        window.setTitle("thenewboston - JavaFX");
        //Bus Id column
        TableColumn<Bus, Integer> busIdColumn = new TableColumn<>("Bus Id");
        busIdColumn.setMinWidth(100);
        busIdColumn.setCellValueFactory(new PropertyValueFactory<>("busNumber"));

        //Departing City column
        TableColumn<Bus, String> originCityColumn = new TableColumn<>("Origin City");
        originCityColumn.setMinWidth(150);
        originCityColumn.setCellValueFactory(new PropertyValueFactory<>("originCity"));

        //Destination City column
        TableColumn<Bus, String> departingCity = new TableColumn<>("Destination City");
        departingCity.setMinWidth(150);
        departingCity.setCellValueFactory(new PropertyValueFactory<>("destinationCity"));
      //Departure Time column
        TableColumn<Bus, String> departureColumn = new TableColumn<>("Departure Time");
        departureColumn.setMinWidth(150);
        departureColumn.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
        //Capacity City column
        TableColumn<Bus, Integer> capcityColumn = new TableColumn<>("Capacity");
        capcityColumn.setMinWidth(150);
        capcityColumn.setCellValueFactory(new PropertyValueFactory<>("seatsAvailable"));
      //Seats Available Time column
        TableColumn<Bus,String> remainingColumn  = new TableColumn<>("Seats Remaining");
        remainingColumn.setMinWidth(150);
        remainingColumn.setCellValueFactory(new PropertyValueFactory<>("seatsOccupied"));
        
        //Reservation Number column 
        TableColumn<Reservation, Integer> reservationNumber = new TableColumn<>("Reservation ID");
        reservationNumber.setMinWidth(200);
        reservationNumber.setCellValueFactory(new PropertyValueFactory<>("reservationNumber"));

        //Date Created column
        TableColumn<Reservation, String> dateCreated = new TableColumn<>("Date Created");
        dateCreated.setMinWidth(150);
        dateCreated.setCellValueFactory(new PropertyValueFactory<>("dateCreated"));

        //Username column
        TableColumn<Reservation, String> userName = new TableColumn<>("Username");
        userName.setMinWidth(100);
        userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
      //Bus Number column
        TableColumn<Reservation, Integer> busNumber = new TableColumn<>("Bus Number");
        busNumber.setMinWidth(100);
        busNumber.setCellValueFactory(new PropertyValueFactory<>("busNumber"));
        //Departure Date column
        TableColumn<Reservation, String> departureDate = new TableColumn<>("Departure Date");
        departureDate.setMinWidth(150);
        departureDate.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
      //Ticket Number column
        TableColumn<Reservation,Integer> ticketNumber  = new TableColumn<>("Ticket Number");
        ticketNumber.setMinWidth(150);
        ticketNumber.setCellValueFactory(new PropertyValueFactory<>("ticketNumber"));
        reservation=new TableView<Reservation>();

        //Add Button
        Button bookButton = new Button("Book");
        bookButton.setOnAction(e -> addButtonClicked());
        //Delete Button
        Button delete = new Button("Remove Flight");
        delete.setOnAction(e -> {
        	
        });
    
      //Back Button to return to admin main page
        Button back = new Button("Back");
        back.setOnAction(e ->{
        	WelcomePage a=new WelcomePage();
        	try {
				a.start(window);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        HBox hBox = new HBox();
        Label book= new Label("Book a Bus Ride");
        Label space= new Label("   ");
        hBox.getChildren().addAll(book,space,bookButton);
        hBox.setAlignment(Pos.BASELINE_RIGHT);
        table = new TableView<>();
      
        table.getColumns().addAll(busIdColumn, originCityColumn, departureColumn,departingCity,capcityColumn,remainingColumn);
        reservation.getColumns().addAll(reservationNumber,dateCreated,userName,busNumber,departureDate,ticketNumber);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);
        VBox yu=new VBox();
        HBox hBack = new HBox();
        hBack.getChildren().addAll(delete,back);
        hBack.setAlignment(Pos.BASELINE_RIGHT);

        yu.getChildren().addAll(reservation,hBack);
        BorderPane lay=new BorderPane();
        lay.setCenter(yu);
        lay.setTop(vBox);
        Scene scene = new Scene(lay,850,850);
        window.setScene(scene);
        window.show();
    }

    //Add button clicked
    public void addButtonClicked(){
    	
    }

    //Delete button clicked
    public void deleteButtonClicked(){
    	try {
        ObservableList<Bus> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();

        productSelected.forEach(allProducts::remove);
    	}catch(NoSuchElementException ex) {
    	Alert.display("Manage Flight", "There are no trips");
    	}
    }
    
   


}