package com.ciwi.dao;

import java.io.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CreateSqlSessionFactory {
	private static SqlSessionFactory ssf;
	static {
		try {
			// Config.xml �б�
			Reader reader = Resources.getResourceAsReader("Config.xml");
			// XML �Ľ� => SqlSessionFactory ����
			ssf = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSssf() {
		return ssf;
	}
}
