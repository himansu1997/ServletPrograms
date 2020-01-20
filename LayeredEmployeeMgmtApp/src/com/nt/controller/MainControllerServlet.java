package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;
import com.nt.service.EmployeeMgmtServiceImpl;
import com.nt.vo.EmployeeVO;


@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	 EmployeeMgmtService service;
	
	@Override
	public void init() throws ServletException {
	    service=new EmployeeMgmtServiceImpl();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	     EmployeeVO  vo=null;
	     EmployeeDTO dto=null;
	     String result=null;
	     PrintWriter pw=null;
	     //get PrintWriter 
	     pw=res.getWriter();
	     //set response content type
	     res.setContentType("text/html");
		//read form data and store into EmployeeVO class obj (optional)
		 vo=new EmployeeVO();
		 vo.setEmpNo(req.getParameter("eno"));
		 vo.setEmpName(req.getParameter("ename"));
		 vo.setEmpAddrs(req.getParameter("eadd"));
		 vo.setEmpDesg(req.getParameter("desg"));
		 vo.setBasicSalary(req.getParameter("bSal"));
		 //Convert  VO class obj DTO class object
		 dto=new EmployeeDTO();
		 dto.setEmpNo(Integer.parseInt(vo.getEmpNo()));
		 dto.setEmpName(vo.getEmpName());
		 dto.setEmpDesg(vo.getEmpDesg());
		 dto.setEmpAddrs(vo.getEmpAddrs());
		 dto.setBasicSalary(Float.parseFloat(vo.getBasicSalary()));
		 try {
		 //use service
		    result=service.registerEmployee(dto);
		    pw.println("<h1>Final Result ::: "+result+"</h1>");
		 }
		 catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>Internal problem </h1>");
		 }
	     // add hyperlink
		 pw.println("<br> <a href='employee_register.html'>home</a>");
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}
	
	@Override
	public void destroy() {
	    service=null;
	}

}
