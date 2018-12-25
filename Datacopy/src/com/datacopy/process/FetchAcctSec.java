package com.datacopy.process;

public class FetchAcctSec extends DataCopy implements FetchTables {
	
	private String acctId;
	private String secId;

	public FetchAcctSec(String acctId, String secId, boolean sviRad, boolean sviSeed, boolean sviTrd, boolean sviCli, boolean accountMaster,
			boolean secMaster, boolean caAcctSec, boolean caPayout, boolean caTerms, boolean caBroker, boolean corpAct,
			boolean hpsMaster, boolean hpsDetail, boolean stepUp) {
		
		super(sviRad, sviSeed, sviTrd, sviCli, accountMaster, secMaster, caAcctSec, caPayout, caTerms, caBroker, corpAct,
				hpsMaster, hpsDetail, stepUp);
		
	}

	@Override
	public void processDataCopy() {
		processRad();
		processTrade();
		processSeed();
		processCli();
		processAccountMaster();
		processSecurityMaster();
		processCaAcctSec();
		processCorpActPayout();
		processCorpActTerms();
		processCorpActBroker();
		processCorpAct();
		processHpsMaster();
		processHpsDetail();
		processStepUp();		
		
	}

	@Override
	public void processRad() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processTrade() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processSeed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processCli() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processAccountMaster() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processSecurityMaster() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processCaAcctSec() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processCorpActPayout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processCorpActTerms() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processCorpActBroker() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processCorpAct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processHpsMaster() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processHpsDetail() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processStepUp() {
		// TODO Auto-generated method stub
		
	}

	
}
	