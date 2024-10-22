package org.one;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWithDifferentDataType {
	public static void main(String[] args) throws IOException {
		File f=new File("/Users/dineshwaren/Desktop/ExcelRead.xlsx");
		FileInputStream fs=new FileInputStream(f);
		Workbook book=new XSSFWorkbook(fs);
		Sheet sheet=book.getSheet("Sheet1");
		for(int i=0;i<sheet.getPhysicalNumberOfRows();i++) {
			Row row = sheet.getRow(i);
			for(int j=0;j<row.getPhysicalNumberOfCells();j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				switch(cellType) {
				case STRING:
					String stringCellValue = cell.getStringCellValue();
					System.out.print(stringCellValue+"\t");
				    break;
				default: 
					if(DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat s=new SimpleDateFormat("dd/MMMM/YYYY");
						String format = s.format(dateCellValue);
						System.out.print(format+"\t");
					}else {
						double numericCellValue = cell.getNumericCellValue();
						long l=(long)numericCellValue;
						System.out.print(l+"\t");
					}
					break;
				}
				
					
			}
			System.out.println();
		}
	}


}
