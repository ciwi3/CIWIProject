package com.ciwi.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.ciwi.controller.Controller;
import com.ciwi.vo.*;
import java.util.*;
public class MypageDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf = CreateSqlSessionFactory.getSsf();
	}
	//���� ���� �˻�
	public static MemberVO myInformation(String id){
		MemberVO vo =new MemberVO();
		SqlSession session=null;
		try{
			session=ssf.openSession();
			vo=session.selectOne("myinformation",id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	//������ ����
	public static void cashchargeUpdate(MemberVO vo){
		SqlSession session=null;
		try{
			session=ssf.openSession();
			session.update("cashchargeUpdate",vo);
			session.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
