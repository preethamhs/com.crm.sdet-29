package com.calenders;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CalenderSysDate {
	
 @Test
 public void sysDate() {
	 LocalDateTime sysdate=LocalDateTime.now();
		int day = sysdate.getDayOfMonth();
		String month = sysdate.getMonth().toString();
		String actMonth = month.substring(0,1)+month.substring(1).toLowerCase();
		String monthAndYear = actMonth+" "+sysdate.getYear();
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.className("langCardClose")).click();
		Actions act=new Actions(driver);
		act.moveByOffset(10, 20).click().perform();
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		driver.findElement(By.xpath("//div[.='"+monthAndYear+"']/ancestor::div[@class='DayPicker']/descendant::p[.='"+day+"']")).click();

 }

}
