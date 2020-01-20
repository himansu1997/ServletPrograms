package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 String name=null,fname=null;
		 int age=0;
		 Cookie ckName,ckFname,ckAge=null;
		 //get PrintWriter
		 pw=res.getWriter();
		 //setContent type
		 res.setContentType("text/html");
		 //read form1/req1  data
		 name=req.getParameter("name");
		 fname=req.getParameter("fname");
		 age=Integer.parseInt(req.getParameter("age"));
		 //add form1/req1 data to InMemory Cookies
		 ckName=new Cookie("cname",name);
		 ckFname=new Cookie("cfname",fname);
		 ckAge=new Cookie("cage",String.valueOf(age));
		 res.addCookie(ckName); res.addCookie(ckFname); res.addCookie(ckAge);
		 //generate form2 dynamically from here..
		 pw.println("<br><h1 style='color:red;text-align:center'>Form2 --Income Tx Details </h1>");
		 pw.println("<form action='secondurl'  method='POST'>");
		 pw.println("<b> Income :::  <input type='text' name='income'><br>");
		 pw.println("<b> Tax :::  <input type='text' name='tax'><br>");
		 pw.println("<b> <input type='submit'  value='submit'>");
		 pw.println("</form>");
		 //clsoe stream
		 pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
           doGet(req,res);
	}//doPost(-,-)
}//class
