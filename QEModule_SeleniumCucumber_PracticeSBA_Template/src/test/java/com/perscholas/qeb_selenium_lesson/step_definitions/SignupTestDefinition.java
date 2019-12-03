package com.perscholas.qeb_selenium_lesson.step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
public class SignupTestDefinition {
	private WebDriver driver;

	@Given("^the user navigates to the Signup page$")
	public void the_user_navigates_to_the_Signup_page() throws Throwable {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Student\\Documents\\GitHub\\PerScholasQE\\ChromeSeleniumDriver\\chromedriver.exe");

		System.out.println("User navigates to the Signup Page");
		driver.get("http://localhost:8080/qeb_selenium_lesson/");

		driver.findElement(By.cssSelector("#name_input")).sendKeys("xiaolin996");
		driver.findElement(By.cssSelector("#email_input")).sendKeys("xiaolin996@gmail.com");
		driver.findElement(By.cssSelector("#password_input")).sendKeys("xiaolin123");
		driver.findElement(By.cssSelector("#signup_form > div:nth-child(4) > input:nth-child(2)")).click();
		driver.findElement(By.cssSelector("#startdate_input")).sendKeys("2019-12-01");
	}

	@When("^the user clicks the \"([^\"]*)\" button$")
	public void the_user_clicks_the_button(String arg1) throws Throwable {
		driver.findElement(By.cssSelector("#signup_form > div:nth-child(8) > input[type=submit]")).click();

	}

	@Then("^the page should direct to Success page$")
	public void the_page_should_direct_to_Success_page() throws Throwable {
		assertEquals(driver.getTitle(), "Success Page");
		driver.close();
	}
}