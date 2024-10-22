package org.one;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	public static void main(String[] args) throws IOException, InvalidFormatException {
		File f=new File("/Users/dineshwaren/Desktop/ExcelWrite1.xlsx");
		Workbook book=new XSSFWorkbook();
		Sheet sheet = book.createSheet("Sheet1");
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("Alice");
		FileOutputStream out=new FileOutputStream(f);
		book.write(out);
	    String stringCellValue = cell.getStringCellValue();
	    System.out.println(stringCellValue);
		
	}

}
