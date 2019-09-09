package com.ciwi.model;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.JjimDAO;
import com.ciwi.dao.MovieDAO;
import com.ciwi.dao.ReviewDAO;
import com.ciwi.dao.ShowDAO;
import com.ciwi.vo.AreaVO;
import com.ciwi.vo.JjimVO;
import com.ciwi.vo.MovieVO;
import com.ciwi.vo.ReviewVO;
import com.ciwi.vo.ShowGenreVO;
import com.ciwi.vo.ShowVO;
import java.util.*;

import javax.servlet.http.HttpSession;

@Controller("showModel")
public class ShowModel {

	@RequestMapping("contents/show.do")
	public String show_list(Model model) {
		List<AreaVO> alist = ShowDAO.getAreaName();
		List<ShowGenreVO> glist = ShowDAO.getGenreName();
		String page = model.getRequest().getParameter("page");
		if (page == null) {
			page = "1";
		}
		int curPage = Integer.parseInt(page);
		int rowSize = 12;
		int start = (curPage * rowSize) - (rowSize - 1);
		int end = (curPage * rowSize);
		int BLOCK = 5;
		int totalPage = ShowDAO.showTotalPage(rowSize);
		int startPage = ((curPage - 1) / BLOCK * BLOCK) + 1;
		int endPage = ((curPage - 1) / BLOCK * BLOCK) + BLOCK;
		int allPage = totalPage;
		if (endPage > allPage) {
			endPage = allPage;
		}
		Map map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);

		List<ShowVO> slist = ShowDAO.showPageListData(map);
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("allPage", allPage);
		model.addAttribute("BLOCK", BLOCK);

		model.addAttribute("alist", alist);
		model.addAttribute("glist", glist);
		model.addAttribute("slist", slist);
		model.addAttribute("main_jsp", "../contents/show.jsp");
		return "../main/main.jsp";
	}

	@RequestMapping("contents/show_detail.do")
	public String show_detail(Model model) {
		try {
			String no = model.getRequest().getParameter("no");
			ShowVO svo = ShowDAO.showDetailData(Integer.parseInt(no));
			
			
			// JJim
			HttpSession session = model.getRequest().getSession();
			String id = (String)session.getAttribute("id");
			int flag=0;
			List<JjimVO> list = new ArrayList<JjimVO>();
			Map selectShowJjimMap = new HashMap();
			selectShowJjimMap.put("category_no", 4);
			selectShowJjimMap.put("contents_no", Integer.parseInt(no));
			if(id==null) {
				selectShowJjimMap.put("id", "-");
			} else {
				selectShowJjimMap.put("id", id);
			}
			list = JjimDAO.getJjim(selectShowJjimMap);
			if(list.isEmpty()) {
				flag=0;
			} else {
				System.out.println("여기 와지나?");
				flag = list.get(0).getFlag();
			}
			model.addAttribute("flag", flag);
			// JJim End
			
			
			List<ReviewVO> rlist = ReviewDAO.showReviewList(svo);
			/* System.out.println(list.size()); */
			model.addAttribute("svo", svo);
			model.addAttribute("rlist", rlist);
			model.addAttribute("main_jsp", "../contents/show_detail.jsp");
		} catch (Exception e) {}
		/*
		 * System.out.println(svo.getCategory_no()); System.out.println(svo.getSno());
		 */

		return "../main/main.jsp";
	}
	@RequestMapping("contents/show_jjim_ok.do")
	public String show_jjim_ok(Model model) {
		String sno = model.getRequest().getParameter("sno"); // 찜 등록,삭제 구분
		HttpSession session = model.getRequest().getSession();
		String id = (String) session.getAttribute("id");
		int flag = 0;
		// 찜 등록
		Map insertJjimMap = new HashMap();
		insertJjimMap.put("sno", sno);
		insertJjimMap.put("id", id);
		JjimDAO.insertJjimShowData(insertJjimMap);

		// 어떤 사용자가 어떤 카테고리의 어떤 글을 찜했는지 안했는지 알기 위한 jjim목록 가져오기
		List<JjimVO> list = new ArrayList<JjimVO>();
		Map selectShowJjimMap = new HashMap();
		selectShowJjimMap.put("category_no", 4);
		selectShowJjimMap.put("contents_no", sno);
		selectShowJjimMap.put("id", id);
		list = JjimDAO.getJjim(selectShowJjimMap); // 카테고리, 글 번호, 아이디, 찜 상태 정보를 가져옴
		
		flag = list.get(0).getFlag();
		
		if (list.size() >= 2) {
			Map deleteJjimMap = new HashMap();
			deleteJjimMap.put("category_no", 4);
			deleteJjimMap.put("contents_no", sno);
			deleteJjimMap.put("id", id);
			JjimDAO.deleteJjimShowData(deleteJjimMap);
			
			// 데이터가 삭제되면 flag=0으로 설정해줌
			flag = 0;
		}
		System.out.println(flag);

		return "redirect:../contents/show_detail.do";
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

	@RequestMapping("contents/show_review_insert.do")
	public String show_rating(Model model) {
		try {
			model.getRequest().setCharacterEncoding("UTF-8");
		} catch (Exception ex) {
		}

		String rating = model.getRequest().getParameter("rating");
		String content_no = model.getRequest().getParameter("no");
		HttpSession session = model.getRequest().getSession();
		String memid = (String) session.getAttribute("memid");
		String rtext = model.getRequest().getParameter("rtext");

		ReviewVO vo = new ReviewVO();

		vo.setRating(Integer.parseInt(rating));
		vo.setContent_no(Integer.parseInt(content_no));
		vo.setMemid(memid);
		vo.setCategory_no(4);
		vo.setRtext(rtext);

		String rCheck = ReviewDAO.ratingcheck(vo);

		if (rCheck != null) {
			ReviewDAO.reviewModified(vo, memid);
		} else if (rCheck == null) {
			if (rtext == null) {
				ReviewDAO.ratingInsert(vo);
			} else {
				ReviewDAO.reviewInsert(vo);
			}
		}

		model.addAttribute("main_jsp", "../contents/show_datail.jsp");

		return "../main/main.jsp";
	}

	@RequestMapping("contents/show_delete.do")
	public String reviewDelete(Model model) {
		String rno = model.getRequest().getParameter("rno");
		HttpSession session = model.getRequest().getSession();
		String memid = (String) session.getAttribute("memid");

		ReviewVO vo = new ReviewVO();

		vo.setRno(Integer.parseInt(rno));
		vo.setMemid(memid);

		ReviewDAO.reviewDelete(vo, memid);
		return "../main/main.jsp";
	}
}
