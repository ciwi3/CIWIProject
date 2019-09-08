package com.ciwi.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ciwi.vo.*;
import java.util.*;

public class JjimDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf = CreateSqlSessionFactory.getSsf();
	}
	
	// �� ���
	public static void insertJjimShowData(Map map) {
		SqlSession session = ssf.openSession(true);
		session.insert("insertJjimShowData", map);
		session.close();
	}
	public static void insertJjimMovieData(Map map) {
		SqlSession session = ssf.openSession(true);
		session.insert("insertJjimMovieData", map);
		session.close();
	}
	public static void insertJjimFestivalData(Map map) {
		SqlSession session = ssf.openSession(true);
		session.insert("insertJjimFestivalData", map);
		session.close();
	}
	
	// ������ ��������
	public static List<JjimVO> getJjim(Map map) {
		List<JjimVO> list=new ArrayList<JjimVO>();
		SqlSession session=ssf.openSession();
		list=session.selectList("getJjim",map);
		session.close();
		return list;
	}
	
	
	// ���� �� ����
	public static void deleteJjimShowData(Map map) {
		SqlSession session = ssf.openSession(true);
		session.delete("deleteJjimShowData", map);
		session.close();
	}
	// ��ȭ �� ����
	public static void deleteJjimMovieData(Map map) {
		SqlSession session = ssf.openSession(true);
		session.delete("deleteJjimMovieData", map);
		session.close();
	}
	// ��� �� ����
	public static void deleteJjimFestivalData(Map map) {
		SqlSession session = ssf.openSession(true);
		session.delete("deleteJjimFestivalData", map);
		session.close();
	}
	
	
	// ���� ���� ���� ��������
	public static List<ShowVO> getJjimShowData(String id) {
		List<ShowVO> jjimSlist=new ArrayList<ShowVO>();
		SqlSession session=ssf.openSession();
		jjimSlist=session.selectList("getJjimShowData",id);
		session.close();
		return jjimSlist;
	}
	// ���� ��ȭ ���� ��������
	public static List<MovieVO> getJjimMovieData(String id) {
		List<MovieVO> jjimMlist=new ArrayList<MovieVO>();
		SqlSession session=ssf.openSession();
		jjimMlist=session.selectList("getJjimMovieData",id);
		session.close();
		return jjimMlist;
	}
	// ���� ��� ���� ��������
	public static List<FestivalVO> getJjimFestivalData(String id) {
		List<FestivalVO> jjimFlist=new ArrayList<FestivalVO>();
		SqlSession session=ssf.openSession();
		jjimFlist=session.selectList("getJjimFestivalData",id);
		session.close();
		return jjimFlist;
	}
}
