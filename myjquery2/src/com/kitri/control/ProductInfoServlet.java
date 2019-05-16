package com.kitri.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.dto.Product;
import com.kitri.service.ProductService;


@WebServlet("/productinfo")
public class ProductInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String no = request.getParameter("no");
		System.out.println(no);
		ProductService ps = new ProductService();
		Product p = ps.findByNo(no);
		request.setAttribute("product", p);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/productInfoResult.jsp");
		dispatcher.forward(request, response);
	}


}
