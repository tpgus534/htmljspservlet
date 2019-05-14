package com.kitri.util;

import java.sql.*;

public class DBConnection {
   
   static /* public DBConnection() */ {   //static은 언제 불러오는가?? 생성자는 new하는 시점,  static은 A라는 클래스가 읽혀질때 올라간다
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
    * A a1; 이건 생성자는 로드가 안되지만 static은 로드된다
    * 
    * A a1 = new A(); 
    * A a2 = new A(); 
    * A a3 = new A();   최초 한번만 static이 로드된다!
    */
}
