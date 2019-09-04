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
	
	//게시물 목록
	public static List<FreeBoardVO> freeboardListData(Map map){
	
		List<FreeBoardVO> list = new ArrayList<FreeBoardVO>();
		SqlSession session = ssf.openSession();
		list = session.selectList("freeboardListData", map);
	
		session.close();
		
		return list;
	}
	//공지사항 목록
	public static List<FreeBoardVO> freeboardNoticeData(Map map){
		
		List<FreeBoardVO> nList = new ArrayList<FreeBoardVO>();
		SqlSession session = ssf.openSession();
		nList = session.selectList("freeboardNoticeData", map);
	
		session.close();
		
		return nList;
	}
	
	//총페이지 읽기
	public static int freeboardTotalPage(){
		int total = 0;
		SqlSession session=ssf.openSession();
		total=session.selectOne("freeboardTotalPage");
		
		session.close();
		return total;
	}
	
	//게시물 전체 갯수 읽기
	public static int freeboardRowCount(){
		int count = 0;
		SqlSession session=ssf.openSession();
		count=session.selectOne("freeboardRowCount");
		
		session.close();
		return count;
	}
	
	//게시글 추가
	public static void freeboardInsert(FreeBoardVO vo){
		SqlSession session = ssf.openSession(true);
		session.insert("freeboardInsert",vo);
		session.close();
	}
	
	//상세보기
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
	
	//수정하기
	public static int freeboardUpdate(FreeBoardVO vo){
		int no=0;
		SqlSession session = ssf.openSession();
		
			no=vo.getNo();
			session.update("freeboardUpdate", vo);
			session.commit();

		
		session.close();
		return no;
	}
	
	// 댓글 올리기
	public static void replyInsert(FreeReplyVO vo)
	{
		SqlSession session=ssf.openSession(true);
		session.insert("replyInsert",vo);
		session.close();
	}
	
	   // 댓글 가지고 오기 
	   public static List<FreeReplyVO> replyListData(int bno)
	   {
		   SqlSession session=ssf.openSession(true);
		   List<FreeReplyVO> list=session.selectList("replyListData",bno);
		   session.close();
		   return list;
	   }
	   
	   //댓글 개수
	   public static int replyListCount(int bno)
	   {
		   SqlSession session=ssf.openSession(true);
		   int count=session.selectOne("replyListCount",bno);
		   session.close();
		   return count;
	   }
	
	//대댓글 쓰기
	   public static void replyReInsert(int root,FreeReplyVO vo)
	   {
		   SqlSession session=ssf.openSession();
		   FreeReplyVO pvo=session.selectOne("replyParentInfo",root);
		   session.update("replyStepIncrement",pvo);
		   // insert
		   vo.setGroup_id(pvo.getGroup_id());
		   vo.setGroup_step(pvo.getGroup_step()+1);
		   vo.setGroup_tab(pvo.getGroup_tab()+1);
		   vo.setRoot(root);
		   session.insert("replyReInsert",vo);
		   // depth
		   session.update("replyDepthIncrement",root);
		   
		   session.commit();
		   session.close();
	   }
	   
	   //댓글 수정 
	   public static void replyUpdate(FreeReplyVO vo)
	   {
		   SqlSession session=ssf.openSession(true);
		   session.insert("replyUpdate",vo);
		   session.close();
	   }
	   
	   //댓글 삭제
		public static void replyDelete(int no){
			  SqlSession session=ssf.openSession();
			  FreeReplyVO vo = session.selectOne("replyGetDepth", no);
			  
			  if(vo.getDepth()==0){
				  session.delete("replyDelete", no);
			  } else {
				  FreeReplyVO fvo = new FreeReplyVO();
				  fvo.setMsg("<font color=red>관리자가 삭제한 댓글입니다</font>");
				  fvo.setNo(no);
				  session.update("replyDataUpdate", fvo);
				  
			  }
			  
			  session.update("replyDepthDecrement", vo.getRoot());
			  session.commit();
			  
			  session.close();
		}
	   
		//게시물 삭제
		public static void freeboardDelete(int no){

			SqlSession session=ssf.openSession();	
			
				session.delete("freeboardReplyDelete", no);
				session.delete("freeboardDelete", no);
				session.commit();

		}
		
		//게시물 찾기
		public static List<FreeBoardVO> boardFindData(Map map){
			List<FreeBoardVO> list = new ArrayList<FreeBoardVO>();
			SqlSession session = ssf.openSession();
			list =session.selectList("boardFindData",map);
			session.close();
			return list;
		}		
		
		
		
		
		
	   
	   
	
	
}
