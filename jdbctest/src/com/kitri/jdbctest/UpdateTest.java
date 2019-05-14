package com.kitri.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {
	
	public UpdateTest() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection makeConnection() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
		return conn;
	}
	
	public static void main(String[] args) {
		
		UpdateTest ut = new UpdateTest();
		String newid = "catcat";
		
		Connection conn = null;
		Statement stmt = null;
		int cnt = 0;
		try {
			conn = ut.makeConnection();
			stmt = conn.createStatement();
			
			String sql = "update jdbctest set id = '"+newid+"' where name = '이세현'";
			System.out.println(sql);
			cnt = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					if (stmt!=null) {
						stmt.close();
					}if (conn!=null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		if (cnt != 0) {
			System.out.println("update success");
		} else {
			System.out.println("실패데스네");
		}	
	}
}
