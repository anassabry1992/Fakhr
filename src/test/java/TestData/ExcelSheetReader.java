package TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelSheetReader {
	
	private static FileInputStream fis = null;
	
	public Object[][] getExcelData(int index,int colsOnSheet) throws IOException{
		
		String filePath = System.getProperty("user.dir")+"//testData//DataFakhr.xlsx";
		File dataFile = new File(filePath);
		fis = new FileInputStream(dataFile);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(index);
		int totRow = sheet.getLastRowNum()+1;
		int totCol = colsOnSheet;
		String [][] arrExcel = new String[totRow][totCol];
		
		for (int row = 0; row < totRow; row++) {
			for (int col = 0; col < totCol; col++) {
				XSSFRow rowSh = sheet.getRow(row);
				DataFormatter df = new DataFormatter();
				arrExcel[row][col] = df.formatCellValue(rowSh.getCell(col)).toString();
			}
		}
		
		wb.close();
		return arrExcel;
	}
}
