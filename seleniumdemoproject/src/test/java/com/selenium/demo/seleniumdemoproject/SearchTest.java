package com.selenium.demo.seleniumdemoproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SearchTest {

	public WebDriver driver;

	public SearchTest() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Mak\\Desktop\\SeleniumFolder\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://link.springer.com/");
		driver.manage().window().maximize();

	}

	@Test(testName = "search valid results")
	public void searchProduct() throws InterruptedException {
		driver.findElement(By.id("query")).clear();
		driver.findElement(By.id("query")).sendKeys("selenium");
		driver.findElement(By.id("search")).click();
		Thread.sleep(3000);
		String s = driver.findElement(
				By.className("number-of-search-results-and-search-terms"))
				.getText();
		Reporter.log("results is  " + s, true);
	 Assert.assertEquals(s, "50,027 Result(s) for 'selenium'");

	}
	
	@Test(testName = "search valid results")
	public void textBoxProgram() throws InterruptedException {
		driver.findElement(By.id("query")).clear();
		driver.findElement(By.id("query")).sendKeys("''''");
		driver.findElement(By.id("search")).click();
		Thread.sleep(3000);
		String s = driver.findElement(
				By.className("number-of-search-results-and-search-terms"))
				.getText();
		Reporter.log("results is  " + s, true);
	 Assert.assertEquals(s, "0 Result(s) for ''''''");

	}

}
