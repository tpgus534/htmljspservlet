package com.kitri.guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuestBookList
 */
@WebServlet("/gblist")
public class GuestBookList extends HttpServlet {
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
	ResultSet rs = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
			String sql = "select * from guestbook order by seq desc";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(sql);
			
			
			out.println("<head>");
			out.println("<title>글목록</title>");
			out.println("<meta charset=\"utf-8\">");
			out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
			out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\">");
			out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
			out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\"></script>");
			out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\"></script>");
			out.println("<style type=\"text/css\">");
			out.println("</style>");
			out.println("<script type=\"text/javascript\">");
			out.println("</script>");
			out.println("</head>");
			out.println("<body>");
			
			out.println("");
			out.println("<div class=\"container\" align=\"center\">");
			out.println("  <div class=\"col-lg-8\" align=\"center\">");
			out.println("  <h2>글목록</h2>");
			out.println("  <table class=\"table table-borderless\">");
			out.println("  	<tr>");
			out.println("  		<td align=\"right\"><button type=\"button\" class=\"btn btn-link\"> <a href=\"/memberservlet/guestbook/write.html\">글쓰기</a></td>");
			out.println("  	</tr>");
			out.println("  </table>");
			out.println("  <table class=\"table table-active\">");
			while (rs.next()) {
			out.println("    <tbody style border=\\\"solid 1px\\\" >");
			out.println("      <tr>");
			out.println("        <td>작성자 : "+rs.getString("name")+"</td>");
			out.println("        <td style=\"text-align: right;\">"+rs.getString("logtime").substring(0, 10)+"</td>");
			out.println("      </tr>");
			out.println("      <tr>");
			out.println("        <td colspan=\"2\"><strong>"+rs.getString("seq")+". "+ rs.getString("subject") + "</strong></td>");
			out.println("      </tr>");
			out.println("      <tr>");
			out.println("        <td colspan=\"2\">"+rs.getString("content")+"</td>");
			out.println("      </tr>");
			out.println("    </tbody>");
			}
			out.println("  </table>");
			out.println("  </div>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
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

	

	}

}
