package com.ciwi.model;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.FestivalDAO;
import com.ciwi.dao.MovieDAO;
import com.ciwi.dao.ShowDAO;

@Controller("IndexModel")
public class IndexModel {
	@RequestMapping("main/index.do")
	public String allCountData(Model model){
		int sCount=ShowDAO.showAllCount();
		int mCount=MovieDAO.movieAllCount();
		int fCount=FestivalDAO.festivalAllCount();
		model.addAttribute("sCount", sCount);
		model.addAttribute("mCount", mCount);
		model.addAttribute("fCount", fCount);
		return "../main/index.jsp";
	}
}
