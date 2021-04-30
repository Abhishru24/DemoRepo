package com.crm.qa.util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import com.crm.qa.util.ExcelUtitlityPOM;

public class ExcelUtil {

	public static String TEST_DATA_SHEET = ".\\src\\main\\java\\com\\crm\\qa\\testdata\\Guru99.xlsx";
	

	public static Object [][] getData(String sheetname) throws IOException
	
	{
		//Create object of XLUtil class to access the methods and Objects
		ExcelUtitlityPOM xlUtil = new ExcelUtitlityPOM(TEST_DATA_SHEET);
		int totalRows = xlUtil.getRowCount(sheetname);//Get number of Rows
		int totalcol = xlUtil.getCellCount(sheetname, 1);//Get column count
		
		Object loginData[][] = new Object[totalRows][totalcol];
		for(int i=1;i<=totalRows;i++) {//rows ===========rows start with 0 it is header part that is why 1
			
			for(int j = 0; j<totalcol;j++) {//columns
				
				loginData[i-1][j] = xlUtil.getCellData(sheetname, i, j);//InExcel first row is header part but in Array it will strat with 00 
				
		}
	}
	return loginData;
		
	}
	public static void setData(String sheetname,String data) throws IOException
	{
		ExcelUtitlityPOM xlUtil = new ExcelUtitlityPOM(TEST_DATA_SHEET);
		int totalRows = xlUtil.getRowCount(sheetname);//Get number of Rows
		int totalcol = xlUtil.getCellCount(sheetname, 1);//Get column count
		for(int i=1;i<=totalRows;i++) {//rows ===========rows start with 0 it is header part that is why 1
			
			for(int j = 0; j<totalcol;j++) {//columns
				
				xlUtil.setCellData(sheetname, i, j, data);
				
			}
		}
		
		
		
	}

}