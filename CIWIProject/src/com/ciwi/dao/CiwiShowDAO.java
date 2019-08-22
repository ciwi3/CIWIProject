package com.ciwi.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ciwi.dao.CreateSqlSessionFactory;
import com.ciwi.vo.CIWIShowVO;

public class CiwiShowDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf = CreateSqlSessionFactory.getSsf();
	}

	public static void insertCIWIShow(CIWIShowVO vo) {
		SqlSession session = ssf.openSession(true);
		session.insert("insertCIWIShow", vo);
		session.close();
	}
}
