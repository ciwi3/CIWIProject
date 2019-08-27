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
	
	public static List<ShowVO> showAllData(){
		List<ShowVO> list=new ArrayList<ShowVO>();
		SqlSession session = ssf.openSession();	// getConnection()
		list=session.selectList("showAllData");
		session.close();	// disConnection()
		return list;
	}
	
	public static void showInsert(ShowVO svo) {
		SqlSession session = ssf.openSession(true);
		session.insert("showInsert", svo);
		session.close();
	}

	public static List<ShowVO> showSearch(Map map) {
		List<ShowVO> list = new ArrayList<ShowVO>();
		SqlSession session = ssf.openSession();
		list = session.selectList("showSearch", map);
		session.close();
		return list;
	}
	
	public static ShowVO showDetailData(int sno){
		ShowVO vo=new ShowVO();
		SqlSession session = ssf.openSession();
		vo=session.selectOne("showDetailData", sno);
		session.close();
		return vo;
	}
}
