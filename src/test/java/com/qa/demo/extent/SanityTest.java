package com.qa.demo.extent;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.demo.extent.pages.LoginPage;
import com.qa.demo.extent.pages.SignUpPage;

public class SanityTest {

	private RemoteWebDriver driver;

	private static ExtentReports report;

	@BeforeClass
	public static void setup() {
		report = new ExtentReports();
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("test-output/html/extentReport.html");
		reporter.config().setAutoCreateRelativePathMedia(true);
		report.attachReporter(reporter);
	}

	@Before
	public void init() {
		ChromeOptions opts = new ChromeOptions();
		opts.setHeadless(true);
		this.driver = new ChromeDriver(opts);
		this.driver.manage().window().maximize();
	}

	@Test
	public void test() throws FileNotFoundException, IOException {

		ExtentTest test = report.createTest("my test");
		// GIVEN
		final String user = "bloop";
		final String pass = "pass";

		// WHEN
		SignUpPage register = new SignUpPage(driver);

		register.createUser(user, pass);

		test.info("created user");

		LoginPage loginPage = new LoginPage(driver);

		String result = loginPage.login(user, pass);

		File srcFile = driver.getScreenshotAs(OutputType.FILE);

		final String scrShotPath = "test-output" + File.separator + "screenshots" + File.separator + "test.png";
		File targetFile = new File(scrShotPath);
		Files.copy(srcFile.toPath(), new FileOutputStream(targetFile));

		// THEN
		if (result.toLowerCase().contains("successful")) {
			test.pass("Logged in successfully").addScreenCaptureFromPath(scrShotPath);
		} else {
			test.fail("NOT logged in successfully").addScreenCaptureFromPath(scrShotPath);
			fail();
		}
	}

	@After
	public void tearDown() {
		this.driver.quit();
	}

	@AfterClass
	public static void flush() {
		report.flush();
	}
}
