package javafxPractice;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.event.*;

public class Login extends Application {
	
	Stage window;
	
	@Override // Overrides the start method in the Application class
	public void start(Stage primaryStage) {
		try {
			window = primaryStage;
			// Create a pane and set its properties
			GridPane pane = new GridPane();
			pane.setAlignment(Pos.CENTER);
			// Set padding property with an Inset (Top, right, bottom, and left space
			// (inside border of pane))
			pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
			pane.setHgap(20);
			pane.setVgap(30);
			
			Label nameLabel = new Label("Username");
			GridPane.setConstraints(nameLabel, 0, 0);
			
			TextField nameInput = new TextField();
			nameInput.setStyle("-fx-text-fill: green");
			GridPane.setConstraints(nameInput, 1, 0);
			
			Label passLabel = new Label("Password");
			GridPane.setConstraints(passLabel, 0, 1);
			
			TextField passInput = new TextField();
			passInput.setPromptText("Password");
			GridPane.setConstraints(passInput, 1, 1);
			
			Button login = new Button("Log in");
			login.setStyle("-fx-background-radius: 20; -fx-background-color: gold");
			login.setOnAction(e -> {
				String check = "";
				check = nameInput.getText();
				if (check.length() != 0) {
					System.out.println("Welcome");
					window.close();
				}
				else
					System.out.println("Enter a valid name");
			});
			GridPane.setConstraints(login, 1, 2);
			
			pane.getChildren().addAll(nameLabel,nameInput,passLabel,passInput,login);
			
			/**
			
			// Place nodes in the pane
			pane.addColumn(1, new TextField(), new TextField());
			pane.addColumn(0, new Label("Username:"), new Label("Password:"));

			// Add submit button
			Button submitButton = new Button("Login");
			/*
			 * submitButton.setOnAction(new EventHandler<ActionEvent>() {
			 * 
			 * @Override public void handle(ActionEvent event) {
			 * System.out.println("Congratulations!");
			 * 
			 * } });
			 */

			/*
			
			// submitButton.setOnAction(s -> System.out.println("Congratulations!"));
			// or

			submitButton.setOnAction(s -> {
				System.out.println("Congratulations!");
				System.out.println("Check this out, it's so cool!");
			});

			// set button alignment
			pane.add(submitButton, 1, 7);
			GridPane.setHalignment(submitButton, HPos.RIGHT);

			// pane.setPrefHeight(400);
			pane.setPrefSize(1600, 800);

			*/ 
			
			pane.setStyle("-fx-background-color: green; -fx-font-size: 40");
			// Create the scene
			Scene scene = new Scene(pane, 800, 400);
			// set the stage title
			window.setTitle("MyJavaFX");
			// set scene
			window.setScene(scene);
			// Display
			primaryStage.show();

			/**
			 * Create another stage Stage secondStage = new Stage();
			 * secondStage.setTitle("Second Stage"); secondStage.setScene(new Scene(new
			 * Button("TEST"), 800, 400)); secondStage.show();
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
