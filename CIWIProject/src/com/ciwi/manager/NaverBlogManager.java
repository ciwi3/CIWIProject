package com.ciwi.manager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class NaverBlogManager {
	public List<String> blogGetData(String data) {
		String result = "";
		String clientId = "h9wMhkL4qrYD8OgT3xZk";// ���ø����̼� Ŭ���̾�Ʈ ���̵�";
		String clientSecret = "ONcND0Gp40";// ���ø����̼� Ŭ���̾�Ʈ ��ũ����";
		String desc = "";
		List<String> rList = new ArrayList<>();
		try {
			String text = URLEncoder.encode(data, "UTF-8");
			String apiURL = "https://openapi.naver.com/v1/search/blog?display=100&query=" + text; // json
			// ���
			// String apiURL =
			// "https://openapi.naver.com/v1/search/blog.xml?query="+ text; //
			// xml ���
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // ���� ȣ��
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			} else { // ���� �߻�
				br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "UTF-8"));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			result = response.toString();
		} catch (Exception e) {
			System.out.println(e);
		}
		String json = result;
		try {
			JSONParser jp = new JSONParser();
			JSONObject obj = (JSONObject) jp.parse(json); // JSONObject�� Array
															// ���� ���� ���� �� �����Ƿ�
															// ����ȯ�ؾ���
			// System.out.println(obj.toJSONString());
			JSONArray arr = (JSONArray) obj.get("items");
			// System.out.println(arr.toJSONString());
			for (int i = 0; i < arr.size(); i++) {
				JSONObject js = (JSONObject) arr.get(i);
				desc = (String) js.get("description");
				desc = desc.replace("<", "");
				desc = desc.replace(">", "");
				desc = desc.replace("/", "");
				desc = desc.replaceAll("[A-Za-z]", "");
				desc = desc.replace("&", "");
				desc = desc.replace("#", "");
				desc = desc.replace(";", "");
				rList.add(desc);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rList;

	}

}