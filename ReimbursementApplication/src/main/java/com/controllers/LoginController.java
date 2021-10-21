package com.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ReimbursementDaoDB;
import com.dao.ReimbursmentDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.Employees;
import com.services.EmployeeServices;

public class LoginController {
	
	public static ReimbursmentDao reimDao = new ReimbursementDaoDB();
	public static EmployeeServices empServices = new EmployeeServices(reimDao);
	
	
	
	public static void login(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		System.out.println("In Login Controller");
		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = req.getReader();
		
		String line;
		while((line=reader.readLine()) != null) {
		buffer.append(line);
		buffer.append(System.lineSeparator());
		}
		
		
		
		String data = buffer.toString();
		System.out.print(data);
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode parseObj = mapper.readTree(data);
		
		
		String email = parseObj.get("email").asText();
		String password = parseObj.get("password").asText();
		
		System.out.println(email);
		System.out.println(password);
		
		try {
			System.out.println("In Login Controller try block");
			Employees emp = empServices.signIn(email, password);
			System.out.println(emp);
			
			req.getSession().setAttribute("id", emp.getId());
			res.setStatus(200);
			res.getWriter().write(new ObjectMapper().writeValueAsString(emp));
		}catch(Exception e) {
			res.setStatus(403);
			res.getWriter().print("Username or password incorrect");
		}
		
	}

}
