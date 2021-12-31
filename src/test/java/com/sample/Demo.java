package com.sample;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
public static void main(String[] args) throws IOException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("http://demo.automationtesting.in/Register.html");
//    List<WebElement> findElements = driver.findElements(By.id("Skills"));
	WebElement element = driver.findElement(By.id("Skills"));
	
	Select select = new Select(element);
	List<WebElement> options = select.getOptions();
	File file = new File("C:\\Users\\hp\\eclipse-workspace\\FrameWorkClass\\WorkBook\\Hello3.xlsx");
	Workbook workbook = new XSSFWorkbook();
	Sheet sheet = workbook.createSheet("SkillsSheet");
	int size = options.size();
	
	
	
	for (int i = 0; i < options.size(); i++) {
		WebElement element2 = options.get(i);
		String text = element2.getText();
//		System.out.println(text);
			
		for (int j = 0; j <size-1; j++) {
			Row row = sheet.createRow(j);
        	Cell cell = row.createCell(0);
			cell.setCellValue(text);
			FileOutputStream stream = new FileOutputStream(file);
			workbook.write(stream);		
		}
	
	}
	
//	FileOutputStream stream = new FileOutputStream(file);
//	workbook.write(stream);
//	
	
	System.out.println("Done.................");
}
}

