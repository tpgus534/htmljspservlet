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


@WebServlet("/addcart")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		String quantity = request.getParameter("quantity");
		 HttpSession session = request.getSession();
		 Map<Product, Integer> c = (Map<Product, Integer>)session.getAttribute("cart");
		 if (c==null) {
			 c = new HashMap<Product, Integer>();
			 session.setAttribute("cart", c);			
		}
		Product p = new Product();
		p.setProd_no(no);
		int intQuantity = Integer.parseInt(quantity);
		
		Integer inte = c.get(p);
		if (inte != null) {
			intQuantity += inte.intValue();
		}
		c.put(p, intQuantity);
		
		String path = "/addcartresult.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		/*
		 * System.out.println("장바구니내용"); Set<Product> keys = c.keySet(); for (Product
		 * key : keys) { int q = c.get(key); System.out.println("상품번호 :"+
		 * key.getProd_no()+", 수량 :"+ q); }
		 */
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
