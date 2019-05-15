<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first.jsp</title>
</head>
<body>
첫번쨰 JSP입니다.
<%int i;
	i=99;%>
<%=i%>
<%! int i; %>
i=<%=i %>,this.i=<%=this.i %>
<br>
<ul>
	<li>page directive : 속성 -contentType, import, errorPage, isErrorPage, buffer
		<%Date dt = new Date();
		  String patten = "yyyy-MM-dd";
		  SimpleDateFormat sdf = new SimpleDateFormat(patten);
		  %>
		  <%=sdf.format(dt)%>
	</li>
	<li>include directive :정적 포함 속성-file</li>
	<li>taglib directive</li>
</ul>
<br>
<h3>ACTION TAG</h3>
<ul>
	<li>STANDARD Action Tag</li>
	<ol>
		<li>jsp:include : 동적 포함(실행결과에 포함) , 속성-page </li>
		<li>jsp:forward</li>
		<li>jsp:param</li>
		<li>jsp:useBean</li>
		<li>jsp:setProperty</li>
		<li>jsp:getProperty</li>
	</ol>
	<li>CUSTOM Action Tag</li>
</ul>
</body>
</html>