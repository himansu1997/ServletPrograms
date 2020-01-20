package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/fourthurl")
public class FourthServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		RequestDispatcher rd=null;
		HttpSession ses=null;
		ServletContext sc=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read and display request attribute values
		pw.println("<br>FourthServlet:: attr1 (req) value::"+req.getAttribute("attr1"));
		//read and display session attribute values
			ses=req.getSession();
			pw.println("<br>Fourtht:: attr2 (ses) value::"+ses.getAttribute("attr2"));
			//read and display ServletContext attribute vlaue
			sc=getServletContext();
			pw.println("<br> FourthServlet:: attr3 (sc) value::"+sc.getAttribute("attr3"));
			

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
