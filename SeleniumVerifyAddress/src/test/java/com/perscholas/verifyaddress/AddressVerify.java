package com.perscholas.verifyaddress;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AddressVerify {

	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C://Users/Student/eclipse-workspace/ChromeSeleniumDriver/chromedriver.exe");
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void perScholas() {
	    driver.get("https://perscholas.org/");
	    driver.manage().window().setSize(new Dimension(1280, 680));
	    driver.findElement(By.cssSelector(".dropdown > #mapToggle")).click();
	    {
	      WebElement element = driver.findElement(By.cssSelector(".active > a"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    driver.findElement(By.cssSelector(".list-group-item:nth-child(1) > a")).click();
	    assertThat(driver.findElement(By.cssSelector(".dropdown > #mapToggle")).getText(), is("ATLANTA"));
	    driver.findElement(By.cssSelector(".col-sm-5 > div:nth-child(2)")).click();
	    vars.put("adrs", driver.findElement(By.cssSelector("address")).getText());
	    System.out.println(vars.get("adrs").toString());
	}
	
}
