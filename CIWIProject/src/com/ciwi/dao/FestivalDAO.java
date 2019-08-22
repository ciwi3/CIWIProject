package com.ciwi.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ciwi.vo.*;

public class FestivalDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf = CreateSqlSessionFactory.getSsf();
	}
	
	public static void festivalDataInsert(FestivalVO vo) {
		SqlSession session = ssf.openSession(true); // getConnection()
		session.insert("festivalDataInsert", vo);
		session.close(); // disConnection()
	}
}
