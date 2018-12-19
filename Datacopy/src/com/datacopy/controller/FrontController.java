package com.datacopy.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
