package com.ciwi.model;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.ShowDAO;
import com.ciwi.vo.AreaVO;
import com.ciwi.vo.ShowGenreVO;
import com.ciwi.vo.ShowVO;
import java.util.*;

@Controller("showModel")
public class ShowModel {

	@RequestMapping("contents/show.do")
	public String show_list(Model model) {
		List<ShowVO> slist = ShowDAO.showAllData();
		List<AreaVO> alist = ShowDAO.getAreaName();
		List<ShowGenreVO> glist = ShowDAO.getGenreName();
		model.addAttribute("alist", alist);
		model.addAttribute("glist", glist);
		model.addAttribute("slist", slist);
		model.addAttribute("main_jsp", "../contents/show.jsp");
		return "../main/main.jsp";
	}

	@RequestMapping("contents/show_detail.do")
	public String show_detail(Model model) {
		String no = model.getRequest().getParameter("no");
		ShowVO svo = ShowDAO.showDetailData(Integer.parseInt(no));
		model.addAttribute("svo", svo);
		model.addAttribute("main_jsp", "../contents/show_detail.jsp");

		return "../main/main.jsp";
	}

	@RequestMapping("contents/show_search.do")
	public String show_Search(Model model) {
		/* String[] checks = model.getRequest().getParameterValues("Checks"); */
		String genre = model.getRequest().getParameter("genre");
		String area = model.getRequest().getParameter("area");
		String searchOption = model.getRequest().getParameter("search");
		String text = model.getRequest().getParameter("stext");
		System.out.println(area);
		Map map = new HashMap<>();
		map.put("show_genre", genre);
		map.put("area", area);
		map.put("searchOption", searchOption);
		map.put("search", text);

		List<ShowVO> slist = ShowDAO.showSearch(map);
		List<AreaVO> alist = ShowDAO.getAreaName();
		List<ShowGenreVO> glist = ShowDAO.getGenreName();

		model.addAttribute("slist", slist);
		model.addAttribute("alist", alist);
		model.addAttribute("glist", glist);
		model.addAttribute("count", slist.size());
		System.out.println(slist.size());
		model.getRequest().getAttribute("count");
		model.addAttribute("main_jsp", "../contents/show_search.jsp");

		return "../main/main.jsp";
	}
}
