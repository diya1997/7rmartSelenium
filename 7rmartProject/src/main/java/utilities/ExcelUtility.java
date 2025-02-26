package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;

public class ExcelUtility {
	static FileInputStream f;// to read from excel
	static XSSFWorkbook wb;// to readfrom workbook
	static XSSFSheet sh;// to get data from sheet

	public static String getStringData(int a, int b,String sheetName) throws IOException {
		f = new FileInputStream(Constants.TESTDATAFILE);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheetName);
		XSSFRow r = sh.getRow(a);// XSSFRow-class
		XSSFCell c = r.getCell(b);
		return c.getStringCellValue();
	}

	public static String getIntegerData(int a, int b,String sheetName) throws IOException {
		f = new FileInputStream(Constants.TESTDATAFILE);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheetName);
		XSSFRow r = sh.getRow(a);
		XSSFCell c = r.getCell(b);
		int v = (int) c.getNumericCellValue();
		return String.valueOf(v);
	}

}
