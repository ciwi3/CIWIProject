package com.ciwi.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.QNABoardDAO;
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
	
	
	
	
	
}
