package com.datacopy.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceDialog;

public class PopUp {
	
	public Alert alert=null;
	public boolean processPermission(String uname, String pass, String port, String host, String sid) {
		
		alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText("Make sure database credentials is correct ?");
		alert.setContentText("Username="+uname+"\n"+"Password="+pass+"\n"+
		"Port="+port+"\n"+"Hostname="+host+"\n"+"SID="+sid);
		alert.showAndWait();
		return true;
		
	}
	
	public void  connectionFail() {
		alert= new Alert (AlertType.ERROR);
		alert.setTitle("Connection Failed");
		alert.setHeaderText("Please check database credentials");
		alert.showAndWait();
		System.exit(0);
	}
	
	public boolean isAcctSec() {
		
		List<String> process = new ArrayList<String>();
		process.add("Account Security Wise");
		process.add("Account Wise");
		
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
			alert.showAndWait();
			throw new Exception();			
		}else if(isAcctSec && secId.trim().isEmpty()){
			alert=new Alert(AlertType.WARNING);
			alert.setTitle("Warning PopUp");
			alert.setHeaderText("Security ID is Emplty ");
			alert.showAndWait();
			throw new Exception();	
			
		}
		return isAcctSec;
		
		
	}
}
