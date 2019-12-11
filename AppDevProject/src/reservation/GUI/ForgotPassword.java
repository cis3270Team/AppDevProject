package reservation.GUI;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import reservation.util.Check;
import reservation.util.Menu;

public class ForgotPassword extends Application {

	Stage window;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Forgot Password");
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(5);
		grid.setAlignment(Pos.CENTER);
		// Username Label
		Label newLabel = new Label("Username:");
		GridPane.setConstraints(newLabel, 0, 0);
		// Username text field
		TextField nameInput = new TextField();
		nameInput.setPromptText("Username");
		GridPane.setConstraints(nameInput, 1, 0);

		// Create a complete button
		Button complete = new Button("Confirm");
		GridPane.setConstraints(complete, 0, 1);
		Button login = new Button("Back");		
		GridPane.setConstraints(login, 1, 1);
		
		login.setOnAction(e->{
			Login a=new Login();
			try {
				a.start(window);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		complete.setOnAction(e -> {
			if(Check.usernameExists(nameInput.getText())) {
			
			String[] query = Menu.forgotPassword(nameInput.getText());
			if (query.length == 3) {
				//query[0] contains the security question
				//query[1] contains the security answer
				//query[2] contains the password
				//All strings
				Stage stage=new Stage();
				Label question= new Label(query[0]);
				TextField answer= new TextField();
				answer.setPromptText("Answer");
				Button confirm= new Button("Confirm");
				confirm.setOnAction(f->{
					if(answer.getText().equals(query[1])) {
						
						Alert.display("Forgot Password",query[2] );
						
					}
					if(!answer.getText().equals(query[1])) {
						
						Alert.display("Forgot Password","Invalid Answer" );
						
					}
					
					
				});
				VBox layout=new VBox();
				layout.getChildren().addAll(question,answer,confirm);
				Scene passwordScene=new Scene(layout,200,100);
				stage.setScene(passwordScene);
				stage.show();
				
			}
		}if(!Check.usernameExists(nameInput.getText())) {
			Alert.display("Forgot Password", "Username Doesn't Exist");
		}
			});
		// Create a login button
		

		grid.getChildren().addAll(newLabel, nameInput, complete, login);

		Scene scene = new Scene(grid, 800, 400);
		window.setScene(scene);
		window.show();
	}


}
