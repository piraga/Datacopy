package com.datacopy.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import com.datacopy.application.Main;
import com.datacopy.application.PopUp;
import com.datacopy.dao.DataManager;
import com.datacopy.process.TempFile;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
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
	@FXML 
	ListView listView;
	
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
		
//		listView = new ListView<String>(FXCollections.observableArrayList(
//				"Item 1", "Item 2", "Item 3", "Item 4"));
		
		
		listView.getItems().addAll(loadProperties());
		
		
	}
	
	
	
	
	public void connectDatabase() throws Exception {
		connectdb.setDisable(true);
		try {
			
		boolean process=popUp.processPermission(username.getText(), password.getText(), portnumber.getText(), 
				hostname.getText(), sid.getText(),sname.getText());
		if(process && sname.getText().equalsIgnoreCase("")) {
			db.connectDb(username.getText(), password.getText(), sid.getText(), hostname.getText(), portnumber.getText());
			main.changeScene();
		}else if(process){
			db.connectSnameDb(username.getText(), password.getText(), sname.getText(), hostname.getText(), portnumber.getText());
			main.changeScene();
		}
	
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Caught");
		}
		
		System.out.println("Hai"+sid.getText()+username.getText()+password.getText()+hostname.getText()+portnumber.getText()+sid.getText());
		connectdb.setDisable(false);
	}
	
	
	public void saveDetails() {
		
		Properties prop = TempFile.loadDbProp();
		String propKey = dbName.getText();
		String propValue = username.getText() + "->" + password.getText() + "->"+hostname.getText()
		+"->"+ sid.getText()+"->"+sname.getText()+"->"+portnumber.getText();
		prop.setProperty(propKey, propValue);
		System.out.println(dbName.getText()+"  "+username.getText() + "   " + password.getText() +"  " + portnumber.getText() + 
			"  "  +	hostname.getText() + "  " + sid.getText() + "   " +sname.getText());
		
		try {
			TempFile.saveProperties(prop);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tempFile.saveToProp(dbName.getText(),username.getText(), password.getText(), portnumber.getText(), 
				hostname.getText(), sid.getText(),sname.getText());
		listView.getItems().clear();
		listView.getItems().addAll(loadProperties());
		
	}
	
	public void loadDetails() {

		
		System.out.println(listView.getSelectionModel().getSelectedItem());
		String selected =(String) listView.getSelectionModel().getSelectedItem();
		System.out.println(selected);
		Properties prop = TempFile.loadDbProp();
		System.out.println(prop.getProperty(selected));
		String propValue = prop.getProperty(selected);
		String[] setters = propValue.split("->");
		
		
		System.out.println(setters[0]+setters[1]+setters[2]+setters[3]+setters[4]+setters[5]);
		

		dbName.setText(selected);
		username.setText(setters[0]);
		password.setText(setters[1]);
		hostname.setText(setters[2]);
		sid.setText(setters[3]);
		sname.setText(setters[4]);
		portnumber.setText(setters[5]);
		
		
		
		
	}

	public void deleteDetails() {
		Properties prop = TempFile.loadDbProp();
		System.out.println(listView.getSelectionModel().getSelectedItem());
		String selected =(String) listView.getSelectionModel().getSelectedItem();
		prop.remove(selected);
		try {
			TempFile.saveProperties(prop);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listView.getItems().clear();
		listView.getItems().addAll(loadProperties());
	}
	
	public static ArrayList<String> loadProperties() {
		
		
		Properties prop = TempFile.loadDbProp();
		ArrayList<String> al =new ArrayList<String>();
		Set<Object> keys = prop.keySet();
		for(Object k:keys){
            String key = (String)k;
            al.add(key);

        }
		
		Collections.reverse(al);
		
		
		return al;
	}
	
	

}
