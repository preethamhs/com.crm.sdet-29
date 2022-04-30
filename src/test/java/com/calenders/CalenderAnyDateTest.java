package com.calenders;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CalenderAnyDateTest {
	
	@Test
	public void anyDateAndMonth() {
		int day =15;
		String monthAndYear ="February 2023";	
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.className("langCardClose")).click();
		Actions act=new Actions(driver);
		act.moveByOffset(10, 20).click().perform();
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		for(;;)
		try {
		driver.findElement(By.xpath("//div[.='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+day+"']")).click();
		break;
		}
		catch (Exception e) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
		
	}

}
