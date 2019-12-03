package UserInterFace;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
public class Main extends Application {
	Stage window;
	public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		window =primaryStage;
		returnMainMenu();
		
	}

	public void registerScene() {
		window.setTitle("Registration");
		GridPane grid =new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		grid.setAlignment(Pos.CENTER);
		Label firstName = new Label("First Name:");
		GridPane.setConstraints(firstName, 0, 0);
		
		TextField fName= new TextField();
		GridPane.setConstraints(fName, 1, 0);
		
		Label lastName= new Label("Last Name:");
		GridPane.setConstraints(lastName, 0, 1);
		
		TextField lName= new TextField();
		GridPane.setConstraints(lName, 1, 1);
		
		Label address = new Label("Address:");
		GridPane.setConstraints(address, 0, 2);
		
		TextField addressT= new TextField();
		GridPane.setConstraints(addressT, 1, 2);
		
		Label city= new Label("City:");
		GridPane.setConstraints(city, 0, 3);
		
		TextField cityT= new TextField();
		GridPane.setConstraints(cityT, 1, 3);
		Label state = new Label("State:");
		GridPane.setConstraints(state, 0, 4);
		
		ChoiceBox<String> stateT= new ChoiceBox<>();
		stateT.getItems().addAll("Alabama", "Alaska", "American Samoa", "Arizona", "Arkansas", "California", "Colorado", 
		"Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia", "Guam", "Hawaii", "Idaho", "Illinois",
		"Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota",
		"Minor Outlying Islands", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey",
		"New Mexico", "New York", "North Carolina", 
		"North Dakota", "Northern Mariana Islands", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", 
		"Puerto Rico", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "U.S. Virgin Islands", "Utah",
		"Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming");
		GridPane.setConstraints(stateT, 1, 4);
		
		Label email= new Label("Email:");
		GridPane.setConstraints(email, 0, 5);
		
		TextField emailT= new TextField();
		GridPane.setConstraints(emailT, 1, 5);
		
		Label ssn= new Label("Social Security:");
		GridPane.setConstraints(ssn, 0, 6);
		
		TextField ssnT= new TextField();
		GridPane.setConstraints(ssnT, 1, 6);
		
		Label userName = new Label("User Name:");
		GridPane.setConstraints(userName, 0, 7);
		
		TextField userNameT= new TextField();
		GridPane.setConstraints(userNameT, 1, 7);
		
		Label passWord= new Label("Password:");
		GridPane.setConstraints(passWord, 0, 8);
		
		PasswordField passWordT= new PasswordField();
		GridPane.setConstraints(passWordT, 1, 8);
		
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		choiceBox.getItems().addAll("1. What is your favorite pet's name? ",
						"2. Where is your mom from?  ",
						"3. Where were you born? ",
						"4. What is the name of your 2nd grade teacher? ");
		Label securityQuestion= new Label("Security Question");
		GridPane.setConstraints(securityQuestion, 0, 9);
		GridPane.setConstraints(choiceBox, 1, 9);
		TextField answer= new TextField();
		answer.setPromptText("Type the Answer");
		GridPane.setConstraints(answer, 2, 9);

		


		
		
		Button loginB=new Button("Complete");
		loginB.setOnAction(e->returnMainMenu());
		GridPane.setConstraints(loginB, 1, 10);
		
		grid.getChildren().addAll(firstName,fName,lastName,lName,address,addressT,city,cityT,state,stateT,email,emailT,ssn,ssnT,userName,userNameT,passWord,passWordT,choiceBox,securityQuestion,answer,loginB);
		Scene sceneRegister = new Scene(grid,650,500);
		window.setScene(sceneRegister);
			
		
	}
	
	public void returnMainMenu() {
		window.setTitle("Main Menu");
        Button loginB=new Button("Login");
		loginB.setOnAction(e-> loginScene());
		Button registerB=new Button("Register");
		
		registerB.setOnAction(e->{
			registerScene();
		});

		FlowPane layout =new FlowPane();
		layout.setHgap(10);
		layout.getChildren().addAll(loginB,registerB);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout,650,500);
		window.setScene(scene);
		window.show();
	}
	public void loginScene() {
window.setTitle("Yusuf Login Page");
		
		GridPane grid =new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		grid.setAlignment(Pos.CENTER);
		
		Label newLabel= new Label("Username:");
		GridPane.setConstraints(newLabel, 0, 0);
		
		TextField nameInput= new TextField("UserName");
		GridPane.setConstraints(nameInput, 1, 0);
		
		Label password= new Label("PassWord");
		GridPane.setConstraints(password, 0, 1);
		
		PasswordField passInput= new PasswordField();
		passInput.setPromptText("Password");
		GridPane.setConstraints(passInput, 1, 1);
		
		Button loginB=new Button("Login");
		GridPane.setConstraints(loginB, 1, 2);
		
		Label forgotPass=new Label("Forgot your password? ");
		GridPane.setConstraints(forgotPass, 1, 3);
		Button forgotB=new Button("Forgot");
		forgotB.setOnAction(e-> returnForgotPassword());
		GridPane.setConstraints(forgotB, 1, 4);
		
		grid.getChildren().addAll(newLabel,nameInput,password,passInput,loginB,forgotPass,forgotB);
		Scene scene = new Scene(grid,650,500);
		window.setScene(scene);
		window.show();
	}
	public void returnForgotPassword() {
		window.setTitle("Forgot Password");
		GridPane grid =new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		grid.setAlignment(Pos.CENTER);
		
		Label newLabel= new Label("Username:");
		GridPane.setConstraints(newLabel, 0, 0);
		
		TextField nameInput= new TextField();
		GridPane.setConstraints(nameInput, 1, 0);
		
		Label emailLabel= new Label("Email:");
		GridPane.setConstraints(emailLabel, 0, 1);
		
		TextField emailInput= new TextField();
		GridPane.setConstraints(emailInput, 1, 1);
		
		Button complete= new Button("Confirm");
		GridPane.setConstraints(complete, 1, 2);
		
		grid.getChildren().addAll(newLabel,nameInput,emailLabel,emailInput,complete);

		Scene scene = new Scene(grid,650,500);
		window.setScene(scene);
		window.show();
		
		
	}
}