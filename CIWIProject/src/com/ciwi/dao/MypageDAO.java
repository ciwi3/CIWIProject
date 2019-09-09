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
	//����ĳ�� ���
	public static int cashTotalData(CashVO vo){
		int pay=0;
		SqlSession session=null;
		try{
			session=ssf.openSession();
			pay=session.selectOne("cashTotalData",vo);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return pay;
	}
	//������ ����
	public static void cashchargeUpdate(CashVO vo){
		SqlSession session=null;
		try{
			session=ssf.openSession();
			session.insert("cashchargeUpdate",vo);
			session.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	// �̽���,����â ����Ϸ��� cash���̺�˻�
	public static List<CashVO> cashManageData(){
		List<CashVO> list = new ArrayList<CashVO>();
		SqlSession session=null;
		try{
			session=ssf.openSession();
			list=session.selectList("cashManageData");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//�������� �Ϸ�
	public static void cashOkData(String id){
		SqlSession session=null;
		try{
			session=ssf.openSession();
			session.update("cashOkData",id);
			session.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	//�������� ���
	public static void cashNoData(String id){
		SqlSession session=null;
		try{
			session=ssf.openSession();
			session.update("cashNoData",id);
			session.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}





