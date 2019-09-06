package com.ciwi.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.ciwi.vo.JjimVO;
import java.util.*;

public class JjimDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf = CreateSqlSessionFactory.getSsf();
	}
	
	// Âò µî·Ï
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
	
	// Âò »èÁ¦
	public static void deleteJjimFestivalData(String id) {
		SqlSession session = ssf.openSession(true);
		session.update("deleteJjimFestivalData", id);
		session.close();
	}
	
}
