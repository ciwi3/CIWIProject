package com.ciwi.manager;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import com.ciwi.dao.MovieDAO;
import com.ciwi.vo.*;

public class CGVTheaterManager {
	public static void main(String[] args) {
		CGVTheaterManager tm=new CGVTheaterManager();
		
		int k=1;
		JSONParser parser=new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("c:\\mvcDev\\CGVTheater.json"));
			JSONObject jsonObject = (JSONObject)obj;
			JSONArray arr=(JSONArray)jsonObject.get("AreaTheaterDetailList");
			for(int i=0;i<arr.size();i++) {
				JSONObject inObj=(JSONObject)arr.get(i);
				String theaterName=(String)inObj.get("TheaterName");
				String theaterLoc=theaterName.substring(3);
				System.out.println(k+"번 째 데이터");
				k++;
				TheaterVO vo=new TheaterVO();
				vo.setTheater_no(i+1);
				vo.setTheater_name(theaterName);
				vo.setTheater_total_seat(200);
				vo.setTheater_loc(theaterLoc);
				System.out.println(vo.getTheater_name());
				System.out.println(vo.getTheater_total_seat());
				System.out.println(vo.getTheater_loc());
				System.out.println("=========================");
				MovieDAO.theaterDataInsert(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		tm.totalSeat();
	}
	
	public static void totalSeat() {
		int severalTotalSeat=0;
		
		for(int i=1; i<=167; i++) {
			severalTotalSeat= (int)((Math.random()*11)+40);
			System.out.println(i+"번 째 상영관");
			System.out.println(severalTotalSeat);
			System.out.println("---------");
			
			TheaterVO vo=new TheaterVO();
			vo.setTheater_no(i);
			vo.setTheater_total_seat(severalTotalSeat);
			MovieDAO.totalSeatUpdate(vo);
		}
		System.out.println("저장 완료");
	}
}
