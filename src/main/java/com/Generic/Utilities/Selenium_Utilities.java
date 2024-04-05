package com.Generic.Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Selenium_Utilities extends PropertiesFile_Utilities{
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void dropDown(WebElement element,String text) {
		Select se = new Select(element);
		se.selectByVisibleText(text);
	}
	
	public void navigate(WebDriver driver,String key) throws IOException {
		driver.navigate().to(readData(key));
	}
	
	public void windowHandle(WebDriver driver) {
		Set<String> winds = driver.getWindowHandles();
		for (String string : winds) {
			driver.switchTo().window(string);
			if(driver.getTitle().equals("")) {
				break;
			}
		}
	}
	
	public void parentWindow(WebDriver driver) {
		Set<String> winds = driver.getWindowHandles();
		for (String string : winds) {
			driver.switchTo().window(string);
			if(driver.getTitle().equals("Administrator - Service Contracts - vtiger CRM 5 - Commercial Open Source CRM")) {
				break;
			}
		}
	}
	
	public void alertAccept(WebDriver driver) throws InterruptedException {
		driver.switchTo().alert().accept();
		Thread.sleep(10000);
	}
	
	public String screenshot(WebDriver driver,String name) throws Exception {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".//Screenshot/"+name+new Java_Utility().getDate()+".png");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
	}

}
