package com.qa.demo.ex5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {

	private RemoteWebDriver driver;

	@Before
	public void init() {
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		this.driver = new ChromeDriver(options);
		this.driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		this.driver.quit();
	}

	@Given("^I am on the 'Home' page$")
	public void i_am_on_the_Home_page() throws Throwable {
		driver.get("http://www.practiceselenium.com/welcome.html");

	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() throws Throwable {
		WebElement menuLink = driver
				.findElementByXPath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a");
		menuLink.click();
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() throws Throwable {
		List<WebElement> products = this.driver.findElementsByCssSelector("div > p > span > span > strong");
		assertTrue(products.size() > 1);
	}

	@Given("^I am on the 'Menu' page$")
	public void i_am_on_the_Menu_page() throws Throwable {
		this.driver.get("http://www.practiceselenium.com/menu.html");
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() throws Throwable {
		WebElement checkout = this.driver.findElementByXPath("/html/body/div/div/div[1]/div/div[16]/div/a/span");
		checkout.click();
	}

	@Then("^I am taken to the 'Checkout' page$")
	public void i_am_taken_to_the_Checkout_page() throws Throwable {
		assertEquals("http://www.practiceselenium.com/check-out.html", this.driver.getCurrentUrl());

	}

}
