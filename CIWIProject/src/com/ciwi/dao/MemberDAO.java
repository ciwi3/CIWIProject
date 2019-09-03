package com.ciwi.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ciwi.vo.MemberVO;

public class MemberDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf = CreateSqlSessionFactory.getSsf();
	}
	//ȸ������ : ���̵� �ߺ�üũ
	public static int memberIdOverlap(String id){
		int count=0;
		SqlSession session =null;
		try{
			session=ssf.openSession();
			count =session.selectOne("memberIdOverlap",id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return count;
	}
	//ȸ������ : ȸ������ db�� �ֱ� 
	public static void memberInsertData(MemberVO vo){
		SqlSession session =null;
		try{
			session=ssf.openSession(true);
			session.insert("memberInsertData",vo);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
	}
	//ȸ������ �� ���̵�ޱ�
	public static String joinFinishData(){
		//MemberVO vo= new MemberVO();
		String id="";
		SqlSession session =null;
		try{
			session=ssf.openSession();
			id=session.selectOne("joinFinishData");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return id;
	}
	//�α��� 
	public static MemberVO memberLogin(String id,String pwd){
		MemberVO vo= new MemberVO();
		SqlSession session=null;
		try{
			session=ssf.openSession();
			int count = session.selectOne("memberIdCount",id);
			if(count==0){// ���̵� Ȯ�� , ���̵� ���� ����
				vo.setMsg("NOID");
			}else{ //��й�ȣ Ȯ��, ���̵� ���� ����
				vo=session.selectOne("memberGetPwd",id); // ���̵� �־�����Ѵ�. 
				if(pwd.equals(vo.getPwd())){ //������ ��й�ȣ�� ��ġ�ϳ�? 
					vo.setMsg("OK");
				}else{
					vo.setMsg("NOPWD");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return vo;
	}
	
}
