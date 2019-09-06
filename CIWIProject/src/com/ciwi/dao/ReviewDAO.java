package com.ciwi.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ciwi.vo.ReviewVO;
public class ReviewDAO {
	private static SqlSessionFactory ssf;
	static{
		ssf=CreateSqlSessionFactory.getSsf();
	}
	// 리뷰 전체 데이터
	public static List<ReviewVO> reviewAllList(){
		List<ReviewVO> list= new ArrayList<ReviewVO>();
		SqlSession session = ssf.openSession(); // getConnection()
		list=session.selectList("reviewAllList");
		session.close();
		return list;
	}
	
	// 총 페이지
	public static int reviewTotalPage(){
		int total=0;
		SqlSession session=ssf.openSession();
		total=session.selectOne("reviewTotalPage");
		session.close();
		return total;
	}
	
	// 평점 등록
	public static void ratingInsert(ReviewVO vo){
		SqlSession session=ssf.openSession(true);
		session.insert("ratinInsert",vo);
		session.close();
	}
	
	// 리뷰(default+= 평점)등록
	public static void reviewInsert(ReviewVO vo){
		SqlSession session=ssf.openSession(true);
		session.insert("reviewInsert",vo);
		session.close();
	}
	
	public static String reviewModified(ReviewVO vo){
		String memid="";
		SqlSession session=ssf.openSession();
			
			memid=vo.getMemid();
			session.update("reviewModified", vo);
			session.commit();
			
		session.close();
		return memid;
	}
	
	public static void reviewDelete(int rno){
		SqlSession session=ssf.openSession();
		
		if(vo.getMemid()==""){
			vo.getMemid().replace(vo.getMemid(), "탈퇴한 사용자");
			session.update("reviewInsert",vo); 
			// 맞는 지 모르겠네 걍 내가 하고싶은거 일단 ㅋㅋ 한거임 이런식으로 하고싶다 하는거 
		}
		
		session.commit();
		session.close();
	}
	
}
