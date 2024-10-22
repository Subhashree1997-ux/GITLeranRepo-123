package org.one;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	public static void main(String[] args) throws IOException {
		File f=new File("/Users/dineshwaren/Desktop/ExcelRead.xlsx");
		FileInputStream fs=new FileInputStream(f);
		Workbook book=new XSSFWorkbook(fs);
		Sheet sheet=book.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		Cell cell=row.getCell(1);
		String stringCellValue = cell.getStringCellValue();
		System.out.println(stringCellValue);
	}
	

}
