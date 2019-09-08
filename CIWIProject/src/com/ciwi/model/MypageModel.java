package com.ciwi.model;

import javax.servlet.http.HttpSession;
import java.util.*;
import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.MypageDAO;
import com.ciwi.vo.MemberVO;
@Controller("MypageModel")
public class MypageModel {
	//����������
	//���� ȸ������ ���
	@RequestMapping("mypage/myinformation.do")
	public String myinformation(Model model){
		// session�� ��ϵ� ���̵�� �˻��ؼ� 
		// ���� �̸�,�޴�����ȣ,������ĳ��,���� �˻� �� ���
		HttpSession session = model.getRequest().getSession();
		MemberVO vo = new MemberVO();
		String id=(String)session.getAttribute("id");
		vo=MypageDAO.myInformation(id);
		model.addAttribute("vo", vo); 
		model.addAttribute("main_jsp", "../mypage/myinformation.jsp");
		return "../main/main.jsp";
	}
	// �� ���� ����ȭ�� ���
	@RequestMapping("mypage/mycashcharge.do")
	public String mycashcharge(Model model){
		model.addAttribute("main_jsp", "../mypage/mycashcharge.jsp");
		return "../main/main.jsp";
	}
	// ĳ������ 
	@RequestMapping("mypage/cashcharge_ok.do")
	public String cashUpdate(Model model){
		//int mempay=model.getRequest().getParameter();
		HttpSession session = model.getRequest().getSession();
		MemberVO vo = new MemberVO();
		String id=(String)session.getAttribute("id");
		vo.setId(id);
		//vo.setMempay(mempay);
		MypageDAO.cashchargeUpdate(vo);
		return "";
	}
	//�����Ϸ� ȭ�����
	
	
}
