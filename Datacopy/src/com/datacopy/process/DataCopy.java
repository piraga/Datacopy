package com.datacopy.process;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.datacopy.controller.MainController;
import com.datacopy.dao.DataManager;

import javafx.scene.control.TextArea;

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
	private TextArea ta;
	DataManager dm =  new DataManager();
	MainController mc = new MainController();
	
	DataCopy(boolean sviRad,boolean sviSeed,boolean sviTrd,boolean sviCli,
			boolean accountMaster,boolean secMaster,boolean caAcctSec,
			boolean caPayout,boolean caTerms,boolean caBroker,
			boolean corpAct,boolean hpsMaster,boolean hpsDetail,boolean stepUp,TextArea ta){
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
		this.ta=ta;
		
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
	
	public void queryProcess(String tableName, String[] pstmNo,boolean acctSecCheck) {
		int j=1;
		int rowcount=1;
		ta.appendText("REM INSERTING into "+tableName +"\n" + 
				"SET DEFINE OFF; \n");
		String query1 = "";
		String propName=tableName;
		try {
			if(!acctSecCheck) {
				propName = propName+"_ACCT";
				
			}
//			System.out.println(acctId+"  "+secId+"  "+acctNo+"  "+secNo);
			ResultSet rs=dm.executeQueryByName(propName, pstmNo);
//			rs.last(); 
//			System.out.println("Count "+rs.getRow());
//			while(rs.next()) {
//				rowcount++;
//			}
//			ta.appendText("--Count"+rowcount+"\n");
//			rs.beforeFirst();
			ResultSetMetaData rsmd = rs.getMetaData();
			String query = "INSERT INTO "+tableName +" (";
			
			int columnCoun=rsmd.getColumnCount();
			for(int i=1;i<=columnCoun;i++) {
				
				query+=rsmd.getColumnName(i) ;
				if(i!=columnCoun)
				{
					query+=",";
				}
				String count = rsmd.getColumnName(i);
			}
			query+=") VALUES(";
			while(rs.next()) {
			
				for(int i=1;i<=columnCoun;i++) {
					
//				System.out.println(rsmd.getColumnTypeName(j));
				String count = rsmd.getColumnName(j);
//				System.out.println(count);
				if("DATE".equals(rsmd.getColumnTypeName(j))) {
					rs.getDate(j);
					if ( rs.wasNull()) {
						query1+=null;
					}else {
						query1+="to_date('" + rs.getDate(j)+"','yyyy/mm/dd')";
					}
				}else {				
						rs.getString(count);
						if ( rs.wasNull()) {
							query1+=null;
						}else {
							if(rsmd.getColumnName(j).equalsIgnoreCase("PROCESS_STATUS") && rs.getString(count).equals("PROCESSED")&& checkRawTable(tableName)) {
								query1+="'";
								query1+="UNDEFINED";
								query1+="'";
							}else {
								query1+="'";
								query1+=rs.getString(count);
								query1+="'";
							}		
						}	
						
					
					
//				}else if("NUMBER".equals(rsmd.getColumnTypeName(j))){
//					rs.getInt(count);
//					if ( rs.wasNull()) {
//						query1+=null;
//					}else {
//						query1+="'";
//						query1+=rs.getInt(count);
//						query1+="'";
//					}
					
				
					
				}
			
				
				if(i!=columnCoun )
				query1+=",";
				j++;
			}
				j=1;
				query1+=");";
				System.out.println(query+" "+query1);
				
				ta.appendText(query+" "+query1+"\n");
//				return query+" "+query1;
				query1="";
				
			}
			
			ta.appendText("\n\n");	
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return query1;
		
	}
	
	public boolean checkRawTable(String tableName) {
		return tableName.equals("SVI_RAD")||tableName.equals("SVI_TRD")||tableName.equals("SVI_SEED");
	}

	public void processDataCopy() {
		// TODO Auto-generated method stub
		processDataCopy();		
		DataManager.disconnectDb();
	}

}
