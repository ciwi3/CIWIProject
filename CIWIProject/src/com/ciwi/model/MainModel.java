package com.ciwi.model;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;

@Controller("mainModel") // key="mainModel"
public class MainModel {
	@RequestMapping("main/index.do")
	public String main_index_page(Model model) { // Model클래스가 request임
		return "../main/index.jsp";
	}
	@RequestMapping("main/main.do")
	public String main_page(Model model) {
		model.addAttribute("main_jsp", "../main/section.jsp");
		return "../main/main.jsp";
	}
}
