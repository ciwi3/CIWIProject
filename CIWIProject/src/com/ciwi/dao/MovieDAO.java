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
}
