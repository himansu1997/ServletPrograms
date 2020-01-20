package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		ServletConfig cg=null;
		ServletContext sc=null;
		//get PrintWriter 
		pw=res.getWriter();
		res.setContentType("text/html");
		//get access to ServletConfig obj
		cg=getServletConfig();
		sc=getServletContext();
		pw.println("<br>dbuser context param value::"+sc.getInitParameter("dbuser"));
		pw.println("<br>driver context param value::"+sc.getInitParameter("driver"));
		
		pw.println("<br>p1 init param value::"+cg.getInitParameter("p1"));
		pw.println("<br>dbuser init param value::"+cg.getInitParameter("dbuser"));
		
		pw.println("<br> SErvletcontext obj class name::"+sc.getClass());
		
		pw.println("<br> Server info::"+sc.getServerInfo());
		pw.println("<br> Servlet api version::"+sc.getMajorVersion()+"."+sc.getMinorVersion());
		pw.println("<br> context path :: "+sc.getContextPath());
		pw.println("<br> MIME type of input.htm::"+sc.getMimeType("/input.html"));
		pw.println("<br> path of input.html ::"+sc.getRealPath("/input.html"));
		pw.println("<br> path of web application ::"+sc.getRealPath("/"));
		pw.println("<br> All servlet names<br>");
		Enumeration<String>  en=sc.getServletNames();
		while(en.hasMoreElements()) {
			String name=en.nextElement();
           pw.println(name+"<br>");
		}
		
		
		//close stream
		pw.close();
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
