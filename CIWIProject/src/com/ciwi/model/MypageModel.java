package com.ciwi.model;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
@Controller("MypageModel")
public class MypageModel {
	//마이페이지
	@RequestMapping("mypage/mypage.do")
	public String mypage(Model model){
		model.addAttribute("main_jsp", "../mypage/mypage.jsp");
		return "../main/main.jsp";
	}
	
	//나의 회원정보 출력
	@RequestMapping("mypage/myinformation.do")
	public String myinformation(Model model){
		//DB에서 아이디 이름 휴대폰번호 내 보유캐시 취향 보여주기
		
		model.addAttribute("main_jsp", "../mypage/myinformation");
		return "../main/main.jsp";
	}
	//내 지갑 화면 출력
	
	// 내 지갑 충전화면 출력
	
	//충전완료 화면출력
	
	
}
