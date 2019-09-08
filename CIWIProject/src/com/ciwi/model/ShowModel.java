package com.ciwi.model;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.JjimDAO;
import com.ciwi.dao.ShowDAO;
import com.ciwi.vo.AreaVO;
import com.ciwi.vo.JjimVO;
import com.ciwi.vo.ShowGenreVO;
import com.ciwi.vo.ShowVO;
import java.util.*;

import javax.servlet.http.HttpSession;

@Controller("showModel")
public class ShowModel {

	@RequestMapping("contents/show.do")
	public String show_list(Model model) {
		List<ShowVO> slist = ShowDAO.showAllData();
		List<AreaVO> alist = ShowDAO.getAreaName();
		List<ShowGenreVO> glist = ShowDAO.getGenreName();
		model.addAttribute("alist", alist);
		model.addAttribute("glist", glist);
		model.addAttribute("slist", slist);
		model.addAttribute("main_jsp", "../contents/show.jsp");
		return "../main/main.jsp";
	}

	@RequestMapping("contents/show_detail.do")
	public String show_detail(Model model) {
		String no = model.getRequest().getParameter("no");
		ShowVO svo = ShowDAO.showDetailData(Integer.parseInt(no));
		model.addAttribute("svo", svo);
		model.addAttribute("main_jsp", "../contents/show_detail.jsp");

		return "../main/main.jsp";
	}

	@RequestMapping("contents/show_search.do")
	public String show_Search(Model model) {
		/* String[] checks = model.getRequest().getParameterValues("Checks"); */
		String genre = model.getRequest().getParameter("genre");
		String area = model.getRequest().getParameter("area");
		String searchOption = model.getRequest().getParameter("search");
		String text = model.getRequest().getParameter("stext");
		System.out.println(area);
		Map map = new HashMap<>();
		map.put("show_genre", genre);
		map.put("area", area);
		map.put("searchOption", searchOption);
		map.put("search", text);

		List<ShowVO> slist = ShowDAO.showSearch(map);
		List<AreaVO> alist = ShowDAO.getAreaName();
		List<ShowGenreVO> glist = ShowDAO.getGenreName();

		model.addAttribute("slist", slist);
		model.addAttribute("alist", alist);
		model.addAttribute("glist", glist);
		model.addAttribute("count", slist.size());
		System.out.println(slist.size());
		model.getRequest().getAttribute("count");
		model.addAttribute("main_jsp", "../contents/show_search.jsp");

		return "../main/main.jsp";
	}
	
	@RequestMapping("contents/show_jjim_ok.do")
	public String show_jjim_ok(Model model) {
		String sno=model.getRequest().getParameter("sno"); // 찜 등록,삭제 구분
		HttpSession session=model.getRequest().getSession();
		String id=(String)session.getAttribute("id");
		
		// 찜 등록
		Map insertJjimMap=new HashMap();
		insertJjimMap.put("sno", sno);
		insertJjimMap.put("id", id);
		JjimDAO.insertJjimShowData(insertJjimMap);
		
		// 어떤 사용자가 어떤 카테고리의 어떤 글을 찜했는지 안했는지 알기 위한 jjim목록 가져오기
		List<JjimVO> list=new ArrayList<JjimVO>();
		Map selectShowJjimMap=new HashMap();
		selectShowJjimMap.put("category_no", 4);
		selectShowJjimMap.put("contents_no", sno);
		selectShowJjimMap.put("id", id);
		list=JjimDAO.getJjim(selectShowJjimMap); // 카테고리, 글 번호, 아이디, 찜 상태 정보를 가져옴
		
		if(list.size()>=2) {
			Map deleteJjimMap=new HashMap();
			deleteJjimMap.put("category_no", 4);
			deleteJjimMap.put("contents_no", sno);
			deleteJjimMap.put("id", id);
			JjimDAO.deleteJjimShowData(deleteJjimMap);
		}
		
		/*try {
			int flag=list.get(1).getFlag();
			// flag가 1이면 찜 삭제, 아니면 빠져나감
			
			model.addAttribute("flag", flag);
		} catch (Exception e) {}*/
		
		// model.addAttribute("flag", list.get(0).getFlag());
		return "../contents/show_detail.jsp";
	}
}
