package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ggd")
public class Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	
	@Override
	public void init() throws ServletException {

		
	}

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		
		out.println("<html>");
		out.println("<body align=\"center\">");
		out.println("<font size=\"20\">***±¸±¸´Ü***</font>");
		out.println("<table  align=\"center\" border=\"1px solid\">");
		
		for (int i = 1; i < 10; i++) {
			out.println("<tr>");
			
			for (int j = 2; j < 10; j++) {
				String color = (j%2==0)? "pink":"steelblue";
				out.println("<td style=\"background-color:"+color+"\""+">"+j+ "x"+ i+" = "+i*j+ "</td>");
			}
			out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
