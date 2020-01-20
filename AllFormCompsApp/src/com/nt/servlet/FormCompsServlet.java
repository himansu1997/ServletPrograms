package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormCompsServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String url=null,name=null,ms=null,gen=null,color=null,hb[]=null,crs[]=null,dob=null,qlfy=null,email=null,addrs=null;
		int age=0;
		long mobileNo=0;
		//get PrintWriter
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read form data
		name=req.getParameter("pname");
		age=Integer.parseInt(req.getParameter("page"));
		addrs=req.getParameter("addrs");
		gen=req.getParameter("gen");
		dob=req.getParameter("dob");
		ms=req.getParameter("ms");
		if(ms==null)
			ms="single";
		crs=req.getParameterValues("courses");
		if(crs==null)
			crs=new String[] {"not intrested to study"};
		color=req.getParameter("color");
		qlfy=req.getParameter("qlfy");
		hb=req.getParameterValues("hb");
		if(hb==null)
			hb=new String[] {"no hobies"};
		email=req.getParameter("email");
		mobileNo=Long.parseLong(req.getParameter("phone"));
		url=req.getParameter("url");
		//write b.logic
		if(gen.equalsIgnoreCase("M")) {
			if(age<5)
				pw.println("<h1 style='color:pink'>Master."+name+"  u  r  baby boy");
			else if(age<13)
				pw.println("<h1 style='color:orange'>Master."+name+"  u  r  small boy");
			else if(age<20)
				pw.println("<h1 style='color:grey'>Mr."+name+"  u  r teenage boy");
			else if(age<36)
				pw.println("<h1 style='color:red'>Mr."+name+"  u  r young man");
			else if(age<50)
				pw.println("<h1 style='color:maroon'>Mr."+name+"  u  r middle-aged man");
			else 
				pw.println("<h1 style='color:black'>Mr."+name+"  u  r Budda man");
		}
		else {
			if(age<5)
				pw.println("<h1 style='color:pink'>Master."+name+"  u  r  baby girl");
			else if(age<13)
				pw.println("<h1 style='color:orange'>Master."+name+"  u  r  little girl");
			else if(age<20) {
				if(ms.equalsIgnoreCase("married"))
				       pw.println("<h1 style='color:grey'>Mrs."+name+"  u  r teenage and married girl");
				else
					   pw.println("<h1 style='color:grey'>Miss."+name+"  u  r teenage  girl");
			}
			else if(age<36) {
				
				if(ms.equalsIgnoreCase("married"))
				       pw.println("<h1 style='color:grey'>Mrs."+name+"  u  r  young and married woman");
				else
					   pw.println("<h1 style='color:grey'>Miss."+name+"  u  r young woman");
			}
			
			else if(age<50) {
				if(ms.equalsIgnoreCase("married"))
				       pw.println("<h1 style='color:grey'>Mrs."+name+"  u  r  married and middle-aged woman");
				else
					   pw.println("<h1 style='color:grey'>Miss."+name+"  u  r middle-aged woman");
			}
			else{ 
				if(ms.equalsIgnoreCase("married"))
				       pw.println("<h1 style='color:grey'>Mrs."+name+"  u  r  married and old woman");
				else
					   pw.println("<h1 style='color:grey'>Miss."+name+"  u  r old woman");
     			}
		}//else
			//display form data
			pw.println("<h2 style='color:red;text-align:center'> The recieved Form data is </h1>");
			pw.println("<br> name::"+name);
			pw.println("<br> age::"+age);
			pw.println("<br> gender::"+gen);
			pw.println("<br> Marital Status::"+ms);
			pw.println("<br> Address::"+addrs);
			pw.println("<br> phone::"+mobileNo);
			pw.println("<br> email::"+email);
			pw.println("<br> DOB::"+dob);
			pw.println("<br> color::"+color);
			pw.println("<br> Qualification::"+qlfy);
			pw.println("<br> Courses::"+Arrays.toString(crs));
			pw.println("<br> hobies::"+Arrays.toString(hb));
			pw.println("<br> URL::"+url);
			
			//add hyperlink
			pw.println("<br><br> <a href='register.html'>home</a>");
			
			//close stream
			pw.close();
			}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	     doGet(req,res);
	}//doPost(-,-)
}//class
