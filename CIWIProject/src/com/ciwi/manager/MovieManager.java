package com.ciwi.manager;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ciwi.dao.MovieDAO;
import com.ciwi.vo.MovieVO;
public class MovieManager {
	public static void main(String[] args) {
		MovieManager mm = new MovieManager();
		List<MovieVO> list=mm.movieData();
		int i=1;
		for(MovieVO vo:list) {
			MovieDAO.movieDataInsert(vo);
			System.out.println("i="+i);
			i++;
		}
		System.out.println("end");
	}
	
	public List<MovieVO> movieData(){
		List<MovieVO> list = new ArrayList<MovieVO>();
		try{
			List<String> linklist = new ArrayList<String>(); //��ũ���� �������� ������.
			int k=1;
			for(int i=0; i<=40; i++){ // 40page�� �� 
				
				Document doc = Jsoup.connect("https://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=pnt&date=20190813&page="+i).get(); // 
				
				Elements link = doc.select("td.title div.tit5 a");
				/*
				 <td class="title"> <div class="tit5"> <a
				 href="/movie/bi/mi/basic.nhn?code=171539" title="�׸� ��">�׸�
				 ��</a> </div> </td>
				 */
				for(int j=0; j<link.size(); j++){
					try{
						String url = "https://movie.naver.com"+link.get(j).attr("href");
						//System.out.println(url);
						Document doc2 = Jsoup.connect(url).get();
						Element title = doc2.selectFirst("h3.h_movie a");
						/* <h3 class="h_movie">
			<a href="./basic.nhn?code=171539">�׸� ��</a><!-- N=a:ifo.title -->
			<strong class="h_movie2" title="Green Book, 2018">Green Book
					2018</strong>
						</h3>
						 * */
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
						vo.setMno(k);
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
