package UserInterFace;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Alert {
	
	public static void display(String title, String message) {
		Stage window = new Stage();	
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);	
		//Created a Label
		Label label = new Label();
		label.setText(message);
		//Created a Button
		Button closeButton = new Button("Close");
		closeButton.setOnAction(e -> window.close());	
		//Created a layout
		VBox layout = new VBox(10);
		//Added a label and Button to the text field
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout);

		window.setScene(scene);

		window.showAndWait();

	}

}

