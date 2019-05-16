<%@page import="com.kitri.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<Product> list = (List<Product>) request.getAttribute("list");
%>
<script type="text/javascript">
	$(function() {
		$('.product').click(function() {
			console.log(1);
			$.ajax({
				url : "productinfo",
				method : "get",
				data : "no=" + $(this).attr("value"),
				success : function(result) {
					$("section").html(result);
				}
			});
		});
	});
</script>
<div>
	<%
		for (int i = 0; i < list.size(); i++) {
			Product p = list.get(i);
	%>
	<div style='border: solid 1px; display: inline-block;' value='<%=p.getProd_no()%>' class='product'>
		<div>
			<img src="image/<%=p.getProd_no()%>.jpg">
		</div>
		<div style='display: inline-block;'>
			상품 종류 :
			<%=p.getProductCategory().getCate_name()%><br> 상품 번호 :
			<%=p.getProd_no()%><br> 상품 이름 :
			<%=p.getProd_name()%><br> 상품 가격 :
			<%=p.getProd_price()%><br>
		</div>
	</div>
	<%
		}
	%>
</div>