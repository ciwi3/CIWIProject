package com.ciwi.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ciwi.vo.*;
import java.util.*;

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

	public static List<FestivalVO> festivalAllData() {
		SqlSession session = ssf.openSession();
		List<FestivalVO> list = session.selectList("festivalAllData");
		session.close();
		return list;
	}

	public static FestivalVO festivalDetail(int fno) {
		SqlSession session = ssf.openSession();
		FestivalVO vo = session.selectOne("festivalDetail", fno);
		session.close();
		return vo;
	}

	public static List<FestivalVO> festivalSearch(Map map) {
		SqlSession session = ssf.openSession();
		List<FestivalVO> list = session.selectList("festivalSearch",map);
		session.close();
		return list;
	}
}
