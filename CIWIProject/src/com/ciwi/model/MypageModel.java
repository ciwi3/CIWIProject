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
	//마이페이지
	//나의 회원정보 출력
	@RequestMapping("mypage/myinformation.do")
	public String myinformation(Model model){
		// session에 등록된 아이디로 검색해서 
		// 나의 이름,휴대폰번호,내보유캐시,취향 검색 후 출력
		HttpSession session = model.getRequest().getSession();
		MemberVO vo = new MemberVO();
		CashVO cvo = new CashVO();
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
	//결제내역 데이터출력
	@RequestMapping("mypage/adminpage.do")
	public String cashManageData(Model model){
		List<CashVO> list = MypageDAO.cashManageData();
		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "../mypage/adminpage.jsp");
		return "../main/main.jsp";
	}
	//관리자결제내역 승인완료
	@RequestMapping("mypage/cashOk.do")
	public String cashOkData(Model model){
		String id=model.getRequest().getParameter("id");
		//System.out.println(id);
		MypageDAO.cashOkData(id);
		return "redirect:../mypage/adminpage.do";
	}
	//관리자결제내역 승인취소
	@RequestMapping("mypage/cashNo.do")
	public String cashNoData(Model model){
		String id=model.getRequest().getParameter("id");
		//System.out.println(id);
		MypageDAO.cashNoData(id);
		return "../mypage/adminpage.do";
	}
	//사용자 캐시충전 내역화면 출력
	//



}












