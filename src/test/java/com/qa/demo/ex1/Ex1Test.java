package com.qa.demo.ex1;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Ex1Test {

	private RemoteWebDriver driver;

	@Before
	public void init() {
		this.driver = new ChromeDriver();
	}

	@Test
	public void test() {

		final String user = "bloop";
		final String pass = "pass";

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

		this.driver.get("http://thedemosite.co.uk/login.php");

		username = this.driver.findElementByXPath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input");
		username.sendKeys(user);

		password = this.driver.findElementByXPath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input");
		password.sendKeys(pass);

		submit = this.driver.findElementByXPath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input");
		submit.click();

		assertTrue(driver.findElementByXPath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
				.getText().toLowerCase().contains("successful"));
	}

	@After
	public void tearDown() {
		this.driver.quit();
	}

}
