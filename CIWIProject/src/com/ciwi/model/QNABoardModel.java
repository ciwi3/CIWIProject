package com.ciwi.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.FreeBoardDAO;
import com.ciwi.dao.QNABoardDAO;
import com.ciwi.vo.FreeBoardVO;
import com.ciwi.vo.QNABoardVO;

@Controller("qNABoardModel")
public class QNABoardModel {

	@RequestMapping("notice/qnaboard.do")
	public String qnaboard_list(Model model){
		
		Map map = new HashMap();
		
		List<QNABoardVO> list =QNABoardDAO.QNABoardListData(map);
		model.addAttribute("list", list);
		
		model.addAttribute("main_jsp", "../notice/qnaboard.jsp");
		return "../main/main.jsp";
		
	}
	
	@RequestMapping("notice/qnaboard_insert.do")
	public String qnaboard_insert(Model model) {

		model.addAttribute("main_jsp", "../notice/qnaboard_insert.jsp");

		return "../main/main.jsp";
	}

	// 게시판 내용 추가
	@RequestMapping("notice/qnaboard_insert_ok.do")
	public String qnaboard_insert_ok(Model model) {

		try {
			model.getRequest().setCharacterEncoding("UTF-8");
		} catch (Exception e) {
		}

		String subject = model.getRequest().getParameter("subject");
		String content = model.getRequest().getParameter("content");
		
		QNABoardVO vo = new QNABoardVO();

		vo.setSubject(subject);
		vo.setContent(content);

		QNABoardDAO.QNABoardInsert(vo);

		return "redirect:../notice/qnaboard_list.do";
	}
	
	
	
	
}
