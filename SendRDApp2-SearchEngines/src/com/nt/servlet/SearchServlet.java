package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    PrintWriter pw=null;
	    String ss=null;
	    String engine=null;
	    String url=null;
	    RequestDispatcher rd=null;
		//general settings
	    pw=res.getWriter();
	    res.setContentType("text/html");
	    //read form data
	    ss=req.getParameter("ss");
	    //ss=res.encodeURL(ss);
	    engine=req.getParameter("engg");
	    //prepare url for sendRedirection based on the SearchEngine that is selected
	    if(engine.equalsIgnoreCase("google"))
	    	url="https://www.google.com/search?q="+ss;
	    else if(engine.equalsIgnoreCase("yahoo"))
	    	url="https://in.search.yahoo.com/search?p="+ss;
	    else if(engine.equalsIgnoreCase("bing"))
	    	url="https://www.bing.com/search?q="+ss;
	    else
	    	url="https://www.ask.com/web?q="+ss;
	    //perform SendRedirection
	    System.out.println("SS::before res.sendRedirect(-)");
	    pw.println("SS::before res.sendRedirect(-)");
	    res.sendRedirect(url);
	   rd=req.getRequestDispatcher("/hello.html");
	   rd.include(req,res);
	    System.out.println("SS::after res.sendRedirect(-)");
	    pw.println("SS::after res.sendRedirect(-)");
	    //close stream
	    pw.close();
	    
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
