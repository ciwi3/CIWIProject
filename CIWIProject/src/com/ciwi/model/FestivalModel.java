package com.ciwi.model;

import java.util.*;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.FestivalDAO;
import com.ciwi.vo.FestivalVO;

@Controller("festivalModel")
public class FestivalModel {
	@RequestMapping("contents/festival.do")
	public String festival_list(Model model) {
		String page = model.getRequest().getParameter("page");
		if (page == null) {
			page = "1";
		}
		int curPage = Integer.parseInt(page);
		int rowSize = 8;
		int start = (curPage * rowSize) - (rowSize - 1);
		int end = (curPage * rowSize);
		int BLOCK = 5;
		int totalPage = FestivalDAO.festivalTotalPage(rowSize);
		int startPage = ((curPage - 1) / BLOCK * BLOCK) + 1;
		int endPage = ((curPage - 1) / BLOCK * BLOCK) + BLOCK;
		int allPage = totalPage;
		if (endPage > allPage) {
			endPage = allPage;
		}

		Map map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);

		List<FestivalVO> flist = FestivalDAO.festivalListData(map);
		model.addAttribute("flist", flist);
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("allPage", allPage);
		model.addAttribute("BLOCK", BLOCK);
		model.addAttribute("main_jsp", "../contents/festival.jsp");
		return "../main/main.jsp";
	}

	@RequestMapping("contents/festival_detail.do")
	public String festival_detail(Model model) {
		String fno = model.getRequest().getParameter("fno");
		FestivalVO fvo = FestivalDAO.festivalDetail(Integer.parseInt(fno));
		model.addAttribute("fvo", fvo);
		model.addAttribute("main_jsp", "../contents/festival_detail.jsp");
		return "../main/main.jsp";
	}
}
