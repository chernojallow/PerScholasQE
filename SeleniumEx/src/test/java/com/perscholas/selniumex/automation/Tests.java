package com.perscholas.selniumex.automation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tests {
	private static WebDriver driver;
	@BeforeClass
	public static void setUp() {
		/* The System.setProperty() method accepts two strings as arguments. Be sure 
		 * these strings align with the particular WebDriver that you intend to use 
		 * and the location of the WebDriver file on your computer. In this example, 
		 * we are using the Chrome WebDriver and then providing the path to the 
     		 * location of the WebDriver file on the device used to create this project. 
                 * Also note that the filename must include .exe on Windows computers */
		System.setProperty("webdriver.chrome.driver", "C://Users/Student/eclipse-workspace/"
				+ "ChromeSeleniumDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://perscholas.org/");
		//driver.get("http://localhost:8080/SeleniumEx/HomeServlet");
	}
	@AfterClass
	public static void shutDown() {
		//driver.close();
	}
	
	@Test
	public void testMessage() {
		/* The WebDriver interface also has methods to find elements on the web 
		 * page. In the following example we will locate the element by it's CSS 
		 * selector. The various ways of locating elements will be discussed 
		 * further in subsequent lessons. */
		WebElement message = driver.findElement(By.cssSelector("h1"));
		// Now we will obtain the text inside the tag with the "getText()" method.
		String actual = message.getText();
		String expected = "Hello Selenium!";
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void testTitle() {
		/* The WebDriver interface includes a method for obtaining the title of a 
		 * web page. In the following test we will assert that the title of the 
		 * web page equals to an expected value. If this turns out to be true, 
		 * then the test passes. */
		String actual = driver.getTitle();
		String expected = "Hello Selenium";
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void test1() {
		WebElement element = driver.findElement(By.cssSelector("#main > div > div > div > div > h1"));
		String actual = element.getText();
		assertThat(actual, equalTo("TECHNOLOGY AT WORK"));
	}
	
	@Test
	public void test2() {
		WebElement element = driver.findElement(By.cssSelector("#header > nav > div > div > ul > li > a"));;
		element.click();
		String actual = element.getText();
		assertThat(actual, equalTo("ABOUT"));
	}
	
	@Test
	public void test3() {
		driver.get("https://www.google.com/");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("food near me\n");
		//element.sendKeys(Keys.RETURN);
	}
}