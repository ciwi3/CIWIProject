package com.ciwi.controller;
import java.io.*;
import java.util.*;
public class ComponentScan {
   public static List<String> componentFileData(String pack)
   {
	   List<String> list=new ArrayList<String>();
	   try
	   {
		   String path="C:\\CIWIProject\\CIWIProject\\CIWIProject\\src";
		   path=path+"\\"+pack.replace(".", "\\");
		   
		   File dir=new File(path);
		   // File : file,directory Á¤º¸ 
		   File[] flist=dir.listFiles();
		   for(File f:flist)
		   {
			   //System.out.println(f.getName());
			   String fname=f.getName();
			   String ext=fname.substring(fname.lastIndexOf(".")+1);
			   if(ext.equals("java"))
			   {
				   String clsName=pack+"."+fname.substring(0,fname.lastIndexOf("."));
				   // System.out.println(clsName); com.sist.model.MainModel
				   list.add(clsName);
			   }
		   }
	   }catch(Exception ex){}
	   return list;
   }
}








