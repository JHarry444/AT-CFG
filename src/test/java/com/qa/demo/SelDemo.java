package com.qa.demo;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SelDemo {

	private RemoteWebDriver driver;

	@Before
	public void init() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
	}

	@Test
	public void test() throws InterruptedException {

		driver.get("http://www.bing.com");
		WebElement search = driver.findElementById("sb_form_q");
////		search = driver.findElementByXPath("//*[@id=\"sb_form_q\"]");
////		search = driver.findElementByXPath("/html/body/header/form/div/input[1]");
//		search = driver.findElementByCssSelector("#sb_form_q");
		search.sendKeys("turtles" + Keys.ENTER);
		Thread.sleep(1000L);
		search = driver.findElementById("sb_form_q");

		assertEquals("turtles", search.getAttribute("value"));
		WebElement home = driver.findElementByXPath("//*[@id=\"sb_form\"]/a/h1");
		home.click();
		Thread.sleep(1000);
	}

	@After
	public void tearDown() {
		this.driver.quit();
	}
}
