package com.ciwi.model;

import java.util.*;

import javax.servlet.http.HttpSession;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.FestivalDAO;
import com.ciwi.dao.MemberDAO;
import com.ciwi.dao.MovieDAO;
import com.ciwi.dao.ShowDAO;
import com.ciwi.manager.NaverBlogManager;
import com.ciwi.vo.FestivalVO;
import com.ciwi.vo.MemberVO;
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
		List<FestivalVO> fList = null;
		String id = "";
		int genre = 0;
		int category = 0;
		HttpSession session = model.getRequest().getSession();
		Map<String, String> map = new HashMap<String, String>();
		NaverBlogManager nm = new NaverBlogManager();
		if (session.getAttribute("id") != null) {
			List<String> bList;
			id = (String) session.getAttribute("id");
			MemberVO vo = MemberDAO.memberGetGenreAndCategory(id);
			if (vo.getCate().contains("1")) {
				StringTokenizer st = new StringTokenizer(vo.getGenre(), ",");
				int genreCount = st.countTokens();
				if (genreCount > 1) {
					String firstGenre = st.nextToken();
					String lastGenre = st.nextToken();
					map.put("first", firstGenre);
					map.put("last", lastGenre);
					fList = FestivalDAO.festivalRecommendMultiGenre(map);
					bList = nm.blogGetData(firstGenre + " " + lastGenre);
				} else {
					fList = FestivalDAO.festivalRecommendSingleGenre(Integer.parseInt(vo.getGenre()));
					bList = nm.blogGetData(vo.getGenre());
				}
				int[] count = new int[fList.size()];
				for (String s : bList) {
					for (int i = 0; i < fList.size(); i++) {
						if (s.contains(fList.get(i).getSubject())) {
							count[i]++;
						}
					}
				}
			}
			model.addAttribute("fList", fList);
			/*
			 * List<FestivalVO> fList =
			 * FestivalDAO.festivalRecommend(vo.getGenre()); FestivalVO[] array
			 * = (FestivalVO[]) fList.toArray(); int[] a = new
			 * int[array.length]; fList.ge model.addAttribute("fList", fList);
			 * 
			 * } if (vo.getCate().contains("2")) { List<ShowVO> sList =
			 * ShowDAO.showRecommend(map); model.addAttribute("sList", sList); }
			 * if (vo.getCate().contains("3")) {
			 * 
			 * }
			 */
		}
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
		map.put("searchOption", "제목");
		map.put("search", text);
		List<FestivalVO> fList = FestivalDAO.festivalSearch(map);
		List<ShowVO> sList = ShowDAO.showSearch8(map);
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
