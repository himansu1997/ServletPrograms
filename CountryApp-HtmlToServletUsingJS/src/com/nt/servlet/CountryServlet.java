package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountryServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		int countryCode=0; 
		String  cities[]=null;
		String impCities[][]=new String[][] { {"delhi","mumbai","chennai","kolkata"},
			                                                                {"karachi","lahore","inslamabad","peshawar"},
			                                                                {"Bejing","shangai","xanzian","tianjin"},
			                                                                {"newyork","chicago","LA","WashingtonDC"},
			                                                                {"sydney","Mellborne","Perth","BrisBain"},
		                                                               };
		
	        //general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		countryCode=Integer.parseInt(req.getParameter("country"));
		//get imp cities
		cities=impCities[countryCode];
		//display them on to the browser
		pw.println("<h1> Imp Cities are </h1>");
		for(String city:cities) {
			pw.println("<br><b>"+city+"</b>");
		}
		//add home hyperlink
		pw.println("<br> <a href='form.html'>home</a>");
		//close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    doGet(req,res);
	}//doPost(-,-)
}//class
