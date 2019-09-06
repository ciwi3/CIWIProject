package com.ciwi.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ciwi.vo.ReviewVO;
public class ReviewDAO {
	private static SqlSessionFactory ssf;
	static{
		ssf=CreateSqlSessionFactory.getSsf();
	}
	// ���� ��ü ������
	public static List<ReviewVO> reviewAllList(){
		List<ReviewVO> list= new ArrayList<ReviewVO>();
		SqlSession session = ssf.openSession(); // getConnection()
		list=session.selectList("reviewAllList");
		session.close();
		return list;
	}
	
	// �� ������
	public static int reviewTotalPage(){
		int total=0;
		SqlSession session=ssf.openSession();
		total=session.selectOne("reviewTotalPage");
		session.close();
		return total;
	}
	
	// ���� ���
	public static void ratingInsert(ReviewVO vo){
		SqlSession session=ssf.openSession(true);
		session.insert("ratinInsert",vo);
		session.close();
	}
	
	// ����(default+= ����)���
	public static void reviewInsert(ReviewVO vo){
		SqlSession session=ssf.openSession(true);
		session.insert("reviewInsert",vo);
		session.close();
	}
	
	public static String reviewModified(ReviewVO vo){
		String memid="";
		SqlSession session=ssf.openSession();
			
			memid=vo.getMemid();
			session.update("reviewModified", vo);
			session.commit();
			
		session.close();
		return memid;
	}
	
	public static void reviewDelete(int rno){
		SqlSession session=ssf.openSession();
		
		if(vo.getMemid()==""){
			vo.getMemid().replace(vo.getMemid(), "Ż���� �����");
			session.update("reviewInsert",vo); 
			// �´� �� �𸣰ڳ� �� ���� �ϰ������ �ϴ� ���� �Ѱ��� �̷������� �ϰ�ʹ� �ϴ°� 
		}
		
		session.commit();
		session.close();
	}
	
}
