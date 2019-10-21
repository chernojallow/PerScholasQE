package com.perscholas.selenium.locators.automation;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsTest {
	private static WebDriver driver;
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C://Users/Student/eclipse-workspace/"
				+ "ChromeSeleniumDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/SeleniumLocators/");
	}
	@AfterClass
	public static void shutDown() {
		driver.close();
	}
	@Test
	public void findByCssSelector() {
		WebElement courseElement = driver.findElement(By.cssSelector("div > h1"));
		String actual = courseElement.getText();
		assertThat(actual, equalTo("Courses"));
		/* The CSS selector in this example could have included the cascading tag 
		 * elements all the way back to <html> but this would be unnecessary. The only 
		 * condition is that the selector pattern is unique and "div > h1" satisfies 
		 * that condition. However, the patterns "html > body > div > h1" or 
		 * "body > div> h1" would have also worked. CSS selectors will be discussed 
		 * further in a subsequent lesson. */
	}
	@Test
	public void findByXPath() {
		String actual = driver.findElement(By.xpath("//*[@id=\"div2\"]/h1")).getText();
		assertThat(actual, equalTo("Courses"));
		/* This is one example of an XPath pattern being used to locate a web element. 
		 * There are various attributes and values that can be used to locate a web 
		 * element by XPath. This will be discussed further in a subsequent lesson. */
	}
	@Test
	public void findById() throws InterruptedException {
		long secondsSinceMidnight = LocalTime.MIDNIGHT.until(LocalTime.now(), ChronoUnit.SECONDS);
		/* We don't want to run this test right at midnight to account for the slight 
		 * chance that the day may change over on the second date reading and result 
		 * in a failed test. Therefore, we will wait 3.1 seconds if the time is 
		 * within 3 seconds of midnight. There are 86,400 seconds in a day so we will 
		 * wait if "secondsSinceMidnight" is greater than 86,397. */
		if (secondsSinceMidnight > 86397) {
			Thread.sleep(3100);
		}
		String dateTimeText = driver.findElement(By.id("dateTime")).getText();
		String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern
				("MMMM d, yyyy"));
		assertThat(dateTimeText, containsString("Today's date and time is " 
				+ currentDate));
	}
	@Test
	public void findByName() {
		driver.findElement(By.name("userName")).sendKeys("John");
		driver.findElement(By.name("submit")).click();
		String welcomeMessage = driver.findElement(By.id("welcomeMessage")).getText();
		assertThat(welcomeMessage, equalTo("Welcome John!"));
	}
	@Test
	public void findByClassName() {
		/* Finding elements by class name implies that we will be searching for 
		 * several elements of the same class so therefore we should expect a list 
		 * in return. The method "findElements()" does exactly that. The web elements 
		 * identified by the class "courseName" will return <td> elements from which 
		 * we will obtain text consisting of each of the course names. */
		List<WebElement> elementList = driver.findElements(By.className("courseName"));
		/* We need to load the text from each of the web elements into another list in 
		 * order to test for the presence of each string using the Hamcrest matcher "hasItems()". */
		List<String> courseNames = new ArrayList<>();
		for (WebElement we : elementList) {
			courseNames.add(we.getText());
		}
		String expected1 = "Application Support Management";
		String expected2 = "Data Engineering";
		String expected3 = "Quality Engineering & Assurance";
		assertThat(courseNames.size(), equalTo(3));
		assertThat(courseNames, hasItems(expected1, expected2, expected3));
	}
}