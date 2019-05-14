package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/singleparam")
public class SingleParamterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//	1.dataget
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		int age	= Integer.parseInt(request.getParameter("age"));
	//	2.logic
		String  color = age == 10?"pink":"cyan";
		
		
	//	3.response page : æ»»ø¿Œ(java2)¥‘ æ»≥Á«œººø‰.
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println(name + "("+ "<font color = \"" +color + "\">" + id + "</font>" + ")¥‘ æ»≥Á«œººø‰.");
		out.println("</body>");
		out.println("</html>");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		doGet(req, resp);
	}

}