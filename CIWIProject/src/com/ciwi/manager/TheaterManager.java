package com.ciwi.manager;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import com.ciwi.vo.*;

public class TheaterManager {
	public static void main(String[] args) {
		TheaterManager tm=new TheaterManager();
		
		JSONParser parser=new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("c:\\mvcDev\\CGVTheater.json"));
			JSONObject jsonObject = (JSONObject)obj;
			JSONArray arr=(JSONArray)jsonObject.get("AreaTheaterDetailList");
			for(int i=0;i<arr.size();i++) {
				JSONObject inObj=(JSONObject)arr.get(i);
				String theaterName=(String)inObj.get("TheaterName");
				System.out.println(theaterName);
				
				TheaterVO vo=new TheaterVO();
				vo.setTheater_no(i+1);
				vo.setTheater_name(theaterName);
				vo.setTheater_total_seat(200);
				vo.setTheater_loc("-");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
