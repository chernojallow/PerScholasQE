package com.perscholas.servletjsp.automation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ServletJSPAutomationTest {
	private static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		/*
		 * The System.setProperty() method accepts two strings as arguments. Be sure
		 * these strings align with the particular WebDriver that you intend to use and
		 * the location of the WebDriver file on your computer. In this example, we are
		 * using the Chrome WebDriver and then providing the path to the location of the
		 * WebDriver file on the device used to create this project. Also note that the
		 * filename must include .exe on Windows computers
		 */
		System.setProperty("webdriver.chrome.driver", "C://Users/Student/Documents/GitHub/PerScholasQE/ChromeSeleniumDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/ServletJSP/HomeServlet");
	}

	@AfterClass
	public static void shutDown() {
//		driver.close();
	}
	
	@Test
	public void test1() {
		WebElement we = driver.findElement(By.cssSelector("h1"));
		String actual = we.getText();
		assertThat(actual, equalTo("Hello Per Scholas!"));
	}
	
	@Test
	public void test2() {
		WebElement we = driver.findElement(By.cssSelector("body > div > p"));
		String actual = we.getText();
		System.out.println(actual);
		assertThat(actual, equalTo("another p tag"));
	}
	
	@Test
	public void test3() {
		driver.findElement(By.cssSelector("a")).click();
		String actual = driver.getTitle();
		assertThat(actual, is("Per Scholas"));
	}
	
	
}
