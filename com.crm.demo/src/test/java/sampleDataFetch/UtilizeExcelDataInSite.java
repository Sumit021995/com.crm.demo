package sampleDataFetch;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import genericUtility.ExcelUtility;

public class UtilizeExcelDataInSite {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ExcelUtility eUtility = new ExcelUtility();
		String excelData1=eUtility.fetchingDataFromExcelFile("Leads", 2, 1);
		String excelData2=eUtility.fetchingDataFromExcelFile("Leads", 2, 2);
		String excelData3=eUtility.fetchingDataFromExcelFile("Contacts", 2, 2);
		String excelData4=eUtility.fetchingDataFromExcelFile("Contacts", 2, 1);
		System.out.println(excelData1);
		System.out.println(excelData2);
		System.out.println(excelData3);
		System.out.println(excelData4);
		
	}
}
