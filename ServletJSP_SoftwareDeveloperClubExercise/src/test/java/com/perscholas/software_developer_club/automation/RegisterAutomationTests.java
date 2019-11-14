package com.perscholas.software_developer_club.automation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

import java.sql.Connection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.perscholas.software_developer_club.dao.DatabaseConnection;

public class RegisterAutomationTests {
	private static WebDriver driver;
	private static DatabaseConnection databaseConnection;
	private static Connection conn;
	private static Boolean databaseIsOnline;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C://Users/Student/Documents/GitHub/PerScholasQE/ChromeSeleniumDriver/chromedriver.exe");
		driver = new ChromeDriver();
		try {
			databaseConnection = new DatabaseConnection();
			conn = databaseConnection.getConnection();
			databaseIsOnline = true;
			conn.close();
		} catch (Exception e) {
			databaseIsOnline = false;
			System.out.println("Could not connect to the database. Tests " + "will be skipped");
		}
	}

	@AfterClass
	public static void tearDownClass() {
//		driver.close();
	}

	@Test
	public void validRegisterTest() {
		driver.get("http://localhost:8080/SoftwareDeveloperClubExercise/HomeServlet");
		assumeTrue(databaseIsOnline);
		driver.findElement(By.cssSelector("body > a")).click();
		
		driver.findElement(By.name("name")).sendKeys("Chen Li");
		driver.findElement(By.name("email")).sendKeys("chenli123@gmail.com");
		driver.findElement(By.name("password")).sendKeys("chenli123");
		driver.findElement(By.name("favoriteLanguage")).sendKeys("Chinese");
		driver.findElement(By.cssSelector("body > form > div:nth-child(5) > input[type=submit]")).click();

		assertEquals(driver.getTitle(), "Login Page");
	}
}
