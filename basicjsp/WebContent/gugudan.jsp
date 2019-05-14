<%@page import="com.sun.prism.paint.Color"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!int i;
	int j;
	String str = i + "x" + j + "=" + i * j;

	public String ggd(int i, int j) {
		return str;
	}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>***구단***</h3>
		<table align="center" border="1px solid">
			<%
				for (i = 1; i < 10; i++) {
					%><tr><%
					for (j = 2; j < 10; j++) {
						%><td><%=ggd(i, j)%></td><%
					}
					%></tr><%
				}
			%>
		</table>
		<hr>
	</div>
</body>
</html>