package com.kitri.basic;

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

@WebServlet("/DbCounter")
public class DbCounter extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static final long serialVersionUID = 1L;

	int count;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.36:1521:orcl","project1","project1");
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
		
		
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String str = String.valueOf(count);
		int a = str.length();
		int zero = 8-a;
		
		
		
		out.println("<html>");
		out.println("<body>");
		for (int i = 0; i < zero; i++) {
			out.println("<img src=\"/basicservlet/img/0.PNG\">");
		}
		for (int i = 0; i < a; i++) {
			out.println("<img src=\"/basicservlet/img/"+str.charAt(i)+".PNG\">");
		}
		out.println("</body>");
		out.println("</html>");
	}

}
