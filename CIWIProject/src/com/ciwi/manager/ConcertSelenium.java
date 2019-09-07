package com.ciwi.manager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ConcertSelenium {
	public static void main(String[] args) {
		ConcertSelenium test = new ConcertSelenium();
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
	private String base_url = "https://ticket.melon.com/concert/index.htm?genreType=GENRE_CON";

	public ConcertSelenium() {
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
			for (int i = 1; i <= 40; i++) {
				WebElement target = driver.findElement(By.className("control_list"));
				Actions builder = new Actions(driver);
				Action seriesOfActions;
				seriesOfActions=builder.sendKeys(Keys.PAGE_DOWN).build();
				seriesOfActions.perform();
			}
			//Thread.sleep(300000);
			
			String html = driver.getPageSource();
			Document doc = Jsoup.parse(html);
			// System.out.println(doc);
			Elements link1 = doc.select("div.wrap_main_concert ul.list_main_concert li.first a"); //performance/index.htm?prodId=204169
			Elements link2 = doc.select("div.wrap_main_concert ul.list_main_concert li a"); //performance/index.htm?prodId=204169
			for (int i=1;i<link1.size();i++) {
				String link="https://ticket.melon.com"+link1.get(i).attr("href");
				System.out.println(link);
			}
			for (int i= 1; i < link2.size(); i++) {
				String link="https://ticket.melon.com"+link2.get(i).attr("href");
				System.out.println(link);
			}
			System.out.println("=================================================");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
	}
}