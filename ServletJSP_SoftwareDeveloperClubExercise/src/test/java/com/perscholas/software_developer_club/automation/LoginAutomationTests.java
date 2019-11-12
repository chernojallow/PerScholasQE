package com.perscholas.software_developer_club.automation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

import java.sql.Connection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.perscholas.software_developer_club.dao.DatabaseConnection;

public class LoginAutomationTests {
	private static WebDriver driver;
	private static DatabaseConnection databaseConnection;
	private static Connection conn;
	private static Boolean databaseIsOnline;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C://Users/Student/Documents/GitHub/PerScholasQE/ChromeSeleniumDriver/chromedriver.exe");
		driver = new ChromeDriver();
		try {
			databaseConnection = new DatabaseConnection();
			conn = databaseConnection.getConnection();
			databaseIsOnline = true;
			conn.close();
		}
		catch (Exception e)
		{
			databaseIsOnline = false;
			System.out.println("Could not connect to the database. Tests "
					+ "will be skipped");
		}
	}
	@AfterClass
	public static void tearDownClass() {
//		driver.close();
	}
	
	@Test
	public void validLoginTest() {
		driver.get("http://localhost:8080/SoftwareDeveloperClubExercise/HomeServlet");
		assumeTrue(databaseIsOnline);
		WebElement nameInput = driver.findElement(By.name("name"));
		nameInput.sendKeys("Lin Xiao");
		WebElement passwordInput = driver.findElement(By.name("password"));
		passwordInput.sendKeys("xiaolin996");
		WebElement submitButton = driver.findElement(By.cssSelector("body > form > div:nth-child(3) > input[type=submit]"));
		submitButton.click();
		
		assertEquals(driver.getTitle(), "Welcome");
	}
}