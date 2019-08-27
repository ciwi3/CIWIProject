package com.ciwi.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ciwi.dao.CreateSqlSessionFactory;
import com.ciwi.vo.ShowVO;

public class ShowDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf = CreateSqlSessionFactory.getSsf();
	}

	public static void insertShow(ShowVO vo) {
		SqlSession session = ssf.openSession(true);
		session.insert("insertCIWIShow", vo);
		session.close();
	}

	public static List<ShowVO> showSearch(Map map) {
		List<ShowVO> list = new ArrayList<>();
		SqlSession session = ssf.openSession();
		list = session.selectList("showSearch", map);
		return list;
	}
}
