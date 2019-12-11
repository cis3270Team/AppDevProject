package reservation.GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Alert {

	public static void display(String title, String message) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		// Create a Label
		Label label = new Label();
		label.setText(message);
		// Create a Button
		Button closeButton = new Button("Close");
		closeButton.setOnAction(e -> window.close());
		// Create a layout
		VBox layout = new VBox(10);
		// Add a label and Button to the text field
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout,800,400);

		window.setScene(scene);

		window.showAndWait();

	}

	public static void display(String question) {
		Stage window = new Stage();
		window.setTitle("Security question");
		window.setMinWidth(250);
		// Create a Label
		Label label = new Label();
		label.setText(question);
		// Create Text Field answer
		TextField answer = new TextField();
		answer.setPromptText("Answer");
		// Create a Button for confirmation
		Button confirm = new Button("Confirm");
		confirm.setOnAction(e -> {
		
			Alert.display("Forgot Password", "Wrong Answer");
		});
		BusMainMenu main = new BusMainMenu();
		// Created a Button
		Button closeButton = new Button("Close");
		closeButton.setOnAction(e -> {
			try {
				main.start(window);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});
		// Created a layout
		VBox layout = new VBox(10);
		// Added a label and Button to the text field
		layout.getChildren().addAll(label, answer, confirm, closeButton);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout,800,400);

		window.setScene(scene);

		window.showAndWait();

	}
	
}
