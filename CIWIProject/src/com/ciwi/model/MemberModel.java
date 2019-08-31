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
	//아이디 중복검색 
	@RequestMapping("member/join_ok.do")
	public String member_join_ok(Model model){
		String id=model.getRequest().getParameter("id");
		int count = MemberDAO.memberIdOverlap(id);
		HttpSession session = model.getRequest().getSession();
		session.setAttribute("count", count);
		return "../member/join_ok.jsp"; // 띄울 화면으로 이동.
	}
	//회원가입:화면이동
	@RequestMapping("member/join.do")
	public String member_join(Model model){
		model.addAttribute("main_jsp", "../member/join.jsp");
		return "../main/main.jsp";
	}
	//회원가입 : 데이터넣기
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
		System.out.println(id+"들어왔나?");
		System.out.println(pwd+"들어왔나?");
		System.out.println(name+"들어왔나?");
		System.out.println(sex+"들어왔나?");
		System.out.println(birthday+"들어왔나?");
		System.out.println(email+"들어왔나?");
		System.out.println(phone+"들어왔나?");//
		System.out.println(post+"들어왔나?");
		System.out.println(main_addr+"들어왔나?");
		System.out.println(sub_addr+"들어왔나?");
		System.out.println(cate+"들어왔나?");
		System.out.println(genre+"들어왔나?");
		
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
	
	//회원수정 
	@RequestMapping("member/join_modify.do")
	public String member_join_modify(Model model){
		model.addAttribute("main_jsp", "../member/join_modify.jsp");
		return "../main/main.jsp";
	}
/*	//회원가입 완료 
	@RequestMapping("mamber/join_finish")
	public String member_join_finish(Model model){
		model.addAttribute("main_jsp", "../member/join_finish.jsp");
		return "../main/main.jsp";
	}*/
	//로그인화면 출력
	@RequestMapping("member/login.do")
	public String member_login(Model model){
		model.addAttribute("main_jsp", "../member/login.jsp");
		return "../main/main.jsp";
	}
	//로그인 유무
	@RequestMapping("member/login_ok.do")
	public String member_login_ok(Model model){
		//값을 받는다
		String id=model.getRequest().getParameter("id");
		String pwd=model.getRequest().getParameter("pwd");
		MemberVO vo = MemberDAO.memberLogin(id, pwd);
		//로그인이 된 상태 = session에 저장한다.
		if(vo.getMsg().equals("OK")){
			HttpSession session = model.getRequest().getSession();
			session.setAttribute("id", id);
			session.setAttribute("name", vo.getName());
			session.setAttribute("admin", vo.getAdmin());
		}
		model.addAttribute("result", vo.getMsg());
		return "../member/login_ok.jsp";
	}
	//로그아웃 : session에 저장한 값 모두 지우기.
	@RequestMapping("member/logout.do")
	public String member_logout(Model model){
		HttpSession session = model.getRequest().getSession();
		session.invalidate();
		return "redirect:../main/main.do";
	}
	
	
	
	
}