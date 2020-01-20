package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,tage=null;
		int age=0;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data (request parameters)
		name=req.getParameter("pname");
		tage=req.getParameter("page");
		age=Integer.parseInt(tage);
		//Write b.logic
		if(age>=18)
			pw.println("<h1 style='color:green;text-align:center'>Mr/Miss/Mrs."+name +"  u r elgible for Voting </h1>");
		else 
			pw.println("<h1 style='color:red;text-align:center'>Mr/Miss/Mrs."+name +"  u r not elgible for Voting  U need wait "+(18-age)+"years "+"</h1>");
		//add graphical hyperlink
			pw.println("<br> <a href='http://localhost:2525/VoterApp-HtmlToServletUsingForms/input.html'><img src='home1.jpg'></a>");
			//close stream
			pw.close();
	}
	

}
