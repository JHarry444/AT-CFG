package com.qa.demo.pom;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qa.demo.pom.pages.LoginPage;
import com.qa.demo.pom.pages.SignUpPage;

public class Ex1Test {

	private RemoteWebDriver driver;

	@Before
	public void init() {
		ChromeOptions opts = new ChromeOptions();
//		opts.setHeadless(true);
		this.driver = new ChromeDriver(opts);
		this.driver.manage().window().maximize();
	}

	@Test
	public void test() {
		// GIVEN
		final String user = "bloop";
		final String pass = "pass";

		// WHEN
		SignUpPage register = new SignUpPage(driver);

		register.login(user, pass);

		LoginPage loginPage = new LoginPage(driver);

		// THEN
		assertTrue(loginPage.login(user, pass).toLowerCase().contains("successful"));
	}

	@After
	public void tearDown() {
		this.driver.quit();
	}

}
