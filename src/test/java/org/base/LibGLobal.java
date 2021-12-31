package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibGLobal {
WebDriver driver;

public void getDriver() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
}
public void loadUrl(String Url) {
	driver.get(Url);
}
public void maximize() {
	driver.manage().window().maximize();
}
public void type(WebElement element,String data) {
	element.sendKeys(data);
}
public void type(WebElement element) {
element.click();
}
public WebElement findElementById(String attribute ) {
WebElement element=driver.findElement(By.id(attribute));
return element;
}
public WebElement findElementByName(String attribute) {
	WebElement element = driver.findElement(By.name(attribute));
	return element;			
}
public WebElement findElementByclassName(String attribute) {
	WebElement element = driver.findElement(By.className(attribute));
	return element;
}
public WebElement findElementByXpath(String xpathExpression) {
	WebElement element = driver.findElement(By.xpath(xpathExpression));
	return element;
}

public String getText(WebElement element) {
String text = element.getText();
return text;
}
public String getTitle() {
	String title = driver.getTitle();
	return title;
}
public String getcurrentUrl() {
	String data=driver.getCurrentUrl();
	return data;
}
public String getAttributevalue(WebElement element) {
	String data = element.getAttribute("value");
	return data;
}
public String getAttributevalue(WebElement element,String attributeName) {
	String data = element.getAttribute(attributeName);
	return data;
}
public void selectoptionByText(WebElement element,String data) {
	Select select = new Select(element);
	select.selectByVisibleText(data);	
}
public void selectoptionByAttribute(WebElement element,String attributevalue) {
Select select = new Select(element);
select.selectByValue(attributevalue);
}
public void selectoptionByIndex(WebElement element,int index) {
	Select select = new Select(element);
	select.selectByIndex(index);
}
public void typeJs(WebElement element,String data) { 
	JavascriptExecutor executor =(JavascriptExecutor)driver;
	executor.executeScript("arguments, setAttribute('value','"+data+"')",element);
}

public void getAttribute(WebElement element) {
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("return arguments[0].getAttribute('value')", element);
}

public void scrollIntoView(WebElement element) {
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("argument[0].scrollIntoView(true)", element);
}

public void scrollIntoView2(WebElement element) {
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("argument[0].scrollIntoView(false)", element);
}

public void jsClick(WebElement element) {
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("argument[0].click", element);
}

public List SelectAllOptions(WebElement elements) {
	Select select = new Select(elements);
	List<WebElement> options = select.getOptions();
	return options;
	}
public List SelectAllSelectedOptions(WebElement elements) {
	
	Select select = new Select(elements);
	List<WebElement> options = select.getAllSelectedOptions();
	return options;
}
public WebElement FirstSelectedOptions(WebElement element) {
	Select select = new Select(element);
    WebElement firstSelectedOption = select.getFirstSelectedOption();
	return firstSelectedOption;
}
	
public boolean ISMultiple(WebElement element) {
	Select select = new Select(element);
	boolean multiple = select.isMultiple();
	return multiple;
	}

public void deSelect(WebElement element) {
	Select select = new Select(element);
	select.deselectAll();
}

public void MoveToElement(WebElement element) {
	Actions action = new Actions (driver);
	action.moveToElement(element).perform();
}
public void Contextclick() {
  Actions action = new Actions (driver);
	action.contextClick().perform();
}

public void doubleclick() {
	 Actions action = new Actions (driver);
	 action.doubleClick().perform();
}

public void draganddrop(WebElement source,WebElement target) {
	 Actions action = new Actions (driver);
	action.dragAndDrop(source, target).perform();
}

public void WindowHandle(String nameOrHandle) {
	driver.switchTo().window(nameOrHandle);
}

public void Frames(String index) {
	driver.switchTo().frame(index);
}
public void Navigatorback() {
	driver.navigate().back();
}

public void Navigatorforward() {
	driver.navigate().forward();
}

public void Navigatorrefresh() {
	driver.navigate().refresh();
}
public void Sleep() throws Exception {
	Thread.sleep(3000);
}

public void RoboPress(int arg0) throws AWTException {
	Robot r = new Robot();
	r.keyPress(arg0);
}

public void Roborelese(int keycode) throws AWTException {
	Robot r = new Robot();
	r.keyRelease(keycode);
}

public void enter() throws AWTException {
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyPress(KeyEvent.VK_ENTER);
}

public void keyup(CharSequence key) {
	Actions action = new Actions (driver);
	action.keyUp(key);
}

public void keydown(CharSequence key) {
	Actions action = new Actions (driver);
	action.keyDown(key);
}

public void screeshot(OutputType<Object> target) {
	TakesScreenshot screenshot = (TakesScreenshot) driver;
	screenshot.getScreenshotAs(target);
}

public void copy(File srcFile,File destFile) throws Exception {
	FileUtils.copyFile(srcFile, destFile);
}

public int Scannernextint() {
	Scanner s = new Scanner(System.in);
	int nextInt = s.nextInt();
	return nextInt;
}

public void printout() {
	System.out.println();
}

public void Frames() {
	driver.switchTo().defaultContent();
}

public String windowhandle() {
	String windowHandle = driver.getWindowHandle();
	return windowHandle;
}

public Set windowhandles() {
	Set<String> windowHandle = driver.getWindowHandles();
	return windowHandle;
}

public void waits(Duration duration) {
	driver.manage().timeouts().implicitlyWait(duration);
}

public Sheet getsheet(String arg0,int index,int index1) {
Workbook book = new XSSFWorkbook();
Sheet sheet = book.getSheet(arg0);
 Row row = sheet.getRow(0);
 Cell cell = row.getCell(0);
 int type = cell.getCellType();
 String value = cell.getStringCellValue();
 double cellValue = cell.getNumericCellValue();
 
return sheet;
}

public void text (String sheetname,int rowno,int cellno,String data) throws IOException {
	File file = new File ("C:\\Users\\hp\\eclipse-workspace\\FrameWorkClass\\WorkBook\\Book.xlsx");
	FileInputStream stream = new FileInputStream(file);
	Workbook book = new XSSFWorkbook(stream);
	Sheet sheet = book.getSheet(sheetname);
	Row row = sheet.getRow(rowno);
	Cell cell = row.createCell(cellno);
	cell.setCellValue(data);
	FileOutputStream output = new FileOutputStream(file);
	book.write(output);
}

public String getData(String name,int rownum,int cellnum) throws IOException  {
	String data = null;
	File file =new File("C:\\Users\\hp\\eclipse-workspace\\FrameWorkClass\\WorkBook\\Hello.xlsx");
	FileInputStream stream=new FileInputStream(file);
	Workbook book = new XSSFWorkbook(stream);
	Sheet sheet = book.getSheet(name);
	Row row = sheet.getRow(rownum);
	Cell cell = row.getCell(cellnum);
	int type = cell.getCellType();
	
	if (type==1) {
		data  = cell.getStringCellValue();
	}
	
	if (type==0) {
		
		if (DateUtil.isCellDateFormatted(cell)) {
			Date date = cell.getDateCellValue();
			SimpleDateFormat dateformat = new SimpleDateFormat ("dd/MM/yyyy");
			data = dateformat.format(date);
		}
		else {
			double d = cell.getNumericCellValue();
			long l = (long)d;
			data = String.valueOf(l);
		}
	}
	return data;
}
public void getUpdate(String name,int rownum,int cellnum,String oldData,String newData) throws IOException {
	File file =new File("C:\\Users\\hp\\eclipse-workspace\\FrameWorkClass\\WorkBook\\Hello.xlsx");
	FileInputStream stream=new FileInputStream(file);
	Workbook workbook = new XSSFWorkbook(stream);
	Sheet sheet = workbook.getSheet(name);
	Row row = sheet.getRow(rownum);
	Cell cell = row.getCell(cellnum);
	String data = cell.getStringCellValue();
	if(data.equals("old data")) {
		cell.setCellValue(newData);
	}
	FileOutputStream output = new FileOutputStream(file);
	workbook.write(output);
}

public void writeData(String sheetname,int rowno,int cellno,String data) throws IOException {
	File file = new File ("C:\\Users\\hp\\eclipse-workspace\\FrameWorkClass\\WorkBook\\AdactinHotel.xlsx");
	FileInputStream stream = new FileInputStream(file);
	Workbook book = new XSSFWorkbook(stream);
	Sheet sheet = book.createSheet("Hotel");
	Row row = sheet.createRow(0);
	Cell cell = row.createCell(0);
	cell.setCellValue("userName");
	FileOutputStream output = new FileOutputStream(file);
	book.write(output);
}





public void DateForm(Date data) {
SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yy");
String format = dateformat.format(data);
}
public void alertOk() {
	Alert alert = driver.switchTo().alert();
	alert.accept();
}

public void alertCancel() {
	Alert alert = driver.switchTo().alert();
	alert.dismiss();
}

public void closeAllWindow() {
	driver.quit();
}

public void closeCurrentWindow() {
	driver.close();
}

}
































