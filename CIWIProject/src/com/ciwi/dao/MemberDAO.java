package com.ciwi.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ciwi.vo.MemberVO;

public class MemberDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf = CreateSqlSessionFactory.getSsf();
	}
	
	public static MemberVO memberLogin(String id,String pwd) {
		MemberVO vo=new MemberVO();
		int result=0;
		SqlSession session=ssf.openSession();
		// ID
		int count=session.selectOne("memberIdCount",id);
		if(count==0) { // ���̵� ���� X
			result=10;
			vo.setAdmin(result);
		} else {
			vo=session.selectOne("memberGetPwd",id);
			if(vo.getPwd().equals(pwd)) { // �α��� �㰡
				vo.setAdmin(vo.getAdmin());
			} else { // �α��� ����
				result=20;
				vo.setAdmin(result);
			}
		}
		session.close();
		return vo;
	}
}
