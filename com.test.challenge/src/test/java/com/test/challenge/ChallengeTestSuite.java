package com.test.challenge;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChallengeTestSuite {
	
	public static WebDriver driver;
	
	WebDriverWait wait = new WebDriverWait(driver, 5);

	@BeforeClass
	public static void SetUp() {
		System.setProperty("webdriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void test1() {
		driver.get("https://google.com/maps");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//button)[2]")).click();
	}
	
	@Test
	public void test2() {
		driver.findElement(By.id("searchboxinput")).sendKeys("Dublin" + Keys.ENTER);	
	}
	
	@Test
	public void test3() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),\"Dublin\")])[1]")));
		String title = driver.findElement(By.xpath("(//span[contains(text(),\"Dublin\")])[1]")).getText();
		assertEquals("Dublin", title);
	}
	
	@Test
	public void test4() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("(//button[contains(@aria-label, \"Direções\")])[2]"))));
		driver.findElement(By.xpath("(//button[contains(@aria-label, \"Direções\")])[2]")).click();
		//String destination = driver.findElement(By.xpath("//*[contains(@aria-label,\"Dublin\")]/parent::*/input")).getText();
		//System.out.println(destination);
	}
	
	//@Test
	//public void test5() {
		//String destination = driver.findElement(By.xpath("//*[contains(@aria-label,\"Dublin\")]/parent::*/input")).getText();
		//assertEquals("Dublin", destination);
	//}
	
	@AfterClass
	public static void TearDown() {
		driver.quit();
		
	}

}
