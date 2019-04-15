package com.datacopy.process;

import javafx.scene.control.TextArea;

public class FetchAcct extends DataCopy implements FetchTables {
	
	private String acctId;
//	private String secId;
	private String[] pstm = new String[1];
	private String[] pstmNo = new String[1];
	private String acctNo;
	private String secNo;

	public FetchAcct(String acctId, boolean sviRad, boolean sviSeed, boolean sviTrd, boolean sviCli, boolean accountMaster, boolean secMaster,
			boolean caAcctSec, boolean caPayout, boolean caTerms, boolean caBroker, boolean corpAct, boolean hpsMaster,
			boolean hpsDetail, boolean stepUp, TextArea ta, boolean vpTransaction) {
		
		super(sviRad, sviSeed, sviTrd, sviCli, accountMaster, secMaster, caAcctSec, caPayout, caTerms, caBroker, corpAct,
				hpsMaster, hpsDetail, stepUp, ta, vpTransaction);
		pstm[0]= this.acctId =acctId;
//		pstm[1]= this.secId=secId;
		pstmNo[0]=acctNo=splitAcctId(acctId);
//		pstmNo[1]=secNo=splitSecId(secId);
	}

	@Override
	public void processDataCopy() {

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
			if(isVpTransaction())
				processVpTransaction();
		
		
	}

	@Override
	public void processRad() {
		
		queryProcess("SVI_RAD",pstmNo,false);
		
	}

	@Override
	public void processTrade() {
		// TODO Auto-generated method stub
		queryProcess("SVI_TRD",pstmNo,false);
		
	}

	@Override
	public void processSeed() {
		// TODO Auto-generated method stub
		
		queryProcess("SVI_SEED",pstmNo,false);
	}

	@Override
	public void processCli() {
		// TODO Auto-generated method stub
		
		queryProcess("SVI_CLI",pstmNo,false);
	}

	@Override
	public void processAccountMaster() {
		// TODO Auto-generated method stub
	
		queryProcess("ACCOUNT_MASTER",pstmNo,false);
	}

	@Override
	public void processSecurityMaster() {
		// TODO Auto-generated method stub
		
		queryProcess("SEC_MASTER",pstmNo,false);
	}

	@Override
	public void processCaAcctSec() {
		// TODO Auto-generated method stub
		queryProcess("CA_ACCT_SEC",pstm,false);
		
	}

	@Override
	public void processCorpActPayout() {
		// TODO Auto-generated method stub
		queryProcess("CORP_ACT_PAYOUT",pstm,false);
		
	}

	@Override
	public void processCorpActTerms() {
		// TODO Auto-generated method stub
		queryProcess("CORP_ACT_TERMS",pstm,false);
		
	}

	@Override
	public void processCorpActBroker() {
		// TODO Auto-generated method stub
		queryProcess("CORP_ACT_BROKER",pstm,false);
		
	}

	@Override
	public void processCorpAct() {
		// TODO Auto-generated method stub
		
		queryProcess("CORP_ACT",pstm,false);
		
	}

	@Override
	public void processHpsMaster() {
		// TODO Auto-generated method stub
		
		queryProcess("FIP_HPS_MASTER",pstmNo,false);
	}

	@Override
	public void processHpsDetail() {
		// TODO Auto-generated method stub
		queryProcess("FIP_HPS_DETAIL",pstmNo,false);
		
	}

	@Override
	public void processStepUp() {
		// TODO Auto-generated method stub
		queryProcess("STEPUP_TRANSACTIONS",pstmNo,false);
		
	}

	@Override
	public void processVpTransaction() {
		// TODO Auto-generated method stub
		queryProcess("VP_TRANSACTION",pstm,false);
	}


}
