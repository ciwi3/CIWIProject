package com.ciwi.model;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import java.util.*;

import javax.servlet.http.HttpSession;

import com.ciwi.dao.*;
import com.ciwi.vo.*;
@Controller("jjimModel")
public class JjimModel {
	// Âò µ¥ÀÌÅÍ Ãâ·Â
	@RequestMapping("mypage/jjim.do")
	public String get_jjim_data(Model model) {
		HttpSession session=model.getRequest().getSession();
		String id=(String)session.getAttribute("id");
		
		// °ø¿¬ Âò µ¥ÀÌÅÍ
		List<ShowVO> jjimSlist=JjimDAO.getJjimShowData(id);
		// ¿µÈ­ Âò µ¥ÀÌÅÍ

		// Çà»ç Âò µ¥ÀÌÅÍ
		List<FestivalVO> jjimFlist=JjimDAO.getJjimFestivalData(id);
		
		model.addAttribute("jjimSlist", jjimSlist);
		model.addAttribute("jjimFlist", jjimFlist);
		model.addAttribute("main_jsp", "../mypage/jjim.jsp");
		return "../main/main.jsp";
	}
}
