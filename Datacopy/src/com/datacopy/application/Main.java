package com.datacopy.application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	
	@FXML
	 static Stage prev;
	
	Parent prevroot;
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass()
                    .getResource("FrontDesign.fxml"));
			primaryStage.setTitle("Datacopy 19.1");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			prev=primaryStage;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void changeScene() throws IOException {
		
//		Parent pane=FXMLLoader.load(getClass()
//                .getResource("FrontDesign.fxml"));
//		stage.setScene(new Scene(pane));
//		
//		stage.show();
		
		Stage stage = new Stage();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainDesign.fxml"));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
        prev.close();
        prev=stage;
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
