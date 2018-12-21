package com.datacopy.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Props;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable {
	
	@FXML
	AnchorPane testarea;
	@FXML
	Button getQueries;
	@FXML
	Button goBack;
	@FXML
	CheckBox ca4;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void fetchQueries() throws Exception {
		Props p = new Props();
		
		if(ca4.isSelected()) {
			System.out.println("Sucess.....");
			System.out.println(p.getProperties().getProperty("SEED"));
		}
		
	}
	
	public void goBack() {
		
	}

}
