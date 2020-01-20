package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String skill=null;
		int exp=0;
		HttpSession ses=null;
				
		//get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form2/req2 data...
		skill=req.getParameter("skill");
		exp=Integer.parseInt(req.getParameter("exp"));
		//create  HttpSession object
		ses=req.getSession(false);
		//place form1/req1 data as settion attribute values
		ses.setAttribute("skill",skill);
		ses.setAttribute("exp",exp);
		
		//Generate form2 dynamically from here
		pw.println("<h1 style='color:red;text-align:center'>Naukri.com Registration Page3 </h1>");
		pw.println("<form action="+res.encodeURL("thirdurl")+" method='POST'>");
		 pw.println("Preffered Location :::<input type='text' name='location'><br>");
		 pw.println("Expected Salary :::<input type='text' name='salary'><br>");
		pw.println("<input type='submit' value='submit'>");
		pw.println("</form>");
		//close stream
		pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	}

}
