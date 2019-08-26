package com.ciwi.model;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;

@Controller("mainModel") // key="mainModel"
public class MainModel {
	@RequestMapping("index_main/index.do")
	public String index_page(Model model) { // ModelŬ������ request��
		// return "main/index.jsp"; //
		return "../index_main/index.jsp";
	}

	@RequestMapping("main/main.do")
	public String main_page(Model model) {
		model.addAttribute("main_jsp", "../main/main.jsp");
		return "../main/main.jsp";
	}
}
