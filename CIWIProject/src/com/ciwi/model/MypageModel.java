package com.ciwi.model;

import com.ciwi.controller.Controller;
import com.ciwi.controller.Model;
import com.ciwi.controller.RequestMapping;
@Controller("MypageModel")
public class MypageModel {
	//����������
	@RequestMapping("mypage/mypage.do")
	public String mypage(Model model){
		model.addAttribute("main_jsp", "../mypage/mypage.jsp");
		return "../main/main.jsp";
	}
	
	//���� ȸ������ ���
	@RequestMapping("mypage/myinformation.do")
	public String myinformation(Model model){
		//DB���� ���̵� �̸� �޴�����ȣ �� ����ĳ�� ���� �����ֱ�
		
		model.addAttribute("main_jsp", "../mypage/myinformation");
		return "../main/main.jsp";
	}
	//�� ���� ȭ�� ���
	
	// �� ���� ����ȭ�� ���
	
	//�����Ϸ� ȭ�����
	
	
}
