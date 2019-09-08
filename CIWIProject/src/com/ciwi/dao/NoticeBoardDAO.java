package com.ciwi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ciwi.vo.NoticeBoardVO;


public class NoticeBoardDAO {
	private static SqlSessionFactory ssf;
	static{
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	//�Խù� ���
	public static List<NoticeBoardVO> noticeboardListData(Map map){
	
		List<NoticeBoardVO> list = new ArrayList<NoticeBoardVO>();
		SqlSession session = ssf.openSession();
		list = session.selectList("noticeboardListData", map);
	
		session.close();
		
		return list;
	}
	
	//�������� �б�
	public static int noticeboardTotalPage(){
		int total = 0;
		SqlSession session=ssf.openSession();
		total=session.selectOne("noticeboardTotalPage");
		
		session.close();
		return total;
	}
	
	//�Խù� ��ü ���� �б�
	public static int noticeboardRowCount(){
		int count = 0;
		SqlSession session=ssf.openSession();
		count=session.selectOne("noticeboardRowCount");
		
		session.close();
		return count;
	}
	
	
}
