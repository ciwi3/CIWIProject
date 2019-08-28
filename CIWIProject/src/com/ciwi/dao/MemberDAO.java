package com.ciwi.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ciwi.vo.MemberVO;

public class MemberDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf = CreateSqlSessionFactory.getSsf();
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
