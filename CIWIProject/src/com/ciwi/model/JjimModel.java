package com.ciwi.model;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import java.util.*;
import com.ciwi.dao.*;
import com.ciwi.vo.*;
@Controller("jjimModel")
public class JjimModel {
	// 찜 데이터 출력
	@RequestMapping("mypage/jjim.do")
	public String get_jjim_data(Model model) {
		List<FestivalVO> jjimFlist=JjimDAO.getJjimFestivalData();
		for(FestivalVO vo:jjimFlist) {
			System.out.println(vo.getPoster());
			System.out.println(vo.getSubject());
			System.out.println(vo.getFdate());
			System.out.println(vo.getPlace());
		}
		model.addAttribute("main_jsp", "../mypage/jjim.jsp");
		return "../main/main.jsp";
	}
}
