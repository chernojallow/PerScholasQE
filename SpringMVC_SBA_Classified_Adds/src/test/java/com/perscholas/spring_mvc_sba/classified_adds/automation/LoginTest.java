package com.perscholas.spring_mvc_sba.classified_adds.automation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	private static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Student\\Documents\\GitHub\\PerScholasQE\\ChromeSeleniumDriver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://localhost:8080/SpringMVC_SBA_Classified_Adds1/");
	}

	@AfterClass
	public static void cleanUp() {
		driver.close();
	}

	@Test
	public void loginTest() {
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys("xiaolin996");
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys("xiaolin996");
		driver.findElement(By.cssSelector("td:nth-child(1) > input")).click();
		assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("Ads"));
	}
}
