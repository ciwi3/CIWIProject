package com.ciwi.model;

import java.util.List;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.MovieDAO;
import com.ciwi.vo.MovieVO;

@Controller("MovieModel")
public class MovieModel {
	@RequestMapping("contents/movie/reserve.do")
	public String movie_reserve_list(Model model) {
		List<MovieVO> list = MovieDAO.movieListData();
		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "../contents/movie/reserve.jsp");
		return "../../main/main.jsp";
	}
}
