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
	System.out.println("생성자 호출되었따");
	}
       
	@Override
	public void init() throws ServletException {
		System.out.println("init이라는 메소드가 호출되었다.");
	}
	
   
	@Override
	public void destroy() {
		System.out.println("destroy 호출");
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 호출!");
	}
}
