package com.datacopy.process;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.datacopy.dao.DataManager;

import javafx.scene.control.TextArea;

public class FetchAcctSec extends DataCopy implements FetchTables {
	
	private String acctId;
	private String secId;
	private String[] pstm = new String[2];
	private String[] pstmNo = new String[2];
	private String acctNo;
	private String secNo;
	
	DataManager dm = new DataManager();
	public FetchAcctSec(String acctId, String secId, boolean sviRad, boolean sviSeed, boolean sviTrd, boolean sviCli, boolean accountMaster,
			boolean secMaster, boolean caAcctSec, boolean caPayout, boolean caTerms, boolean caBroker, boolean corpAct,
			boolean hpsMaster, boolean hpsDetail, boolean stepUp, TextArea ta) {
		
		super(sviRad, sviSeed, sviTrd, sviCli, accountMaster, secMaster, caAcctSec, caPayout, caTerms, caBroker, corpAct,
				hpsMaster, hpsDetail, stepUp,ta);
		pstm[0]= this.acctId =acctId;
		pstm[1]= this.secId=secId;
		pstmNo[0]=acctNo=splitAcctId(acctId);
		pstmNo[1]=secNo=splitSecId(secId);
		
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
		if(isCaAcctSec())
		processCaAcctSec();
		if(isCaPayout())
		processCorpActPayout();
		if(isCaTerms())
		processCorpActTerms();
		if(isCaBroker())
		processCorpActBroker();
		if(isCorpAct())
		processCorpAct();
		if(isHpsMaster())
		processHpsMaster();
		if(isHpsDetail())
		processHpsDetail();
		if(isStepUp())
		processStepUp();		
		
	}

	@Override
	public void processRad() {
		
		queryProcess("SVI_RAD",pstmNo,true);
		System.out.println("RAD \n");
//		int j=1;
//
//		String query1 = "";
//		try {
//			
//			System.out.println(acctId+"  "+secId+"  "+acctNo+"  "+secNo);
//			ResultSet rs=dm.executeQueryByName("RAD", pstmNo);
//			
//			ResultSetMetaData rsmd = rs.getMetaData();
//			String query = "INSERT INTO SVI_RAD (";
//			
//			int columnCoun=rsmd.getColumnCount();
//			for(int i=1;i<=columnCoun;i++) {
//				
//				query+=rsmd.getColumnName(i) ;
//				if(i!=columnCoun)
//				{
//					query+=",";
//				}
//				String count = rsmd.getColumnName(i);
//			}
//			query+=") VALUES(";
//			while(rs.next()) {
//			
//				for(int i=1;i<=columnCoun;i++) {
//					
////				System.out.println(rsmd.getColumnTypeName(j));
//				String count = rsmd.getColumnName(j);
////				System.out.println(count);
//				if("DATE".equals(rsmd.getColumnTypeName(j))) {
//					rs.getDate(j);
//					if ( rs.wasNull()) {
//						query1+=null;
//					}else {
//						query1+="to_date('" + rs.getDate(j)+"','yyyy/mm/dd')";
//					}
//					
//				}else if("NUMBER".equals(rsmd.getColumnTypeName(j))){
//					rs.getInt(count);
//					if ( rs.wasNull()) {
//						query1+=null;
//					}else {
//						query1+="'";
//						query1+=rs.getInt(count);
//						query1+="'";
//					}
//					
//				}else {
//					rs.getString(count);
//					if ( rs.wasNull()) {
//						query1+=null;
//					}else {
//						query1+="'";
//						query1+=rs.getString(count);
//						query1+="'";
//					}
//					
//				}
//			
//				
//				if(i!=columnCoun )
//				query1+=",";
//				j++;
//			}
//				j=1;
//				query1+=");";
//				System.out.println(query+" "+query1);
//				query1="";
//				
//			}
			
			
			
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		
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
		queryProcess("STEPUP_TRANSACTION",pstmNo,true);
		
	}
	
	
}
	