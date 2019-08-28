package com.ciwi.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ciwi.vo.MemberVO;

public class MemberDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf = CreateSqlSessionFactory.getSsf();
	}
	//로그인 
	public static MemberVO memberLogin(String id,String pwd){
		MemberVO vo= new MemberVO();
		SqlSession session=null;
		try{
			session=ssf.openSession();
			int count = session.selectOne("memberIdCount",id);
			if(count==0){// 아이디 확인 , 아이디가 없는 상태
				vo.setMsg("NOID");
			}else{ //비밀번호 확인, 아이디가 존재 상태
				vo=session.selectOne("memberGetPwd",id); // 아이디를 넣어줘야한다. 
				if(pwd.equals(vo.getPwd())){ //가져온 비밀번호와 일치하냐? 
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
