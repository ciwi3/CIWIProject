package com.ciwi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ciwi.vo.QNABoardVO;

public class QNABoardDAO {
	private static SqlSessionFactory ssf;
	static{
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	public static List<QNABoardVO> QNABoardListData(Map map){
		
		List<QNABoardVO> list = new ArrayList<QNABoardVO>();
		SqlSession session = ssf.openSession();
		list = session.selectList("QNABoardListData", map);
		
		session.close();
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
