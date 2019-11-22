package com.perscholas.spring_mvc_sba.classified_adds.automation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdTest {
	private static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Student\\Documents\\GitHub\\PerScholasQE\\ChromeSeleniumDriver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://localhost:8080/SpringMVC_SBA_Classified_Adds1/allAds");
	}

	@AfterClass
	public static void cleanUp() {
		driver.close();
	}

	@Test
	public void adTest() {
		driver.findElement(By.id("name")).click();
		driver.findElement(By.id("name")).sendKeys("xPhone");
		driver.findElement(By.id("price")).click();
		driver.findElement(By.id("price")).sendKeys("555.55");
		driver.findElement(By.cssSelector("input:nth-child(3)")).click();
		assertThat(driver.findElement(By.cssSelector("td:nth-child(2)")).getText(), is("xPhone"));
	}
}
