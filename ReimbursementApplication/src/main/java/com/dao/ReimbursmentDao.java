package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.models.Employees;
import com.models.Reimbursement;

public interface ReimbursmentDao {

	List<Reimbursement> getEmpReimbursments(Employees emp)throws SQLException;
	
	
	
	List<Reimbursement> getAllReimbursements() throws SQLException;
	
}
