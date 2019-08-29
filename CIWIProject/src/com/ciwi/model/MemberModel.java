package com.ciwi.model;

import javax.servlet.http.HttpSession;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.MemberDAO;
import com.ciwi.vo.MemberVO;
@Controller("MemberModel")
public class MemberModel {
	//���̵� �ߺ��˻� 
	@RequestMapping("member/join_ok.do")
	public String member_join_ok(Model model){
		String id=model.getRequest().getParameter("id");
		System.out.println(id);
		int count = MemberDAO.memberIdOverlap(id);
		System.out.println(count);
		HttpSession session = model.getRequest().getSession();
		session.setAttribute("count", count);
		return "../member/join_ok.jsp"; // ��� ȭ������ �̵�.
	}
	//ȸ������
	@RequestMapping("member/join.do")
	public String member_join(Model model){
		model.addAttribute("main_jsp", "../member/join.jsp");
		return "../main/main.jsp";
	}
	//ȸ������ 
	@RequestMapping("member/join_modify.do")
	public String member_join_modify(Model model){
		model.addAttribute("main_jsp", "../member/join_modify.jsp");
		return "../main/main.jsp";
	}
	//ȸ������ �Ϸ� 
	@RequestMapping("mamber/join_finish")
	public String member_join_finish(Model model){
		model.addAttribute("main_jsp", "../member/join_finish.jsp");
		return "../main/main.jsp";
	}
	//�α���ȭ�� ���
	@RequestMapping("member/login.do")
	public String member_login(Model model){
		model.addAttribute("main_jsp", "../member/login.jsp");
		return "../main/main.jsp";
	}
	//�α��� ����
	@RequestMapping("member/login_ok.do")
	public String member_login_ok(Model model){
		//���� �޴´�
		String id=model.getRequest().getParameter("id");
		String pwd=model.getRequest().getParameter("pwd");
		MemberVO vo = MemberDAO.memberLogin(id, pwd);
		//�α����� �� ���� = session�� �����Ѵ�.
		if(vo.getMsg().equals("OK")){
			HttpSession session = model.getRequest().getSession();
			session.setAttribute("id", id);
			session.setAttribute("name", vo.getName());
			session.setAttribute("admin", vo.getAdmin());
		}
		model.addAttribute("result", vo.getMsg());
		return "../member/login_ok.jsp";
	}
	//�α׾ƿ� : session�� ������ �� ��� �����.
	@RequestMapping("member/logout.do")
	public String member_logout(Model model){
		HttpSession session = model.getRequest().getSession();
		session.invalidate();
		return "redirect:../main/main.do";
	}
	
	
	
	
}