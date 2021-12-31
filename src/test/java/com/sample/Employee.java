package com.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Employee {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\hp\\eclipse-workspace\\FrameWorkClass\\WorkBook\\Book.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("Datas");
		int rowcount = sheet.getPhysicalNumberOfRows();
		for (int i = 0; i <rowcount; i++) {
		Row row = sheet.getRow(i);
		int cellcount = row.getPhysicalNumberOfCells();
		for (int j = 0; j < cellcount; j++) {
			Cell cell = row.getCell(j);
			System.out.println(cell);
		}
		
		}
		}
		
	}

	


