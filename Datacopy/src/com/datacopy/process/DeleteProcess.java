package com.datacopy.process;

import javafx.scene.control.TextArea;

public class DeleteProcess extends DataCopy implements FetchTables {
	
	
	private String acctId;
	private String secId;
	private String[] pstm = new String[2];
	private String[] pstmNo = new String[2];
	private String acctNo;
	private String secNo;
	
	public DeleteProcess(String acctId, String secId,boolean sviRad, boolean sviSeed, boolean sviTrd, boolean sviCli, boolean accountMaster,
			boolean secMaster, boolean caAcctSec, boolean caPayout, boolean caTerms, boolean caBroker, boolean corpAct,
			boolean hpsMaster, boolean hpsDetail, boolean stepUp, TextArea ta, boolean vpTransaction, boolean sqlFile) {
		super(acctId,secId,sviRad, sviSeed, sviTrd, sviCli, accountMaster, secMaster, caAcctSec, caPayout, caTerms, caBroker, corpAct,
				hpsMaster, hpsDetail, stepUp,ta,vpTransaction, sqlFile);
		pstm[0]= this.acctId =acctId;
		pstm[1]= this.secId=secId;
		pstmNo[0]=acctNo=splitAcctId(acctId);
		pstmNo[1]=secNo=splitSecId(secId);
		System.out.println("IN");
	}
	
	public void getDeleteQueries() {
		System.out.println("Process");
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
		if(isSecMaster())
			processSecurityMaster();
		if(isVpTransaction())
			processVpTransaction();

		if(isCaBroker())
			processCorpActBroker();
		if(isCaTerms())
			processCorpActTerms();
		if(isCaPayout())
			processCorpActPayout();
		if(isCorpAct())
			processCorpAct();
		if(isCaAcctSec())
			processCaAcctSec();
		if(isHpsMaster())
			processHpsMaster();
		if(isHpsDetail())
			processHpsDetail();
		if(isStepUp())
			processStepUp();
		
	}
	
	@Override
	public void processRad() {
		
		getDeleteQueries("SVI_RAD",pstmNo,pstm);
		
	}

	@Override
	public void processTrade() {
		// TODO Auto-generated method stub
		getDeleteQueries("SVI_TRD",pstmNo,pstm);
		
	}

	@Override
	public void processSeed() {
		// TODO Auto-generated method stub
		
		getDeleteQueries("SVI_SEED",pstmNo,pstm);
	}

	@Override
	public void processCli() {
		// TODO Auto-generated method stub
		
		getDeleteQueries("SVI_CLI",pstmNo,pstm);
	}

	@Override
	public void processAccountMaster() {
		// TODO Auto-generated method stub
	
		getDeleteQueries("ACCOUNT_MASTER",pstmNo,pstm);
	}

	@Override
	public void processSecurityMaster() {
		// TODO Auto-generated method stub
		
		getDeleteQueries("SEC_MASTER",pstmNo,pstm);
	}

	@Override
	public void processCaAcctSec() {
		// TODO Auto-generated method stub
		getDeleteQueries("CA_ACCT_SEC",pstmNo,pstm);
		
	}

	@Override
	public void processCorpActPayout() {
		// TODO Auto-generated method stub
		getDeleteQueries("CORP_ACT_PAYOUT",pstmNo,pstm);
		
	}

	@Override
	public void processCorpActTerms() {
		// TODO Auto-generated method stub
		getDeleteQueries("CORP_ACT_TERMS",pstmNo,pstm);
		
	}

	@Override
	public void processCorpActBroker() {
		// TODO Auto-generated method stub
		getDeleteQueries("CORP_ACT_BROKER",pstmNo,pstm);
		
	}

	@Override
	public void processCorpAct() {
		// TODO Auto-generated method stub
		
		getDeleteQueries("CORP_ACT",pstmNo,pstm);
		
	}

	@Override
	public void processHpsMaster() {
		// TODO Auto-generated method stub
		
		getDeleteQueries("FIP_HPS_MASTER",pstmNo,pstm);
	}

	@Override
	public void processHpsDetail() {
		// TODO Auto-generated method stub
		getDeleteQueries("FIP_HPS_DETAIL",pstmNo,pstm);
		
	}

	@Override
	public void processStepUp() {
		// TODO Auto-generated method stub
		getDeleteQueries("STEPUP_TRANSACTIONS",pstmNo,pstm);
		
	}

	@Override
	public void processVpTransaction() {
		// TODO Auto-generated method stub
		getDeleteQueries("VP_TRANSACTION",pstmNo,pstm);
	}
	
	

}
