package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/compurl")
public class CalcCompoundIntrAmtServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    PrintWriter pw=null;
	    float pAmt=0.0f,rate=0.0f,time=0.0f;
	    float  cIntrAmt=0.0f;
	    //get Writer 
	    pw=res.getWriter();
	    res.setContentType("text/html");
	    //read form data
	    pAmt=Float.parseFloat(req.getParameter("pAmt"));
	    rate=Float.parseFloat(req.getParameter("rate"));
	    time=Float.parseFloat(req.getParameter("time"));
	    //calculate Compound Intr Amount
	    cIntrAmt= (float) ((pAmt*Math.pow((1+rate/100),time))-pAmt);
	    pw.println("<bR><b>WATwo--> Compund IntrAmount :::"+cIntrAmt+"</b>");
	    //do not close stream
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	}

}
