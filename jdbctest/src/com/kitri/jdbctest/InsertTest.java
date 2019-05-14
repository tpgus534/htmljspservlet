package com.kitri.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {

	public InsertTest() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection makeConnection() throws SQLException {

		Connection con = null;
		con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
		System.out.println("드라이버 연결 성공");

		return con;
	}

	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		String name = "";
		String id = "";
		Connection conn = null;
		Statement stmt = null;
		int cnt = 0;

		try {
			conn = it.makeConnection();
			String sql = "";
			sql += "insert into jdbctest(no, name, id, joindate) \n";
			sql += "values (jdbctest_no_seq.nextval, '" + name + "', '" + id + "', sysdate)";

			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		if (cnt != 0) {
			System.out.println("insert success");
		} else {
			System.out.println("insert fail");
		}

	}
}
