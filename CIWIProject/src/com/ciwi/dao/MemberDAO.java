package com.ciwi.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ciwi.vo.MemberVO;

public class MemberDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf = CreateSqlSessionFactory.getSsf();
	}

	// ȸ������ : ���̵� �ߺ�üũ
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

	// ȸ������ : ȸ������ db�� �ֱ�
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

	// ȸ������ �� ���̵�ޱ�
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

	// �α���
	public static MemberVO memberLogin(String id, String pwd) {
		MemberVO vo = new MemberVO();
		SqlSession session = null;
		try {
			session = ssf.openSession();
			int count = session.selectOne("memberIdCount", id);
			if (count == 0) {// ���̵� Ȯ�� , ���̵� ���� ����
				vo.setMsg("NOID");
			} else { // ��й�ȣ Ȯ��, ���̵� ���� ����
				vo = session.selectOne("memberGetPwd", id); // ���̵� �־�����Ѵ�.
				if (pwd.equals(vo.getPwd())) { // ������ ��й�ȣ�� ��ġ�ϳ�?
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

	// ȸ������ ����
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

	// ��й�ȣ ã��
	public static MemberVO memberGetPwd(String id) {
		MemberVO vo = new MemberVO();
		SqlSession session = null;
		try {
			session = ssf.openSession();
			vo = session.selectOne("memberGetPwd", id);
			// System.out.println(vo.getPwd());
		} catch (Exception e) {
		} finally {
			if (session != null)
				session.close();
		}
		return vo;
	}

	// ȸ�� Ż��
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

	// ��õ�� ���� ȸ�� ���� Ȯ��
	public static MemberVO memberGetGenreAndCategory(int id) {
		MemberVO vo = new MemberVO();
		SqlSession session = null;
		try {
			session = ssf.openSession();
			vo = session.selectOne("memberGetGenreAndCategory", id);
			// System.out.println(vo.getPwd());
		} catch (Exception e) {
		} finally {
			if (session != null)
				session.close();
		}
		return vo;
	}

}
