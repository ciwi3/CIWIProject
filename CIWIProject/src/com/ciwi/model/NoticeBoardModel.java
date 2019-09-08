package com.ciwi.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.*;
import com.ciwi.vo.*;

@Controller("noticeBoardModel")
public class NoticeBoardModel {
	
	@RequestMapping("notice/noticeboard_list.do")
	public String nboard_list(Model model){
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
		

		List<NoticeBoardVO> list =NoticeBoardDAO.noticeboardListData(map);
		model.addAttribute("list", list);
		
		
		int totalpage=NoticeBoardDAO.noticeboardTotalPage();
		int count = NoticeBoardDAO.noticeboardRowCount();
		count=count-((curpage*rowSize)-rowSize);
		
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		model.addAttribute("today", today);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("count", count);
		model.addAttribute("main_jsp", "../notice/noticeboard_list.jsp");
		
		
		return "../main/main.jsp";
	}
}
