package com.kitri.jdbctest;

public class DriverLoadingTest {
	
	public DriverLoadingTest() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버연결 성공!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
	}
	
	
	public static void main(String[] args) {
		new DriverLoadingTest();
		
	}
}
