package com.datacopy.process;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.datacopy.dao.DataManager;

import javafx.scene.control.TextArea;

public class FetchAcctSec extends DataCopy implements FetchTables {
	
	private String acctId;
	private String secId;
	private String[] pstm = new String[2];
	private String[] pstmNo = new String[2];
	private String acctNo;
	private String secNo;
	private String clientId;
	private String boId;
	private String firmNo;
	private String subNo;
	private int count=0;
	private int threshold=10;
	DataManager dm = new DataManager();
	ArrayList<String> isDeliverACTF=new ArrayList<>();
	public FetchAcctSec(String clientId, String boId, String firmNo, String subNo, String acctId, String secId, boolean sviRad, boolean sviSeed, boolean sviTrd, boolean sviCli, boolean accountMaster,
			boolean secMaster, boolean caAcctSec, boolean caPayout, boolean caTerms, boolean caBroker, boolean corpAct,
		
			boolean hpsMaster, boolean hpsDetail, boolean stepUp, TextArea ta, boolean vpTransaction, boolean sqlFile) {
		super(acctId,secId,sviRad, sviSeed, sviTrd, sviCli, accountMaster, secMaster, caAcctSec, caPayout, caTerms, caBroker, corpAct,
				hpsMaster, hpsDetail, stepUp,ta,vpTransaction, sqlFile);
		pstm[0]= this.acctId =acctId;
		pstm[1]= this.secId=secId;
		pstmNo[0]=acctNo=splitAcctId(acctId);
		pstmNo[1]=secNo=splitSecId(secId);
		this.clientId=clientId;
		this.boId=boId;
		this.firmNo=firmNo;
		this.subNo=subNo;
	}

	@Override
	public void processDataCopy() {
		if(isSecMaster())
			processSecurityMaster();
		if(isSviRad())
			processRad();
		if(isSviTrd())
			processTrade();
		if(isSviSeed())
			processSeed();
		if(isSviCli())
			processCli();
		if(isAccountMaster())
			processAccountMaster();
		if(isVpTransaction())
			processVpTransaction();
		if(isCorpAct())
			processCorpAct();
		if(isCaBroker())
			processCorpActBroker();
		if(isCaTerms())
			processCorpActTerms();
		if(isCaPayout())
			processCorpActPayout();
		if(isCaAcctSec())
			processCaAcctSec();
		if(isHpsMaster())
			processHpsMaster();
		if(isHpsDetail())
			processHpsDetail();
		if(isStepUp())
			processStepUp();
		if(!clientId.isEmpty()&& !boId.isEmpty() && !firmNo.isEmpty() && !subNo.isEmpty() && !acctId.isEmpty() && !secId.isEmpty())  {
			prepare_Update_Query(clientId,boId,firmNo,subNo,acctId,secId);
			System.out.println("Innnnnnnnnnnnnnnnnnn");
		}
//		ef.FileWriterClose();
		
			
		
	}
	public void getRelatedAccts() {
		getRelatedAccts(acctNo,secNo);

	}

	

	private ArrayList<String> getRelatedAccts(String acctNo, String secNo) {
		// TODO Auto-generated method stub
		System.out.println("Inside FetchAcctSec");
		count++;
		ArrayList<String> isDeliverACTF=isDeliverACTF("CHECKACTFDELIVER",acctNo,secNo,count,threshold,true);
		if(!actflist.isEmpty()&& count<=threshold) {
			for(String acctSec:isDeliverACTF) {
				String[] acctSecurity=acctSec.split(";");
				System.out.println(acctSecurity[0]+" ;"+acctSecurity[1]);
				isDeliverACTF("CHECKACTFREVEIVE",acctSecurity[0],acctSecurity[1],count,threshold,true);
				getRelatedAccts(acctSecurity[0],acctSecurity[1]);
			}
		}else if (count==threshold) {
			isDeliverACTF("CHECKACTFDELIVER",acctNo,secNo,count,threshold,false);
		}
		return null;
	}

	@Override
	public void processRad() {
		
		queryProcess("SVI_RAD",pstmNo,true);
		
	}

	@Override
	public void processTrade() {
		// TODO Auto-generated method stub
		queryProcess("SVI_TRD",pstmNo,true);
		
	}

	@Override
	public void processSeed() {
		// TODO Auto-generated method stub
		
		queryProcess("SVI_SEED",pstmNo,true);
	}

	@Override
	public void processCli() {
		// TODO Auto-generated method stub
		
		queryProcess("SVI_CLI",pstmNo,true);
	}

	@Override
	public void processAccountMaster() {
		// TODO Auto-generated method stub
	
		queryProcess("ACCOUNT_MASTER",pstmNo,true);
	}

	@Override
	public void processSecurityMaster() {
		// TODO Auto-generated method stub
		
		queryProcess("SEC_MASTER",pstmNo,true);
	}

	@Override
	public void processCaAcctSec() {
		// TODO Auto-generated method stub
		queryProcess("CA_ACCT_SEC",pstm,true);
		
	}

	@Override
	public void processCorpActPayout() {
		// TODO Auto-generated method stub
		queryProcess("CORP_ACT_PAYOUT",pstm,true);
		
	}

	@Override
	public void processCorpActTerms() {
		// TODO Auto-generated method stub
		queryProcess("CORP_ACT_TERMS",pstm,true);
		
	}

	@Override
	public void processCorpActBroker() {
		// TODO Auto-generated method stub
		queryProcess("CORP_ACT_BROKER",pstm,true);
		
	}

	@Override
	public void processCorpAct() {
		// TODO Auto-generated method stub
		
		queryProcess("CORP_ACT",pstm,true);
		
	}

	@Override
	public void processHpsMaster() {
		// TODO Auto-generated method stub
		
		queryProcess("FIP_HPS_MASTER",pstmNo,true);
	}

	@Override
	public void processHpsDetail() {
		// TODO Auto-generated method stub
		queryProcess("FIP_HPS_DETAIL",pstmNo,true);
		
	}

	@Override
	public void processStepUp() {
		// TODO Auto-generated method stub
		queryProcess("STEPUP_TRANSACTIONS",pstmNo,true);
		
	}

	@Override
	public void processVpTransaction() {
		// TODO Auto-generated method stub
		queryProcess("VP_TRANSACTION",pstm,true);
		
	}
	
	
}
	