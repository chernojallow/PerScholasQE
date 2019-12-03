package com.perscholas.selenium_cucumber_sba.step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

@RunWith(Cucumber.class)
public class PopularSessionStepDef {
	private WebDriver driver;

	@Given("^the user navigates to the My Store page$")
	public void the_user_navigates_to_the_My_Store_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Student\\Documents\\GitHub\\PerScholasQE\\ChromeSeleniumDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}

	@When("^the user add items to the shopping cart$")
	public void the_user_add_items_to_the_shopping_cart() throws Throwable {
		Actions action = new Actions(driver);

		WebElement item = driver.findElement(By.cssSelector(
				"#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.left-block > div > a.product_img_link > img"));
		action.moveToElement(item).perform();
		driver.findElement(
				By.cssSelector("#homefeatured > .ajax_block_product:nth-child(1) .button:nth-child(1) > span")).click();
		driver.findElement(By.cssSelector(".continue > span")).click();

		item = driver.findElement(By.cssSelector(
				"#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.last-line.first-item-of-tablet-line.first-item-of-mobile-line.last-mobile-line > div > div.left-block > div > a.product_img_link > img"));
		action.moveToElement(item).perform();
		driver.findElement(
				By.cssSelector("#homefeatured > .ajax_block_product:nth-child(7) .button:nth-child(1) > span")).click();
		driver.findElement(By.cssSelector(".continue > span")).click();
	}

	@Then("^the page opens an adding frame$")
	public void the_page_opens_an_adding_frame() throws Throwable {

	}

	@When("^the user clicks on the Cart button$")
	public void the_user_clicks_on_the_Cart_button() throws Throwable {
		driver.findElement(By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a > b"))
				.click();
	}

	@Then("^the user is redirected to the Order - My Store page$")
	public void the_user_is_redirected_to_the_Order_My_Store_page() throws Throwable {
		String item = driver.findElement(By.cssSelector(
				"#product_1_1_0_0 > td.cart_quantity.text-center > input.cart_quantity_input.form-control.grey"))
				.getAttribute("value");
		assertThat(item, is("1"));

		item = driver.findElement(By.cssSelector(
				"#product_7_34_0_0 > td.cart_quantity.text-center > input.cart_quantity_input.form-control.grey"))
				.getAttribute("value");
		assertThat(item, is("1"));
		driver.close();
	}
}
