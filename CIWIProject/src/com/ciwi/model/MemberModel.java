package com.ciwi.model;

import java.util.ArrayList;
import java.util.List;
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
	//회원가입: 휴대폰번호 중복 확인
	@RequestMapping("member/join_phone_ok.do")
	public String join_phone(Model model){
		String phone=model.getRequest().getParameter("phone1")+"-"+model.getRequest().getParameter("phone2")+"-"
							+model.getRequest().getParameter("phone3");
		int count = MemberDAO.joinPhone(phone);
		//System.out.println(count);
		model.addAttribute("count", count);
		return "../member/join_phone_ok.jsp";
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
		String email=model.getRequest().getParameter("email1")+"@"+model.getRequest().getParameter("email2");
		String phone=model.getRequest().getParameter("phone1")+"-"+model.getRequest().getParameter("phone2")
							+"-"+model.getRequest().getParameter("phone3");
		String post=model.getRequest().getParameter("post");
		String main_addr=model.getRequest().getParameter("main_addr");
		String sub_addr=model.getRequest().getParameter("sub_addr");
		String cate=model.getRequest().getParameter("cate1")+","+
							model.getRequest().getParameter("cate2");
		String genre=model.getRequest().getParameter("genre1")+","+
							model.getRequest().getParameter("genre2");
		
		MemberVO vo = new MemberVO();
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
		MemberDAO.memberInsertData(vo);
		return "redirect:../member/join_finish.do"; //값을 전송
	}
	//회원가입 완료 
	@RequestMapping("member/join_finish.do")
	public String member_join_finish(Model model){
		String id=MemberDAO.joinFinishData();
		model.addAttribute("id", id);
		model.addAttribute("main_jsp", "../member/join_finish.jsp");
		return "../main/main.jsp";
	}
	//회원수정 화면이동
	@RequestMapping("member/join_modify.do")
	public String join_modify(Model model){
		model.addAttribute("main_jsp", "../member/join_modify.jsp");
		return "../main/main.jsp";
	}
	//회원수정 
	@RequestMapping("member/join_modify_ok.do")
	public String join_modify_update(Model model){
		try{
			model.getRequest().setCharacterEncoding("UTF-8");
		}catch (Exception e) {}
		String pwd=model.getRequest().getParameter("pwd");
		String email=model.getRequest().getParameter("email1")+"@"+model.getRequest().getParameter("email2");
		String phone=model.getRequest().getParameter("phone1")+"-"+model.getRequest().getParameter("phone2")
				+"-"+model.getRequest().getParameter("phone3");
		String post=model.getRequest().getParameter("post");
		String main_addr=model.getRequest().getParameter("main_addr");
		String sub_addr=model.getRequest().getParameter("sub_addr");
		String cate=model.getRequest().getParameter("cate1")+","+
							model.getRequest().getParameter("cate2");
		String genre=model.getRequest().getParameter("genre1")+","+
							model.getRequest().getParameter("genre2");

		MemberVO vo= new MemberVO();
		vo.setPwd(pwd);
		vo.setEmail(email);
		vo.setPhone(phone);
		vo.setPost(post);
		vo.setMain_addr(main_addr);
		vo.setSub_addr(sub_addr);
		vo.setCate(cate);
		vo.setGenre(genre);
		// 확인
		HttpSession session=model.getRequest().getSession();
		String id=(String)session.getAttribute("id");
		vo.setId(id);
		MemberDAO.joinUpdate(vo);
		return "redirect:../member/modify_finish.do";
	}
	//회원수정완료
	@RequestMapping("member/modify_finish.do")
	public String member_modify_finish(Model model){
		model.addAttribute("main_jsp", "../member/modify_finish.jsp");
		return "../main/main.jsp";
	}
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
	//아이디 찾기 화면출력
	@RequestMapping("member/idFind.do")
	public String idFind(Model model){
		model.addAttribute("main_jsp", "../member/idFind.jsp");
		return "../main/main.jsp";
	}
	//아이디찾기
	@RequestMapping("member/idFind_ok.do")
	public String idFind_ok(Model model){
		String phone=model.getRequest().getParameter("phone1")+"-"+model.getRequest().getParameter("phone2")
				+"-"+model.getRequest().getParameter("phone3");
		MemberVO vo= MemberDAO.memberIdsearch(phone);
		String id=vo.getId();
		System.out.println(id);
		
		return "../member/idFind_ok.jsp";
	}
	//아이디 찾기 완료 화면출력
	@RequestMapping("member/idFind_finish.do")
	public String idFind_finish(Model model){
		
		model.addAttribute("main_jsp", "../member/idFind_finish.jsp");
		return "../main/main.jsp";
	}
	//비밀번호 찾기 화면출력
	
	//회원 탈퇴 
	@RequestMapping("member/member_delete.do")
	public String member_delete(Model model){
		String pwd=model.getRequest().getParameter("pwd");
		String db_pwd="";
		MemberVO vo = new MemberVO();
		HttpSession session=model.getRequest().getSession();
		String id=(String)session.getAttribute("id");
		vo=MemberDAO.memberGetPwd(id);
		db_pwd=vo.getPwd();
		System.out.println(db_pwd);
		if(pwd.equals(vo.getPwd())){
			MemberDAO.member_delete(id);
			session.invalidate();
		}
		return "redirect:../member/join_modify.do";
	}
	
	
	
}