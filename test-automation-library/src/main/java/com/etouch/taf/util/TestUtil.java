/*
 * 
 */
package com.etouch.taf.util;

import com.etouch.taf.core.datamanager.excel.Xlsx_Reader;

// TODO: Auto-generated Javadoc
/**
 * The Class TestUtil.
 */
public class TestUtil {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//find if the Test Suite is runnable based on the run mode
		/**
 * Checks if is suite runnable.
 *
 * @param xls the xls
 * @param suiteName the suite name
 * @return true, if is suite runnable
 */
public static boolean isSuiteRunnable(Xlsx_Reader xls, String suiteName){
			System.out.println("Xls name:"+xls+", Suite name:"+suiteName);
			boolean isExecutable =false;
			for(int  i = 2; i<=xls.getRowCount("Test Suite"); i++){
				String tsid = xls.getCellData("Test Suite", "TSID", i);
				String runmode = xls.getCellData("Test Suite", "Runmode", i);
				System.out.println(tsid + " Runmode is " + runmode);
				
				if(tsid.equalsIgnoreCase(suiteName)){
					if(runmode.equalsIgnoreCase("Y")){
						isExecutable = true;
					}
						else{
							isExecutable = false;
							}
					}
				}
		xls = null;
		return isExecutable;
		}
	
		
		
//Find if the specified test is runnable based on runmode
		/**
 * Checks if is test runnable.
 *
 * @param xls the xls
 * @param testCaseName the test case name
 * @return true, if is test runnable
 */
public static boolean isTestRunnable(Xlsx_Reader xls, String testCaseName){
			boolean isExecutable = false;
			
			System.out.println("Sheet name:"+xls+", Test case name:"+testCaseName);
			for(int i =2; i<=xls.getRowCount("Test Cases"); i++){
				String tcid = xls.getCellData("Test Cases", "TCID", i);
				String runmode = xls.getCellData("Test Cases", "Runmode", i);
				
				//System.out.println(tcid + " Runmode " + runmode);
				/*System.out.println("TIDA:"+tcid);
				System.out.println("TIDE:"+testCaseName);
				System.out.println("runmodeA:"+runmode);
				System.out.println("runmodeE:"+"Y");*/
				
				if(tcid.equalsIgnoreCase(testCaseName)){
					if(runmode.equalsIgnoreCase("Y")){
						isExecutable = true;						
					}else{
						isExecutable = false;
						}
					}
				}
				
			xls =null;//release memory
			return isExecutable;		
		}

	
	
//Return the test data from a two dimensional array
		/**
 * Gets the data.
 *
 * @param xls the xls
 * @param testCaseName the test case name
 * @return the data
 */
public static Object[][] getData(Xlsx_Reader xls, String testCaseName){
			
			System.out.println("Reader sheet name:"+xls+", testcasename:"+testCaseName);
			//if the test data sheet is not present for a test case
			if(! xls.isSheetExist(testCaseName)){
				xls = null;
				return new Object[1][0];
			}
			
			int rows = xls.getRowCount(testCaseName);
			int cols = xls.getColumnCount(testCaseName);
			
			//Retrieving data from excel
			Object[][] data = new Object[rows-1][cols-3];
			for(int rowNum =2; rowNum<=rows; rowNum++ ){
				for(int colNum =0; colNum<cols-3; colNum++){
					//System.out.print(xls.getCellData(testCaseName, colNum, rowNum)+ " -- ");
					data[rowNum-2][colNum] = xls.getCellData(testCaseName, colNum, rowNum);
				}
				//System.out.println();
			}
				return data;
		}
		
		
// checks Runmode for dataSet
				/**
 * Gets the data set runmodes.
 *
 * @param xlsFile the xls file
 * @param sheetName the sheet name
 * @return the data set runmodes
 */
public static String[] getDataSetRunmodes(Xlsx_Reader xlsFile,String sheetName){
					String[] runmodes=null;
					if(!xlsFile.isSheetExist(sheetName)){
						xlsFile=null;
						sheetName=null;
						runmodes = new String[1];
						runmodes[0]="Y";
						xlsFile=null;
						sheetName=null;
						return runmodes;
					}
					runmodes = new String[xlsFile.getRowCount(sheetName)-1];
					for(int i=2;i<=runmodes.length+1;i++){
						runmodes[i-2]=xlsFile.getCellData(sheetName, "Runmode", i);
						System.out.println("Runmodes of sheet:"+xlsFile.getCellData(sheetName, "Runmode", i));
					}
					xlsFile=null;
					sheetName=null;
					return runmodes;
					
				}
		
//updating results for a particular data set
		/**
 * Report data set result.
 *
 * @param xls the xls
 * @param testCaseName the test case name
 * @param rowNum the row num
 * @param result the result
 */
public static void reportDataSetResult(Xlsx_Reader xls, String testCaseName, int rowNum, String result){
			xls.setCellData(testCaseName, "Results", rowNum, result);
		}
		
	//updating results for a particular data set
		/**
	 * Report data set result class link.
	 *
	 * @param xls the xls
	 * @param testCaseName the test case name
	 * @param rowNum the row num
	 * @param result the result
	 */
	public static void reportDataSetResultClassLink(Xlsx_Reader xls, String testCaseName, int rowNum, String result){
			xls.setCellData(testCaseName, "ClassregLnk", rowNum, result);
		}
		//updating results for a particular data set
		/**
		 * Report data set result class id.
		 *
		 * @param xls the xls
		 * @param testCaseName the test case name
		 * @param rowNum the row num
		 * @param result the result
		 */
		public static void reportDataSetResultClassId(Xlsx_Reader xls, String testCaseName, int rowNum, String result){
			xls.setCellData(testCaseName, "ClassId", rowNum, result);
		}

//return the Row Number for a Test
		/**
 * Gets the row num.
 *
 * @param xls the xls
 * @param id the id
 * @return the row num
 */
public static int getRowNum(Xlsx_Reader xls, String id){
			for(int i =2; i<=xls.getRowCount("Test Cases"); i++){
				String tcid = xls.getCellData("Test Cases", "TCID", i);
				if(tcid.equals(id)){
					xls=null;
					return i;
				}
			}
			return -1;
		}
}