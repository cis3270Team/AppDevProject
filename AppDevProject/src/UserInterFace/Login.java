package UserInterFace;
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
	public class Login extends Application {
	Stage window;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window=primaryStage;
		window.setTitle("Yusuf Login Page");
	ForgotPassword passwordScene=new ForgotPassword();
		GridPane grid =new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		grid.setAlignment(Pos.CENTER);
		//Created a Username label
		Label newLabel= new Label("Username:");
		GridPane.setConstraints(newLabel, 0, 1);
		//Created a Username text field
		TextField nameInput= new TextField("");
		nameInput.setPromptText("Username");

		GridPane.setConstraints(nameInput, 1, 1);
		//Created a password label
		Label password= new Label("PassWord");
		GridPane.setConstraints(password, 0, 2);
		//Created password input field
		PasswordField passInput= new PasswordField();
		passInput.setPromptText("Password");
		GridPane.setConstraints(passInput, 1, 2);
		//Created a login button
		Button loginB=new Button("Login");
		GridPane.setConstraints(loginB, 1, 3);
		WelcomePage welcome=new WelcomePage();
		loginB.setOnAction(e->{
			try {
				welcome.start(window);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		//Created a forgot password label
		Label forgotPass=new Label("Forgot your password? ");
		GridPane.setConstraints(forgotPass, 1, 4);
		//Created a forgot button
		Button forgotB=new Button("Forgot");
		forgotB.setOnAction(e-> {
			try {
				passwordScene.start(window);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
		GridPane.setConstraints(forgotB, 1, 5);
		//Created a main menu button
		Button back =new Button("Main Menu");
		GridPane.setConstraints(back, 1, 6);
		BusMainMenu main= new BusMainMenu();
		back.setOnAction(e->{
			try {
				//Will return to main menu
				main.start(window);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		//Added all the button,label, and fields to the layout
		grid.getChildren().addAll(newLabel,nameInput,password,passInput,loginB,forgotPass,forgotB,back);
		Scene scene = new Scene(grid,650,500);
		window.setScene(scene);
		window.show();
	}
		
	}
	

