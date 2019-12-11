package reservation.GUI;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class BusMainMenu extends Application {
	Stage window;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Bus Transportation");
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		grid.setAlignment(Pos.CENTER);
		// Create a Main Menu Label
		Label headerLabel = new Label("Main Menu");

		headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));

		grid.add(headerLabel, 0, 0, 2, 1);

		GridPane.setHalignment(headerLabel, HPos.CENTER);

		GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));
		// Create a login button
		Button login = new Button("Login");
		GridPane.setConstraints(login, 0, 1);
		// Create a register button
		Button register = new Button("Register");
		GridPane.setConstraints(register, 1, 1);
		// Create a Login object
		Login loginS = new Login();
		// Create a registration object
		Registration registerS = new Registration();
		login.setOnAction(e -> {
			try {
				// Go to login page
				loginS.start(window);
			} catch (Exception e1) {
				e1.printStackTrace();

			}
		});
		register.setOnAction(e -> {
			try {
				// Go to registration page
				registerS.start(window);
			} catch (Exception e1) {
				e1.printStackTrace();

			}
		});
		grid.getChildren().addAll(login, register);
		Scene sceneRegister = new Scene(grid, 800, 400);
		window.setScene(sceneRegister);
		window.show();
	}

}
