package UserInterFace;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
public class MainPage extends Application {
	Stage window;
	BorderPane layout;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window= primaryStage;
		window.setTitle("Bus Transportation");
		GridPane grid =new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		Label newLabel= new Label("Hello welcome back");
		GridPane.setConstraints(newLabel, 0, 0);
		
		TextField nameInput= new TextField("Yomar813");
		GridPane.setConstraints(nameInput, 1, 0);
		
		Label password= new Label("PassWord");
		GridPane.setConstraints(password, 0, 1);
		
		TextField passInput= new TextField();
		passInput.setPromptText("Password");
		GridPane.setConstraints(passInput, 1, 1);
		
		Button loginB=new Button("Login");
		GridPane.setConstraints(loginB, 1, 2);
		
		grid.getChildren().addAll(newLabel,nameInput,password,passInput,loginB);
		
		//Book Menu
		Menu bookMenu= new Menu("Book");
		MenuItem addTrip= new MenuItem("Add Trip");
	
		
		bookMenu.getItems().add(addTrip);
		
		//My Trips Menu
		Menu trips= new Menu("My Trips");
		MenuItem viewTrip= new MenuItem("View");
		MenuItem removeTrip= new MenuItem("Remove");
		
		trips.getItems().add(viewTrip);
		trips.getItems().add(removeTrip);
        HBox lay=new HBox();
        
		Button logout=new Button("Logout");
		lay.getChildren().add(logout);
		lay.setAlignment(Pos.BOTTOM_LEFT);
	
		
	
		
		MenuBar menuBar= new MenuBar();
		menuBar.getMenus().addAll(bookMenu,trips);
		
		layout = new  BorderPane();
		layout.setTop(menuBar);
		layout.setCenter(grid);
		Scene scene=new Scene(layout,650,650);
		window.setScene(scene);
		window.show();
		layout.setLeft(lay);

	}

}
