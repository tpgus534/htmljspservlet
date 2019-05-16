<%@page import="com.kitri.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%Product p = (Product)request.getAttribute("product");%>

<div style='height: 400px; position: relative;'>
	<img src="image/<%=p.getProd_no()%>.jpg" style="float:left; padding-right: 50px";>&nbsp;

	<h2><%=p.getProd_name()%></h2>
	<br>
	<%=p.getProd_detail() %>
	<br>
	<span>
	상품 번호 :<%=p.getProd_no()%><br>
	가격 : <%=p.getProd_price()%><br>
	수량 : <select>			
			<option>수량을 입력해주세요</option>	
			<option value="1">1</option>	
			<option value="2">2</option>	
			<option value="3">3</option>	
			<option value="4">4</option>	
			<option value="5">5</option>	
			<option value="6">6</option>	
			<option value="7">7</option>	
			<option value="8">8</option>	
			<option value="9">9</option>	
			<option value="10">10</option>	
		 </select>
		 </span>
</div>