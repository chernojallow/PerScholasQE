package com.perscholas.selenium_cucumber_sba.step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

@RunWith(Cucumber.class)
public class MenuOptionsStepDef {
	private WebDriver driver;

	@Given("^the user navigates to the store home page$")
	public void the_user_navigates_to_the_store_home_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Student\\Documents\\GitHub\\PerScholasQE\\ChromeSeleniumDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}

	@When("^the user hovers over the \"([^\"]*)\" header$")
	public void the_user_hovers_over_the_something_header(String strArg1) throws Throwable {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(1) > a"));
		action.moveToElement(we).perform();
	}

	@When("^the user clicks on \"([^\"]*)\"$")
	public void the_user_clicks_on_something(String strArg1) throws Throwable {
		driver.findElement(By.cssSelector(
				"#block_top_menu > ul > li:nth-child(1) > ul > li:nth-child(2) > ul > li:nth-child(2) > a")).click();
	}

	@When("^the user adds the \"([^\"]*)\" to the cart$")
	public void the_user_adds_the_something_to_the_cart(String strArg1) throws Throwable {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(
				By.cssSelector("#center_column > ul > li > div > div.left-block > div > a.product_img_link > img"));

		action.moveToElement(we).perform();
		driver.findElement(By.cssSelector(
				"#center_column > ul > li > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default"))
				.click();
	}

	@Then("^the submenu displays$")
	public void the_submenu_displays() throws Throwable {
		String actual = driver
				.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(1) > ul > li:nth-child(2) > a"))
				.getText();
		assertEquals(actual, "DRESSES");
	}

	@When("^the user clicks on the Cart button2$")
	public void the_user_clicks_on_the_Cart_button2() throws Throwable {
		driver.findElement(By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a > b"))
				.click();
	}
	
	@Then("^the page redirect to the \"([^\"]*)\" page$")
	public void the_page_redirect_to_the_something_page(String strArg1) throws Throwable {
		String actual = driver.findElement(By.cssSelector("#center_column > h1 > span.cat-name")).getText().trim()
				.toUpperCase();
		assertEquals(actual, "EVENING DRESSES");
	}

	@Then("^the page opens a frame$")
	public void the_page_opens_a_frame() throws Throwable {
		String actual = driver.findElement(By.cssSelector("#layer_cart")).getAttribute("id");
		assertEquals(actual, "layer_cart");
	}

	@Then("^the page redirect to the Cart page$")
	public void the_page_redirect_to_the_cart_page() throws Throwable {
		String actual = driver.findElement(By.cssSelector(
				"#product_4_16_0_0 > td.cart_quantity.text-center > input.cart_quantity_input.form-control.grey"))
				.getAttribute("value");
		assertEquals(actual, "1");
		driver.close();
	}

	@And("^the user clicks on the Continue Shopping button$")
	public void the_user_clicks_on_the_continue_shopping_button() throws Throwable {
		driver.findElement(By.cssSelector(".continue > span")).click();
	}
}
