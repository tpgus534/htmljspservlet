package com.kitri.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/life")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public LifeCycle() {
	System.out.println("������ ȣ��Ǿ���");
	}
       
	@Override
	public void init() throws ServletException {
		System.out.println("init�̶�� �޼ҵ尡 ȣ��Ǿ���.");
	}
	
   
	@Override
	public void destroy() {
		System.out.println("destroy ȣ��");
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() ȣ��!");
	}
}
