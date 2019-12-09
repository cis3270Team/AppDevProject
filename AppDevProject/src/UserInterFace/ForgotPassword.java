package UserInterFace;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ForgotPassword extends Application {

	Stage window;
	
	
	public static void main(String[] args) {
		launch(args);
		
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		window=primaryStage;
		window.setTitle("Forgot Password");
		GridPane grid =new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(5);
		grid.setAlignment(Pos.CENTER);
		//Username Label
		Label newLabel= new Label("Username:");
		GridPane.setConstraints(newLabel, 0, 0);
		//Username text field
		TextField nameInput= new TextField();
		nameInput.setPromptText("Username");
		GridPane.setConstraints(nameInput, 1, 0);

		//Created a complete button
		Button complete= new Button("Confirm");
		GridPane.setConstraints(complete, 0, 1);
		complete.setOnAction(e->{
			try{
				getSecurityQuestion(nameInput.getText(),window);
			}catch(Exception ex) {
				
			}
		});
		//Created a login button
		Button login= new Button("Main Menu");
		GridPane.setConstraints(login, 1,1);
		//Created a bus main menu object
		BusMainMenu main=new BusMainMenu();
		login.setOnAction(e->{
			try {
				//Return to the main menu page
				main.start(window);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		grid.getChildren().addAll(newLabel,nameInput,complete,login);

		Scene scene = new Scene(grid,350,350);
		window.setScene(scene);
		window.show();		
	}
	public void getSecurityQuestion(String userName,Stage window) {
		 Alert.display("When was you born?",window);
	}

}
