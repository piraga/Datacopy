package com.datacopy.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.datacopy.application.Main;
import com.datacopy.application.PopUp;
import com.datacopy.application.Props;
import com.datacopy.process.DataCopy;
import com.datacopy.process.FetchAcct;
import com.datacopy.process.FetchAcctSec;
import com.datacopy.process.FetchTables;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable {
	
	
	@FXML
	Button getQueries,goBack;
	@FXML
	CheckBox sviRad,sviSeed,sviTrd,sviCli,accountMaster,secMaster,caAcctSec,caPayout,caTerms,caBroker,
	corpAct,hpsMaster,hpsDetail,stepUp;
	@FXML
	TextField acctid,secid;
	@FXML
	TextArea textarea = new TextArea();
	
	private boolean isAcctSec;
	private String acctId;
	private String secId;
	
	Main main = new Main();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		acctid.setText("2-37-1-10074996");
		secid.setText("2-2689615");
	}
	
	public void fetchQueries() throws Exception {
		Props p = new Props();
		acctId=acctid.getText();
		secId = secid.getText();
		textarea.setText("Welcome");
		PopUp popUp = new PopUp();
		DataCopy proc = null;
//		textarea.appendText("\"12364541");
		try {
//			textarea.appendText("\"12364541");
			isAcctSec=popUp.initialValidation(acctId, secId);
//			textarea.appendText("\"12364541");
			if(isAcctSec) {
				proc=new FetchAcctSec(acctId,secId,sviRad.isSelected(), sviSeed.isSelected(), sviTrd.isSelected(),
						sviCli.isSelected(), accountMaster.isSelected(), secMaster.isSelected(),
						caAcctSec.isSelected(), caPayout.isSelected(), caTerms.isSelected(),
						caBroker.isSelected(), corpAct.isSelected(),
						hpsMaster.isSelected(), hpsDetail.isSelected(), stepUp.isSelected(),textarea);
			}else {
				proc=new FetchAcct(acctId,sviRad.isSelected(), sviSeed.isSelected(), sviTrd.isSelected(),
						sviCli.isSelected(), accountMaster.isSelected(), secMaster.isSelected(),
						caAcctSec.isSelected(), caPayout.isSelected(), caTerms.isSelected(),
						caBroker.isSelected(), corpAct.isSelected(),
						hpsMaster.isSelected(), hpsDetail.isSelected(), stepUp.isSelected(),textarea);
			}
			
		} catch (Exception e) {
			System.out.println("Catch block");
		}
		proc.processDataCopy();
		System.out.println(acctid.getText()+secid.getText());
		
	}
	
	public void goBack() {
		
		try {
			main.goPrevious();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void setTextDisplay(String qeury) {
		
		try {
			textarea.setText(qeury);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}
