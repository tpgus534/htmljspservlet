<%@page contentType="text/html; charset=UTF-8"%>
<ul>
	<%
		String id = (String) session.getAttribute("loginInfo");
		if (id == null) {
	%>
	<li><a href="user/login.html">로그인</a></li>
	<li><a href="user/member.html">가입</a></li>
	<%
		} else {
	%>
	<li><a href="productlist">상품목록</a></li>
	<li><a href="viewcart">장바구니보기</a></li>
	<li><a href="logout">로그아웃</a></li>
	<%
		}
	%>
	
</ul>
