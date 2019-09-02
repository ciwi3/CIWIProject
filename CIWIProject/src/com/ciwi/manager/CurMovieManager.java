package com.ciwi.manager;

import java.util.ArrayList;
import java.util.List;

import com.ciwi.dao.FestivalDAO;
import com.ciwi.dao.MovieDAO;
import com.ciwi.vo.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CurMovieManager {

	public static void main(String[] args) {
		CurMovieManager cm = new CurMovieManager();
		// List<MovieVO> list=cm.movieAlldata();
		/*int i=1;
		for(MovieVO vo:list) {
			MovieDAO.movieDataInsert(vo);
			System.out.println("i="+i);
			i++;
		}
		System.out.println("save end");
		cm.theaterData();*/
		
		// 167개의 극장에서 각 날짜에 해당하는 상영시간표에 난수를 넣음
		/*int k=1;
		for(int i=1; i<=167; i++) { // 극장 총 167개
			DateInfoVO vo=new DateInfoVO();
			vo.setDate_no(i);
			vo.setTime_no(cm.reserveDayData());
			MovieDAO.dateInsert(vo);
			System.out.println("k= "+k);
			k++;
		}*/
		// 난수 
		/*int k=1;
		for(int i=1; i<=30; i++) {
			DateInfoVO vo=new DateInfoVO();
			vo.setDate_no(i);
			vo.setTime_no(cm.reserveDayData());
		}*/
	}

public List<MovieVO> movieAlldata(){
		
		List<MovieVO> list = new ArrayList<MovieVO>();
		try {
			
			int k=1;
			
			Document doc = Jsoup.connect("https://movie.naver.com/movie/running/current.nhn").get();
			Elements link = doc.select("div.thumb a");

				for(int j = 0 ; j < link.size() ;j++) {
					
					try{
					String url = "https://movie.naver.com"+link.get(j).attr("href");
					Document doc2 = Jsoup.connect(url).get();
				
					Element title = doc2.selectFirst("h3.h_movie a");
					Element genre =doc2.select("p.info_spec span").get(0);
					Element redate = doc2.select("p.info_spec span").get(3);
					Element grade = doc2.select("p.info_spec span").get(4);
					Element director = doc2.selectFirst("div.info_spec2 dl.step1 dd a");
					Element actor = doc2.selectFirst("div.info_spec2 dl.step2 dd");
					Element poster = doc2.selectFirst("div.poster a img");
					Element story = doc2.selectFirst("div.story_area p.con_tx");
					Element score = doc2.selectFirst("div.star_score span.st_on");
					
					String sco = score.text();
					sco=sco.substring(7,11);
					
					System.out.println(k+"."+title.text());
					System.out.println("포스터 : "+poster.attr("src"));
					System.out.println("장르 : "+genre.text());
					System.out.println("개봉일 : "+redate.text());
					System.out.println("등급 : "+grade.text().substring(4, grade.text().indexOf("가")+1));
					System.out.println("감독 : "+director.text());
					System.out.println("평점 : "+sco);
					System.out.println("스토리 : "+story.text());
					if(actor==null) {
						System.out.println("출연 : -");
					} else {
						System.out.println("출연 : "+actor.text());
					}
					
					MovieVO vo = new MovieVO();
					vo.setMno(k);
					vo.setTitle(title.text());
					vo.setPoster(poster.attr("src"));
					vo.setDirector(director.text());
					if(actor==null || actor.text().equals("")) { // actor만 없는 영화가 종종있음. 예외처리
						vo.setActor("-");
					} else {
						vo.setActor(actor.text());
					}
					vo.setGenre(genre.text());
					vo.setGrade(grade.text().substring(4, grade.text().indexOf("가")+1));
					vo.setRegdate(redate.text());
					vo.setStory(story.text());
					vo.setCategory_no(2); // category_no = 2 (현재 상영중인 영화)
					vo.setScore(sco);
					// 난수 발생 시킴
					String theaterData=CurMovieManager.theaterData();
					vo.setTheater_no(theaterData); // 현재 상영중인 영화의 상영관 난수 발생시켜야됨
					list.add(vo);
					System.out.println("================================================");
					k++;
					
					}catch (Exception e) { 
						e.printStackTrace();
					}
				}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	// 해당 영화에 대한 상영관 난수 발생
	public static String theaterData() {
		// 총 극장 20개 중 => 1 1 1 1 (중복이 있으면 안됨)
		String result="";
		int[] com=new int[(int)(Math.random()*10)+6]; // 중복없는 난수 발생 => 최소 6개~최대15개 
		int su=0;
		boolean bCheck=false;
		for(int i=0; i<com.length; i++) {
			bCheck=true;
			while(bCheck) {
				su=(int)(Math.random()*167)+1; // com[] 배열에 1~20 값을 넣음 
				bCheck=false;
				for(int j=0;j<i;j++) {
					if(com[j]==su) {
						bCheck=true;
						break;
					}
				}
			}
			com[i]=su;
		}
		
		for(int i=0;i<com.length-1;i++) { // 선택정렬 오름차순
			for(int j=i+1;j<com.length;j++) {
				if(com[i]>com[j]) {
					int temp=com[i];
					com[i]=com[j];
					com[j]=temp;
				}
			}
		}
		for(int i=0;i<com.length;i++) {
			// System.out.print(com[i]+" ");
			result+=com[i]+", ";
		}
		result=result.substring(0,result.lastIndexOf(", "));
		System.out.println(result);
		return result;
	}
	
	// 상영관 마다 상영하는 날짜 난수 발생
	public String reserveDayData() {
		// 총 극장 20개 중 => 1 1 1 1 (중복이 있으면 안됨)
		String result="";
		int[] com=new int[(int)(Math.random()*10)+5]; // 중복없는 난수 발생 => 최소 5개부터 15개까지
		int su=0;
		boolean bCheck=false;
		for(int i=0; i<com.length; i++) {
			bCheck=true;
			while(bCheck) {
				su=(int)(Math.random()*30)+1; // 1~30 (9월)
				bCheck=false;
				for(int j=0;j<i;j++) {
					if(com[j]==su) {
						bCheck=true;
						break;
					}
				}
			}
			com[i]=su;
		}
		
		for(int i=0;i<com.length-1;i++) { // 선택정렬 오름차순
			for(int j=i+1;j<com.length;j++) {
				if(com[i]>com[j]) {
					int temp=com[i];
					com[i]=com[j];
					com[j]=temp;
				}
			}
		}
		for(int i=0;i<com.length;i++) {
			// System.out.print(com[i]+" ");
			result+=com[i]+", ";
		}
		result=result.substring(0,result.lastIndexOf(", "));
		// System.out.println(result);
		return result;
	}
	
	// 상영관 마다 상영하는 날짜 난수발생
	public String reserveTimeData() {
		// 총 극장 20개 중 => 1 1 1 1 (중복이 있으면 안됨)
		String result="";
		int[] com=new int[(int)(Math.random()*6)+5]; // 중복없는 난수 발생 => 최소 5개부터 11개까지
		int su=0;
		boolean bCheck=false;
		for(int i=0; i<com.length; i++) {
			bCheck=true;
			while(bCheck) {
				su=(int)(Math.random()*27)+1; // 1~27
				bCheck=false;
				for(int j=0;j<i;j++) {
					if(com[j]==su) {
						bCheck=true;
						break;
					}
				}
			}
			com[i]=su;
		}
		
		for(int i=0;i<com.length-1;i++) { // 선택정렬 오름차순
			for(int j=i+1;j<com.length;j++) {
				if(com[i]>com[j]) {
					int temp=com[i];
					com[i]=com[j];
					com[j]=temp;
				}
			}
		}
		for(int i=0;i<com.length;i++) {
			// System.out.print(com[i]+" ");
			result+=com[i]+", ";
		}
		result=result.substring(0,result.lastIndexOf(", "));
		System.out.println(result);
		return result;
	}
}

