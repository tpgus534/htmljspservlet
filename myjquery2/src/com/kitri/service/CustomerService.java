package com.kitri.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.customer.Customer;
import com.kitri.dao.CustomerDAO;
import com.kitri.exception.NotFoundException;

public class CustomerService {
	private static CustomerService customerService;
	static {
		customerService = new CustomerService();
	}
	
	private CustomerService() {
		// TODO Auto-generated constructor stub
	}
	
	public static CustomerService getCustomerService() {
		return customerService;
	}

	public String login(String id, String pass) {
		Customer c=null;
		String result="";
		try {
			c = CustomerDAO.getCustomerDAO().selectById(id);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result += "-1";
		}
		if (c.getPass().equals(pass)) {
			result += "1";
		} else {
			result += "-1";
		}
		
		return result;
	}
}
