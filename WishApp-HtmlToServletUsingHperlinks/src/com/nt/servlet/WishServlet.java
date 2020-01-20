//WishServlet.java
package com.nt.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
public class WishServlet extends HttpServlet
{
	public  void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
        PrintWriter pw=null;
		Calendar calendar=null;
		int hour=0;
		ServletOutputStream os=null;
		   //get PrintWriter
		os=res.getOutputStream();
		pw=res.getWriter();
		   //set response contentn type
		   res.setContentType("text/html");
		   //writer b.logic
		   calendar=Calendar.getInstance();
              //get current hour of the day
			  hour=calendar.get(Calendar.HOUR_OF_DAY);  //gives time in 24hrs format
			  //write wish message
			  if(hour<12)
				  os.println("<h1 style='color:red;text-align:center'>Good Morning</h1>");
			  else if(hour<16)
				  os.println("<h1 style='color:red;text-align:center'>Good AfterNoon</h1>");
			  else if(hour<20)
				  os.println("<h1 style='color:red;text-align:center'>Good Evening</h1>");
			  else
				  os.println("<h1 style='color:red;text-align:center'>Good Night</h1>");
			  //add hyperlink
			  os.println("<a href='page.html'>Go To home </a>");
			  //close stream
			  os.close();
	}//service(-,-)
}
