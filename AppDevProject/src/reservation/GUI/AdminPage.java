package reservation.GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AdminPage extends Application {
	Stage window;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		// Create a Grid
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		grid.setAlignment(Pos.CENTER);
		// Create a welcome label
		Label welcome = new Label(Login.user.getUserName() + ", welcome to Bus INC administrative portal");
		GridPane.setConstraints(welcome, 0, 0);
		// Create a Book Rides Button
		Button book = new Button("Book Rides");
		GridPane.setConstraints(book, 0, 1);
		book.setOnAction(e->{
			BookRides a=new BookRides();
			try {
				a.start(window);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		// Create a button for "All available rides"
		Button available = new Button("All Available Rides");
		GridPane.setConstraints(available, 0, 2);
		available.setOnAction(e -> {
			ViewAvailableRides a = new ViewAvailableRides();
			try {
				a.start(window);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		// Created a manage trips button
		Button manage = new Button("Manage Trips");
		GridPane.setConstraints(manage, 0, 3);
		manage.setOnAction(e -> {
			ManageRides admin = new ManageRides();
			try {
				admin.start(window);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		// Created password input field
		Button logout = new Button("Logout");
		GridPane.setConstraints(logout, 0, 4);
		// Created a login object
		Login log = new Login();
		logout.setOnAction(e -> {
			try {
				// Return to The Login Page
				log.start(window);
			} catch (Exception e1) {

				e1.printStackTrace();
			}
		});

		// Add all labels and buttons to the layout
		grid.getChildren().addAll(welcome, book, available, logout, manage);
		grid.setAlignment(Pos.CENTER);
		Scene scene = new Scene(grid, 800, 400);
		window.setScene(scene);
		window.show();
	}

}