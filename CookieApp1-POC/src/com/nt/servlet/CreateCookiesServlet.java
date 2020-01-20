package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createCookies")
public class CreateCookiesServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		Cookie cookie1=null,cookie2=null,cookie3=null,cookie4=null;
		//get PrintWriter 
		pw=res.getWriter();
		res.setContentType("text/html");
		//create cookies
		cookie1=new Cookie("ap","Amavathi");
		cookie2=new Cookie("TS","Hyderabad");
		res.addCookie(cookie1); res.addCookie(cookie2);  //In Memory cookies
		cookie3=new Cookie("mh","mumbai");
		cookie4=new Cookie("mp", "bhopal");
		cookie3.setMaxAge(20); cookie4.setMaxAge(30);
		res.addCookie(cookie3); res.addCookie(cookie4);  //Persistence cookies
		
		pw.println("<h1 style='color:red;text-align:center'>Cookies are added </h1>");
		//close stream
		pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    doGet(req,res);
	}

}
