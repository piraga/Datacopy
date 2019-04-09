package com.datacopy.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.datacopy.application.Main;
import com.datacopy.application.PopUp;
import com.datacopy.dao.DataManager;
import com.datacopy.process.TempFile;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
	@FXML
	TextField sname = new TextField();
	@FXML
	TextField dbName= new TextField();
	@FXML
	Button saveDetails;
	@FXML
	Button loadDetails;
	@FXML
	Button deleteDetails;
	
	TempFile tempFile; 
	Main main = new Main();
	PopUp popUp=new PopUp();
	DataManager db = new DataManager();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		sid.setFocusTraversable(false);// TO disable cursor from automatic pointing to text field
//		username.setText("username");
//		password.setText("Password");
//		hostname.setText("Hostname");
//		portnumber.setText("1521");
//		sid.setText("SID");
		this.tempFile = new TempFile(); 
	}
	
	public void connectDatabase() {
		connectdb.setDisable(true);
		try {
			
		boolean process=popUp.processPermission(username.getText(), password.getText(), portnumber.getText(), 
				hostname.getText(), sid.getText(),sname.getText());
		if(process && sname.getText().equalsIgnoreCase("")) {
			db.connectDb(username.getText(), password.getText(), sid.getText(), hostname.getText(), portnumber.getText());
		}else {
			db.connectSnameDb(username.getText(), password.getText(), sname.getText(), hostname.getText(), portnumber.getText());
		}
	
		
		main.changeScene();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Hai"+sid.getText()+username.getText()+password.getText()+hostname.getText()+portnumber.getText()+sid.getText());
		connectdb.setDisable(false);
	}
	
	
	public void saveDetails() {
		
		tempFile.saveToProp(dbName.getText(),username.getText(), password.getText(), portnumber.getText(), 
				hostname.getText(), sid.getText(),sname.getText());
		
	}
	
	public void loadDetails() {
		
	}

	public void deleteDetails() {
	
	}
	
	

}
