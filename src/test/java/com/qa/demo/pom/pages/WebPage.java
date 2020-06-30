package com.qa.demo.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class WebPage {

	public final String URL;

	public WebPage(WebDriver driver, String url) {
		this.URL = url;
		driver.get(URL);
		PageFactory.initElements(driver, this);
	}

}
