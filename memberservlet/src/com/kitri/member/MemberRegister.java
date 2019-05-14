package com.kitri.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class MemberRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement stmt = null;

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		String email = req.getParameter("emailid");
		String emaildomain = req.getParameter("emaildomain");
		String zipcode = req.getParameter("zipcode");
		String address = req.getParameter("address");
		String address_detail = req.getParameter("address_detail");
		String tel1 = req.getParameter("tel1");
		String tel2 = req.getParameter("tel2");
		String tel3 = req.getParameter("tel3");

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

			int a = stmt.executeUpdate();

			out.println("<html>");
			out.println("	<body>");
			if (a != 0) {
				out.println(name+"님의 회원가입을 환영합니다!!!!<br>");
				out.println("로그인 후 모든 서비스를 이용할 수 있습니다.<br>");
				out.println("<a href=\"/memberjsp/user/login.jsp\">로그인</a>");
			} else {
				out.println("회원등록실패!!!");
			}
			out.println("	</body>");
			out.println("</html>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
