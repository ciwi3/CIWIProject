package com.ciwi.manager;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ciwi.dao.MovieDAO;
import com.ciwi.vo.MovieVO;
import com.ciwi.vo.TheaterVO;
public class MovieManager {
	public static void main(String[] args) {
		MovieManager mm = new MovieManager();
		
	}
	
	public List<MovieVO> movieData(){
		List<MovieVO> list = new ArrayList<MovieVO>();
		try{
			List<String> linklist = new ArrayList<String>(); //��ũ���� �������� ������.
			int k=1;
			for(int i=0; i<=40; i++){ // 40page�� �� 
				
				Document doc = Jsoup.connect("https://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=pnt&date=20190813&page="+i).get(); // 
				
				Elements link = doc.select("td.title div.tit5 a");
				for(int j=0; j<link.size(); j++){
					try{
						String url = "https://movie.naver.com"+link.get(j).attr("href");
						//System.out.println(url);
						Document doc2 = Jsoup.connect(url).get();
						Element title = doc2.selectFirst("h3.h_movie a");
						Element poster = doc2.selectFirst("div.poster img");
						Element genre = doc2.select("p.info_spec span").get(0);
						Element regdate = doc2.select("p.info_spec span").get(3);
						Element grade = doc2.select("p.info_spec span").get(4);
						String grad = grade.text();
						if(grad==null){
							grad="-";
						}else{
							grad=grade.text().substring(4,grade.text().indexOf("��")+1);
						}
						Element actor = doc2.selectFirst("div.info_spec2 dl.step2 dd a");
						String act = actor.text();
						System.out.println(act);
						if(act==null){
							act="-";
						}
						Element director = doc2.selectFirst("div.info_spec2 dl.step1 dd a");
						Element story=doc2.selectFirst("div.story_area p.con_tx");
						Element score = doc2.select("div.main_score div.score div.star_score").get(2);
						String sco=score.text();
						if(sco.equals("0�� ���")){
							sco = "-";
						}
						
						System.out.println("����:"+k+title.text());
						System.out.println("������:"+poster.attr("src"));
						System.out.println("������:"+regdate.text());
						System.out.println("�帣:"+genre.text());
					    System.out.println("���:"+grad);
						System.out.println("�⿬:"+act);
						System.out.println("����:"+director.text());
						System.out.println("�ٰŸ�:"+story.text());
						System.out.println("����:"+sco);
						System.out.println("=================================================");
						
						MovieVO vo=new MovieVO();
						vo.setMno(k+71);
						vo.setTitle(title.text());
						vo.setPoster(poster.attr("src"));
						vo.setDirector(director.text());
						vo.setActor(act);
						vo.setGenre(genre.text());
						vo.setGrade(grad);
						vo.setRegdate(regdate.text());
						vo.setStory(story.text());
						vo.setCategory_no(3);
						vo.setScore(sco);
						vo.setTheater_no("0"); // 0=�󿵰� ����
						list.add(vo);
						k++;  
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
