package com.ciwi.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ciwi.vo.*;
import java.util.*;

public class JjimDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf = CreateSqlSessionFactory.getSsf();
	}
	
	// 찜 등록
	public static void insertJjimShowData(Map map) {
		SqlSession session = ssf.openSession(true);
		session.insert("insertJjimShowData", map);
		session.close();
	}
	public static void insertJjimMovieData(Map map) {
		SqlSession session = ssf.openSession(true);
		session.insert("insertJjimMovieData", map);
		session.close();
	}
	public static void insertJjimFestivalData(Map map) {
		SqlSession session = ssf.openSession(true);
		session.insert("insertJjimFestivalData", map);
		session.close();
	}
	
	// 구분자 가져오기
	public static List<JjimVO> getJjim(Map map) {
		List<JjimVO> list=new ArrayList<JjimVO>();
		SqlSession session=ssf.openSession();
		list=session.selectList("getJjim",map);
		session.close();
		return list;
	}
	
	
	// 공연 찜 삭제
	public static void deleteJjimShowData(Map map) {
		SqlSession session = ssf.openSession(true);
		session.delete("deleteJjimShowData", map);
		session.close();
	}
	// 영화 찜 삭제
	public static void deleteJjimMovieData(Map map) {
		SqlSession session = ssf.openSession(true);
		session.delete("deleteJjimMovieData", map);
		session.close();
	}
	// 행사 찜 삭제
	public static void deleteJjimFestivalData(Map map) {
		SqlSession session = ssf.openSession(true);
		session.delete("deleteJjimFestivalData", map);
		session.close();
	}
	
	
	// 찜한 공연 내용 가져오기
	public static List<ShowVO> getJjimShowData(String id) {
		List<ShowVO> jjimSlist=new ArrayList<ShowVO>();
		SqlSession session=ssf.openSession();
		jjimSlist=session.selectList("getJjimShowData",id);
		session.close();
		return jjimSlist;
	}
	// 찜한 영화 내용 가져오기
	public static List<MovieVO> getJjimMovieData(String id) {
		List<MovieVO> jjimMlist=new ArrayList<MovieVO>();
		SqlSession session=ssf.openSession();
		jjimMlist=session.selectList("getJjimMovieData",id);
		session.close();
		return jjimMlist;
	}
	// 찜한 행사 내용 가져오기
	public static List<FestivalVO> getJjimFestivalData(String id) {
		List<FestivalVO> jjimFlist=new ArrayList<FestivalVO>();
		SqlSession session=ssf.openSession();
		jjimFlist=session.selectList("getJjimFestivalData",id);
		session.close();
		return jjimFlist;
	}
}
