package com.ciwi.model;

import java.text.SimpleDateFormat;
import java.util.*;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.FreeBoardDAO;
import com.ciwi.vo.FreeBoardVO;

@Controller("boardModel")
public class BoardModel {

	@RequestMapping("community/freeboard_list.do")
	public String board_list(Model model){
		String page = model.getRequest().getParameter("page");
		if(page == null)
			page = "1";
		int curpage = Integer.parseInt(page);
		
		Map map = new HashMap();
		int rowSize=10;
		int start = (curpage*rowSize)-(rowSize-1);
		int end = curpage*rowSize;
		
		map.put("start", start);
		map.put("end", end);
		
		List<FreeBoardVO> list = FreeBoardDAO.freeboardListData(map);
		
		model.addAttribute("list", list);
		
		int totalpage=FreeBoardDAO.freeboardTotalPage();
		int count = FreeBoardDAO.freeboardRowCount();
		count=count-((curpage*rowSize)-rowSize);
		
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		model.addAttribute("today", today);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("count", count);
		model.addAttribute("main_jsp", "../community/freeboard_list.jsp");
		
		
		return "../main/main.jsp";
	}
	
	@RequestMapping("community/freeboard_insert.do")
	public String board_insert(Model model){
		
		model.addAttribute("main_jsp", "../community/freeboard_insert.jsp");
		
		return "../main/main.jsp";
	}
	
	@RequestMapping("community/freeboard_insert_ok.do")
	public String freeboard_insert_ok(Model model){
		
		try {
			model.getRequest().setCharacterEncoding("UTF-8");
		} catch (Exception e) {}
		
		String id=model.getRequest().getParameter("id");
		String subject=model.getRequest().getParameter("subject");
		String content=model.getRequest().getParameter("content");
		String bcategory=model.getRequest().getParameter("board_category");
		
		bcategory=bcategory.substring(0,1);
		int board_category = Integer.parseInt(bcategory);
		FreeBoardVO vo = new FreeBoardVO();
		
		vo.setId(id);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setBoard_category(board_category);
		
		FreeBoardDAO.freeboardInsert(vo);
		
		return "redirect:../community/freeboard_list.do";
	}
	
	@RequestMapping("community/freeboard_detail.do")
	public String board_detail(Model model){
		
		String no=model.getRequest().getParameter("no");
		FreeBoardVO vo = FreeBoardDAO.freeboardDetailData(Integer.parseInt(no), "detail");
		model.addAttribute("vo", vo);
		model.addAttribute("main_jsp", "../community/freeboard_detail.jsp");		
		//list ´ñ±Û¸ñ·Ï 
		
		
		return "../main/main.jsp";
	}
	
	
	
	
	
	
	
	
	
	
}
