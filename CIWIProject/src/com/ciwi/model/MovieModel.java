package com.ciwi.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpSession;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.FestivalDAO;
import com.ciwi.dao.JjimDAO;
import com.ciwi.dao.MovieDAO;
import com.ciwi.dao.ReviewDAO;
import com.ciwi.dao.ShowDAO;
import com.ciwi.vo.*;

@Controller("MovieModel")
public class MovieModel {
	@RequestMapping("contents/movie.do")
	public String movie_list(Model model) {

		List<MovieVO> slist = MovieDAO.movieListData();
		List<MovieGenreVO> glist = MovieDAO.getMovieGenreName();
		String page = model.getRequest().getParameter("page");
		if (page == null) {
			page = "1";
		}
		int curPage = Integer.parseInt(page);
		int rowSize = 12;
		int start = (curPage * rowSize) - (rowSize - 1);
		int end = (curPage * rowSize);
		int BLOCK = 5;
		int totalPage = MovieDAO.movieTotalPage(rowSize);
		int startPage = ((curPage - 1) / BLOCK * BLOCK) + 1;
		int endPage = ((curPage - 1) / BLOCK * BLOCK) + BLOCK;
		int allPage = totalPage;
		if (endPage > allPage) {
			endPage = allPage;
		}
		Map map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);

		List<MovieVO> mlist = MovieDAO.moviePageListData(map);
		model.addAttribute("mlist", mlist);
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("allPage", allPage);
		model.addAttribute("BLOCK", BLOCK);

		model.addAttribute("glist", glist);
		model.addAttribute("slist", slist);
		model.addAttribute("main_jsp", "../contents/movie.jsp");
		return "../main/main.jsp";
	}

	@RequestMapping("contents/movie_search.do")
	public String show_Search(Model model) {
		String genre = model.getRequest().getParameter("genre");
		String onScreen = model.getRequest().getParameter("onScreen");
		String searchOption = model.getRequest().getParameter("search");
		String search = model.getRequest().getParameter("mtext");
		Map map = new HashMap<>();
		map.put("movieGenre", genre);
		map.put("isOnScreen", onScreen);
		System.out.println(onScreen);
		map.put("searchOption", searchOption);
		map.put("search", search);

		List<MovieVO> mlist = MovieDAO.movieSearch(map);
		List<MovieGenreVO> glist = MovieDAO.getMovieGenreName();

		model.addAttribute("mlist", mlist);
		model.addAttribute("glist", glist);
		model.addAttribute("count", mlist.size());
		System.out.println(mlist.size());
		model.addAttribute("main_jsp", "../contents/movie_search.jsp");

		return "../main/main.jsp";
	}

	@RequestMapping("contents/movie_detail.do")
	public String movie_detail(Model model) {
		try {
			String no = model.getRequest().getParameter("no");
			MovieVO mvo = MovieDAO.movieDetailData(Integer.parseInt(no));

			int flag = 0;
			HttpSession session = model.getRequest().getSession();
			String id = (String) session.getAttribute("idSe");
			boolean tCheck = false;

			List<JjimVO> list = new ArrayList<JjimVO>();
			Map selectMovieJjimMap = new HashMap();
			selectMovieJjimMap.put("category_no", 2);
			selectMovieJjimMap.put("contents_no", Integer.parseInt(no));
			if (id == null) {
				selectMovieJjimMap.put("id", "-");
			} else {
				selectMovieJjimMap.put("id", id);
			}
			list = JjimDAO.getJjim(selectMovieJjimMap);
			if (list.isEmpty()) {
				flag = 0;
			} else {
				flag = list.get(0).getFlag();
			}

			List<ReviewVO> rlist = ReviewDAO.movieReviewList(mvo);

			String content_no = model.getRequest().getParameter("no");
			String memid = (String) session.getAttribute("id");
			if(memid==null){
				memid="-";
			}
			ReviewVO vo = new ReviewVO();

			vo.setContent_no(Integer.parseInt(content_no));
			vo.setCategory_no(2);
			vo.setMemid(memid);
			ReviewVO resultVo = ReviewDAO.myReviewCheck(vo);

			try {
				if (resultVo.getRating() == 0) {
				}
			} catch (NullPointerException e) {
				tCheck = false;
			}

			if (resultVo.getRtext() != null) {
				tCheck = true;
				model.addAttribute("vo", resultVo);
			}

			model.addAttribute("mvo", mvo);
			model.addAttribute("flag", flag);
			model.addAttribute("rlist", rlist);
			model.addAttribute("tCheck", tCheck);
			model.addAttribute("main_jsp", "../contents/movie_detail.jsp");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return "../main/main.jsp";
	}

	@RequestMapping("contents/movie_jjim_ok.do")
	public String movie_jjim_ok(Model model) {
		String mno = model.getRequest().getParameter("mno"); // 찜 등록,삭제 구분
		HttpSession session = model.getRequest().getSession();
		String id = (String) session.getAttribute("id");
		int flag = 0;
		// 찜 등록
		Map insertJjimMap = new HashMap();
		insertJjimMap.put("mno", mno);
		insertJjimMap.put("id", id);
		JjimDAO.insertJjimMovieData(insertJjimMap);

		// 어떤 사용자가 어떤 카테고리의 어떤 글을 찜했는지 안했는지 알기 위한 jjim목록 가져오기
		List<JjimVO> list = new ArrayList<JjimVO>();
		Map selectMovieJjimMap = new HashMap();
		selectMovieJjimMap.put("category_no", 2);
		selectMovieJjimMap.put("contents_no", mno);
		selectMovieJjimMap.put("id", id);
		list = JjimDAO.getJjim(selectMovieJjimMap); // 카테고리, 글 번호, 아이디, 찜 상태
													// 정보를 가져옴

		flag = list.get(0).getFlag();
		if (list.size() >= 2) {
			Map deleteJjimMap = new HashMap();
			deleteJjimMap.put("category_no", 2);
			deleteJjimMap.put("contents_no", Integer.parseInt(mno));
			deleteJjimMap.put("id", id);
			JjimDAO.deleteJjimMovieData(deleteJjimMap);
			// 데이터가 삭제되면 flag=0으로 설정해줌
			flag = 0;
		}
		return "redirect:../contents/movie_detail.do";
	}

	// 예약 영화 리스트
	@RequestMapping("contents/reserve.do")
	public String movie_reserve_list(Model model) {
		List<MovieVO> mlist = MovieDAO.movieListData();
		// int totalSeat=MovieDAO.totalSeat(1);
		model.addAttribute("mlist", mlist);
		model.addAttribute("main_jsp", "../contents/reserve.jsp");
		return "../main/main.jsp";
	}

	// 상영관
	@RequestMapping("contents/theater.do")
	public String movie_theater(Model model) {
		String theater_no = model.getRequest().getParameter("theater_no");
		List<TheaterVO> tlist = new ArrayList<TheaterVO>();
		StringTokenizer st = new StringTokenizer(theater_no, ", ");
		while (st.hasMoreTokens()) { // 데이터 갯수가 명확하지 않은 경우 hasMoreTokens 사용
			TheaterVO vo = MovieDAO.theaterData(Integer.parseInt(st.nextToken()));
			System.out.println(vo);
			tlist.add(vo);
		}
		model.addAttribute("tlist", tlist);
		model.addAttribute("main_jsp", "../contents/reserve.jsp");
		return "theater.jsp";
	}

	// 달력
	@RequestMapping("contents/date.do")
	public String movie_date(Model model) {
		// 사용자 요청값 받기
		String strYear = model.getRequest().getParameter("year");
		String strMonth = model.getRequest().getParameter("month");

		// 현재 날짜 읽기
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");// 07 08 MM=>1~9
																// => 01,09
		// 자바는 숫자표현식 => 10,8(0),16(0x)
		StringTokenizer st = new StringTokenizer(sdf.format(date), "-");

		String sy = st.nextToken();
		String sm = st.nextToken();
		String day1 = st.nextToken();

		if (strYear == null) {
			strYear = sy;
		}
		if (strMonth == null) {
			strMonth = sm;
		}

		int year = Integer.parseInt(strYear);
		int month = Integer.parseInt(strMonth);
		int day = Integer.parseInt(day1);

		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);

		String[] strWeek = { "일", "월", "화", "수", "목", "금", "토" };
		model.addAttribute("strWeek", strWeek);

		Calendar cal = Calendar.getInstance();
		// cal.set(year,month,1);
		/*
		 * cal.set(Calendar.YEAR, year); cal.set(Calendar.MONTH, month-1);
		 * cal.set(Calendar.DATE, 1);
		 */
		cal.set(year, month - 1, 1);
		// System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		/*
		 * // 요일 구하기 int[] lastday={31,28,31,30,31,30, 31,31,30,31,30,31}; // 1년
		 * 1월 1일 ~ 2018년 12월 31의 총합 int total=(year-1)*365 +(year-1)/4
		 * -(year-1)/100 +(year-1)/400; //2019년 1월 ~ 7월의 총합 if((year%4==0 &&
		 * year%100!=0)||(year%400==0)) lastday[1]=29; else lastday[1]=28;
		 * 
		 * for(int i=0;i<month-1;i++) { total+=lastday[i]; }
		 * 
		 * total++;
		 * 
		 * // 요일구하기 int week=total%7;
		 */

		int week = cal.get(Calendar.DAY_OF_WEEK);
		week = week - 1;
		int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// System.out.println("Calendar.DATE=" +
		// cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		// System.out.println(lastday);
		model.addAttribute("week", week);
		model.addAttribute("lastday", lastday);

		String date_no = model.getRequest().getParameter("date_no"); // date no
																		// =>
																		// 난수로
																		// 저장됨,
																		// 1~31중
																		// 몇개
		int[] reday = new int[30];
		StringTokenizer st1 = new StringTokenizer(date_no, ", "); // 난수를 ", "로
																	// 잘라냄
		while (st1.hasMoreTokens()) {
			int k = Integer.parseInt(st1.nextToken());
			reday[k - 1] = k; // 첨자 하나가 작아야됨
		}
		List<Integer> rList = new ArrayList<Integer>();
		for (int k : reday) {
			if (k < day) // 오늘 이후것만 출력
				k = 0;
			rList.add(k);
		}
		model.addAttribute("rList", rList);
		model.addAttribute("main_jsp", "../contents/reserve.jsp");
		return "date.jsp";
	}

	@RequestMapping("contents/time.do")
	public String movie_time(Model model) {
		String day = model.getRequest().getParameter("day");
		String timeno = MovieDAO.reserveGetTime(Integer.parseInt(day));
		List<String> list = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(timeno, ", ");
		while (st.hasMoreTokens()) { // 각 갯수가 틀리기 때문에 hasMoreTokens()
			list.add(MovieDAO.timeData(Integer.parseInt(st.nextToken())));
		}
		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "../contents/reserve.jsp");
		return "time.jsp";
	}

	@RequestMapping("contents/inwon.do")
	public String movie_inwon(Model model) {
		model.addAttribute("main_jsp", "../contents/reserve.jsp");
		return "inwon.jsp";
	}

	@RequestMapping("contents/movie_review_insert.do")
	public String movie_rating(Model model) {
		try {
			model.getRequest().setCharacterEncoding("UTF-8");
		} catch (Exception ex) {
		}

		String rating = model.getRequest().getParameter("rating");
		String content_no = model.getRequest().getParameter("no");
		HttpSession session = model.getRequest().getSession();
		String memid = (String) session.getAttribute("id");
		int memno = (Integer) session.getAttribute("memno");
		String rtext = model.getRequest().getParameter("rtext");

		ReviewVO vo = new ReviewVO();

		vo.setRating(Double.parseDouble(rating));
		vo.setContent_no(Integer.parseInt(content_no));
		vo.setMemid(memid);
		vo.setMemno(memno);
		vo.setCategory_no(2);
		vo.setRtext(rtext);

		String rCheck = ReviewDAO.ratingCheck(vo);

		if (rCheck != null) {
			ReviewDAO.reviewModified(vo, memid);
		} else if (rCheck == null) {
			if (rtext == null) {
				ReviewDAO.ratingInsert(vo);
			} else {
				ReviewDAO.reviewInsert(vo);
			}
		}
		MovieVO mvo = MovieDAO.movieDetailData(Integer.parseInt(content_no));
		List<ReviewVO> rlist = ReviewDAO.movieReviewList(mvo);
		model.addAttribute("rlist", rlist);
		return "../contents/review_ok.jsp";
	}

	@RequestMapping("contents/movie_delete.do")
	public String reviewDelete(Model model) {
		String rno = model.getRequest().getParameter("rno");
		HttpSession session = model.getRequest().getSession();
		String memid = (String) session.getAttribute("id");

		ReviewVO vo = new ReviewVO();

		vo.setRno(Integer.parseInt(rno));
		vo.setMemid(memid);

		ReviewDAO.reviewDelete(vo, memid);
		return "../main/main.jsp";
	}

	@RequestMapping("contents/insert.do")
	public String reserveMovie(Model model) {
		try {
			model.getRequest().setCharacterEncoding("UTF-8");
		} catch (Exception e) {
		}
		HttpSession session = model.getRequest().getSession();
		String id = (String) session.getAttribute("id");
		String title = model.getRequest().getParameter("title");
		String tname = model.getRequest().getParameter("tname");
		String rdate = model.getRequest().getParameter("rdate");
		String rtime = model.getRequest().getParameter("rtime");
		String inwon = model.getRequest().getParameter("inwon");
		String price = model.getRequest().getParameter("price");

		ReserveInfoVO vo = new ReserveInfoVO();
		vo.setR_id(id);
		vo.setR_title(title);
		vo.setR_tname(tname);
		vo.setR_rdate(rdate);
		vo.setR_rtime(rtime);
		vo.setR_inwon(inwon);
		vo.setR_price(price);
		MovieDAO.reserveMovie(vo);

		model.addAttribute("main_jsp", "redirect../mypage/reservepage.do");
		return "../main/main.jsp";
	}
}
