package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
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
}
