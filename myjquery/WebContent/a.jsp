<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-08"); %>
<%String id = request.getParameter("id");
String name = request.getParameter("name");
%>
<% Thread.sleep(1*1000);%>
응답 결과입니다.
<%=id%>(<%=name%>)님 반갑습니다.
