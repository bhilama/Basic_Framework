package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;

	public ExcelDataProvider() {
		File scr = new File("./testdata/Data.xlsx");
		
		
		try {
			FileInputStream fin = new FileInputStream(scr);
			wb = new XSSFWorkbook(fin);
		}
		catch(IOException e) {
			System.out.println("Unable to read excel file - " + e.getMessage());
		}
		
	}
	
	public String getStringData(String sheetName, int row, int column) {
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericData(String sheetName, int row, int column) {
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
	
	public String getStringData(int sheetIndex, int row, int column) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericData(int sheetIndex, int row, int column) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getNumericCellValue();
	}
}
