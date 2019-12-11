package reservation.GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import reservation.util.Admin;
import reservation.util.Check;
import reservation.util.Customer;
import reservation.util.Menu;
import reservation.util.User;

public class Login extends Application {
	Stage window;
	static User user;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Bus Login Page");
		ForgotPassword passwordScene = new ForgotPassword();
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		grid.setAlignment(Pos.CENTER);
		// Created a Username label
		Label newLabel = new Label("Username:");
		GridPane.setConstraints(newLabel, 0, 1);
		// Created a Username text field
		TextField nameInput = new TextField("");
		nameInput.setPromptText("Username");

		GridPane.setConstraints(nameInput, 1, 1);
		// Created a password label
		Label password = new Label("PassWord");
		GridPane.setConstraints(password, 0, 2);
		// Create password input field
		PasswordField passInput = new PasswordField();
		passInput.setPromptText("Password");
		GridPane.setConstraints(passInput, 1, 2);
		// Create a login button
		Button loginB = new Button("Login");
		GridPane.setConstraints(loginB, 1, 3);
		WelcomePage welcome = new WelcomePage();
		loginB.setOnAction(e -> {
			try {
				if (Check.isValidUser(nameInput.getText(), passInput.getText())) {
						user = Menu.login(nameInput.getText(), passInput.getText());
					}
					
					//Create a string to receive response from user's actions
					String response = "";
					
					// check if user is an admin
					if (Check.isValidUser(nameInput.getText(),passInput.getText()) 
							&& (user instanceof Admin)) {
						AdminPage ad=new AdminPage();
						ad.start(window);
					}
					else if (Check.isValidUser(nameInput.getText(),passInput.getText()) 
						&& (user instanceof Customer)) {
					welcome.start(window);
			}else {
				Alert.display("Error","Invalid Username or Password");
			}
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		// Create a forgot password label
		Label forgotPass = new Label("Forgot your password? ");
		GridPane.setConstraints(forgotPass, 1, 4);
		// Create a forgot button
		Button forgotB = new Button("Forgot");
		forgotB.setOnAction(e -> {
			try {
				passwordScene.start(window);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		});
		GridPane.setConstraints(forgotB, 1, 5);
		// Create a main menu button
		Button back = new Button("Main Menu");
		GridPane.setConstraints(back, 1, 6);
		BusMainMenu main = new BusMainMenu();
		back.setOnAction(e -> {
			try {
				// Will return to main menu
				main.start(window);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		// Add all the button,label, and fields to the layout
		grid.getChildren().addAll(newLabel, nameInput, password, passInput, loginB, forgotPass, forgotB, back);
		Scene scene = new Scene(grid, 800, 400);
		window.setScene(scene);
		window.show();
	}

}
