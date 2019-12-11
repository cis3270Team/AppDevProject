package reservation.GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class WelcomePage extends Application {
	Stage window;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		grid.setAlignment(Pos.CENTER);
		// Create a Username label
		Label welcome = new Label("Welcome to Bus INC "+", "+Login.user.getFirstName());
		GridPane.setConstraints(welcome, 0, 0);
		// Create a Username text field
		Button book = new Button("Book Rides");
		GridPane.setConstraints(book, 0, 1);
		book.setOnAction(e -> {
			BookRides a = new BookRides();
			try {
				a.start(window);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		// Create a password label
		Button available = new Button("All Available Rides");
		GridPane.setConstraints(available, 0, 2);
		available.setOnAction(e -> {
			ViewAvailableRides a = new ViewAvailableRides();
			try {
				a.start(window);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});
		// Create password input field
		Button logout = new Button("Logout");
		GridPane.setConstraints(logout, 0, 3);
		Login log = new Login();
		logout.setOnAction(e -> {
			try {
				log.start(window);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		grid.getChildren().addAll(welcome, book, available, logout);
		grid.setAlignment(Pos.CENTER);
		Scene scene = new Scene(grid, 800, 400);
		window.setScene(scene);
		window.show();
	}

}
