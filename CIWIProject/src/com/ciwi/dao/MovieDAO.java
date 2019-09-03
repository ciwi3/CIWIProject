package com.ciwi.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ciwi.vo.*;
import java.util.*;

public class MovieDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf = CreateSqlSessionFactory.getSsf();
	}//

	public static void movieDataInsert(MovieVO vo) {
		SqlSession session = ssf.openSession(true);
		session.insert("movieDataInsert", vo);
		session.close();
	}
	
	public static void theaterDataInsert(TheaterVO vo) {
		SqlSession session = ssf.openSession(true);
		session.insert("theaterDataInsert", vo);
		session.close();
	}
	
	public static List<MovieVO> movieSearch(Map map) {
		List<MovieVO> list = new ArrayList<>();
		SqlSession session = ssf.openSession(true);
		list = session.selectList("movieSearch", map);
		session.close();
		return list;
	}
	
	public static void totalSeatUpdate(TheaterVO vo) {
		SqlSession session=ssf.openSession(true);
		session.update("totalSeatUpdate", vo);
		session.close();
	}
	
	public static void dateInsert(DateInfoVO vo) {
		SqlSession session=ssf.openSession(true);
		session.insert("dateInsert",vo);
		session.close();
	}
	
	public static void theaterDateUpdate(TheaterVO vo) {
		SqlSession session=ssf.openSession(true);
		session.update("theaterDateUpdate", vo);
		session.close();
	}
	
	
	// 영화 예매
	public static List<MovieVO> movieListData() {
		List<MovieVO> list=new ArrayList<MovieVO>();
		SqlSession session=ssf.openSession();
		list=session.selectList("movieListData");
		session.close();
		return list;
	}
	public static TheaterVO theaterData(int theater_no) {
		TheaterVO vo=new TheaterVO();
		SqlSession session=ssf.openSession();
		try {
			vo=session.selectOne("theaterData",theater_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		session.close();
		return vo;
	}
	public static String reserveGetTime(int date_no) {
		String list="";
		SqlSession session=null;
		try {
			session=ssf.openSession();
			list=session.selectOne("reserveGetTime", date_no);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		return list;
	}
	public static String timeData(int time_no) {
		String time="";
		SqlSession session=null;
		try {
			session=ssf.openSession();
			time=session.selectOne("timeData",time_no);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		return time;
	}
}
