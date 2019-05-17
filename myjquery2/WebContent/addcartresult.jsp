<%@page import="com.kitri.dto.Product"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script>
    $(function(){
    	var arr = $("div.addcartresult>button");
    	$(arr[0]).click(function() {
    		alert("상품목록으로 가기");
    	$("nav>ul>li>a[href=productlist]").trigger("click");
    	return false;
    	});
    	$(arr[1]).click(function() {
			$("nav>ul>li>a[href=viewcart]").trigger("click");
		});
    });
    	
    </script>
<div class="addcartresult" style="position:absolute;top:400px;left: 600px; width:250px; border:1px solid">
장바구니에 넣었습니다.
<button>상품목록으로 가기</button>
<button>장바구니 보기</button>
</div>