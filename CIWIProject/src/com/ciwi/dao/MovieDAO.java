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
		session.insert("movieDataInsert", vo);  // 매개변수가 parameterType이다. 
		session.close();
	}
	
	public static void curmovieDataInsert(MovieVO vo) {
		SqlSession session=ssf.openSession(true);
		session.insert("curmovieDataInsert",vo);
		session.close();
	}
}
