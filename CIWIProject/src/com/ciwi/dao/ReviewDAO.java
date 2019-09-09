package com.ciwi.dao;

import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ciwi.vo.FestivalVO;
import com.ciwi.vo.MovieVO;
import com.ciwi.vo.ReviewVO;
import com.ciwi.vo.ShowVO;

public class ReviewDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf = CreateSqlSessionFactory.getSsf();
	}

	// 내가 쓴 리뷰리스트
	public static List<ReviewVO> myPageList() {
		List<ReviewVO> list = new ArrayList<ReviewVO>();
		SqlSession session = ssf.openSession(); // getConnection()
		list = session.selectList("myPageList");
		session.close();
		return list;
	}

	// 총 페이지
	public static int reviewTotalPage() {
		int total = 0;
		SqlSession session = ssf.openSession();
		total = session.selectOne("reviewTotalPage");
		session.close();
		return total;
	}

	// 평점 등록
	public static void ratingInsert(ReviewVO vo) {
		SqlSession session = ssf.openSession(true);
		session.insert("ratingInsert", vo);
		session.close();
	}

	// 리뷰(default+= 평점)등록
	public static void reviewInsert(ReviewVO vo) {
		SqlSession session = ssf.openSession(true);
		session.insert("reviewInsert", vo);
		session.close();
	}

	public static int reviewModified(ReviewVO vo, String id) {
		SqlSession session = ssf.openSession(true);
		int result = 0;
		if (vo.getMemid().equals(id)) {
			session.update("reviewModified", vo);
			result=1;
		}
		session.close();
		return result;
	}

	public static int reviewDelete(ReviewVO vo, String id) {
		SqlSession session = ssf.openSession(true);
		int result = 0;
		if (vo.getMemid().equals(id)) {
			session.selectOne("reviewDelete", vo);
			result=1;
		}
		session.close();
		return result;

	}

	public static List<ReviewVO> showReviewList(ShowVO vo) {
		SqlSession session=ssf.openSession();
		List<ReviewVO> list=new ArrayList<ReviewVO>();
		list=session.selectList("showReviewList",vo);
		session.close();
		
		return list;
	}
	public static List<ReviewVO> FestivalReviewList(FestivalVO vo) {
		SqlSession session=ssf.openSession(true);
		List<ReviewVO> list=new ArrayList<ReviewVO>();
		list=session.selectList("FestivalReviewList",vo);
		session.close();
		
		return list;
	}
	public static List<ReviewVO> movieReviewList(MovieVO vo) {
		SqlSession session=ssf.openSession(true);
		List<ReviewVO> list=new ArrayList<ReviewVO>();
		list=session.selectList("movieReviewList",vo);
		session.close();
		
		return list;
	}
	public static String ratingcheck(ReviewVO vo) {
		SqlSession session=ssf.openSession();
		String rCheck=session.selectOne("ratingcheck",vo);
		session.close();
		
		return rCheck;
	}
}
