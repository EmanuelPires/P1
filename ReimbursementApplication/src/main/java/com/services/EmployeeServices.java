package com.services;

import java.sql.SQLException;
import java.util.List;

import com.dao.ReimbursementDaoDB;
import com.exceptions.UserDoesNotExist;
import com.logging.Logging;
import com.models.Employees;
import com.models.Reimbursement;

public class EmployeeServices {
	
	
	ReimbursementDaoDB reimDao = new ReimbursementDaoDB();
	
	public Employees signIn(String email, String password) throws UserDoesNotExist{
		
		
		
		Employees emp = reimDao.getEmpInfo(email);
		
		if(emp.getId()==0) {
			Logging.logger.warn("Username does not exist");
			throw new UserDoesNotExist();
		}else if(emp.getPassword().equals(password)) {
			return emp;
		}
		
		return null;
	}
	

	public List<Reimbursement> getEmpReimbursements(Employees emp){
		
		
		try {
			return reimDao.getEmpReimbursments(emp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
