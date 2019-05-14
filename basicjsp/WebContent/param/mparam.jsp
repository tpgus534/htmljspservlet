<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    response.setContentType("text/html;charset=UTF-8");
    String name = request.getParameter("name");
	String id = request.getParameter("id");
	int age = Integer.parseInt(request.getParameter("age"));
	String[] fruit = request.getParameterValues("fruit");
    %>
    <%String color = age == 10 ? "pink" : "cyan"; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=name%><font color ='<%=color%>'><%=id%></font>님 안녕하세요.
<%
if (fruit == null) {
			out.println("좋아하는 과일은 없습니다.");
		} else {
			int len = fruit.length;
			out.println("좋아하는 과일은 ");
			out.print(fruit[0]);
			if (len > 1) {
				for (int i = 1; i < len; i++) {
					out.print(", " + fruit[i]);
				}
			}
			out.print("입니다");
		}
%>
</body>
</html>