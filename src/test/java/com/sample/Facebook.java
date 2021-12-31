package com.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://en-gb.facebook.com/");
	
	WebElement txtUserName = driver.findElement(By.id("email"));
	txtUserName.sendKeys("Poornimaashok0716@gmail.com");
	WebElement txtPassword = driver.findElement(By.id("pass"));
	txtPassword.sendKeys("poorniashok*0716");
	WebElement btnLogin = driver.findElement(By.xpath("//button[text()='Log In']"));
	btnLogin.click();
}
}
