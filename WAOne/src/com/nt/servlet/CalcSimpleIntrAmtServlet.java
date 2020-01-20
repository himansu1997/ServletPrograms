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

@WebServlet("/simpleurl")
public class CalcSimpleIntrAmtServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    PrintWriter pw=null;
	    float pAmt=0.0f,rate=0.0f,time=0.0f;
	    ServletContext sc=null,fc=null;
	    float sIntrAmt=0.0f;
	    RequestDispatcher rd=null;
	    //get PrintWriter 
	    pw=res.getWriter();
	    res.setContentType("text/html");
	    //read form data
	    pAmt=Float.parseFloat(req.getParameter("pAmt"));
	    rate=Float.parseFloat(req.getParameter("rate"));
	    time=Float.parseFloat(req.getParameter("time"));
	    //calc  SimpleIntr Amount
	    sIntrAmt=(pAmt*rate*time)/100.0f;
	    pw.println("<b>WAOne:: SimpleIntr Amount::"+sIntrAmt+"</b>");
	    //get ServletContext obj
	    sc=getServletContext();
	    //get Foriegn context obj of Dest Web App
	    fc=sc.getContext("/WATwo");
	    //create RquestDispacher pointing Dest Servlet comp of WATwo
	    rd=fc.getRequestDispatcher("/compurl");
	    rd.include(req,res);
	    //add hyperlink
	    pw.println("<br>  <a href='details.html'>home</a>");
	    //close stream
	    pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	
	}

}
