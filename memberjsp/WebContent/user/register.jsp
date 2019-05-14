<%@page import="java.net.URLEncoder"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!Connection conn = null;
	PreparedStatement stmt = null;
	int a = 0;%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");

	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String pass = request.getParameter("pass");
	String email = request.getParameter("emailid");
	String emaildomain = request.getParameter("emaildomain");
	String zipcode = request.getParameter("zipcode");
	String address = request.getParameter("address");
	String address_detail = request.getParameter("address_detail");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");

	StringBuffer sql = new StringBuffer("");
	try {
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
		sql.append("insert all\n");
		sql.append("	into member (id, name, pass, emailid, emaildomain, joindate)\n");
		sql.append("	values(?,?,?,?,?, sysdate)\n");
		sql.append("	into member_detail (id, zipcode, address, address_detail, tel1, tel2, tel3)\n");
		sql.append("	values(?,?,?,?,?,?,?)\n");
		sql.append("select * from dual\n");

		int idx = 0;
		stmt = conn.prepareStatement(sql.toString());
		stmt.setString(++idx, id);
		stmt.setString(++idx, name);
		stmt.setString(++idx, pass);
		stmt.setString(++idx, email);
		stmt.setString(++idx, emaildomain);
		stmt.setString(++idx, id);
		stmt.setString(++idx, zipcode);
		stmt.setString(++idx, address);
		stmt.setString(++idx, address_detail);
		stmt.setString(++idx, tel1);
		stmt.setString(++idx, tel2);
		stmt.setString(++idx, tel3);

		a = stmt.executeUpdate();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		try {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	String root = request.getContextPath();	
	if (a != 0) {
		response.sendRedirect(root + "/user/registerok.jsp?name=" + URLEncoder.encode(name, "UTF-8"));
	} else {
		response.sendRedirect(root + "/user/registerfail.jsp");
	}
%>