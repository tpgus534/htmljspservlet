package com.kitri.jdbctest;

public class DriverLoadingTest {
	
	public DriverLoadingTest() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("����̹����� ����!");
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
