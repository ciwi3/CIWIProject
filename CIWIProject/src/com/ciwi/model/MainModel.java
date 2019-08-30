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

		Map map = new HashMap<>();
		map.put("searchOption", "力格");
		map.put("text", "绢亥");
		List<MovieVO> list = MovieDAO.movieSearch(map);
		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "../main/section.jsp");
		for(MovieVO vo : list){
			System.out.println(vo.getTitle());
		}
		
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
		map.put("searchOption", "力格");
		map.put("text", text);
		List<FestivalVO> fList = FestivalDAO.festivalSearch(map);
		List<ShowVO> sList = ShowDAO.showSearch(map);
		List<MovieVO> mList = MovieDAO.movieSearch(map);

		System.out.println(fList.size());
		System.out.println(sList.size());
		System.out.println(mList.size());
		model.addAttribute("fList", fList);
		model.addAttribute("sList", sList);
		model.addAttribute("mList", mList);
		model.addAttribute("main_jsp", "../main/unifiedsearch.jsp");

		return "../main/main.jsp";
	}
}
