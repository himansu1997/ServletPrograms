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

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		RequestDispatcher rd=null;
		HttpSession ses=null;
		ServletContext sc=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//create request attribute
		req.setAttribute("attr1", "Val1");
		//create Session attribute
		ses=req.getSession();
		ses.setAttribute("attr2","val2");
		//create ServletContext attribute
		sc=getServletContext();
		sc.setAttribute("attr3","val3");
		//forward request to SecondServlet
		rd=req.getRequestDispatcher("/secondurl");
		rd.forward(req,res);
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
