package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {
	
	//@Override
	public void processPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet.processPost(-,-)");
		PrintWriter pw=null;
		String name=null,gender=null,tage=null;
		int age=0;
		boolean status=false;
		List<String> errList=null;
		String vstatus=null;
		
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		name=req.getParameter("pname");
		tage=req.getParameter("page");
		gender=req.getParameter("gen");
		//read vflag value
		vstatus=req.getParameter("vflag");
		if(vstatus.equalsIgnoreCase("no")) {
		// server side form validation logic
		System.out.println("Server side form validations are taking place..");
		errList=new ArrayList();
		if(name==null || name.equals("") || name.length()==0) { //required rule
			errList.add("Person name is required");
		}
		
		if(tage==null || tage.equals("") ||tage.length()==0) {  //required 
		  errList.add("Person age is required");
		}
		else {
			try {
				age=Integer.parseInt(tage);
				if(age<=0 || age>125) {
					errList.add("Person age must be there in the range of 1 to 125 ");
				}
			}
			catch(NumberFormatException nfe) {
				errList.add("Person age must be numeric value");
			}
		}
		
		//Dispaly form Valudation error messages
		if(errList.size()>0) {
			for(String msg:errList) {
				pw.println("<b style='color:red'>"+msg+"</b> <br>");
			}
			return;
		}//if
		}//if
		else {
			age=Integer.parseInt(tage);
		}
		
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
		    pw.println("<a href='input.html'>Go home </a>");
          //close stream
		    pw.close();
			 
		 }//doGet(-,-)
	
	//@Override
	public void processGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet.processGet(-,-)");
		PrintWriter pw=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//write response to browser
		pw.println("<h1 style='color:red;text-align:center'>Date and time is::"+new Date()+"</h1>");
		
		 //add hyerplink
	    pw.println("<br><a href='input.html'>Go home </a>");
	    pw.close();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet.doGet(-,-)");
	   processGet(req,res);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet.doPost(-,-)");
		processPost(req,res);
	}
	
}//class
