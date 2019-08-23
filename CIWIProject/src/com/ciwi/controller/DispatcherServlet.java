package com.ciwi.controller;

import java.io.*;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.util.*;
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // web.xml => XML의 경로명 읽기 ==> HandlerMapping에 전송 (SAX) ==> 등록된 클래스 모아둔다 
	//                                                          ========= Model
	// XML에 등록 패키지의 => 클래스를 모아둔다 
	// ㅎㅇ
	private List<String> list=new ArrayList<String>();
	public void init(ServletConfig config) throws ServletException {
		String path=config.getInitParameter("xmlPath");
		// <init-param> => config (web.xml을 읽기)
		// System.out.println(path);
		// 패키지 읽기
		try
		{
			SAXParserFactory spf=SAXParserFactory.newInstance();
			// 파서기 생성기
			SAXParser sp=spf.newSAXParser(); // 파서기 (XML의 데이터를 읽기)
			
			// 파서 형식을 지정 
			HandlerMapping hm=new HandlerMapping();
			sp.parse(new File(path), hm);
			
			List<String> packList=hm.getPackList();
			
			for(String pack:packList)
			{
				List<String> clsList=ComponentScan.componentFileData(pack);
				for(String cls:clsList)
				{
					list.add(cls);
				}
			}
		}catch(Exception ex){}
		
	}
    /*
                    사용자 요청 처리
          1. 사용자 요청을 받는다   board/list.do  ==> URI
          2. 처리한 메소드를 찾는다  ==> 어노테이션  @RequestMapping("board/list.do")
             *** Annotation은 항상 위에 있다 
          3. Model(Request)을 전송 한다 ==> 해당 메소드로 전송 (결과를 Request에 추가)
             ===== Request,Response
          4. ViewResolver ==> 화면에 출력할 JSP를 찾는다 
          5. JSP에 Model(Request)를 전송한다 
          6. JSP에서 화면 출력 
          
          for()
          {
             for()
             {
                //break;
                //return
             }
          }
     */
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			String cmd=request.getRequestURI();
			// /JSPMVCLastProject/main/main.do  ===> URI
			// ================== ContextPath
			cmd=cmd.substring(request.getContextPath().length()+1);
			// MVVM 
			// 클래스 찾기 
			for(String cls:list)
			{
				Class clsName=Class.forName(cls);// 클래스 정보
				
				// @Controller 존재 여부 (true:존재,false:없는 상태 =>isAnnotationPresent)
				if(clsName.isAnnotationPresent(Controller.class)==false)
				{
					continue;
				}
				//System.out.println(obj);
				// 메모리 할당 
				Object obj=clsName.newInstance();
				// 메소드 찾기 
				Method[] methods=clsName.getDeclaredMethods();
				for(Method m:methods)
				{
					RequestMapping rm=m.getAnnotation(RequestMapping.class);
					if(cmd.equals(rm.value()))
					{
						Model model=new Model(request, response);
						String jsp=(String)m.invoke(obj, model);
						// MainModel m=new MainModel(); => m.main_page()
						// redirect:list.do
				        if(jsp.startsWith("redirect"))
				        {
				        	response.sendRedirect(jsp.substring(jsp.indexOf(":")+1));
				        	// 화면 이동 
				        }
				        else
				        {
				        	// 화면 출력 
				        	RequestDispatcher rd=request.getRequestDispatcher(jsp);
				        	rd.forward(request, response);
				        }
				        
				        return;// 메소드 
					}
				}
			}
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}








