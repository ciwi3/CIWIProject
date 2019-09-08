package com.ciwi.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.ciwi.vo.MemberVO;
public class MemberDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf = CreateSqlSessionFactory.getSsf();
	}
	// 회원가입 : 아이디 중복체크
	public static int memberIdOverlap(String id) {
		int count = 0;
		SqlSession session = null;
		try {
			session = ssf.openSession();
			count = session.selectOne("memberIdOverlap", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return count;
	}
	// 회원가입 : 휴대폰번호 중복체크
	public static int joinPhone(String phone){
		int count = 0;
		SqlSession session = null;
		try {
			session = ssf.openSession();
			count = session.selectOne("joinPhone", phone);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return count;
	}
	// 회원가입 : 회원정보 db에 넣기
	public static void memberInsertData(MemberVO vo) {
		SqlSession session = null;
		try {
			session = ssf.openSession(true);
			session.insert("memberInsertData", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	// 회원가입 후 아이디받기
	public static String joinFinishData() {
		String id = "";
		SqlSession session = null;
		try {
			session = ssf.openSession();
			id = session.selectOne("joinFinishData");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return id;
	}

	// 로그인
	public static MemberVO memberLogin(String id, String pwd) {
		MemberVO vo = new MemberVO();
		SqlSession session = null;
		try {
			session = ssf.openSession();
			int count = session.selectOne("memberIdCount", id);
			if (count == 0) {// 아이디 확인 , 아이디가 없는 상태
				vo.setMsg("NOID");
			} else { // 비밀번호 확인, 아이디가 존재 상태
				vo = session.selectOne("memberGetPwd", id); // 아이디를 넣어줘야한다.
				if (pwd.equals(vo.getPwd())) { // 가져온 비밀번호와 일치하냐?
					vo.setMsg("OK");
				} else {
					vo.setMsg("NOPWD");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return vo;
	}

	// 회원정보 수정
	public static void joinUpdate(MemberVO vo) {

		SqlSession session = null;
		try {
			session = ssf.openSession();
			session.update("joinUpdate", vo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}
	//아이디찾기 
	public static MemberVO memberIdsearch(String phone){
		MemberVO vo=new MemberVO();
		SqlSession session = null;
		try{
			session=ssf.openSession();
			 vo=session.selectOne("memberIdsearch",phone);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null){
				session.close();
			}
		}
		return vo;
	}
	//비밀번호 찾기
	public static MemberVO memberPwdsearch(String id){
		MemberVO vo = new MemberVO();
		SqlSession session = null;
		try{
			session=ssf.openSession();
			vo=session.selectOne("memberPwdsearch",id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return vo;
	}
	// 회원탈퇴: 비밀번호 확인
	public static MemberVO memberGetPwd(String id) {
		MemberVO vo = new MemberVO();
		SqlSession session = null;
		try {
			session = ssf.openSession();
			vo = session.selectOne("memberGetPwd", id);
		} catch (Exception e) {
		} finally {
			if (session != null)
				session.close();
		}
		return vo;
	}
	// 회원 탈퇴하기 전에 리뷰 회원아이디 변경
	public static void reviewMemIdUpdate(int memno){
		SqlSession session = null;
		try {
			session = ssf.openSession();
			session.update("reviewMemIdUpdate", memno);
			session.commit();
		} catch (Exception e) {
		} finally {
			if (session != null)
				session.close();
		}
	}
	// 회원 탈퇴
	public static void member_delete(String id) {
		SqlSession session = null;
		try {
			session = ssf.openSession();
			session.delete("joinDelete", id);
			session.commit();
		} catch (Exception e) {
		} finally {
			if (session != null)
				session.close();
		}
	}

	// 추천을 위한 회원 취향 확인
	public static MemberVO memberGetGenreAndCategory(String id) {
		MemberVO vo = new MemberVO();
		SqlSession session = null;
		try {
			session = ssf.openSession();
			vo = session.selectOne("memberGetGenreAndCategory", id);
		} catch (Exception e) {
		} finally {
			if (session != null)
				session.close();
		}
		return vo;
	}

}
