package reservation.GUI;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import reservation.util.Menu;

public class Registration extends Application {
	Stage window;

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	
	window = primaryStage;
	window.setTitle("Registration");
	GridPane grid = new GridPane();
	grid.setPadding(new Insets(10, 10, 10, 10));
	grid.setVgap(8);
	grid.setHgap(10);
	grid.setAlignment(Pos.CENTER);
	
	// Create a Registration Label
	// Add Header
	Label headerLabel = new Label("Registration Form");

	headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));

	grid.add(headerLabel, 0, 0, 2, 1);

	GridPane.setHalignment(headerLabel, HPos.CENTER);

	GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));
	// Create a First Name label
	Label firstName = new Label("First Name:");
	GridPane.setConstraints(firstName, 0, 1);
	// Create a First Name Text Field
	TextField fName = new TextField();
	GridPane.setConstraints(fName, 1, 1);
	// Create a Last Name Label
	Label lastName = new Label("Last Name:");
	GridPane.setConstraints(lastName, 0, 2);
	// Create a Last Name Text Field
	TextField lName = new TextField();
	GridPane.setConstraints(lName, 1, 2);
	// Create a Address Label
	Label address = new Label("Address:");
	GridPane.setConstraints(address, 0, 3);
	// Created a Address Text Field
	TextField addressT = new TextField();
	GridPane.setConstraints(addressT, 1, 3);
	// Created a Address Label
	Label zip = new Label("Zip:");
	GridPane.setConstraints(zip, 0, 4);
	// Created a Address Text Field
	TextField zipT = new TextField();
	GridPane.setConstraints(zipT, 1, 4);
	// Created a city Label
	Label city = new Label("City:");
	GridPane.setConstraints(city, 0, 5);
	// Created a City Text Field
	TextField cityT = new TextField();
	GridPane.setConstraints(cityT, 1, 5);
	// Created a State Label
	Label state = new Label("State:");
	GridPane.setConstraints(state, 0, 6);
	// Created a choice box for all 50 states
	ChoiceBox<String> stateT = new ChoiceBox<>();
	stateT.getItems().addAll("Alabama", "Alaska", "American Samoa", "Arizona", "Arkansas", "California", "Colorado",
			"Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia", "Guam", "Hawaii", "Idaho",
			"Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts",
			"Michigan", "Minnesota", "Minor Outlying Islands", "Mississippi", "Missouri", "Montana", "Nebraska",
			"Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota",
			"Northern Mariana Islands", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Puerto Rico", "Rhode Island",
			"South Carolina", "South Dakota", "Tennessee", "Texas", "U.S. Virgin Islands", "Utah", "Vermont",
			"Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming");
	GridPane.setConstraints(stateT, 1, 6);
	// Created a Email Label
	Label email = new Label("Email:");
	GridPane.setConstraints(email, 0, 7);
	// Created a Email Text Field
	TextField emailT = new TextField();
	GridPane.setConstraints(emailT, 1, 7);
	// Created a SSN Label
	Label ssn = new Label("Social Security:");
	GridPane.setConstraints(ssn, 0, 8);
	// Created a SSN Text Field
	TextField ssnT = new TextField();
	GridPane.setConstraints(ssnT, 1, 8);
	// Created a Userame Label
	Label userName = new Label("User Name:");
	GridPane.setConstraints(userName, 0, 9);
	// Created a Userame Text Field
	TextField userNameT = new TextField();
	GridPane.setConstraints(userNameT, 1, 9);
	// Created a password Label
	Label passWord = new Label("Password:");
	GridPane.setConstraints(passWord, 0, 10);
	// Created a password Text Field
	PasswordField passWordT = new PasswordField();
	GridPane.setConstraints(passWordT, 1, 10);

	// Created a choice box for security questions
	ChoiceBox<String> choiceBox = new ChoiceBox<>();
	choiceBox.getItems().addAll("What is your favorite pet's name? ", "Where is your mom from?  ",
			"Where were you born? ", "What is the name of your 2nd grade teacher? ");
	// Created a label for Security Question
	Label securityQuestion = new Label("Security Question");
	GridPane.setConstraints(securityQuestion, 0, 11);
	GridPane.setConstraints(choiceBox, 1, 11);
	// Created a text field for answer
	TextField answer = new TextField();
	answer.setPromptText("Type the Answer");
	GridPane.setConstraints(answer, 3, 11);
	// Created a login Object
	Login login = new Login();
	Button back = new Button("Main Menu");
	BusMainMenu main = new BusMainMenu();
	GridPane.setConstraints(back, 3, 13);
	back.setOnAction(e -> {
		try {
			main.start(window);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	});
	// Created a login Button
	Button loginB = new Button("Submit");
	loginB.setOnAction(e -> {
		String result;
		String[] newUser = {userNameT.getText(),passWordT.getText(),fName.getText(),lName.getText(),
				addressT.getText(),cityT.getText(),
				stateT.getSelectionModel().getSelectedItem(),zipT.getText(),
				emailT.getText(), ssnT.getText(), choiceBox.getSelectionModel().getSelectedItem(),
				answer.getText()};
		
		result=Menu.register(newUser);
		Stage popUp=new Stage();
		popUp.setTitle("Registration Alert");
		Label news= new Label(result);
		Button close=new Button("Close");
		close.setOnAction(f->popUp.close());
		VBox vbox=new VBox();
		vbox.getChildren().addAll(news,close);
		vbox.setAlignment(Pos.CENTER);
		Scene pop=new Scene(vbox,200,50);
		popUp.setScene(pop);
		popUp.show();
	});
	GridPane.setConstraints(loginB, 3, 12);
	// Added all the button,label, and fields to the layout
	grid.getChildren().addAll(firstName, fName, lastName, lName, address, addressT, zip, zipT, city, cityT, state,
			stateT, email, emailT, ssn, ssnT, userName, userNameT, passWord, passWordT, choiceBox, securityQuestion,
			answer, loginB, back);
	Scene sceneRegister = new Scene(grid, 800, 400);
	window.setScene(sceneRegister);
	window.show();

}
	public boolean userInput(TextField a, TextField b, TextField c, TextField d, TextField e, TextField g, TextField i,
			TextField j, TextField k, ChoiceBox<String> f, ChoiceBox<String> h, TextField l) {
		if (a.getText().isEmpty() || b.getText().isEmpty() || c.getText().isEmpty() || d.getText().isEmpty()
				|| f.getSelectionModel().isEmpty() || e.getText().isEmpty() || g.getText().isEmpty()
				|| k.getText().isEmpty() || i.getText().isEmpty() || h.getSelectionModel().isEmpty()
				|| j.getText().isEmpty() || l.getText().isEmpty()) {
			return true;
		}
		return false;

	}

}
