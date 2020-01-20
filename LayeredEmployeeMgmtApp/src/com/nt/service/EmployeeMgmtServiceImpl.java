package com.nt.service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dao.EmployeeDAOImpl;
import com.nt.dto.EmployeeDTO;

public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	private  EmployeeDAO  dao; 
	public  EmployeeMgmtServiceImpl() {
		dao=new EmployeeDAOImpl();
	}

	@Override
	public String registerEmployee(EmployeeDTO dto) throws Exception {
		float gSal=0.0f, netSal=0.0f;
		EmployeeBO bo=null;
		int count=0;
		 //calcculate grossSalary,netSalary
		gSal=dto.getBasicSalary()+ (dto.getBasicSalary()*0.3f);
		netSal=gSal-(gSal*0.1f);
		//prepare EmployeeBO class obj having persistable data..
	        bo=new EmployeeBO();
	        bo.setEmpNo(dto.getEmpNo());
	        bo.setEmpName(dto.getEmpName());
	        bo.setEmpDesg(dto.getEmpDesg());
	        bo.setEmpAddrs(dto.getEmpAddrs());
	        bo.setBasicSalary(dto.getBasicSalary());
	        bo.setGrossSalary(gSal);
	        bo.setNetSalary(netSal);
	        //use DAO 
	        count=dao.insert(bo);
	        //process the Reuslts
	        if(count==0)
	        	 return "Employee Registration Failed---> GrossSalary=="+gSal+" netSalary==="+netSal;
	        else
	        	 return "Employee Registration Succeded---> GrossSalary=="+gSal+" netSalary==="+netSal;
	}//method
}//class
