package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public static  String fetchingDataFromExcelFile(String sheetName , int rowIndex,int cellIndex ) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream(IPathUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(file);
//		Sheet sh = wb.getSheet("Animal");
//		Row row = sh.getRow(1);
		Cell cell = wb.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex);
		DataFormatter df = new DataFormatter();
		String value = df.formatCellValue(cell);
		return value;
		
		
	}
	/**
	 * 
	 * @param sheetName
	 * @param startRowIndex
	 * @param startCellIndex
	 * @return List<String>
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public   List<String> fetchingMultipleDataFromExcelFile(String sheetName,int startRowIndex,int startCellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream(IPathUtility.moduleExcelFilePath);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet(sheetName);
		DataFormatter df = new DataFormatter();
		List<String> data= new ArrayList();
		for(int i =startRowIndex;i<=sh.getLastRowNum();i++)
		{
			Row row = sh.getRow(i);
			for(int j=startCellIndex;j<row.getLastCellNum();j++)
			{
				Cell cell = row.getCell(j);
				String value = df.formatCellValue(cell);
//				System.out.println(value);
				data.add(value);	
			}
		}
		return data;
		
	}
	/**
	 * 
	 * @param sheetName
	 * @param startRowIndex
	 * @param startCellIndex
	 * @return List<String>
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public   List<String> fetchingMultipleDataFromExcelFileForFixedRowCrm(String sheetName,int rowIndex,int startCellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream(IPathUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet(sheetName);
		DataFormatter df = new DataFormatter();
		List<String> data= new ArrayList();
		
			Row row = sh.getRow(rowIndex);
			for(int j=startCellIndex;j<row.getLastCellNum();j++)
			{
				Cell cell = row.getCell(j);
				String value = df.formatCellValue(cell);
				data.add(value);
			}
		
			return data;
		}
		
	}
	

