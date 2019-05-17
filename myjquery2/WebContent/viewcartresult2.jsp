<%@page import="java.util.Set"%>
<%@page import="com.kitri.dto.Product"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%Map<Product, Integer> c = (Map<Product, Integer>)request.getAttribute("rcart");%>
<div>
<%Set<Product> keys = c.keySet();
for(Product p:keys){%>
	<div style='border: solid 1px; display: inline-block;' value='<%=p.getProd_no()%>' class='product'>
		<div>
			<img src="image/<%=p.getProd_no()%>.jpg">
		</div>
		<div style='display: inline-block;'>
			상품 종류 :<%=p.getProductCategory().getCate_name()%><br>
			상품 번호 :<%=p.getProd_no()%><br>
			상품 이름 :<%=p.getProd_name()%><br>
			상품 가격 :<%=p.getProd_price()%><br>
			상품 수량 :<%=c.get(p)%>
		</div>
	</div>
<%}%>
</div>
