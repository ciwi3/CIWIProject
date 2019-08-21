package com.ciwi.manager;

import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ciwi.dao.CiwiShowDAO;
import com.ciwi.vo.*;

public class ShowManager {
	public static void main(String[] args) {
		ShowManager sm = new ShowManager();
		sm.showData();
	}

	public List<CIWIShowVO> showData() {
		List<CIWIShowVO> list = new ArrayList<CIWIShowVO>();
		int sno = 1;
		try {
			for (int i = 1; i <= 22; i++) {
				Document doc = Jsoup.connect("https://www.culture.go.kr/perform/experienceList.do?cPage=" + i).get();
				Elements link = doc.select("div.list_type dl.info dt a");
				// System.out.println(link.get(0).attr("href"));

				for (int j = 0; j < link.size(); j++) {
					try {
						if (i < 15) {
							continue;
						}
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
						CIWIShowVO vo = new CIWIShowVO();
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
						case "����/�ܼ�Ʈ":
							vo.setGenre_no(1);
							break;
						case "������/�����":
							vo.setGenre_no(2);
							break;
						case "����":
							vo.setGenre_no(3);
							break;
						case "����":
							vo.setGenre_no(4);
							break;
						case "����/�߷�":
							vo.setGenre_no(5);
							break;
						case "�Ƶ�/����":
							vo.setGenre_no(6);
							break;
						case "����":
							vo.setGenre_no(7);
							break;
						default:
							vo.setGenre_no(8);
							break;
						}

						String area = "";
						if (address.text().contains("�ּ�-")) {
							area = address.text().substring(3, address.text().length());
						} else {
							area = address.text().substring(2, address.text().length());
						}
						vo.setAddress(area);

						if (area.contains("����Ư��")) {
							vo.setArea_no(1);
						} else if (area.contains("�λ�")) {
							vo.setArea_no(2);
						} else if (area.contains("�뱸")) {
							vo.setArea_no(3);
						} else if (area.contains("��õ")) {
							vo.setArea_no(4);
						} else if (area.contains("����")) {
							vo.setArea_no(5);
						} else if (area.contains("����")) {
							vo.setArea_no(6);
						} else if (area.contains("���")) {
							vo.setArea_no(7);
						} else if (area.contains("����")) {
							vo.setArea_no(8);
						} else if (area.contains("���")) {
							vo.setArea_no(9);
						} else if (area.contains("����")) {
							vo.setArea_no(10);
						} else if (area.contains("��û�ϵ�")) {
							vo.setArea_no(11);
						} else if (area.contains("��û����")) {
							vo.setArea_no(12);
						} else if (area.contains("����ϵ�")) {
							vo.setArea_no(13);
						} else if (area.contains("���󳲵�")) {
							vo.setArea_no(14);
						} else if (area.contains("���ϵ�")) {
							vo.setArea_no(15);
						} else if (area.contains("��󳲵�")) {
							vo.setArea_no(16);
						} else if (area.contains("����")) {
							vo.setArea_no(17);
						} else {
							vo.setArea_no(18);
						}
						vo.setSource("����");
						try {
							vo.setHomepage(homepage.text());
						} catch (NullPointerException e) {
							vo.setHomepage("����");
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
						if (address.text().contains("�ּ�-")) {
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
						CiwiShowDAO.insertCIWIShow(vo);
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