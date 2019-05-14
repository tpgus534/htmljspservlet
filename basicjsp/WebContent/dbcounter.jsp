<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
    int count;
    
    public void init(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    %>
    
    <%
    try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","project1","project1");
			stmt = conn.createStatement();
			
			String sql = "select num from count";
			rs = stmt.executeQuery(sql);
			rs.next();
			count = rs.getInt(1);
			
			sql = "update count set num = num+1";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(rs!=null)
						rs.close();
					if(stmt!=null)
						stmt.close();
					if(conn!=null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
    
    String str = String.valueOf(count);
	int a = str.length();
	int zero = 8-a;
		%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
for (int i = 0; i < zero; i++) {
	%><img src="/basicservlet/img/0.PNG">
<%
}
for (int i = 0; i < a; i++) {
	%><img src="/basicservlet/img/<%=str.charAt(i)%>.PNG">
<%
}
%>
</body>
</html>