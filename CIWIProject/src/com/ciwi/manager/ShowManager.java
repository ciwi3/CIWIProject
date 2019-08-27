package com.ciwi.manager;

import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ciwi.dao.ShowDAO;
import com.ciwi.vo.*;

// show ㅁㅁㅗㅗㅗ
public class ShowManager {
	public static void main(String[] args) {
		ShowManager sm = new ShowManager();
		sm.showData();
	}

	/// 컴맹
	/// 시발
	// 컴맹
	// 전 아님
	// 그럼누구?
	// 짝꿍
	public List<ShowVO> showData() {
		List<ShowVO> list = new ArrayList<ShowVO>();
		int sno = 1;
		try {
			for (int i = 1; i <= 19; i++) {
				Document doc = Jsoup.connect("https://www.culture.go.kr/perform/experienceList.do?cPage=" + i).get();
				Elements link = doc.select("div.list_type dl.info dt a");
				// System.out.println(link.get(0).attr("href"));

				for (int j = 16; j < link.size(); j++) {
					try {
				
						String site = "https://www.culture.go.kr" + link.get(j).attr("href");
						Document doc2 = Jsoup.connect(site).get();
						Element subject = doc2.select("div.content_link div span").first();
						Element poster = doc2.select("div.detail_wrap div.thumb img").first();
						Element sdate = doc2.select("table.tbl_info tbody tr td").get(0);
						Element starttime = doc2.select("table.tbl_info tbody tr td").get(1);
						Element price = doc2.select("table.tbl_info tbody tr td").get(3);
						Element place = doc2.select("table.tbl_info tbody tr td span.txt").first();
						Element host = doc2.select("table.tbl_info tbody tr td").get(5);
						Element showtime = doc2.select("table.tbl_info tbody tr td").get(6);
						Element age = doc2.select("table.tbl_info tbody tr td").get(7);
						Element tel = doc2.select("table.tbl_info tbody tr td").get(8);
						Element address = doc2.select("div.jqTabLocation div.detail_info ul li").get(1);
						Element homepage = doc2.select("div.jqTabLocation div.detail_info ul li a").first();
						Element genre = doc2.select("div.info_wrap div.label_info span.basic").first();
						ShowVO vo = new ShowVO();
						vo.setSno(sno);
						vo.setSubject(subject.text());
						vo.setPoster(poster.attr("src"));
						vo.setSdate(sdate.text().substring(0, 21));
						vo.setStarttime(starttime.text());
						vo.setPrice(price.text());
						vo.setPlace(place.text());
						vo.setHost(host.text());
						vo.setShowtime(showtime.text());
						vo.setAge(age.text());
						vo.setTel(tel.text());
						vo.setSlike(0);
						vo.setCategory_no(4);
						switch (genre.text()) {
						case "음악/콘서트":
							vo.setGenre_no(1);
							break;
						case "뮤지컬/오페라":
							vo.setGenre_no(2);
							break;
						case "연극":
							vo.setGenre_no(3);
							break;
						case "국악":
							vo.setGenre_no(4);
							break;
						case "무용/발레":
							vo.setGenre_no(5);
							break;
						case "아동/가족":
							vo.setGenre_no(6);
							break;
						case "전시":
							vo.setGenre_no(7);
							break;
						default:
							vo.setGenre_no(8);
							break;
						}

						String area = "";
						if (address.text().contains("주소-")) {
							area = address.text().substring(3, address.text().length());
						} else {
							area = address.text().substring(2, address.text().length());
						}
						vo.setAddress(area);

						if (area.contains("서울특별")) {
							vo.setArea_no(1);
						} else if (area.contains("부산")) {
							vo.setArea_no(2);
						} else if (area.contains("대구")) {
							vo.setArea_no(3);
						} else if (area.contains("인천")) {
							vo.setArea_no(4);
						} else if (area.contains("광주")) {
							vo.setArea_no(5);
						} else if (area.contains("대전")) {
							vo.setArea_no(6);
						} else if (area.contains("울산")) {
							vo.setArea_no(7);
						} else if (area.contains("세종")) {
							vo.setArea_no(8);
						} else if (area.contains("경기")) {
							vo.setArea_no(9);
						} else if (area.contains("강원")) {
							vo.setArea_no(10);
						} else if (area.contains("충청북도")) {
							vo.setArea_no(11);
						} else if (area.contains("충청남도")) {
							vo.setArea_no(12);
						} else if (area.contains("전라북도")) {
							vo.setArea_no(13);
						} else if (area.contains("전라남도")) {
							vo.setArea_no(14);
						} else if (area.contains("경상북도")) {
							vo.setArea_no(15);
						} else if (area.contains("경상남도")) {
							vo.setArea_no(16);
						} else if (area.contains("제주")) {
							vo.setArea_no(17);
						} else {
							vo.setArea_no(18);
						}
						vo.setSource("없음");
						try {
							vo.setHomepage(homepage.text());
						} catch (NullPointerException e) {
							vo.setHomepage("없음");
						}

						System.out.println(subject.text());
						System.out.println(poster.attr("src"));
						System.out.println(sdate.text().substring(0, 21));
						System.out.println(starttime.text());
						System.out.println(price.text());
						System.out.println(place.text());
						System.out.println(host.text());
						System.out.println(showtime.text());
						System.out.println(age.text());
						System.out.println(tel.text());
						if (address.text().contains("주소-")) {
							System.out.println((address.text().substring(3, address.text().length())));
						} else {
							System.out.println((address.text().substring(2, address.text().length())));
						}
						if (homepage != null) {
							System.out.println(homepage.text());
						}
						System.out.println(genre.text());
						System.out.println("====================================");
						sno++;
						ShowDAO.insertShow(vo);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
