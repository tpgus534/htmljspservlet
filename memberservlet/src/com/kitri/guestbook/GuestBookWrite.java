package com.kitri.guestbook;

import java.awt.print.Printable;
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

@WebServlet("/gbwrite")
public class GuestBookWrite extends HttpServlet {
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

	Connection conn = null;
	PreparedStatement psmt = null;
	int cnt = 0;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		int idx=0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
			String sql = "insert into guestbook (seq, name, subject, content, logtime) values (guestbook_seq.nextval,?,?,?,to_char(sysdate,'YYMMDD'))";
			psmt = conn.prepareStatement(sql);
			psmt.setString(++idx, name);
			psmt.setString(++idx, subject);
			psmt.setString(++idx, content);

			cnt = psmt.executeUpdate();

			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		out.println("<html align=\"center\">");
		out.println("<body>");
		if (cnt != 0) {
			out.println("글작성 성공");
		} else {
			out.println("글작성 실패");
		}
		out.println("<a href=\"/memberservlet/gblist\">리스트로</a>");
		out.println("</body>");
		out.println("</html>");

	}

}
