package com.sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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

public class Automation {
public static void main(String[] args) throws IOException{
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("http://demo.automationtesting.in/Register.html");
	WebElement element = driver.findElement(By.id("Skills"));
	Select select = new Select(element);
	List<WebElement> options = select.getOptions();

	List<String> list = new ArrayList<String>();
	for (WebElement x :options) {
		String text = x.getText();
		list.add(text);	
	}
	System.out.println(list);
	
	File file=new File("c:\\Users\\hp\\eclipse-workspace\\FrameWorkClass\\WorkBook\\Hello.xlsx");
	Workbook workbook = new XSSFWorkbook();
	Sheet sheet = workbook.createSheet("SkillsSheet");
	for (int i = 0; i <list.size(); i++) {
		Row row = sheet.createRow(i);
		Cell cell = row.createCell(0);
		cell.setCellValue(list.get(i));
	}
	FileOutputStream stream = new FileOutputStream(file);
	workbook.write(stream);
	
	System.out.println("Done.................");
	
}	
	
}


