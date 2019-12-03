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

public class Welcome extends Application {
	
	Stage window;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		window = primaryStage;
		window.setTitle("Welcome!");
		
		//TextField and Labels
		TextField userInput = new TextField();
		userInput.setMaxWidth(500);
		Label firstLabel = new Label("Welcome, ");
		Label secondLabel = new Label();
		
		HBox bottomText = new HBox(firstLabel,secondLabel);
		bottomText.setAlignment(Pos.CENTER);
		
		VBox welcomeMsg = new VBox(10, userInput, bottomText);
		welcomeMsg.setAlignment(Pos.CENTER);
		
		secondLabel.textProperty().bind(userInput.textProperty());
		
		welcomeMsg.setStyle("-fx-background-color: green; -fx-font-size: 40");
		// Create the scene
		Scene scene = new Scene(welcomeMsg, 800, 400);
		// set the stage title
		window.setTitle("MyJavaFX");
		// set scene
		window.setScene(scene);
		// Display
		primaryStage.show();
		
	}

}
