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
    // web.xml => XML�� ��θ� �б� ==> HandlerMapping�� ���� (SAX) ==> ��ϵ� Ŭ���� ��Ƶд� 
	//                                                          ========= Model
	// XML�� ��� ��Ű���� => Ŭ������ ��Ƶд� 
	// ����
	private List<String> list=new ArrayList<String>();
	public void init(ServletConfig config) throws ServletException {
		String path=config.getInitParameter("xmlPath");
		// <init-param> => config (web.xml�� �б�)
		// System.out.println(path);
		// ��Ű�� �б�
		try
		{
			SAXParserFactory spf=SAXParserFactory.newInstance();
			// �ļ��� ������
			SAXParser sp=spf.newSAXParser(); // �ļ��� (XML�� �����͸� �б�)
			
			// �ļ� ������ ���� 
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
                    ����� ��û ó��
          1. ����� ��û�� �޴´�   board/list.do  ==> URI
          2. ó���� �޼ҵ带 ã�´�  ==> ������̼�  @RequestMapping("board/list.do")
             *** Annotation�� �׻� ���� �ִ� 
          3. Model(Request)�� ���� �Ѵ� ==> �ش� �޼ҵ�� ���� (����� Request�� �߰�)
             ===== Request,Response
          4. ViewResolver ==> ȭ�鿡 ����� JSP�� ã�´� 
          5. JSP�� Model(Request)�� �����Ѵ� 
          6. JSP���� ȭ�� ��� 
          
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
			// Ŭ���� ã�� 
			for(String cls:list)
			{
				Class clsName=Class.forName(cls);// Ŭ���� ����
				
				// @Controller ���� ���� (true:����,false:���� ���� =>isAnnotationPresent)
				if(clsName.isAnnotationPresent(Controller.class)==false)
				{
					continue;
				}
				//System.out.println(obj);
				// �޸� �Ҵ� 
				Object obj=clsName.newInstance();
				// �޼ҵ� ã�� 
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
				        	// ȭ�� �̵� 
				        }
				        else
				        {
				        	// ȭ�� ��� 
				        	RequestDispatcher rd=request.getRequestDispatcher(jsp);
				        	rd.forward(request, response);
				        }
				        
				        return;// �޼ҵ� 
					}
				}
			}
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}








