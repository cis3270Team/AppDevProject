package UserInterFace;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AdminPage extends Application {
	Stage window;
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		window=primaryStage;
		//Created a Grid
		GridPane grid =new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		grid.setAlignment(Pos.CENTER);
		//Created a welcome label
		Label welcome= new Label("Welcome to Bus INC ");
		GridPane.setConstraints(welcome, 0,0 );
		//Created a Book Rides Button
		Button book= new Button("Book Rides");
		GridPane.setConstraints(book, 0, 1);
		//Created a available label
		Button available= new Button("All Available Rides");
		GridPane.setConstraints(available, 0,2 );
		//Created a manage trips button
		Button manage= new Button("Manage Trips");
		GridPane.setConstraints(manage, 0,3 );
		//Created password input field
		Button logout= new Button("Logout");
		GridPane.setConstraints(logout, 0,4 );
		//Created a login object
		Login log=new Login();
		logout.setOnAction(e->{
			try {
				//Return to The Login Page
				log.start(window);
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		});
		//Added all labels and buttons to the layout
		grid.getChildren().addAll(welcome,book,available,logout,manage);
		grid.setAlignment(Pos.CENTER);
		Scene scene=new Scene(grid,450,450);
		window.setScene(scene);
		window.show();
	}

	
}