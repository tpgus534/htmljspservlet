package com.kitri.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	
	public ConnectionTest() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("����̹� ���� ����");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void dbConnect() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri","kitri");
			System.out.println("Ŀ��Ʈ ����");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		ConnectionTest ct = new ConnectionTest();
		ct.dbConnect();
	}

}
