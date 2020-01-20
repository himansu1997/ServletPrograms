//HtmlServlet.java
package com.nt.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HtmlServlet extends HttpServlet
{
	
	static {
		System.out.println("HtmlServlet:static block");
	}
	
	public HtmlServlet() {
		System.out.println("HtmlServlet:0-param constructor");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	   System.out.println("HtmlServlet.init(-)");
	}
	
    public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
    	System.out.println("HtmlServlet.service(-,-)");
		  PrintWriter pw=null;
          //get PrintWrtier 
		  pw=res.getWriter();
		  res.setContentType("text/html");
          //write b.logic
		  pw.println("<table border='1'  bgcolor='cyan'>");
		  pw.println("<tr><th>Name</th><th> Party</th><th>MpLocation</th><th>2019 results Prediction </th></tr>");
		  pw.println("<tr><td>Modi </td> <td> BJP </td><td> Kasi </td> <td> Super Win </td></tr>");
		  pw.println("<tr><td>Rahul </td> <td> Congress </td><td> Amethi </td> <td> Normal Win </td></tr>");
		  pw.println("<tr><td> KCR </td> <td> TRS </td><td> KarimNagar </td> <td> Bumper Win </td></tr>");
		  pw.println("<tr><td> Mamatha Didi</td> <td> TMC </td><td> Kolcutta </td> <td> Rebel Win </td></tr>");
		  pw.println("<tr><td> HemaMalini-DGI</td> <td> BJP </td><td> mathura </td> <td> So so win </td></tr>");
		  pw.println("</table>");
		  //close stream
		  pw.close();

	}//servce(-,-)
}//class