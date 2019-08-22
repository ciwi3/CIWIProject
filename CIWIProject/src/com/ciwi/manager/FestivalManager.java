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
		fm.festivalAllData();
		/*List<FestivalVO> list=fm.festivalAllData();
		int i=1;
		for(FestivalVO vo:list) {
			FestivalDAO.festivalDataInsert(vo);
			System.out.println("i="+i);
			i++;
		}
		System.out.println("save end");*/
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
				for(int i=16;i<subject.size();i++) { // 10개씩
					System.out.println(k);
					System.out.println("제목: "+subject.get(i).text());
					String sub=subject.get(i).text();
					System.out.println("포스터: https://www.culture.go.kr"+poster.get(i).attr("src"));
					// System.out.println("카운터 :"+linkCount);
					
					try {
						String detailLink="https://www.culture.go.kr"+link.get(linkCount).attr("href");
						Document doc2=Jsoup.connect(detailLink).get();
						Element fDate=doc2.select("div.info_wrap table.tbl_info tbody tr td").get(0);
						Element loc=doc2.select("div.info_wrap table.tbl_info tbody tr td").get(1);
						Element place=doc2.select("div.info_wrap table.tbl_info tbody tr td").get(2);
						Element host=doc2.select("div.info_wrap table.tbl_info tbody tr td").get(3);
						Element tel=doc2.select("div.info_wrap table.tbl_info tbody tr td").get(4);
						Element hompage=doc2.selectFirst("div.link_wrap a");
						System.out.println("기간: "+fDate.text());
						System.out.println("지역: "+loc.text());
						System.out.println("장소: "+place.text());
						System.out.println("주최: "+host.text());
						System.out.println("전화: "+tel.text());
						System.out.println("공식 홈페이지: "+hompage.attr("href"));
						
						FestivalVO vo=new FestivalVO();
						vo.setFno(k);
						vo.setPlace(loc.text()+"-"+place.text());
						vo.setSubject(sub);
						vo.setPoster("https://www.culture.go.kr"+poster.get(i).attr("src"));
						vo.setFdate(fDate.text());
						vo.setHost(host.text());
						vo.setHomepage(hompage.attr("href"));
						vo.setTel(tel.text());
						vo.setShowtime("null");
						vo.setFlike(1);
						vo.setConcert_genre(1);
						vo.setCategory_no(1);
						vo.setArea_no(1);
						
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
