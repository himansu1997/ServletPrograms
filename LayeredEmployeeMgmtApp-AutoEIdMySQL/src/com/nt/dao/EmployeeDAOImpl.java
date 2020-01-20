package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.EmployeeBO;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static  final String  INSERT_EMP_QUERY="INSERT INTO LAYERED_EMPLOYEE(ENAME,DESG,ADDRS,BASICSALARY,GROSSSALARY,NETSALARY) VALUES(?,?,?,?,?,?)";
	
	private  Connection  getPooledConnection()throws Exception{
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		//create InitialContext obj
		ic=new InitialContext();
		//get DataSource obj through Lookup operation
		ds=(DataSource) ic.lookup("java:/comp/env/DsJndi-mysql");
		//get PooledConnection obj
		con=ds.getConnection();
		return con;
	}
	

	@Override
	public int insert(EmployeeBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		//get Pooled Connection
		con=getPooledConnection();
		//create PreparedStatement obj
		ps=con.prepareStatement(INSERT_EMP_QUERY);
		//set values to Query params
		ps.setString(1, bo.getEmpName());
		ps.setString(2,bo.getEmpAddrs());
		ps.setString(3,bo.getEmpDesg());
		ps.setFloat(4,bo.getBasicSalary());
		ps.setFloat(5,bo.getGrossSalary());
		ps.setFloat(6,bo.getNetSalary());
		//execute theQuery
		count=ps.executeUpdate();
		//close jdbc objs
		ps.close();
		con.close();
		return  count;
	}//method
}//class
