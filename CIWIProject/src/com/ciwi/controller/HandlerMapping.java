package com.ciwi.controller;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;
/*
 * �Ľ��� �̹� ������� ����(controller���ϴ°�)
 * ������̼ǵ� ������ ����
 * 
 * FrameWork : Spring, Mybatis => �Ľ̵� XML
 */
public class HandlerMapping extends DefaultHandler{
	// ��Ű���� �������� �Ǳ� ������ ���ʸ��� String
	// ĸ��ȭ.. private�̸� getter�� ������ �ʿ�
	private List<String> packList=new ArrayList<String>();
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		/*
		 * qName : �±��̸�
		 * attributes : �±��� �Ӽ��� �о����
		 */
		try {
			if(qName.equals("context:component-scan")) { // �̸��� Spring�� ���缭 ������.. ���� �� �̸��� ����
				String pack=attributes.getValue("base-package"); // ��Ű������ pack�� ����
				packList.add(pack); // ����Ʈ�� ��Ű���� �߰�
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	// private�̱� ������
	public List<String> getPackList() {
		return packList;
	}
	
}
