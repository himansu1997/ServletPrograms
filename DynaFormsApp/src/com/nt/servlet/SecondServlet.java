package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String f2val1=null,f2val2=null;
		String name=null,fname=null,ms=null;
		String age=null;
		//get PrintWriter
		pw=res.getWriter();
		//response content type
		res.setContentType("text/html");
		//read form2/req2 data
		f2val1=req.getParameter("f2t1");
		f2val2=req.getParameter("f2t2");
		//read form1/req data
		name=req.getParameter("pname");
		fname=req.getParameter("pfname");
		age=req.getParameter("page");
		ms=req.getParameter("ms");
		
		//display form1/req1  and form2/req2 data
		pw.println("<br><b><i> form1/req1 data ::"+name+".. "+fname+".. "+age+".. "+ms+"</b></i>");
		pw.println("<br><b><i> form2/req2 data ::"+f2val1+".. "+f2val2);
		pw.println("<br> <a href='person_details.html'>home</a>");
		//close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
