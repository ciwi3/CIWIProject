package com.ciwi.manager;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ciwi.dao.FestivalDAO;
import com.ciwi.vo.FestivalVO;

public class FestivalManager {
	public static void main(String[] args) {
		FestivalManager fm=new FestivalManager();
		// fm.festivalAllData();
		List<FestivalVO> list=fm.festivalAllData();
		int i=1;
		for(FestivalVO vo:list) {
			FestivalDAO.festivalDataInsert(vo);
			System.out.println("i="+i);
			i++;
		}
		System.out.println("save end");
	}
	
	public List<FestivalVO> festivalAllData() {
		List<FestivalVO> list=new ArrayList<FestivalVO>();
		try {
			int k=1;
			int linkCount=48;
			for(int page=1;page<=5;page++) {
				String url="https://www.culture.go.kr/festival/festivalList.do?cPage="+page;
				Document doc=Jsoup.connect(url).get();
				Elements subject=doc.select("div#contents div.list_type1 dl.info dt a");
				Elements poster=doc.select("div.list_type1 div.thumb img");
				Elements link=doc.select("div.list_type1 ul li a");
				linkCount=48;
				for(int i=16;i<subject.size();i++) { // 10����
					System.out.println(k);
					System.out.println("����: "+subject.get(i).text());
					String sub=subject.get(i).text();
					System.out.println("������: https://www.culture.go.kr"+poster.get(i).attr("src"));
					// System.out.println("ī���� :"+linkCount);
					
					try {
						String detailLink="https://www.culture.go.kr"+link.get(linkCount).attr("href");
						Document doc2=Jsoup.connect(detailLink).get();
						Element fDate=doc2.select("div.info_wrap table.tbl_info tbody tr td").get(0); // o
						Element loc=doc2.select("div.info_wrap table.tbl_info tbody tr td").get(1); // o
						Element place=doc2.select("div.info_wrap table.tbl_info tbody tr td").get(2); //o
						Element host=doc2.select("div.info_wrap table.tbl_info tbody tr td").get(3); //o
						Element tel=doc2.select("div.info_wrap table.tbl_info tbody tr td").get(4); //o
						Element hompage=doc2.selectFirst("div.link_wrap a"); //o
						System.out.println("�Ⱓ: "+fDate.text());
						System.out.println("����: "+loc.text());
						System.out.println("���: "+place.text());
						System.out.println("����: "+host.text());
						System.out.println("��ȭ: "+tel.text());
						System.out.println("���� Ȩ������: "+hompage.attr("href"));
						
						String area=loc.text();
						FestivalVO vo=new FestivalVO();
						
						vo.setFno(k);
						vo.setSubject(sub);
						vo.setFdate(fDate.text());
						vo.setPoster("https://www.culture.go.kr"+poster.get(i).attr("src"));
						if(place.text().equals("")) {
							vo.setPlace("-");
						} else {
							vo.setPlace(place.text());
						}
						vo.setShowtime("-");
						vo.setHost(host.text());
						vo.setHomepage(hompage.attr("href"));
						vo.setTel(tel.text());
						vo.setShowtime("-");
						vo.setFlike(0);
						vo.setFestival_no(1);
						vo.setCategory_no(1);
						if (area.contains("����")) {
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
						} else if (area.contains("���")) {
							vo.setArea_no(11);
						} else if (area.contains("�泲")) {
							vo.setArea_no(12);
						} else if (area.contains("����")) {
							vo.setArea_no(13);
						} else if (area.contains("����")) {
							vo.setArea_no(14);
						} else if (area.contains("���")) {
							vo.setArea_no(15);
						} else if (area.contains("�泲")) {
							vo.setArea_no(16);
						} else if (area.contains("����")) {
							vo.setArea_no(17);
						} else {
							vo.setArea_no(18);
						}
						
						list.add(vo);
					} catch(Exception e) {
						e.printStackTrace();
					}
					System.out.println("--------------------------------------------------------------------");
					k++;
					linkCount=linkCount+3;
				}
				System.out.println("====================================================================");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
