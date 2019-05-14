package com.kitri.util;

import java.sql.*;

public class DBConnection {
   
   static /* public DBConnection() */ {   //static�� ���� �ҷ����°�?? �����ڴ� new�ϴ� ����,  static�� A��� Ŭ������ �������� �ö󰣴�
      try {
         Class.forName(SiteConstance.DB_DRIVER);
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
   }
   
   
   
   public static Connection makeConnection() throws SQLException {
      return DriverManager.getConnection(SiteConstance.DB_URL, SiteConstance.DB_USERNAME, SiteConstance.DB_PASSWORD);
   }
   
   /*
    * A a1; �̰� �����ڴ� �ε尡 �ȵ����� static�� �ε�ȴ�
    * 
    * A a1 = new A(); 
    * A a2 = new A(); 
    * A a3 = new A();   ���� �ѹ��� static�� �ε�ȴ�!
    */
}
