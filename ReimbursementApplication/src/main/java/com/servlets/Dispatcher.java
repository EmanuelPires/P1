package com.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controllers.LoginController;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Dispatcher {
	
	
	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		System.out.println("In Dispatcher going to " + req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/ReimbursementApplication/api/login":
			LoginController.login(req, res);
			break;
		}
	}

}
