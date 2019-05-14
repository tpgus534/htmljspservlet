package com.kitri.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("로그인하러 왔냐구여!!!!!!!!!!");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String name=null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");

			stmt = conn.createStatement();

			StringBuffer sql = new StringBuffer();
			sql.append("select name from member where id = '" + id + "'\n");
			sql.append("and pass = '" + pass + "'");
			rs = stmt.executeQuery(sql.toString());
			if(rs.next()) {
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
		out.print("<html>");
		out.print("<body>");
		if (name != null) {
			out.print(name + "님 안녕하세요");
		} else {
			out.print("아이디 비밀번호를 확인해주세요");
			out.print("<a href=\"/memberservlet/user/login.html\">다시 로그인</a>");
		}
		out.print("</body>");
		out.print("</html>");
		
	}

}
