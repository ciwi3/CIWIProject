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
		
		// 167���� ���忡�� �� ��¥�� �ش��ϴ� �󿵽ð�ǥ�� ������ ����
		/*int k=1;
		for(int i=1; i<=167; i++) { // ���� �� 167��
			DateInfoVO vo=new DateInfoVO();
			vo.setDate_no(i);
			vo.setTime_no(cm.reserveDayData());
			MovieDAO.dateInsert(vo);
			System.out.println("k= "+k);
			k++;
		}*/
		// ���� 
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
					System.out.println("������ : "+poster.attr("src"));
					System.out.println("�帣 : "+genre.text());
					System.out.println("������ : "+redate.text());
					System.out.println("��� : "+grade.text().substring(4, grade.text().indexOf("��")+1));
					System.out.println("���� : "+director.text());
					System.out.println("���� : "+sco);
					System.out.println("���丮 : "+story.text());
					if(actor==null) {
						System.out.println("�⿬ : -");
					} else {
						System.out.println("�⿬ : "+actor.text());
					}
					
					MovieVO vo = new MovieVO();
					vo.setMno(k);
					vo.setTitle(title.text());
					vo.setPoster(poster.attr("src"));
					vo.setDirector(director.text());
					if(actor==null || actor.text().equals("")) { // actor�� ���� ��ȭ�� ��������. ����ó��
						vo.setActor("-");
					} else {
						vo.setActor(actor.text());
					}
					vo.setGenre(genre.text());
					vo.setGrade(grade.text().substring(4, grade.text().indexOf("��")+1));
					vo.setRegdate(redate.text());
					vo.setStory(story.text());
					vo.setCategory_no(2); // category_no = 2 (���� ������ ��ȭ)
					vo.setScore(sco);
					// ���� �߻� ��Ŵ
					String theaterData=CurMovieManager.theaterData();
					vo.setTheater_no(theaterData); // ���� ������ ��ȭ�� �󿵰� ���� �߻����Ѿߵ�
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

	// �ش� ��ȭ�� ���� �󿵰� ���� �߻�
	public static String theaterData() {
		// �� ���� 20�� �� => 1 1 1 1 (�ߺ��� ������ �ȵ�)
		String result="";
		int[] com=new int[(int)(Math.random()*10)+6]; // �ߺ����� ���� �߻� => �ּ� 6��~�ִ�15�� 
		int su=0;
		boolean bCheck=false;
		for(int i=0; i<com.length; i++) {
			bCheck=true;
			while(bCheck) {
				su=(int)(Math.random()*167)+1; // com[] �迭�� 1~20 ���� ���� 
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
		
		for(int i=0;i<com.length-1;i++) { // �������� ��������
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
	
	// �󿵰� ���� ���ϴ� ��¥ ���� �߻�
	public String reserveDayData() {
		// �� ���� 20�� �� => 1 1 1 1 (�ߺ��� ������ �ȵ�)
		String result="";
		int[] com=new int[(int)(Math.random()*10)+5]; // �ߺ����� ���� �߻� => �ּ� 5������ 15������
		int su=0;
		boolean bCheck=false;
		for(int i=0; i<com.length; i++) {
			bCheck=true;
			while(bCheck) {
				su=(int)(Math.random()*30)+1; // 1~30 (9��)
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
		
		for(int i=0;i<com.length-1;i++) { // �������� ��������
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
	
	// �󿵰� ���� ���ϴ� ��¥ �����߻�
	public String reserveTimeData() {
		// �� ���� 20�� �� => 1 1 1 1 (�ߺ��� ������ �ȵ�)
		String result="";
		int[] com=new int[(int)(Math.random()*6)+5]; // �ߺ����� ���� �߻� => �ּ� 5������ 11������
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
		
		for(int i=0;i<com.length-1;i++) { // �������� ��������
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

