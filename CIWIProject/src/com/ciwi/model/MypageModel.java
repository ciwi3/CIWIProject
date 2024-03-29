package com.ciwi.model;

import javax.servlet.http.HttpSession;
import java.util.*;
import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.MypageDAO;
import com.ciwi.vo.CashVO;
import com.ciwi.vo.MemberVO;
import com.ciwi.vo.ReserveInfoVO;
@Controller("MypageModel")
public class MypageModel {
	//마이페이지
	//나의 회원정보 출력
	@RequestMapping("mypage/myinformation.do")
	public String myinformation(Model model){
		// session에 등록된 아이디로 검색해서 
		// 나의 이름,휴대폰번호,취향,보유총캐시 검색 후 출력
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
	//사용자 캐시 내역 화면 출력
	@RequestMapping("mypage/mypage.do")
	public String mypageData(Model model){
		List<CashVO> list = MypageDAO.cashManageData();
		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "../mypage/mypage.jsp");
		return "../main/main.jsp";
	}
	//관리자 결제내역 데이터출력
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
		MypageDAO.cashOkData(id);
		return "redirect:../mypage/adminpage.do";
	}
	//관리자 예매내역 승인완료
	@RequestMapping("mypage/reserveOk.do")
	public String reserveOkData(Model model){
		String id=model.getRequest().getParameter("id");
		MypageDAO.reserveOkData(id);
		return "redirect:../mypage/adminreserve.do";
	}
	//사용자 예매 데이터 출력
	@RequestMapping("mypage/reservepage.do")
	public String reserveData(Model model){
		HttpSession session = model.getRequest().getSession();
		String id=(String)session.getAttribute("id");
		//System.out.println(id);
		List<ReserveInfoVO> list = MypageDAO.reserveData(id);
		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "../mypage/reservepage.jsp");
		return "../main/main.jsp";
	}
	// 관리자예매 데이터 출력
	@RequestMapping("mypage/adminreserve.do")
	public String reserveAdminData(Model model){
		List<ReserveInfoVO> list = MypageDAO.reserveAdminData();
		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "../mypage/adminreserve.jsp");
		return "../main/main.jsp";
	}

}

