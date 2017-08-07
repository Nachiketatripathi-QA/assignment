package com.qait.main;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {
	Actions action;

	@Test(dataProvider = "mailingDetails")
	public void sendingMails(String recipient, String subject, String contentMail) throws Exception {
		System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://accounts.google.com");
		driver.findElement(By.id("identifierId")).sendKeys("nachiketatripathi111qait@gmail.com");
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("nachi111.");
		driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@aria-label='Mail']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[text()='COMPOSE']")).click();
		Thread.sleep(1000);
		Thread.sleep(2000);
		driver.findElement(By.className("vO")).sendKeys(recipient);
		Thread.sleep(500);
		driver.findElement(By.className("aoT")).sendKeys(subject);
		Thread.sleep(500);
		driver.findElement(By.xpath("(.//*[@aria-label='Message Body'])[2]")).sendKeys(contentMail);
		Thread.sleep(500);
		driver.findElement(By.cssSelector("[aria-label='Send ‪(Ctrl-Enter)‬']")).click();
		driver.findElement(By.xpath("//span[@class='gb_7a gbii']")).click();
		driver.findElement(By.xpath(".//a[@id='gb_71']")).click();
		Thread.sleep(5000);
	}

	@DataProvider(name = "mailingDetails", parallel = true)
	public Object[][] mailingDetails() throws IOException {
		action = new Actions();
		Object[][] obj = action.readFromExcel();
		return obj;
	}

}