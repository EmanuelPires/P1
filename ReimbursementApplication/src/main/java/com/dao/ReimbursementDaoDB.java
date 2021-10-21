package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.models.Employees;
import com.models.Reimbursement;
import com.utils.ConnectionUtil;

public class ReimbursementDaoDB implements ReimbursmentDao{

	
	
	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
	public List<Reimbursement> getEmpReimbursments(Employees emp) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con = conUtil.getConnection();
		
		List<Reimbursement> reimList = new ArrayList<Reimbursement>();
		
		String sql = "SELECT * FROM reimbursements WHERE reimAuthor='" +emp.getId()+ "'";
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		while(rs.next()) {
			reimList.add(new Reimbursement(rs.getInt(1), rs.getBigDecimal(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
		}
		
		
		
		return reimList;
	}

	
	
	
	
	
	
	
	
	public List<Reimbursement> getAllReimbursements() throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con = conUtil.getConnection();
		
		List<Reimbursement> reimList = new ArrayList<Reimbursement>();
		String sql = "SELECT * FROM reimbursements";
		Statement s = con.createStatement();
		ResultSet rs= s.executeQuery(sql);
		
		while(rs.next()) {
			reimList.add(new Reimbursement(rs.getInt(1), rs.getBigDecimal(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
		}
		
		
		return reimList;
	}
	
	@Override
	 public Employees getEmpInfo(String email) {
		 Employees emp = new Employees();
			
			Connection  con = conUtil.getConnection();
			
			String sql = "SELECT * FROM employees WHERE employees.email='" +email+"'";
			
			try {
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				
				
				while(rs.next()) {
				emp.setId(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setEmail(rs.getString(4));
				emp.setUsername(rs.getString(5));
				emp.setPassword(rs.getString(6));
				emp.setUserRole(rs.getInt(7));
				}
				
				
				return emp;
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return null;
	 }

}
