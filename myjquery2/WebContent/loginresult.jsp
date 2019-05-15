<%@page import="com.kitri.service.CustomerService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%String result = (String) request.getAttribute("result");
 	String str="";%>
 
 <%if(result.equals("1")){
		str += "로그인 성공";
 	} else {
 		str+="로그인 실패";
 	}
 %>
<%=str%>