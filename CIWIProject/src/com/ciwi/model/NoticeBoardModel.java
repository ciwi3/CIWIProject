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
		int rowSize=5;
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
	
	// 게시판 내용 추가
	@RequestMapping("notice/noticeboard_insert.do")
	public String nboard_insert(Model model) {

		model.addAttribute("main_jsp", "../notice/noticeboard_insert.jsp");

		return "../main/main.jsp";
	}

	@RequestMapping("notice/noticeboard_insert_ok.do")
	public String nboard_insert_ok(Model model) {

		try {
			model.getRequest().setCharacterEncoding("UTF-8");
		} catch (Exception e) {
		}

		String id = model.getRequest().getParameter("id");
		String subject = model.getRequest().getParameter("subject");
		String content = model.getRequest().getParameter("content");

		NoticeBoardVO vo = new NoticeBoardVO();

		vo.setId(id);
		vo.setSubject(subject);
		vo.setContent(content);

		NoticeBoardDAO.noticeboardInsert(vo);

		return "redirect:../notice/noticeboard_list.do";
	}
	
	@RequestMapping("notice/noticeboard_detail.do")
	public String nboard_detail(Model model) {

		String no = model.getRequest().getParameter("no");
		String page = model.getRequest().getParameter("page");
		NoticeBoardVO vo = NoticeBoardDAO.noticeboardDetailData(Integer.parseInt(no), "detail");
		model.addAttribute("vo", vo);
		// list 댓글목록
		model.addAttribute("curpage", page);
		model.addAttribute("main_jsp", "../notice/noticeboard_detail.jsp");

		return "../main/main.jsp";
	}
	
	@RequestMapping("notice/noticeboard_update.do")
	public String nboard_update(Model model) {
	
		String no = model.getRequest().getParameter("no");
	
		NoticeBoardVO vo = NoticeBoardDAO.noticeboardDetailData(Integer.parseInt(no), "update");
		
		String page = model.getRequest().getParameter("page");
		model.addAttribute("curpage", page);
		
		model.addAttribute("vo", vo);
		model.addAttribute("main_jsp", "../notice/noticeboard_update.jsp");
		return "../main/main.jsp";
	}

	@RequestMapping("notice/noticeboard_update_ok.do")
	public String board_update_ok(Model model) {
		try {
			model.getRequest().setCharacterEncoding("UTF-8");
		} catch (Exception ex) {
		}

		String subject = model.getRequest().getParameter("subject");
		String content = model.getRequest().getParameter("content");
		String no = model.getRequest().getParameter("no");
		
		String page = model.getRequest().getParameter("page");
		model.addAttribute("curpage", page);

		NoticeBoardVO vo = new NoticeBoardVO();
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setNo(Integer.parseInt(no));

		int n = NoticeBoardDAO.noticeboardUpdate(vo);

		model.addAttribute("no", n);

		return "../notice/noticeboard_update_ok.jsp";
	}
	
	@RequestMapping("notice/noticeboard_delete_ok.do")
	public String nboard_delete_ok(Model model) {
		String no = model.getRequest().getParameter("no");
		NoticeBoardDAO.noticeboardDelete(Integer.parseInt(no));
		return "redirect:..../notice/noticeboard_list.do";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
