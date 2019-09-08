package com.ciwi.model;

import java.util.*;

import javax.servlet.http.HttpSession;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.*;
import com.ciwi.dao.JjimDAO;
import com.ciwi.vo.FestivalVO;
import com.ciwi.vo.JjimVO;

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
	@RequestMapping("contents/festival_jjim_ok.do")
	public String festival_jjim_ok(Model model) {
		String fno=model.getRequest().getParameter("fno"); // 찜 등록,삭제 구분
		HttpSession session=model.getRequest().getSession();
		String id=(String)session.getAttribute("id");
		
		// 찜 등록
		Map insertJjimMap=new HashMap();
		insertJjimMap.put("fno", fno);
		insertJjimMap.put("id", id);
		System.out.println("여기로오지 계속?");
		JjimDAO.insertJjimFestivalData(insertJjimMap);
		
		// 어떤 사용자가 어떤 카테고리의 어떤 글을 찜했는지 안했는지 알기 위한 jjim목록 가져오기
		List<JjimVO> list=new ArrayList<JjimVO>();
		Map selectFestivalJjimMap=new HashMap();
		selectFestivalJjimMap.put("category_no", 1);
		selectFestivalJjimMap.put("contents_no", fno);
		selectFestivalJjimMap.put("id", id);
		list=JjimDAO.getJjim(selectFestivalJjimMap); // 카테고리, 글 번호, 아이디, 찜 상태 정보를 가져옴
		if(list.size()==2) {
			Map deleteJjimMap=new HashMap();
			deleteJjimMap.put("category_no", 1);
			deleteJjimMap.put("contents_no", fno);
			deleteJjimMap.put("id", id);
			JjimDAO.deleteJjimFestivalData(deleteJjimMap);
		}
		
		/*try {
			int flag=list.get(1).getFlag();
			// flag가 1이면 찜 삭제, 아니면 빠져나감
			
			model.addAttribute("flag", flag);
		} catch (Exception e) {}*/
		
		model.addAttribute("flag", list.get(0).getFlag());
		return "../contents/festival_detail.jsp";
	}
}







