package com.ciwi.dao;

import java.io.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// 공통모듈 => Config.xml 파싱을 클래스화 시킴
public class CreateSqlSessionFactory {
	private static SqlSessionFactory ssf;
	static {
		try {
			// Config.xml 읽기
			Reader reader=Resources.getResourceAsReader("Config.xml");
			// XML 파싱 => SqlSessionFactory 대입
			ssf=new SqlSessionFactoryBuilder().build(reader);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSsf() {
		return ssf;
	}
}
