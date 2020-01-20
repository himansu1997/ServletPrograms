package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String pval=null;
		int val1=0,val2=0;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read s1 req param value
		pval=req.getParameter("source");
		System.out.println("caption value::"+pval);
		if(!pval.equalsIgnoreCase("link1") && !pval.equalsIgnoreCase("link2")) {
			val1=Integer.parseInt(req.getParameter("t1"));
			val2=Integer.parseInt(req.getParameter("t2"));
		}
		//differentiate the logics
		if(pval.equalsIgnoreCase("add")) {
			pw.println("<h1 style='color:red'>Add ::"+(val1+val2)+"</h1>");
		}
		else if(pval.equalsIgnoreCase("sub")) {
			pw.println("<h1 style='color:red'>Sub ::"+(val1-val2)+"</h1>");
		}
		else if(pval.equalsIgnoreCase("mul")) {
			pw.println("<h1 style='color:red'>Mul ::"+(val1*val2)+"</h1>");
		}
		else if(pval.equalsIgnoreCase("div")) {
			pw.println("<h1 style='color:red'>DIV ::"+((float)val1/val2)+"</h1>");
		}
		else if(pval.equalsIgnoreCase("link1")) {
			pw.println("<h1 style='color:red'>Date and time ::"+new java.util.Date()+"</h1>");
		}
		else {
			pw.println("<h1 style='color:red'>Sys Props ::"+System.getProperties()+"</h1>");
		}
		//add home hyperlink
		pw.println("<a href='input.html'>home </a>");
		//close stream
		pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)

}//class
