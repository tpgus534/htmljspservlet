package com.kitri.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kitri.dto.Product;
import com.kitri.service.ProductService;


@WebServlet("/viewcart")
public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService ps;
	public ViewCartServlet() {
		ps = new ProductService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Map<Product, Integer> c = (Map<Product, Integer>)session.getAttribute("cart");
		Map<Product, Integer> rc = new HashMap<Product, Integer>();
		
		if (c!=null) {
			Set<Product> keys = c.keySet();
			for (Product p:keys) {
				String no = p.getProd_no();
				Product p1 = ps.findByNo(no);
				
				int quantitiy = c.get(p);
				rc.put(p1, quantitiy);
			}
			request.setAttribute("rcart", rc);
			String path = "/viewcartresult.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
			System.out.println("viewcart c is exsist");
		}else {
			System.out.println("viewcart c is null");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
