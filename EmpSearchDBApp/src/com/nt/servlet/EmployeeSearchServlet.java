//EmpSearchServlet.java
package com.nt.servlet;

import java.sql.*;  //jdbc api
import java.util.Enumeration;

import javax.servlet.*;  //servlet api
import javax.servlet.http.*;  //servlet api
import java.io.*;

public class EmployeeSearchServlet extends HttpServlet
{  private static final String   GET_EMP_DETAILS="SELECT EMPNO,ENAME,SAL,JOB,MGR,DEPTNO FROM EMP WHERE EMPNO=?";

	public   void   doGet(HttpServletRequest req,
		                                    HttpServletResponse res)throws ServletException,IOException{
		   PrintWriter pw=null;
		   int no=0;
		   Connection con=null;
		   PreparedStatement ps=null;
		   ResultSet rs=null;
		  ServletContext sc=null;
		   String driver=null,url=null;
		   String dbuser=null,dbpwd=null;
		   Enumeration<String> e=null;
		   try {
         //get PrintWriter
		 pw=res.getWriter();
		 //set response content type
		 res.setContentType("text/html");
		 //read form data
		 no=Integer.parseInt(req.getParameter("eno"));
		 //get Access to ServletConfig obj
		 sc=getServletContext();
		 //read init param values
		 driver=sc.getInitParameter("driver");
		 url=sc.getInitParameter("url");
		 dbuser=sc.getInitParameter("dbuser");
		 dbpwd=sc.getInitParameter("dbpwd");
				 
		 //write JDBC code
                //register JDBC driver s/w
				Class.forName(driver);
				//establish the connection
				con=DriverManager.getConnection(url,dbuser,dbpwd);
				//create PreparedStatement object
				ps=con.prepareStatement(GET_EMP_DETAILS);
				//set value query param
				ps.setInt(1,no);
				//execute Query
                 rs=ps.executeQuery();
				 //process the ResultSet
				 if(rs!=null){
					 if(rs.next()){
                          pw.println("<br><br><h1> Employee Details are  </h1><br><br>");
						  pw.println("<br><b> emp number ::"+rs.getInt(1));
  						  pw.println("<br><b> emp name ::"+rs.getString(2));
						  pw.println("<br><b> emp  Salary ::"+rs.getInt(3));
						  pw.println("<br><b> emp  Job ::"+rs.getString(4));
						  pw.println("<br><b> emp  Manager Number ::"+rs.getInt(5));
						  pw.println("<br><b> emp  Dept Number ::"+rs.getInt(6));
					 }//if
					 else{
                        pw.println("<br><br><h1> Employee Not Found </h1><br><br>");
					 }
  					 //add hyperlink
				 pw.println("<br><br><a href='input.html'><img src='images/home.png'> </a>");
				 }
				 
     		 }//try
			 catch(SQLException se){
				// pw.println("<br><b> Internal DB Problem </b>");
                   se.printStackTrace();
			 }
			 catch(ClassNotFoundException cnf){
				   //pw.println("<br><b> Internal JDBC driver Problem </b>");
                   cnf.printStackTrace();
			 }
			 catch(Exception ex){
                   ex.printStackTrace();
			 }
			 finally{
                      try{
                          if(rs!=null){
                                rs.close();
						  }
					  }
					  catch(SQLException se){
						    se.printStackTrace();
					  }
					   try{
                          if(ps!=null){
                                ps.close();
						  }
					  }
					  catch(SQLException se){
						    se.printStackTrace();
					  }
					    try{
                          if(con!=null){
                                con.close();
						  }
					  }
					  catch(SQLException se){
						    se.printStackTrace();
					  }
				
			 }//finally
	}//doGet(-,-)

      public   void   doPost(HttpServletRequest req,
		                                    HttpServletResponse res)throws ServletException,IOException{
		   doGet(req,res);
	  }

}//class

