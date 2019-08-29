package com.ciwi.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ciwi.vo.*;
import java.util.*;
public class MovieDAO {
	private static SqlSessionFactory ssf;
	static{
		ssf= CreateSqlSessionFactory.getSsf();
	}//
	public static void movieDataInsert(MovieVO vo){
		SqlSession session = ssf.openSession(true);
		session.insert("movieDataInsert", vo);  // �Ű������� parameterType�̴�. 
		session.close();
	}
	
	public static void curmovieDataInsert(MovieVO vo) {
		SqlSession session=ssf.openSession(true);
		session.insert("curmovieDataInsert",vo);
		session.close();
	}
}
