package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

//@WebServlet(value="/poolurl")
@WebServlet("/poolurl")
public class PoolServlet extends HttpServlet {
	@Resource(name="DsJndi")
	private DataSource ds;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String  tabName=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		ResultSetMetaData rsmd=null;
		int count=0;
		
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		try {
		//read form data
		tabName=req.getParameter("tabName");
		
		//get Pooled jdbc con object
			con=ds.getConnection();
		 //create Statement obj
			st=con.createStatement();
			//send and execute SQL Query
			rs=st.executeQuery("SELECT * FROM  "+tabName);
			//get ResultSetMetaData obj
			rsmd=rs.getMetaData();
			//get Column count
			count=rsmd.getColumnCount();
			//print Col names
			pw.println("<table border='1' align='center'  bgcolor='cyan'>");
			pw.println("<tr style='color:red'>");
			  for(int i=1;i<=count;++i) {
				  pw.println("<td>"+rsmd.getColumnLabel(i)+"</td>");
			  }
			pw.println("</tr>");
			//print col values
			while(rs.next()) {
				pw.println("<tr style='color:blue'>");
				for(int i=1;i<=count;++i) {
					pw.println("<td>"+rs.getString(i)+"</td>");
				}//for
				pw.println("</tr>");
			}//while
		}//try
		catch(SQLException se) {
			se.printStackTrace();
			 if(se.getErrorCode()==903)
				 pw.println("<b>Table not found  </b>");
			 else if(se.getErrorCode()==923)
				 pw.println("<b>Query Syntax Problem  </b>");
			 else
				 pw.println("<b>unknown DB Problem  </b>");
		}
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<b> Unkonwn Internal Problem </b> ");
		}
		finally {
			//close jdbc objs
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(st!=null)
					st.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}//finally
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
          doGet(req,res);
	}//doPost(-,-)
	
	
}//class
