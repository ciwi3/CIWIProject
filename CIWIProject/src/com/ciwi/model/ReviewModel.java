package com.ciwi.model;
import java.util.*;

import javax.print.attribute.HashAttributeSet;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.ReviewDAO;
import com.ciwi.vo.ReviewVO;
@Controller("reviewModel")
public class ReviewModel {
	@RequestMapping("contents/show_detail.do")
	public String reviewListPage(Model model){
		String page=model.getRequest().getParameter("total");
		if(page==null){
			page="1";
		}
		int curpage=Integer.parseInt(page);
		
		Map map=new HashMap();
		int rowSize=9;
		int start=(curpage*rowSize)-(rowSize-1);
		int end=curpage*rowSize;
		
		map.put("start",start);
		map.put("end", end);
		
		List<ReviewVO> list=ReviewDAO.reviewAllList();
		
		return "../main/main.jsp";
	}
}
