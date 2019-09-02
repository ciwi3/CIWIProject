package com.ciwi.dao;

import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ciwi.dao.CreateSqlSessionFactory;
import com.ciwi.vo.FreeBoardVO;
import com.ciwi.vo.FreeReplyVO;

public class FreeBoardDAO {
	private static SqlSessionFactory ssf;
	static{
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	//�Խù� ���
	public static List<FreeBoardVO> freeboardListData(Map map){
	
		List<FreeBoardVO> list = new ArrayList<FreeBoardVO>();
		SqlSession session = ssf.openSession();
		list = session.selectList("freeboardListData", map);
	
		session.close();
		
		return list;
	}
	//�������� ���
	public static List<FreeBoardVO> freeboardNoticeData(Map map){
		
		List<FreeBoardVO> nlist = new ArrayList<FreeBoardVO>();
		SqlSession session = ssf.openSession();
		nlist = session.selectList("freeboardNoticeData", map);
	
		session.close();
		
		return nlist;
	}
	
	//�������� �б�
	public static int freeboardTotalPage(){
		int total = 0;
		SqlSession session=ssf.openSession();
		total=session.selectOne("freeboardTotalPage");
		
		session.close();
		return total;
	}
	
	//�Խù� ��ü ���� �б�
	public static int freeboardRowCount(){
		int count = 0;
		SqlSession session=ssf.openSession();
		count=session.selectOne("freeboardRowCount");
		
		session.close();
		return count;
	}
	
	//�Խñ� �߰�
	public static void freeboardInsert(FreeBoardVO vo){
		SqlSession session = ssf.openSession(true);
		session.insert("freeboardInsert",vo);
		session.close();
	}
	
	//�󼼺���
	public static FreeBoardVO freeboardDetailData(int no, String type){
		FreeBoardVO vo = new FreeBoardVO();
		SqlSession session = ssf.openSession();
		if(type.equals("detail")){
			session.update("hitIncrement",no);
			session.commit();
		}
		vo = session.selectOne("freeboardDetailData", no);	
		session.close();
		return vo;
	}
	
	//�����ϱ�
	public static int freeboardUpdate(FreeBoardVO vo){
		int no=0;
		SqlSession session = ssf.openSession();
		
			no=vo.getNo();
			session.update("freeboardUpdate", vo);
			session.commit();

		
		session.close();
		return no;
	}
	
	// ��� �ø���
	public static void replyInsert(FreeReplyVO vo)
	{
		SqlSession session=ssf.openSession(true);
		session.insert("replyInsert",vo);
		session.close();
	}
	
	   // ��� ������ ���� 
	   public static List<FreeReplyVO> replyListData(int bno)
	   {
		   SqlSession session=ssf.openSession(true);
		   List<FreeReplyVO> list=session.selectList("replyListData",bno);
		   session.close();
		   return list;
	   }
	   
	   public static int replyListCount(int bno)
	   {
		   SqlSession session=ssf.openSession(true);
		   int count=session.selectOne("replyListCount",bno);
		   session.close();
		   return count;
	   }
	
	
	
	
	
}
