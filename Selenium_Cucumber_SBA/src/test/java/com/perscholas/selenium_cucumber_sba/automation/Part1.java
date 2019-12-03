package com.perscholas.selenium_cucumber_sba.automation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Part1 {
	private static WebDriver driver;
	private static List<String> mList;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Student\\Documents\\GitHub\\PerScholasQE\\ChromeSeleniumDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		mList = new ArrayList<String>();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void shutDown() {
		driver.close();
	}
	
	@Test
	public void findPerScholasStaff() {
		driver.get("https://perscholas.org/");
	    driver.manage().window().setSize(new Dimension(1280, 656));
	    driver.findElement(By.cssSelector(".dropdown > #mapToggle")).click();
	    driver.findElement(By.cssSelector("#mapControls > div > div > div > div.col-xs-12.col-md-4 > ul > li:nth-child(6) > a")).click();
	    driver.findElement(By.cssSelector(".navbar-subnav-right > li:nth-child(1) > a")).click();
	    driver.findElement(By.cssSelector(".col-md-4:nth-child(3) #Layer_1")).click();
	   
	    mList.add(driver.findElement(By.cssSelector("#greater-boston-team .col-sm-3:nth-child(1) h5")).getText());
	    mList.add(driver.findElement(By.cssSelector("#greater-boston-team .col-sm-3:nth-child(2) h5")).getText());
	    mList.add(driver.findElement(By.cssSelector("#greater-boston-team .col-sm-3:nth-child(3) h5")).getText());
	    mList.add(driver.findElement(By.cssSelector("#greater-boston-team .col-sm-3:nth-child(4) h5")).getText());
	    mList.add(driver.findElement(By.cssSelector("#greater-boston-team .col-sm-3:nth-child(5) h5")).getText());
	    
	    assertTrue(mList.contains("Robin Nadeau"));
	    assertFalse(mList.contains("Jake McIntos"));
	}
}
