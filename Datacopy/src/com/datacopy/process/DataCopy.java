package com.datacopy.process;

public class DataCopy {
	
	private boolean sviRad;
	private boolean sviSeed;
	private boolean sviTrd;
	private boolean sviCli;
	private boolean accountMaster;
	private boolean secMaster;
	private boolean caAcctSec;
	private boolean caPayout;
	private boolean caTerms;
	private boolean caBroker;
	private boolean corpAct;
	private boolean hpsMaster;
	private boolean hpsDetail;
	private boolean stepUp;
	
	DataCopy(boolean sviRad,boolean sviSeed,boolean sviTrd,boolean sviCli,
			boolean accountMaster,boolean secMaster,boolean caAcctSec,
			boolean caPayout,boolean caTerms,boolean caBroker,
			boolean corpAct,boolean hpsMaster,boolean hpsDetail,boolean stepUp){
		this.sviRad=sviRad;
		this.sviSeed=sviSeed;
		this.sviTrd=sviTrd;
		this.sviCli=sviCli;
		this.accountMaster=accountMaster;
		this.secMaster=secMaster;
		this.caAcctSec=caAcctSec;
		this.caPayout=caPayout;
		this.caTerms=caTerms;
		this.caBroker=caBroker;
		this.corpAct=corpAct;
		this.hpsMaster=hpsMaster;
		this.hpsDetail=hpsDetail;
		this.stepUp=stepUp;
		
	}
	
	public boolean isSviRad() {
		return sviRad;
	}

	public void setSviRad(boolean sviRad) {
		this.sviRad = sviRad;
	}

	public boolean isSviSeed() {
		return sviSeed;
	}

	public void setSviSeed(boolean sviSeed) {
		this.sviSeed = sviSeed;
	}

	public boolean isSviTrd() {
		return sviTrd;
	}

	public void setSviTrd(boolean sviTrd) {
		this.sviTrd = sviTrd;
	}

	public boolean isSviCli() {
		return sviCli;
	}

	public void setSviCli(boolean sviCli) {
		this.sviCli = sviCli;
	}

	public boolean isAccountMaster() {
		return accountMaster;
	}

	public void setAccountMaster(boolean accountMaster) {
		this.accountMaster = accountMaster;
	}

	public boolean isSecMaster() {
		return secMaster;
	}

	public void setSecMaster(boolean secMaster) {
		this.secMaster = secMaster;
	}

	public boolean isCaAcctSec() {
		return caAcctSec;
	}

	public void setCaAcctSec(boolean caAcctSec) {
		this.caAcctSec = caAcctSec;
	}

	public boolean isCaPayout() {
		return caPayout;
	}

	public void setCaPayout(boolean caPayout) {
		this.caPayout = caPayout;
	}

	public boolean isCaTerms() {
		return caTerms;
	}

	public void setCaTerms(boolean caTerms) {
		this.caTerms = caTerms;
	}

	public boolean isCaBroker() {
		return caBroker;
	}

	public void setCaBroker(boolean caBroker) {
		this.caBroker = caBroker;
	}

	public boolean isCorpAct() {
		return corpAct;
	}

	public void setCorpAct(boolean corpAct) {
		this.corpAct = corpAct;
	}

	public boolean isHpsMaster() {
		return hpsMaster;
	}

	public void setHpsMaster(boolean hpsMaster) {
		this.hpsMaster = hpsMaster;
	}

	public boolean isHpsDetail() {
		return hpsDetail;
	}

	public void setHpsDetail(boolean hpsDetail) {
		this.hpsDetail = hpsDetail;
	}

	public boolean isStepUp() {
		return stepUp;
	}

	public void setStepUp(boolean stepUp) {
		this.stepUp = stepUp;
	}
	
	public String splitAcctId(String acctId) {
		String[] accNo=acctId.split("-");
		return accNo[3];
		
	}
	
	public String splitSecId(String secId) {
		String[] secNo=secId.split("-");
		return secNo[1];
		
	}

	public void processDataCopy() {
		// TODO Auto-generated method stub
		processDataCopy();
		
	}

}
