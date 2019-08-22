package com.ciwi.model;

import javax.servlet.http.HttpSession;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.MemberDAO;
import com.ciwi.vo.MemberVO;
@Controller("memberModel")
public class MemberModel {
	@RequestMapping("member/join.do")
	public String member_main(Model model) {
		model.addAttribute("main_jsp", "../member/join.jsp");
		return "../main/main.jsp";
	}
	// �α��� ó�� => �α��� ��ư�� ������ �ٷ� main���� ���°� �ƴ϶� login.jsp�� ���ļ� ���ߵ�
	@RequestMapping("member/login.do")
	public String member_login(Model model) {
		String id=model.getRequest().getParameter("id");
		String pwd=model.getRequest().getParameter("pwd");
		
		MemberVO vo=MemberDAO.memberLogin(id, pwd);
		if(!(vo.getAdmin()==10||vo.getAdmin()==20)) {
			HttpSession session=model.getRequest().getSession();
			session.setAttribute("id", id);
			session.setAttribute("admin", vo.getAdmin());
			session.setAttribute("name", vo.getName());
		}
		model.addAttribute("result", vo.getAdmin());
		return "../member/login.jsp";
	}
	
	@RequestMapping("member/logout.do")
	public String member_logout(Model model) {
		HttpSession session=model.getRequest().getSession();
		session.invalidate(); // ���ǿ� ����� ��� ������ ���� => id=null, admin=null
		return "redirect:../main/main.do";
	}
}















