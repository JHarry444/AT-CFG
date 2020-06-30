package com.qa.demo.cuke;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
		this.driver = new ChromeDriver();
	}

	@Given("^I have an account with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_have_an_account_with_and(String user, String pass) throws Throwable {
		this.driver.get("http://thedemosite.co.uk/addauser.php");
		WebElement username = this.driver.findElementByXPath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input");
		username.sendKeys(user);
		WebElement password = this.driver.findElementByXPath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input");
		password.sendKeys(pass);

		WebElement submit = this.driver.findElementByXPath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input");
		submit.click();
	}

	@Given("^I am on the login page$")
	public void i_am_on_the_login_page() throws Throwable {
		this.driver.get("http://thedemosite.co.uk/login.php");

	}

	@When("^I login with that \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_login_with_that_and(String user, String pass) throws Throwable {
		WebElement username = this.driver.findElementByXPath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input");
		username.sendKeys(user);

		WebElement password = this.driver.findElementByXPath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input");
		password.sendKeys(pass);

		WebElement submit = this.driver.findElementByXPath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input");
		submit.click();
	}

	@Then("^I verify i have the correct \"([^\"]*)\"$")
	public void i_verify_i_have_the_correct(String status) throws Throwable {
		String loginStatus = driver
				.findElementByXPath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
				.getText();
		assertTrue(loginStatus.toLowerCase().contains(status.toLowerCase()));
	}

	@After
	public void tearDown() {
		this.driver.quit();
	}

}
