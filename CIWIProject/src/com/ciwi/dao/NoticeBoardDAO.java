package com.ciwi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ciwi.vo.FreeBoardVO;
import com.ciwi.vo.NoticeBoardVO;


public class NoticeBoardDAO {
	private static SqlSessionFactory ssf;
	static{
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	//���� ���
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
	
	//���� ��ü ���� �б�
	public static int noticeboardRowCount(){
		int count = 0;
		SqlSession session=ssf.openSession();
		count=session.selectOne("noticeboardRowCount");
		
		session.close();
		return count;
	}
	
	//���� �߰�
	public static void noticeboardInsert(NoticeBoardVO vo){
		SqlSession session = ssf.openSession(true);
		session.insert("noticeboardInsert",vo);
		session.close();
	}
	//�󼼺���
	public static NoticeBoardVO noticeboardDetailData(int no, String type){
		NoticeBoardVO vo = new NoticeBoardVO();
		SqlSession session = ssf.openSession();
		if(type.equals("detail")){
			session.update("nhitIncrement",no);
			session.commit();
		}
		vo = session.selectOne("noticeboardDetailData", no);	
		session.close();
		return vo;
	}
	
	//�����ϱ�
	public static int noticeboardUpdate(NoticeBoardVO vo){
		int no=0;
		SqlSession session = ssf.openSession();
		
			no=vo.getNo();
			session.update("noticeboardUpdate", vo);
			session.commit();

		
		session.close();
		return no;
	}
	
	// ���� ����
	public static void noticeboardDelete(int no){
		SqlSession session = ssf.openSession();
		session.delete("noticeboardDelete",no);
		session.commit();
	}
	
	
	
	
	
	
	
	
}
