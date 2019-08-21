package com.ciwi.manager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Selenium {
	public static void main(String[] args) {
		Selenium test = new Selenium();
		test.crawl();

	}

	// WebDriver
	private WebDriver driver;

	// Properties
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 주의,
																			// webdriver
																			// 아니야
	public static final String WEB_DRIVER_PATH = "C:/mvcDev/chromedriver.exe";

	// 크롤링할 URL
	private String base_url = "https://www.culture.go.kr/perform/experienceList.do";

	public Selenium() {
		super();

		// System Property SetUp
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

		// Driver SetUp
		driver = new ChromeDriver();
	}

	public void crawl() {
		try {
			// get page
			driver.get(base_url);
			WebElement target = driver.findElement(By.className("last"));
			Actions builder = new Actions(driver);
			Action seriesOfActions;
			seriesOfActions = builder.click(target).build();
			seriesOfActions.perform();
			//Thread.sleep(3000);
			String url=driver.getCurrentUrl();
			System.out.println(url);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
	}
}