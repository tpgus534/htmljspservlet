<%@page import="com.kitri.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Product p = (Product) request.getAttribute("product");
%>
<script>
$(function(){
	$("ul>li>button").click(function() {
		$.ajax({
			url:"addcart",
			method:"get",
			data: $("input").serialize(),
			success:function(result){
				$("div.addcartresult").remove();
				$("section").append(result.trim());
			}
		});
	});
	
});

</script>
<div style='height: 400px; position: relative;'>
	<img src="image/<%=p.getProd_no()%>.jpg"
		style="float: left; padding-right: 50px";>&nbsp;

	<h2><%=p.getProd_name()%></h2>
	<br>
	<%=p.getProd_detail()%>
	<br>

	<input type="hidden" name="no" value="<%=p.getProd_no()%>">
		<ul>
			<li>상품 번호 :<%=p.getProd_no()%></li>
			<li>가격 : <%=p.getProd_price()%></li>
			<li>수량 : <input type='number' name='quantity' value='1' min='1'
				max='99'></li>
			<li><button>장바구니 넣기</button></li>
		</ul>

</div>