package com.ciwi.dao;

import java.io.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// ������ => Config.xml �Ľ��� Ŭ����ȭ ��Ŵ
public class CreateSqlSessionFactory {
	private static SqlSessionFactory ssf;
	static {
		try {
			// Config.xml �б�
			Reader reader=Resources.getResourceAsReader("Config.xml");
			// XML �Ľ� => SqlSessionFactory ����
			ssf=new SqlSessionFactoryBuilder().build(reader);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSsf() {
		return ssf;
	}
}
