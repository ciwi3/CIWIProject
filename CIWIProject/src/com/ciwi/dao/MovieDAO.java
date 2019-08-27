package com.ciwi.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ciwi.vo.*;
import java.util.*;
public class MovieDAO {
	//공통으로 사용하기 위해서 클래스로 빼낸것이다 == 공통기반 
	private static SqlSessionFactory ssf;
	static{
		ssf= CreateSqlSessionFactory.getSsf();
	}//
	public static void movieDataInsert(MovieVO vo){
		SqlSession session = ssf.openSession(true);
		session.insert("movieDataInsert", vo);  // 매개변수가 parameterType이다. 
		session.close();
	}
}
