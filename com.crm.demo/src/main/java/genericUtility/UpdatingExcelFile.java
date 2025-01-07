package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UpdatingExcelFile {
	public static void updateDataInExcelFile(String sheetName) throws Exception
	{
		FileInputStream fis = new FileInputStream(IPathUtility.moduleExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		sh.createRow(6).createCell(0).setCellValue("Blue Whale");
//		sh.createRow(6).createCell(0).setCellValue("Blue Whale");
		FileOutputStream fos= new FileOutputStream(IPathUtility.moduleExcelFilePath);
		wb.write(fos);
	}
}
