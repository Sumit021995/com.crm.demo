package sampleDataFetch;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataFromExcelFile 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\TestData\\Module.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet("Animal");
		Row row = sh.getRow(1);
		Cell cell = row.getCell(1);
		DataFormatter df = new DataFormatter();
		String value = df.formatCellValue(cell);
//		return value;
		System.out.println(value);
	}
//	public static  void fetchingDataFromExcelFile() throws EncryptedDocumentException, IOException
//	{
//		FileInputStream file = new FileInputStream("C:\\Users\\sumit\\git\\com.crm.demo\\com.crm.demo\\src\\test\\resources\\TestData\\Module.xlsx");
//		Workbook wb = WorkbookFactory.create(file);
//		Sheet sh = wb.getSheet("Animal");
//		Row row = sh.getRow(1);
//		Cell cell = row.getCell(1);
//		DataFormatter df = new DataFormatter();
//		String value = df.formatCellValue(cell);
////		return value;
//		System.out.println(value);
//		
//	}
}
