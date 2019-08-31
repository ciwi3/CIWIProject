package com.ciwi.model;

import javax.servlet.http.HttpSession;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.MemberDAO;
import com.ciwi.vo.MemberVO;

import net.bytebuddy.matcher.ModifierMatcher.Mode;
@Controller("MemberModel")
public class MemberModel {
	//���̵� �ߺ��˻� 
	@RequestMapping("member/join_ok.do")
	public String member_join_ok(Model model){
		String id=model.getRequest().getParameter("id");
		int count = MemberDAO.memberIdOverlap(id);
		HttpSession session = model.getRequest().getSession();
		session.setAttribute("count", count);
		return "../member/join_ok.jsp"; // ��� ȭ������ �̵�.
	}
	//ȸ������:ȭ���̵�
	@RequestMapping("member/join.do")
	public String member_join(Model model){
		model.addAttribute("main_jsp", "../member/join.jsp");
		return "../main/main.jsp";
	}
	//ȸ������ : �����ͳֱ�
	@RequestMapping("member/insert.do")
	public String member_join_insert(Model model){
		try{
			model.getRequest().setCharacterEncoding("UTF-8");
		}catch (Exception e) {}
		String id=model.getRequest().getParameter("id");
		String pwd=model.getRequest().getParameter("pwd");
		String name=model.getRequest().getParameter("name");
		String sex=model.getRequest().getParameter("sex");
		String birthday=model.getRequest().getParameter("birth");
		String email=model.getRequest().getParameter("email");
		String phone=model.getRequest().getParameter("phone");
		String post=model.getRequest().getParameter("post");
		String main_addr=model.getRequest().getParameter("main_addr");
		String sub_addr=model.getRequest().getParameter("sub_addr");
		String cate=model.getRequest().getParameter("cate");
		String genre=model.getRequest().getParameter("genre");
		System.out.println(id+"���Գ�?");
		System.out.println(pwd+"���Գ�?");
		System.out.println(name+"���Գ�?");
		System.out.println(sex+"���Գ�?");
		System.out.println(birthday+"���Գ�?");
		System.out.println(email+"���Գ�?");
		System.out.println(phone+"���Գ�?");//
		System.out.println(post+"���Գ�?");
		System.out.println(main_addr+"���Գ�?");
		System.out.println(sub_addr+"���Գ�?");
		System.out.println(cate+"���Գ�?");
		System.out.println(genre+"���Գ�?");
		
		/*MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setName(name);
		vo.setSex(sex);
		vo.setBirthday(birthday);
		vo.setEmail(email);
		vo.setPhone(phone);
		vo.setPost(post);
		vo.setMain_addr(main_addr);
		vo.setSub_addr(sub_addr);
		vo.setCate(cate);
		vo.setGenre(genre);
		MemberDAO.memberInsertData(vo);*/
		//model.addAttribute("main_jsp", "../member/join_finish.jsp");
		return "redirect:../member/join_finish.do";
	}
	
	//ȸ������ 
	@RequestMapping("member/join_modify.do")
	public String member_join_modify(Model model){
		model.addAttribute("main_jsp", "../member/join_modify.jsp");
		return "../main/main.jsp";
	}
/*	//ȸ������ �Ϸ� 
	@RequestMapping("mamber/join_finish")
	public String member_join_finish(Model model){
		model.addAttribute("main_jsp", "../member/join_finish.jsp");
		return "../main/main.jsp";
	}*/
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