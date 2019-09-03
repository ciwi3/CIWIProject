package com.ciwi.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
import com.ciwi.dao.MovieDAO;
import com.ciwi.vo.*;

@Controller("MovieModel")
public class MovieModel {
	// ���� ��ȭ ����Ʈ
	@RequestMapping("contents/reserve.do")
	public String movie_reserve_list(Model model) {
		List<MovieVO> mlist = MovieDAO.movieListData();
		model.addAttribute("mlist", mlist);
		model.addAttribute("main_jsp", "../contents/reserve.jsp");
		return "../main/main.jsp";
	}
	// �󿵰�
	@RequestMapping("contents/theater.do")
	public String movie_theater(Model model) {
		String theater_no=model.getRequest().getParameter("theater_no");
		List<TheaterVO> tlist=new ArrayList<TheaterVO>();
		StringTokenizer st = new StringTokenizer(theater_no, ", ");
		while (st.hasMoreTokens()) { // ������ ������ ��Ȯ���� ���� ��� hasMoreTokens ���
			TheaterVO vo = MovieDAO.theaterData(Integer.parseInt(st.nextToken()));
			tlist.add(vo);
		}
		model.addAttribute("tlist", tlist);
		model.addAttribute("main_jsp", "../contents/reserve.jsp");
		return "theater.jsp";
	}
	// �޷�
	@RequestMapping("contents/date.do")
	public String movie_date(Model model) {
		// ����� ��û�� �ޱ�
		String strYear = model.getRequest().getParameter("year");
		String strMonth = model.getRequest().getParameter("month");

		// ���� ��¥ �б�
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");// 07 08 MM=>1~9
																// => 01,09
		// �ڹٴ� ����ǥ���� => 10,8(0),16(0x)
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

		String[] strWeek = { "��", "��", "ȭ", "��", "��", "��", "��" };
		model.addAttribute("strWeek", strWeek);

		Calendar cal = Calendar.getInstance();
		// cal.set(year,month,1);
		/*
		 * cal.set(Calendar.YEAR, year); cal.set(Calendar.MONTH, month-1);
		 * cal.set(Calendar.DATE, 1);
		 */
		cal.set(year, month - 1, 1);
		//System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		/*
		 * // ���� ���ϱ� int[] lastday={31,28,31,30,31,30, 31,31,30,31,30,31}; // 1��
		 * 1�� 1�� ~ 2018�� 12�� 31�� ���� int total=(year-1)*365 +(year-1)/4
		 * -(year-1)/100 +(year-1)/400; //2019�� 1�� ~ 7���� ���� if((year%4==0 &&
		 * year%100!=0)||(year%400==0)) lastday[1]=29; else lastday[1]=28;
		 * 
		 * for(int i=0;i<month-1;i++) { total+=lastday[i]; }
		 * 
		 * total++;
		 * 
		 * // ���ϱ��ϱ� int week=total%7;
		 */

		int week = cal.get(Calendar.DAY_OF_WEEK);
		week = week - 1;
		int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		//System.out.println("Calendar.DATE=" + cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		//System.out.println(lastday);
		model.addAttribute("week", week);
		model.addAttribute("lastday", lastday);
		
		String date_no = model.getRequest().getParameter("date_no"); // date no => ������ �����, 1~31�� �
		int[] reday=new int[30];
		StringTokenizer st1=new StringTokenizer(date_no,", "); // ������ ", "�� �߶�
		while(st1.hasMoreTokens()) {
			int k=Integer.parseInt(st1.nextToken());
			reday[k-1]=k; // ÷�� �ϳ��� �۾ƾߵ�
		}
		List<Integer> rList=new ArrayList<Integer>();
		for(int k:reday) {
			if(k<day) // ���� ���İ͸� ���
				k=0;
			rList.add(k);
		}
		model.addAttribute("rList", rList);
		model.addAttribute("main_jsp", "../contents/reserve.jsp");
		return "date.jsp";
	}
	@RequestMapping("contents/time.do")
	public String movie_time(Model model) {
		String day=model.getRequest().getParameter("day");
		String timeno=MovieDAO.reserveGetTime(Integer.parseInt(day));
		List<String> list=new ArrayList<String>();
		StringTokenizer st=new StringTokenizer(timeno,", ");
		while(st.hasMoreTokens()) { // �� ������ Ʋ���� ������ hasMoreTokens()
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
}
