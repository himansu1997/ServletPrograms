package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.JobSeekerBO;

public class JobSeekerDAOImpl implements JobSeekerDAO {
	private static final String   NAUKRI_INSERT_QUERY="INSERT INTO INFO_NAUKRI VALUES(NAUKRIID_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
	
	private  Connection getPooledConnection() throws Exception{
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		//get InitialContext object
		ic=new InitialContext();
		//get DAtaSource obj through lookup operation
		ds=(DataSource) ic.lookup("java:/comp/env/DsJndi");
		//get Pooled Connection
		con=ds.getConnection();
		return con;
	}

	@Override
	public int insert(JobSeekerBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		//get Pooled connection
		con=getPooledConnection();
		//create PreparedStatement object
		ps=con.prepareStatement(NAUKRI_INSERT_QUERY);
		//set values to Query params
		ps.setString(1,bo.getJsName());
		ps.setInt(2,bo.getAge());
		ps.setString(3,bo.getAddrs());
		ps.setString(4,bo.getSkill());
		ps.setInt(5, bo.getExperience());
		ps.setString(6,bo.getLocation());
		ps.setInt(7,bo.getExpSalary());
		//execute the Qury
		count=ps.executeUpdate();
		return count;
	}

}
