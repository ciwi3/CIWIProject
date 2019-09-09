package com.ciwi.model;

import javax.servlet.http.HttpSession;
import java.util.*;
import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.MypageDAO;
import com.ciwi.vo.CashVO;
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
		CashVO cvo = new CashVO();
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
	@RequestMapping("mypage/mycashcharge_ok.do")
	public String cashUpdate(Model model){
		String pay=model.getRequest().getParameter("pay");
		System.out.println(pay);
		HttpSession session = model.getRequest().getSession();
		CashVO vo = new CashVO();
		String id=(String)session.getAttribute("id");
		vo.setCash_id(id);
		vo.setCash_pay(Integer.parseInt(pay));
		MypageDAO.cashchargeUpdate(vo);
		return "../mypage/mycashcharge_ok.do";
	}
	//�������� ���������
	@RequestMapping("mypage/adminpage.do")
	public String cashManageData(Model model){
		List<CashVO> list = MypageDAO.cashManageData();
		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "../mypage/adminpage.jsp");
		return "../main/main.jsp";
	}
	//�����ڰ������� ���οϷ�
	@RequestMapping("mypage/cashOk.do")
	public String cashOkData(Model model){
		String id=model.getRequest().getParameter("id");
		//System.out.println(id);
		MypageDAO.cashOkData(id);
		return "redirect:../mypage/adminpage.do";
	}
	//�����ڰ������� �������
	@RequestMapping("mypage/cashNo.do")
	public String cashNoData(Model model){
		String id=model.getRequest().getParameter("id");
		//System.out.println(id);
		MypageDAO.cashNoData(id);
		return "../mypage/adminpage.do";
	}
	//����� ĳ������ ����ȭ�� ���
	//



}












