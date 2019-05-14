<%@page import="java.net.URLEncoder"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!public void init() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}%>
<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	String name = null;
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	try {
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
		stmt = conn.createStatement();
		StringBuffer sql = new StringBuffer();
		sql.append(" select name from member where id = '" + id + "'  \n");
		sql.append(" and pass = '" + pass + "'");
		rs = stmt.executeQuery(sql.toString());
		if (rs.next()) {
			name = rs.getString("name");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	if (name != null) {
		response.sendRedirect("loginok.jsp?name=" + URLEncoder.encode(name, "UTF-8"));
	} else {
		response.sendRedirect("loginfail.jsp");
	}
%>