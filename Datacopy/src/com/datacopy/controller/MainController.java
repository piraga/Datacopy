package com.datacopy.controller;

import java.awt.List;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;

import com.datacopy.application.Main;
import com.datacopy.application.PopUp;
import com.datacopy.application.Props;
import com.datacopy.process.DataCopy;
import com.datacopy.process.DeleteProcess;
import com.datacopy.process.FetchAcct;
import com.datacopy.process.FetchAcctSec;
import com.datacopy.process.FetchTables;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable {
	
	
	@FXML
	Button getQueries,goBack,getDeleteQueries,generateSqlFile,getRelatedAccts;
	@FXML
	CheckBox sviRad,sviSeed,sviTrd,sviCli,accountMaster,secMaster,caAcctSec,caPayout,caTerms,caBroker,
	corpAct,hpsMaster,hpsDetail,stepUp,vpTransaction,selectAll;
	@FXML
	TextField acctid,secid,clientid,boid,firmno,subno;
	@FXML
	TextArea textarea = new TextArea();
	
	private boolean isAcctSec;
	private String acctId;
	private String secId;
	private String clientId;
	private String boId;
	private String firmNo;
	private String subNo;
	
	
	Main main = new Main();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
//		
		acctid.setText("2-37-1-46267937");
		secid.setText("2-3244965");
		
//		2-37-1-46267937	2-3244965


	}
	
	public void selectAll() {
		
		if(selectAll.isSelected()) {
			sviRad.setSelected(true);
			sviSeed.setSelected(true);
			sviTrd.setSelected(true);
			sviCli.setSelected(true);
			accountMaster.setSelected(true);
			secMaster.setSelected(true);
			caAcctSec.setSelected(true);
			caPayout.setSelected(true);
			caTerms.setSelected(true);
			caBroker.setSelected(true);
			corpAct.setSelected(true);
			hpsMaster.setSelected(true);
			hpsDetail.setSelected(true);
			stepUp.setSelected(true);
			vpTransaction.setSelected(true);
			
			
		}else {
			sviRad.setSelected(false);
			sviSeed.setSelected(false);
			sviTrd.setSelected(false);
			sviCli.setSelected(false);
			accountMaster.setSelected(false);
			secMaster.setSelected(false);
			caAcctSec.setSelected(false);
			caPayout.setSelected(false);
			caTerms.setSelected(false);
			caBroker.setSelected(false);
			corpAct.setSelected(false);
			hpsMaster.setSelected(false);
			hpsDetail.setSelected(false);
			stepUp.setSelected(false);
			vpTransaction.setSelected(false);
		}
		
	}
	
	public void fetchQueries() throws Exception {
		Props p = new Props();
		acctId=acctid.getText();
		secId = secid.getText();
		clientId=clientid.getText();
		boId=boid.getText();
		firmNo=firmno.getText();
		subNo=subno.getText();
//		textarea.setText("Welcome");
		PopUp popUp = new PopUp();
		DataCopy proc = null;
		
		
		try {
//			isAcctSec=popUp.initialValidation(acctId, secId);
//			if(isAcctSec) {
				proc=new FetchAcctSec(clientId,boId,firmNo,subNo,acctId,secId,sviRad.isSelected(), sviSeed.isSelected(), sviTrd.isSelected(),
						sviCli.isSelected(), accountMaster.isSelected(), secMaster.isSelected(),
						caAcctSec.isSelected(), caPayout.isSelected(), caTerms.isSelected(),
						caBroker.isSelected(), corpAct.isSelected(),
						hpsMaster.isSelected(), hpsDetail.isSelected(), stepUp.isSelected(),textarea,vpTransaction.isSelected(),false);
//			}else {   ***ACCOUNT_LEVEL_PROCESS**
//				proc=new FetchAcct(acctId,secId,sviRad.isSelected(), sviSeed.isSelected(), sviTrd.isSelected(),
//						sviCli.isSelected(), accountMaster.isSelected(), secMaster.isSelected(),
//						caAcctSec.isSelected(), caPayout.isSelected(), caTerms.isSelected(),
//						caBroker.isSelected(), corpAct.isSelected(),
//						hpsMaster.isSelected(), hpsDetail.isSelected(), stepUp.isSelected(),textarea,vpTransaction.isSelected(),false);
//			}
//				Thread t1 = new Thread(proc);
//				t1.start();
//				t1.join();
			
		} catch (Exception e) {
			System.out.println("Catch block");
		}
//		disableButton();
		proc.processDataCopy();
//		enableButton();
		if(!clientId.isEmpty()&& !boId.isEmpty() && !firmNo.isEmpty() && !subNo.isEmpty() && !acctId.isEmpty() && !secId.isEmpty())  {
//			prepare_Update_Query(clientId,boId,firmNo,subNo,acctId,secId,p);
			System.out.println("Innnnnnnnnnnnnnnnnnn");
		}
		
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
	
	public void getRelatedAccts(){
		acctId=acctid.getText();
		secId = secid.getText();
		clientId=clientid.getText();
		boId=boid.getText();
		firmNo=firmno.getText();
		subNo=subno.getText();
		DataCopy proc = null;
		try {
//			isAcctSec=popUp.initialValidation(acctId, secId);
//			if(isAcctSec) {
				proc=new FetchAcctSec(clientId,boId,firmNo,subNo,acctId,secId,sviRad.isSelected(), sviSeed.isSelected(), sviTrd.isSelected(),
						sviCli.isSelected(), accountMaster.isSelected(), secMaster.isSelected(),
						caAcctSec.isSelected(), caPayout.isSelected(), caTerms.isSelected(),
						caBroker.isSelected(), corpAct.isSelected(),
						hpsMaster.isSelected(), hpsDetail.isSelected(), stepUp.isSelected(),textarea,vpTransaction.isSelected(),true);
//			}else {
//				proc=new FetchAcct(acctId,secId,sviRad.isSelected(), sviSeed.isSelected(), sviTrd.isSelected(),
//						sviCli.isSelected(), accountMaster.isSelected(), secMaster.isSelected(),
//						caAcctSec.isSelected(), caPayout.isSelected(), caTerms.isSelected(),
//						caBroker.isSelected(), corpAct.isSelected(),
//						hpsMaster.isSelected(), hpsDetail.isSelected(), stepUp.isSelected(),textarea,vpTransaction.isSelected(),true);
//			}
				
			
		} catch (Exception e) {
			System.out.println("Catch block");
		}
		proc.getRelatedAccts();
		System.out.println("Block getRelatedAccts()");
		
	}
	
	public void generateSqlFile() {
		
		Props p = new Props();
		acctId=acctid.getText();
		secId = secid.getText();
		clientId=clientid.getText();
		boId=boid.getText();
		firmNo=firmno.getText();
		subNo=subno.getText();
//		textarea.setText("Welcome");
		PopUp popUp = new PopUp();
		DataCopy proc = null;
		try {
//			isAcctSec=popUp.initialValidation(acctId, secId);
//			if(isAcctSec) {
				proc=new FetchAcctSec(clientId,boId,firmNo,subNo,acctId,secId,sviRad.isSelected(), sviSeed.isSelected(), sviTrd.isSelected(),
						sviCli.isSelected(), accountMaster.isSelected(), secMaster.isSelected(),
						caAcctSec.isSelected(), caPayout.isSelected(), caTerms.isSelected(),
						caBroker.isSelected(), corpAct.isSelected(),
						hpsMaster.isSelected(), hpsDetail.isSelected(), stepUp.isSelected(),textarea,vpTransaction.isSelected(),true);
//			}else {
//				proc=new FetchAcct(acctId,secId,sviRad.isSelected(), sviSeed.isSelected(), sviTrd.isSelected(),
//						sviCli.isSelected(), accountMaster.isSelected(), secMaster.isSelected(),
//						caAcctSec.isSelected(), caPayout.isSelected(), caTerms.isSelected(),
//						caBroker.isSelected(), corpAct.isSelected(),
//						hpsMaster.isSelected(), hpsDetail.isSelected(), stepUp.isSelected(),textarea,vpTransaction.isSelected(),true);
//			}
				
			
		} catch (Exception e) {
			System.out.println("Catch block");
		}
//		disableButton();
		proc.processDataCopy();
//		enableButton();
//		UpdateQuery_CrossPlatform();
		System.out.println(acctid.getText()+secid.getText());

		
	}
	
	public void getDeleteQueries() {
		
		disableButton();
		
		DataCopy proc=new DeleteProcess(acctid.getText(),secid.getText(),sviRad.isSelected(), sviSeed.isSelected(), sviTrd.isSelected(),
				sviCli.isSelected(), accountMaster.isSelected(), secMaster.isSelected(),
				caAcctSec.isSelected(), caPayout.isSelected(), caTerms.isSelected(),
				caBroker.isSelected(), corpAct.isSelected(),
				hpsMaster.isSelected(), hpsDetail.isSelected(), stepUp.isSelected(),textarea,vpTransaction.isSelected(),false);
		proc.getDeleteQueries();
		
		enableButton();
		
	}
	public void setTextDisplay(String qeury) {
		
		try {
			textarea.setText(qeury);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void disableButton() {
//		getQueries.setDisable(true);
//		goBack.setDisable(true);
//		getDeleteQueries.setDisable(true);
//		generateSqlFile.setDisable(true);
		
	}
	
	public void enableButton() {
//		getQueries.setDisable(false);
//		goBack.setDisable(false);
//		getDeleteQueries.setDisable(false);
//		generateSqlFile.setDisable(false);
		
	}
	


}
