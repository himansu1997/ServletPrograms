package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.EmployeeBO;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static  final String  INSERT_EMP_QUERY="INSERT INTO LAYERED_EMPLOYEE VALUES(?,?,?,?,?,?,?)";
	
	private  Connection  getPooledConnection()throws Exception{
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		//create InitialContext obj
		ic=new InitialContext();
		//get DataSource obj through Lookup operation
		ds=(DataSource) ic.lookup("java:/comp/env/DsJndi");
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
		ps.setInt(1, bo.getEmpNo());
		ps.setString(2, bo.getEmpName());
		ps.setString(4,bo.getEmpDesg());
		ps.setString(3,bo.getEmpAddrs());
		ps.setFloat(5,bo.getBasicSalary());
		ps.setFloat(6,bo.getGrossSalary());
		ps.setFloat(7,bo.getNetSalary());
		//execute theQuery
		count=ps.executeUpdate();
		//close jdbc objs
		ps.close();
		con.close();
		return  count;
	}//method
}//class
