package com.qa.demo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SelDemo {

	private static RemoteWebDriver driver;

	@BeforeClass
	public static void init() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get("http://www.bing.com");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
