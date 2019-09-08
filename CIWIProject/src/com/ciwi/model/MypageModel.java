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
	//마이페이지
	//나의 회원정보 출력
	@RequestMapping("mypage/myinformation.do")
	public String myinformation(Model model){
		// session에 등록된 아이디로 검색해서 
		// 나의 이름,휴대폰번호,내보유캐시,취향 검색 후 출력
		HttpSession session = model.getRequest().getSession();
		MemberVO vo = new MemberVO();
		String id=(String)session.getAttribute("id");
		vo=MypageDAO.myInformation(id);
		model.addAttribute("vo", vo); 
		model.addAttribute("main_jsp", "../mypage/myinformation.jsp");
		return "../main/main.jsp";
	}
	// 내 지갑 충전화면 출력
	@RequestMapping("mypage/mycashcharge.do")
	public String mycashcharge(Model model){
		model.addAttribute("main_jsp", "../mypage/mycashcharge.jsp");
		return "../main/main.jsp";
	}
	// 캐시충전 
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
	//충전완료 화면출력
	
	
}
