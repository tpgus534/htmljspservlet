package com.kitri.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.kitri.customer.Customer;
import com.kitri.exception.NotFoundException;

public class CustomerDAO {
	
	private static CustomerDAO customerDAO;
	
	static {
		customerDAO = new CustomerDAO();
	}
	
	private CustomerDAO() {
		
	}
	
	public static CustomerDAO getCustomerDAO() {
		return customerDAO;
	}


	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int cnt = 0;

	public Customer selectById(String id) throws com.kitri.exception.NotFoundException {
		Customer c = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
			String sql = "select * from member where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			System.out.println(id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				c = new Customer();
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setPass(rs.getString("pass"));
				return c;
			} else {
				throw new NotFoundException("아이디에 해당하는 고객이 없습니다.");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NotFoundException(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NotFoundException(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public List<Customer> selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Customer> selectAll() {
		// TODO Auto-generated method stub

		return null;
	}

	public void insert(Customer c) {

	}

}
