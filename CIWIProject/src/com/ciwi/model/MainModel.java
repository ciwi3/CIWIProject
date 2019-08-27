package com.ciwi.model;

import java.util.*;
import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.FestivalDAO;
import com.ciwi.vo.FestivalVO;

@Controller("mainModel")
public class MainModel {
	@RequestMapping("main/index.do")
	public String main_index_page(Model model) {
		return "../main/index.jsp";
	}
	@RequestMapping("main/main.do")
	public String main_page(Model model) {
		// festival 목록 출력
		List<FestivalVO> flist=FestivalDAO.festivalAllData();
		model.addAttribute("flist", flist);
		
		model.addAttribute("main_jsp", "../main/section.jsp");
		return "../main/main.jsp";
	}
}
