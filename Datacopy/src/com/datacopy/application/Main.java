package com.datacopy.application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
//			primaryStage.resizableProperty().setValue(Boolean.FALSE);//Disable maximize icon
			primaryStage.getIcons().add(new Image("file:Datacopy/logo.png"));
//			primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("/Properties/Datacopy_logo.png")));
			primaryStage.setTitle("LazyCopy");
			primaryStage.setScene(new Scene(root));
			
			primaryStage.show();
			prev=primaryStage;
			
//			new Image("/Properties/Datacopy_icon.png")
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void changeScene() throws IOException {
		
	
		Stage stage = new Stage();
		Parent pane = FXMLLoader.load(getClass().getResource("MainDesign.fxml"));
//		stage.resizableProperty().setValue(Boolean.FALSE);//Disable maximize icon
        Scene scene = new Scene(pane);
        prev.setScene(scene);
        prev.show();
//        prev.close();
//        prev=stage;
		
		
	}
	
	@FXML
	public void goPrevious() throws Exception {
		
		Stage stage = new Stage();
        Parent pane = FXMLLoader.load(getClass().getResource("FrontDesign.fxml"));
        Scene scene = new Scene(pane);
//        prev.close();
        prev.setScene(scene);
//        stage.resizableProperty().setValue(Boolean.FALSE);//Disable maximize icon
        prev.show();
        
//        prev=stage;
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
