package com.ciwi.controller;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;
/*
 * 파싱은 이미 만들어진 상태(controller말하는거)
 * 어노테이션도 만들지 않음
 * 
 * FrameWork : Spring, Mybatis => 파싱된 XML
 */
public class HandlerMapping extends DefaultHandler{
	// 패키지명만 가져오면 되기 때문에 제너릭은 String
	// 캡슐화.. private이면 getter가 무조건 필요
	private List<String> packList=new ArrayList<String>();
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		/*
		 * qName : 태그이름
		 * attributes : 태그의 속성값 읽어오기
		 */
		try {
			if(qName.equals("context:component-scan")) { // 이름은 Spring과 맞춰서 연습겸.. 원래 이 이름이 맞음
				String pack=attributes.getValue("base-package"); // 패키지명을 pack에 저장
				packList.add(pack); // 리스트에 패키지명 추가
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	// private이기 때문에
	public List<String> getPackList() {
		return packList;
	}
	
}
