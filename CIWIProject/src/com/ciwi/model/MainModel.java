package com.ciwi.model;

import java.util.*;
import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.FestivalDAO;
import com.ciwi.dao.MovieDAO;
import com.ciwi.dao.ShowDAO;
import com.ciwi.vo.FestivalVO;
import com.ciwi.vo.MovieVO;
import com.ciwi.vo.ShowVO;

@Controller("mainModel")
public class MainModel {
	@RequestMapping("main/index.do")
	public String main_index_page(Model model) {
		return "../main/index.jsp";
	}

	@RequestMapping("main/main.do")
	public String main_page(Model model) {

		model.addAttribute("main_jsp", "../main/section.jsp");

		return "../main/main.jsp";
	}

	@RequestMapping("main/unifiedsearch.do")
	public String main_search(Model model) {
		try {
			model.getRequest().setCharacterEncoding("UTF-8");
		} catch (Exception ex) {
		}

		String text = model.getRequest().getParameter("text");
		Map map = new HashMap<>();
		map.put("searchOption", "Á¦¸ñ");
		map.put("text", text);
		List<FestivalVO> fList = FestivalDAO.festivalSearch(map);
		List<ShowVO> sList = ShowDAO.showSearch(map);
		List<MovieVO> mList = MovieDAO.movieSearch(map);
		int searchTextSize = 15;
		for (FestivalVO vo : fList) {
			if (vo.getSubject().length() > searchTextSize)
				vo.setSubject(vo.getSubject().substring(0, searchTextSize) + "...");
		}
		for (ShowVO vo : sList) {
			if (vo.getSubject().length() > searchTextSize)
				vo.setSubject(vo.getSubject().substring(0, searchTextSize) + "...");
		}
		for (MovieVO vo : mList) {
			if (vo.getTitle().length() > searchTextSize)
				vo.setTitle(vo.getTitle().substring(0, searchTextSize) + "...");
		}
		model.addAttribute("fList", fList);
		model.addAttribute("sList", sList);
		model.addAttribute("mList", mList);
		model.addAttribute("main_jsp", "../main/unifiedsearch.jsp");

		return "../main/main.jsp";
	}
}
