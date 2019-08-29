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
		CurMovieManager m = new CurMovieManager();
		
		List<MovieVO> list=m.movieAlldata();
		int i=1;
		for(MovieVO vo:list) {
			MovieDAO.curmovieDataInsert(vo);
			System.out.println("i="+i);
			i++;
		}
		System.out.println("save end");
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
					System.out.println("================================================");
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
					vo.setTheater_no(0); // 아직 상영관 카테고리 정보 없음
					list.add(vo);
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
	
	
	
	
}

