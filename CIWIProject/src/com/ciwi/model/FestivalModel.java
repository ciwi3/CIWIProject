package com.ciwi.model;

import java.util.*;

import javax.servlet.http.HttpSession;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.*;
import com.ciwi.vo.FestivalVO;
import com.ciwi.vo.JjimVO;
import com.ciwi.vo.ReviewVO;

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

		List<FestivalVO> flist = FestivalDAO.festivalPageListData(map);
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
	public String festival_detail(Model model){
		try {
			String fno = model.getRequest().getParameter("fno");
			HttpSession session = model.getRequest().getSession();
			String id = (String)session.getAttribute("id");
			int flag=0;
			FestivalVO fvo = FestivalDAO.festivalDetail(Integer.parseInt(fno));
			
			List<JjimVO> list = new ArrayList<JjimVO>();
			Map selectFestivalJjimMap = new HashMap();
			selectFestivalJjimMap.put("category_no", 1);
			selectFestivalJjimMap.put("contents_no", Integer.parseInt(fno));
			selectFestivalJjimMap.put("id", id);
			list = JjimDAO.getJjim(selectFestivalJjimMap);
			if(list.isEmpty()) {
				flag=0;
			} else {
				flag = list.get(0).getFlag();
			}
			
			List<ReviewVO> rlist = ReviewDAO.FestivalReviewList(fvo);
			model.addAttribute("fvo", fvo);
			model.addAttribute("flag", flag);
			model.addAttribute("rlist", rlist);
			model.addAttribute("main_jsp", "../contents/festival_detail.jsp");
		} catch(Exception e){}
		
		return "../main/main.jsp";
	}
	@RequestMapping("contents/festival_jjim_ok.do")
	public String festival_jjim_ok(Model model) {
		String fno = model.getRequest().getParameter("fno"); // 찜 등록,삭제 구분
		HttpSession session = model.getRequest().getSession();
		String id = (String) session.getAttribute("id");
		int flag = 0;
		// 찜 등록
		Map insertJjimMap = new HashMap();
		insertJjimMap.put("fno", fno);
		insertJjimMap.put("id", id);
		JjimDAO.insertJjimFestivalData(insertJjimMap);

		// 어떤 사용자가 어떤 카테고리의 어떤 글을 찜했는지 안했는지 알기 위한 jjim목록 가져오기
		List<JjimVO> list = new ArrayList<JjimVO>();
		Map selectFestivalJjimMap = new HashMap();
		selectFestivalJjimMap.put("category_no", 1);
		selectFestivalJjimMap.put("contents_no", Integer.parseInt(fno));
		selectFestivalJjimMap.put("id", id);
		list = JjimDAO.getJjim(selectFestivalJjimMap); // 카테고리, 글 번호, 아이디, 찜 상태
														// 정보를 가져옴

		flag = list.get(0).getFlag();
		if (list.size() >= 2) {
			Map deleteJjimMap = new HashMap();
			deleteJjimMap.put("category_no", 1);
			deleteJjimMap.put("contents_no", Integer.parseInt(fno));
			deleteJjimMap.put("id", id);
			JjimDAO.deleteJjimFestivalData(deleteJjimMap);
			// 데이터가 삭제되면 flag=0으로 설정해줌
			flag = 0;
		}
		return "redirect:../contents/festival_detail.do";
	}
	
	@RequestMapping("contents/fesitval_review_insert.do")
	public String Festival_rating(Model model) {
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

		model.addAttribute("main_jsp", "../contents/festival_datail.jsp");

		return "../main/main.jsp";
	}

	@RequestMapping("contents/festival_delete.do")
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
