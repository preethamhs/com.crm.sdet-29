package com.calenders;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CalenderPopupsTest {
	
	@Test
	public void calender() {
		
		int day=13;
		String monthAndYear="March 2022";
		
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
