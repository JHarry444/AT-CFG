//package com.qa.bp;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//public class BPDemo {
//
//	private RemoteWebDriver driver;
//
//	@Before
//	public void init() {
//		this.driver = new ChromeDriver();
//		this.driver.manage().window().maximize();
//	}
//
//	@Test
//	public void demoTest() {
//		this.driver.get("http://www.bing.com");
//		WebElement search = driver.findElementById("sb_form_q");
//		search.sendKeys("turtles" + Keys.ENTER);
//		search = driver.findElementById("sb_form_q");
//		assertEquals("turtles", search.getAttribute("value"));
//
//	}
//
//	@After
//	public void tearDown() {
//		this.driver.quit();
//	}
//}
