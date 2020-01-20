package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		    PrintWriter pw=null;
		    String pval=null;
		    Locale locales[]=null;
	          //general settings
		    pw=res.getWriter();
		    res.setContentType("text/html");
		    // read p1 req param value
		    pval=req.getParameter("p1");
		    //get All Locales that are Availble
		    locales=Locale.getAvailableLocales();
		    //differentiate logics for hyperlinks
		    if(pval.equalsIgnoreCase("link1")) {
		    	pw.println("<h1>All Languages </h1>");
		    	for(Locale lcl:locales) {
		    		pw.println("<br>"+lcl.getDisplayLanguage());
		    	}
		    }
		    else if(pval.equalsIgnoreCase("link2")) {
		    	pw.println("<h1>All Countries </h1>");
		    	for(Locale lcl:locales) {
		    		pw.println("<br>"+lcl.getDisplayCountry());
		    	}
		    }
		    else {
		    	pw.println("<h1>System Date and  Time::"+new Date()+"</h1>");
		    }
		    //add home hyperlink
		    pw.println("<br> <a href='links.html'>home </a>");
		    //close stream
		    pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	      doGet(req,res);
	}//doPost(-,-)
}//class
