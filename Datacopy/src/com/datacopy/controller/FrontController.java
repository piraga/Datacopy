package com.datacopy.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FrontController  implements Initializable {
	
	@FXML
	Button connectdb;
	@FXML
	TextField username = new TextField();
	@FXML
	TextField hostname = new TextField();
	@FXML
	TextField portnumber = new TextField();
	@FXML
	TextField sid = new TextField();
	@FXML
	TextField password = new TextField();
	
	Main main = new Main();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void connectDatabase() {
		connectdb.setDisable(true);
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText("Make sure database credentials is correct ?");
		alert.setContentText("Username:"+username.getText()+" "+"Password:"+password.getText()+" "+
		"Port"+portnumber.getText()+" "+"Hostname"+hostname.getText()+" "+sid.getText());
		try {
			main.changeScene();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Hai"+sid.getText()+username.getText()+hostname.getText()+portnumber.getText()+sid.getText());
		connectdb.setDisable(false);
	}
	
	

}
