package com.ciwi.model;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpSession;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.FreeBoardDAO;
import com.ciwi.vo.FreeBoardVO;
import com.ciwi.vo.FreeReplyVO;

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
		List<FreeBoardVO> nList = FreeBoardDAO.freeboardNoticeData(map);
		model.addAttribute("list", list);
		model.addAttribute("nList", nList);
		
		
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
	public String board_insert(Model model) {

		model.addAttribute("main_jsp", "../community/freeboard_insert.jsp");

		return "../main/main.jsp";
	}

	// 게시판 내용 추가
	@RequestMapping("community/freeboard_insert_ok.do")
	public String freeboard_insert_ok(Model model) {

		try {
			model.getRequest().setCharacterEncoding("UTF-8");
		} catch (Exception e) {
		}

		String id = model.getRequest().getParameter("id");
		String subject = model.getRequest().getParameter("subject");
		String content = model.getRequest().getParameter("content");
		String bcategory = model.getRequest().getParameter("board_category");

		bcategory = bcategory.substring(0, 1);
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
	public String board_detail(Model model) {

		String no = model.getRequest().getParameter("no");
		String page = model.getRequest().getParameter("page");
		FreeBoardVO vo = FreeBoardDAO.freeboardDetailData(Integer.parseInt(no), "detail");
		model.addAttribute("vo", vo);
		// list 댓글목록
		List<FreeReplyVO> list = FreeBoardDAO.replyListData(Integer.parseInt(no));
		int count = FreeBoardDAO.replyListCount(Integer.parseInt(no));
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("curpage", page);
		model.addAttribute("main_jsp", "../community/freeboard_detail.jsp");

		return "../main/main.jsp";
	}

	@RequestMapping("community/freeboard_update.do")
	public String board_update(Model model) {
		// 요청값을 받는다
		String no = model.getRequest().getParameter("no");
		// DAO => 결과값 받기
		FreeBoardVO vo = FreeBoardDAO.freeboardDetailData(Integer.parseInt(no), "update");
		// 결과값 => JSP로 전송
		String page = model.getRequest().getParameter("page");
		model.addAttribute("curpage", page);
		
		model.addAttribute("vo", vo);
		model.addAttribute("main_jsp", "../community/freeboard_update.jsp");
		return "../main/main.jsp";
	}

	@RequestMapping("community/freeboard_update_ok.do")
	public String board_update_ok(Model model) {
		try {
			model.getRequest().setCharacterEncoding("UTF-8");
		} catch (Exception ex) {
		}

		String subject = model.getRequest().getParameter("subject");
		String content = model.getRequest().getParameter("content");
		String bcategory = model.getRequest().getParameter("board_category");
		String no = model.getRequest().getParameter("no");
		
		String page = model.getRequest().getParameter("page");
		model.addAttribute("curpage", page);
		
		bcategory = bcategory.substring(0, 1);
		int board_category = Integer.parseInt(bcategory);

		FreeBoardVO vo = new FreeBoardVO();
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setBoard_category(board_category);
		vo.setNo(Integer.parseInt(no));

		// DAO 연결 ==> password
		int n = FreeBoardDAO.freeboardUpdate(vo);

		model.addAttribute("no", n);

		return "../community/freeboard_update_ok.jsp";
	}

	@RequestMapping("community/reply_insert.do")
	public String reply_insert(Model model) {
		// 요청값을 받는다
		try {
			model.getRequest().setCharacterEncoding("UTF-8");
		} catch (Exception ex) {
		}

		String bno = model.getRequest().getParameter("bno");
		String msg = model.getRequest().getParameter("msg");
		
		String page = model.getRequest().getParameter("page");
		model.addAttribute("curpage", page);
		
		HttpSession session = model.getRequest().getSession();
		String id = (String) session.getAttribute("id");

		FreeReplyVO vo = new FreeReplyVO();
		vo.setBno(Integer.parseInt(bno));
		vo.setMsg(msg);
		vo.setId(id);

		// DAO=>데이터 추가

		FreeBoardDAO.replyInsert(vo);
		// 결과값(X)
		return "redirect:../community/freeboard_detail.do?no=" + bno+"&page="+page;
	}

	@RequestMapping("community/reply_reinsert.do")
	public String reply_reinsert(Model model) {
		try {
			model.getRequest().setCharacterEncoding("UTF-8");
		} catch (Exception ex) {
		}

		// msg
		String msg = model.getRequest().getParameter("msg");
		// no
		String pno = model.getRequest().getParameter("no");
		// bno
		String bno = model.getRequest().getParameter("bno");

		HttpSession session = model.getRequest().getSession();
		String id = (String) session.getAttribute("id");

		String page = model.getRequest().getParameter("page");
		model.addAttribute("curpage", page);
		
		FreeReplyVO vo = new FreeReplyVO();
		vo.setBno(Integer.parseInt(bno));

		vo.setMsg(msg);
		vo.setId(id);

		FreeBoardDAO.replyReInsert(Integer.parseInt(pno), vo);
		// group_id , group_step , group_tab

		return "redirect:../community/freeboard_detail.do?no=" + bno+"&page="+page;
	}

	@RequestMapping("community/reply_update.do")
	public String reply_update(Model model) {
		try {
			model.getRequest().setCharacterEncoding("UTF-8");
		} catch (Exception ex) {
		}

		// msg
		String msg = model.getRequest().getParameter("msg");
		// no
		String no = model.getRequest().getParameter("no");
		// bno
		String bno = model.getRequest().getParameter("bno");

		String page = model.getRequest().getParameter("page");
		model.addAttribute("curpage", page);
		
		FreeReplyVO vo = new FreeReplyVO();
		// DAO처리
		vo.setMsg(msg);
		vo.setNo(Integer.parseInt(no));

		FreeBoardDAO.replyUpdate(vo);

		return "redirect:../community/freeboard_detail.do?no=" + bno+"&page="+page;
	}

	@RequestMapping("community/reply_delete.do")
	public String reply_delete(Model model) {
		String no = model.getRequest().getParameter("no");
		// bno
		String bno = model.getRequest().getParameter("bno");
		// DAO
		
		String page = model.getRequest().getParameter("page");
		model.addAttribute("curpage", page);
		
		FreeBoardDAO.replyDelete(Integer.parseInt(no));
		return "redirect:../community/freeboard_detail.do?no=" + bno+"&page="+page;
	}

	@RequestMapping("community/freeboard_delete.do")
	public String board_delete(Model model) {
		String no = model.getRequest().getParameter("no");
		model.addAttribute("no", no);
		model.addAttribute("main_jsp", "../community/freeboard_delete.jsp");
		return "../main/main.jsp";
		// 삭제창으로 이동
	}

	@RequestMapping("community/freeboard_delete_ok.do")
	public String board_delete_ok(Model model) {
		String no = model.getRequest().getParameter("no");
		FreeBoardDAO.freeboardDelete(Integer.parseInt(no));
		return "../community/freeboard_list.do";
	}

	@RequestMapping("community/freeboard_find.do")
	public String board_find(Model model) {

		try {
			model.getRequest().setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String fs = model.getRequest().getParameter("fs");
		String ss = model.getRequest().getParameter("ss");

		Map map = new HashMap();
		map.put("fs", fs);
		map.put("ss", ss);
		List<FreeBoardVO> list = FreeBoardDAO.boardFindData(map);

		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		model.addAttribute("main_jsp", "../community/freeboard_find.jsp");
		return "../main/main.jsp";
	}

}
