package UserInterFace;
import java.util.NoSuchElementException;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManageRides extends Application {

    Stage window;
    TableView<Bus> table;
    TextField busId, originCity, destinationCity,departureTime,departureDate,capacity,remaining;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       Alert.display("Admin", "Please add & Remove Bus Rides Carefully");
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
        //Bus input
        busId = new TextField();
        busId.setPromptText("Bus Id");
        busId.setMinWidth(150);

        //Departure City input
        originCity = new TextField();
        originCity.setPromptText("Departure City");

        //Destination City input
        destinationCity = new TextField();
        destinationCity.setPromptText("Destination City");
        //Departure Date City input
        departureTime = new TextField();
        departureTime.setPromptText("Departure Date");
        //Destination City input
        capacity = new TextField();
        capacity.setPromptText("Amount");
        //Departure Date City input
        remaining = new TextField("0");
        //Add Button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        //Delete Button
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());
      //Back Button to return to admin main page
        Button back = new Button("back");
        back.setOnAction(e ->{
        	AdminPage a=new AdminPage();
        	try {
				a.start(window);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(busId, originCity,departureTime, destinationCity,capacity,remaining,addButton, deleteButton,back);

        table = new TableView<>();
      
        table.getColumns().addAll(busIdColumn, originCityColumn, departureColumn,departingCity,capcityColumn,remainingColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);
        BorderPane lay=new BorderPane();
        lay.setCenter(vBox);
        
        Scene scene = new Scene(lay);
        window.setScene(scene);
        window.show();
    }

    //Add button clicked
    public void addButtonClicked(){
    	try {
    	Bus bus = new Bus();
        bus.setBusNumber(Integer.parseInt(busId.getText()));
        bus.setOriginCity(originCity.getText());
        bus.setDestinationCity(destinationCity.getText());
        bus.setDepartureTime(departureTime.getText());
        bus.setSeatsAvailable(Integer.parseInt(capacity.getText()));
        bus.setSeatsOccupied(Integer.parseInt(remaining.getText()));
        table.getItems().add(bus);
        busId.clear();
        originCity.clear();
        destinationCity.clear();
        departureTime.clear();
        capacity.clear();
     
       }catch(Exception ex) {
    	   Alert.display("Manage Flight", "Invalid Input please enter correct inputs!");

       }
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