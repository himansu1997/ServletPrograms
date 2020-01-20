package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,gender=null;
		int age=0;
		boolean status=false;
		
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		name=req.getParameter("pname");
		age=Integer.parseInt(req.getParameter("page"));
		gender=req.getParameter("gen");
		//write the b.logic
		 if(gender.equalsIgnoreCase("M")) 
			    status=age>=21?true:false;
		    else			    
		    	 status=age>=18?true:false;
		    if(status)
		    	pw.println("<h1 style='color:green;text-align:center'> Mr/Miss.."+name+"  u  r eligble to marry  but think twice</h1>");
		    else
		    	pw.println("<h1 style='color:red;text-align:center'> Mr/Miss.."+name+"  u  r not eligble to marry  ..enjoy life</h1>");
		    
		    //add hyerplink
		    pw.println("<a href='input.html'>home </a>");
          //close stream
		    pw.close();
			 
		 }//doPost(-,-)

}//class
