package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.text.normalizer.CharTrie.FriendAgent;

@WebServlet("/multiparam")
public class MultiParameterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
		String color = age == 10 ? "pink" : "cyan";
		
		String[] fruit = request.getParameterValues("fruit");

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println(name + "(<font color =\"" + color + "\">" + id + "</font>)�� �ȳ��ϼ���<br>");

		if (fruit == null) {
			out.println("�����ϴ� ������ �����ϴ�.");
		} else {
			int len = fruit.length;
			out.println("�����ϴ� ������ ");
			out.print(fruit[0]);
			if (len > 1) {
				for (int i = 1; i < len; i++) {
					out.print(", " + fruit[i]);
				}
			}
			out.print("�Դϴ�");
			out.println("</body>");
			out.println("</html>");
		}

	}
}
