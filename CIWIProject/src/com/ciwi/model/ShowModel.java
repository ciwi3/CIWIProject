package com.ciwi.model;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.ShowDAO;
import com.ciwi.vo.ShowVO;
import java.util.*;

@Controller("showModel")
public class ShowModel {
	
	@RequestMapping("show/show.do")
	public String show_list(Model model){
		List<ShowVO> slist=ShowDAO.showAllData();
		model.addAttribute("slist",slist);
		return "../main/main.jsp";
	}
	
	@RequestMapping("show/show_detail.do")
	public String show_detail(Model model){
		String sno=model.getRequest().getParameter("sno");
		ShowVO svo=ShowDAO.showDetailData(Integer.parseInt(sno));
		model.addAttribute("sno", sno);
		return "../main/main.jsp";
	}
	
	@RequestMapping("show/show_search.do")
	public String show_Search(Model model){
		String[] checks = model.getRequest().getParameterValues("Checks");
		String text=model.getRequest().getParameter("text");
		
		Map map=new HashMap<>();
		
		map.put("show_genre", checks[0]);
		map.put("show_area", checks[1]);
		map.put("searchOption", checks[2]);
		map.put("text", text);
		
		List<ShowVO> slist=ShowDAO.showSearch(map);
		
		model.addAttribute("slist", slist);
		return "../show/show.jsp";
	}

}
