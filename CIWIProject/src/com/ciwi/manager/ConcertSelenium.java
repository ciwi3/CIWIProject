package com.ciwi.manager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
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
			for (int i = 1; i <= 60; i++) {
				WebElement target = driver.findElement(By.className("control_list"));
				Actions builder = new Actions(driver);
				Action seriesOfActions;
				seriesOfActions=builder.sendKeys(Keys.PAGE_DOWN).build();
				seriesOfActions.perform();
			}
			
			String html = driver.getPageSource();
			Document doc = Jsoup.parse(html);
			
			Elements link1 = doc.select("div.wrap_main_concert ul.list_main_concert li.first a");
			Elements link2 = doc.select("div.wrap_main_concert ul.list_main_concert li a");
			
			for (int i=0;i<link1.size();i++) {
				String link="https://ticket.melon.com"+link1.get(i).attr("href");
				Document doc2=Jsoup.connect(link).get();
				
				Element title=doc2.selectFirst("div.box_consert_txt p.tit");
				Element fDate=doc2.select("div.box_consert_info dl.info_left dd.txt_info").get(0);
				Element showTime=doc2.select("div.box_consert_info dl.info_left dd.txt_info").get(1);
				Element place=doc2.select("div.box_consert_info dl.info_right dd.txt_info").get(0);
				Element grade=doc2.select("div.box_consert_info dl.info_right dd.txt_info").get(1);
				Elements price=doc2.select("div.box_bace_price span.price");
				
				System.out.println("콘서트 명: "+title.text());
				System.out.println("공연 날짜: "+fDate.text());
				System.out.println("공연 시간: "+showTime.text());
				System.out.println("장       소: "+place.text());
				System.out.println("등       급: "+grade.text());
				System.out.println("가       격: "+price.text());
				
				System.out.println("=====================================================");
			}
			for (int i= 1; i < link2.size(); i++) {
				String link="https://ticket.melon.com"+link2.get(i).attr("href");
				Document doc2=Jsoup.connect(link).get();
				
				Element title=doc2.selectFirst("div.box_consert_txt p.tit");
				Element fDate=doc2.select("div.box_consert_info dl.info_left dd.txt_info").get(0);
				Element showTime=doc2.select("div.box_consert_info dl.info_left dd.txt_info").get(1);
				Element place=doc2.select("div.box_consert_info dl.info_right dd.txt_info").get(0);
				Element grade=doc2.select("div.box_consert_info dl.info_right dd.txt_info").get(1);
				Elements price=doc2.select("div.box_bace_price span.price");
				
				System.out.println("콘서트 명: "+title.text());
				System.out.println("공연 날짜: "+fDate.text());
				System.out.println("공연 시간: "+showTime.text());
				System.out.println("장       소: "+place.text());
				System.out.println("등       급: "+grade.text());
				System.out.println("가       격: "+price.text());
				
				System.out.println("=====================================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
	}
}