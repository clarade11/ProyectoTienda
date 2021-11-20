package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Tienda extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		//conexion con fxml base
		
		Pane pane = (Pane)FXMLLoader.load(getClass().getResource("Inicio.fxml"));
		Scene scene = new Scene(pane);
		
		scene.getStylesheets().addAll(this.getClass().getResource("inicio.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Akkala");
		primaryStage.show();
		
	}
}
