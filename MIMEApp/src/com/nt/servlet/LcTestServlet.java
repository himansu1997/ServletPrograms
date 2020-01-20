package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LcTestServlet extends HttpServlet {
	private ServletConfig cg;
	static {
		System.out.println("LcTestServlet::static block");
	}
	
	public LcTestServlet() {
		System.out.println("LcTestServlet::0-param constuctor");
	}
	
	
	
@Override
	public void init(ServletConfig cg) throws ServletException {
	this.cg=cg;
		System.out.println("LcTestServlet.init(ServletConfig)");
		String s1=cg.getInitParameter("dbuser");
		String s2=cg.getInitParameter("dbpwd");
		System.out.println(s1+"  "+s2);
		
	} 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   System.out.println("LcTestServlet.2nd doPost(-,-)");
	   PrintWriter pw=null;
	   //get PrintWriter 
	   pw=res.getWriter();
	   // set response content type
	   res.setContentType("text/html");
	   pw.println("<br><h1> Date and time :::"+new java.util.Date()+"</h1>");
	   try{
	   //ServletConfig cg=getServletConfig();
	   System.out.println(cg.getInitParameter("dbuser")+"   "+cg.getInitParameter("dbpwd"));
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   //close stream
	   pw.close();
	}
	
	@Override
	public void destroy() {
	  System.out.println("LcTestServlet::destroy()");
	}
	
	public static void main(String[] args) {
		System.out.println("main(-)");
	}
	
	

}
