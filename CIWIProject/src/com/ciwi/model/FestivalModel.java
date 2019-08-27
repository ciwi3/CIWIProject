package com.ciwi.model;
import java.util.*;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.FestivalDAO;
import com.ciwi.vo.FestivalVO;

@Controller("festivalModel")
public class FestivalModel {
	@RequestMapping("contents/festival.do")
	public String festival_list(Model model) {
		List<FestivalVO> flist=FestivalDAO.festivalAllData();
		model.addAttribute("flist", flist);
		model.addAttribute("main_jsp", "../contents/festival.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("contents/festival_detail.do")
	public String festival_detail(Model model) {
		String fno=model.getRequest().getParameter("fno");
		FestivalVO fvo=FestivalDAO.festivalDetail(Integer.parseInt(fno));
		model.addAttribute("fvo", fvo);
		model.addAttribute("main_jsp", "../contents/festival_detail.jsp");
		return "../main/main.jsp";
	}
}
