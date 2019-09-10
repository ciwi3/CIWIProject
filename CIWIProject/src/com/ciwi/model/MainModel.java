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
		List<FestivalVO> flist=FestivalDAO.festivalMainList();
		List<MovieVO> mlist=MovieDAO.movieListData();
		
		model.addAttribute("flist", flist);
		model.addAttribute("mlist", mlist);
		
		
		List<FestivalVO> fList = null;
		List<ShowVO> sList = null;
		List<MovieVO> mList = null;
		String id = "";
		HttpSession session = model.getRequest().getSession();
		Map<String, Integer> map = new HashMap<String, Integer>();
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
					map.put("first", Integer.parseInt(firstGenre));
					map.put("last", Integer.parseInt(lastGenre));
					fList = FestivalDAO.festivalRecommendMultiGenre(map);
				} else {
					fList = FestivalDAO.festivalRecommendSingleGenre(Integer.parseInt(vo.getGenre()));
				}
				Collections.shuffle(fList);
				if (fList.size() > 5) {
					fList = fList.subList(0, 6);
				}
				model.addAttribute("fList", fList);
			}
			if (vo.getCate().contains("2")) {
				StringTokenizer st = new StringTokenizer(vo.getGenre(), ",");
				int genreCount = st.countTokens();
				if (genreCount > 1) {
					String firstGenre = st.nextToken();
					String lastGenre = st.nextToken();
					map.put("first", Integer.parseInt(firstGenre));
					map.put("last", Integer.parseInt(lastGenre));
					sList = ShowDAO.showRecommendMultiGenre(map);
				} else {
					sList = ShowDAO.showRecommendSingleGenre(Integer.parseInt(vo.getGenre()));
				}
				Collections.shuffle(sList);
				if (fList.size() > 5) {
					sList = sList.subList(0, 6);
				}
				model.addAttribute("sList", sList);
			}
			if (vo.getCate().contains("3")) {
				StringTokenizer st = new StringTokenizer(vo.getGenre(), ",");
				int genreCount = st.countTokens();
				if (genreCount > 1) {
					String firstGenre = st.nextToken();
					String lastGenre = st.nextToken();
					map.put("first", Integer.parseInt(firstGenre));
					map.put("last", Integer.parseInt(lastGenre));
					mList = MovieDAO.movieRecommendMultiGenre(map);
					bList = nm.blogGetData(firstGenre + " " + lastGenre + " �쁺�솕");
				} else {
					mList = MovieDAO.movieRecommendSingleGenre(Integer.parseInt(vo.getGenre()));
					bList = nm.blogGetData(vo.getGenre());
				}
				for (String s : bList) {
					for (int i = 0; i < mList.size(); i++) {
						if (s.contains(mList.get(i).getTitle())) {
							mList.get(i).setCount(mList.get(i).getCount() + 1);
						}
					}
				}
				Collections.sort(mList, new Comparator<MovieVO>() {
					@Override
					public int compare(MovieVO vo1, MovieVO vo2) {
						return Integer.compare(vo2.getCount(), vo1.getCount());
					}
				});
				if (mList.size() > 5) {
					mList = mList.subList(0, 6);
				}
				model.addAttribute("mList", mList);
			}
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
		map.put("searchOption", "占쎌젫筌륅옙");
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
	
	@RequestMapping("main/aboutUS.do")
	public String aboutUS(Model model){
		
		model.addAttribute("main_jsp", "../main/aboutUS.jsp");
		
		return "../main/main.jsp";
	}
	
}
