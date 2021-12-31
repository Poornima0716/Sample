package com.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sample {
	public static void main(String[] args) throws Exception {
	File file = new File("C:\\Users\\hp\\eclipse-workspace\\FrameWorkClass\\WorkBook\\WorskSheet1.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
	Sheet sheet = workbook.getSheet("Data");
	int rowcount = sheet.getPhysicalNumberOfRows();
	for (int i = 0; i <rowcount; i++) {
		Row row = sheet.getRow(i);
		int cellcount = row.getPhysicalNumberOfCells();
		for (int j = 0; j <cellcount; j++) {
			Cell cell = row.getCell(j);
			int type = cell.getCellType();
			if(type==1) {
				String data = cell.getStringCellValue();
				System.out.println(data);
			}
			else {
				if(DateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
					String data = dateFormat.format(date);
					System.out.println(data);
				}
			}
			if(type==0) {
				double d = cell.getNumericCellValue();
				long l = (long)d;
				String data = String.valueOf(l);
				System.out.println(data);
			}
			
		}
		
	}
		
	}

}
