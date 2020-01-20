package com.nt.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
	private String empName;
	private String empDesg;
	private String empAddrs;
	private float basicSalary;


	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesg() {
		return empDesg;
	}

	public void setEmpDesg(String empDesg) {
		this.empDesg = empDesg;
	}

	public String getEmpAddrs() {
		return empAddrs;
	}

	public void setEmpAddrs(String empAddrs) {
		this.empAddrs = empAddrs;
	}

	public float getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}
}
