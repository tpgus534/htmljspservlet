<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>포함 지시자</h3>
<%@include file ="loginresult.jsp"%>
<hr>
<h3>포함 태그</h3>
<jsp:include page="loginresult.jsp"></jsp:include>
</body>
</html>