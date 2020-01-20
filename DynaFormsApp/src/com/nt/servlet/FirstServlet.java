package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
          PrintWriter pw=null;
          String ms=null,name=null,fname=null;
          int age=0;
          
          //get PrintWriter 
          pw=res.getWriter();
          res.setContentType("text/html");
          //read form1/req1 data...
          name=req.getParameter("pname");
          fname=req.getParameter("pfname");
          age=Integer.parseInt(req.getParameter("page"));
          ms=req.getParameter("ms");
          //set not selected state of  check box
          if(ms==null)
        	  ms="single";
          //Generate form2 dynamically  based on the marital status..
          if(ms.equalsIgnoreCase("married")) {
        	  pw.println("<h1 style='color:red;text-align:center'>Form2-Provide Marital life details </h1>");
        	  pw.println("<form action='secondurl'  method='POST'>");
        	  pw.println(" Spouse name :: <input type='text' name='f2t1'><br>");
        	  pw.println(" no.of kids :: <input type='text' name='f2t2'><br>");
        	  pw.println(" <input type='submit' value='submit'>");
        	  pw.println("</form>");
          }
          else {
        	  pw.println("<h1 style='color:red;text-align:center'>Form2-Provide Bachelor life details </h1>");
        	  pw.println("<form action='secondurl'  method='POST'>");
        	  pw.println(" when do u want to marry :: <input type='text' name='f2t1'><br>");
        	  pw.println(" why do u want to marry :: <input type='text' name='f2t2'><br>");
        	  pw.println(" <input type='submit' value='submit'>");
        	  pw.println("</form>");
          }
          
          //close stream
          pw.close();
	
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}

}
