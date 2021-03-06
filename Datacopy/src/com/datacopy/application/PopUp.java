package com.datacopy.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class PopUp {
	
	public Alert alert=null;
	public Stage stage;
	public boolean processPermission(String uname, String pass, String port, String host, String sid,String sname) {
		
		alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText("Make sure database credentials is correct ?");
		stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("logo.png")); // To add an icon
		
		alert.setContentText("Username="+uname+"\n"+"Password="+pass+"\n"+
		"Port="+port+"\n"+"Hostname="+host+"\n"+"SID="+sid+"\n"+"ServiceName="+sname);
		
		 Optional<ButtonType> result = alert.showAndWait();
		 if (result.isPresent() && result.get() == ButtonType.OK) {
			 return true;
		 }
//		alert.showAndWait();
		return false;
		
	}
	
	public void  connectionFail() {
		alert= new Alert (AlertType.ERROR);
		alert.setTitle("Connection Failed");
		alert.setHeaderText("Please check database credentials");
		stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("logo.png")); // To add an icon
		alert.showAndWait();
		
	}
	
	public void exportPopUp(String location) {
		alert= new Alert (AlertType.INFORMATION);
		alert.setTitle("ExportFile Loaction");
		alert.setHeaderText("File Location: ");
		stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("logo.png")); // To add an icon
		alert.setContentText(location);
		alert.showAndWait();
	}
	
	public boolean isAcctSec() {
		
		List<String> process = new ArrayList<String>();
		process.add("Account Security Wise");
//		process.add("Account Wise");
		
		ChoiceDialog<String> choice = new ChoiceDialog<String>("Account Security Wise",process);
		choice.setTitle("Datacopy Choices");
		choice.setHeaderText("Pick any one choice");
		choice.setContentText("Choose your wish");
		Optional<String> selection=choice.showAndWait();
		System.out.println(selection.get());
		if (selection.get().equalsIgnoreCase("Account Security Wise"))
			return true;
		System.out.println(selection);
		return false;
		
	}
	
	public boolean initialValidation(String acctId, String secId) throws Exception {
		boolean isAcctSec;
		Main main = new Main();
		PopUp popUp = new PopUp();
		isAcctSec=popUp.isAcctSec();
		if( acctId.trim().isEmpty() ) {
			alert=new Alert(AlertType.WARNING);
			alert.setTitle("Warning PopUp");
			alert.setHeaderText("Account ID is Emplty ");
			stage = (Stage) alert.getDialogPane().getScene().getWindow();
			stage.getIcons().add(new Image("logo.png")); // To add an icon
			alert.showAndWait();
			throw new Exception();			
		}else if(isAcctSec && secId.trim().isEmpty()){
			alert=new Alert(AlertType.WARNING);
			alert.setTitle("Warning PopUp");
			alert.setHeaderText("Security ID is Emplty ");
			stage = (Stage) alert.getDialogPane().getScene().getWindow();
			stage.getIcons().add(new Image("logo.png")); // To add an icon
			alert.showAndWait();
			throw new Exception();	
			
		}
		return isAcctSec;
		
		
	}
}
