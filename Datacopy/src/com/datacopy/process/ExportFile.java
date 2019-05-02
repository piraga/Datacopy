package com.datacopy.process;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import com.datacopy.application.PopUp;

public class ExportFile {
	
//	private static String tmpDir = System.getProperty("java.io.tmpdir");
	private static String userHome = System.getProperty("user.home");
	private static String fileSeparator = System.getProperty("file.separator");
//	static String firstBack =tmpDir.substring(0, tmpDir.lastIndexOf(fileSeparator));
//    static String beforeTemp = firstBack.substring(0, firstBack.lastIndexOf(fileSeparator)+1);
	static String DSI = "DatacopyExports";
	static String fileDir=userHome+fileSeparator+DSI.trim();
	static String fileName;
	Date date =new Date();
	String acctId;
	String secID;
	FileWriter fw;
	PopUp pu = new PopUp();
	
	public ExportFile(String acctId,String secId) {
		this.acctId=acctId;
		this.secID=secId;
		this.fileName=fileDir+fileSeparator+"exports"+acctId+"_"+secId+".sql";
		createSqlFile();
		
		  
		
	}
	
	public FileWriter getFileWriter() {
		try {
			fw = new FileWriter(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fw;
	}
	
	public void FileWriter(String query) {
		try {
			fw.write(query);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void FileWriterClose() {
		try {
			fw.write("COMMIT;");
			fw.close();
			pu.exportPopUp(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	
	public void createSqlFile() {
		System.out.println(date);
		System.out.println(fileDir);
		System.out.println(fileName);
//		System.out.println(fileSeparator);		
		File createDir = new File(fileDir);
		File createFile = new File(fileName);
		if(!createDir.exists()) {
			createDir.mkdir();
			System.out.println("DONE");
		}
		createFile.deleteOnExit();
		if(!createFile.exists()) {
			try {
				createFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		fw= getFileWriter();
				
	}

}
