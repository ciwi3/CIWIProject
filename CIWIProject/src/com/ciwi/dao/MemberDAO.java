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
		if(count==0) { // 아이디 존재 X
			result=10;
			vo.setAdmin(result);
		} else {
			vo=session.selectOne("memberGetPwd",id);
			if(vo.getPwd().equals(pwd)) { // 로그인 허가
				vo.setAdmin(vo.getAdmin());
			} else { // 로그인 불허
				result=20;
				vo.setAdmin(result);
			}
		}
		session.close();
		return vo;
	}
}
