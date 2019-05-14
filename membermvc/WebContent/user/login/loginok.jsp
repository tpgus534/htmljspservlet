<%@page import="com.kitri.util.MoveUrl"%>
<%@page import="com.kitri.member.model.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templet/header.jsp"%>
<%MemberDto memberdto = (MemberDto) session.getAttribute("userInfo");
if(memberdto !=null){
%>

<<script type="text/javascript">
function deleteMember(){
	if (confirm("정말로 탈퇴?")) {
		document.location.href = "<%=root%>/user?act=deletemember";
	}
}
</script>
<%=memberdto.getId()%> 안녕하세요
<a href="<%=root%>/user?act=logout";>로그아웃</a>
<a href="<%=root%>/user?act=mvmodify";>정보수정</a>
<a href="#" onclick="javascript:deleteMember();">회원탈퇴</a>
<%
if("java2".equals(memberdto.getId())){
	
}
%>
<a href="<%=root%>/admin?act=memberlist";>관리자</a>
<%} else {
	MoveUrl.redirect(request, response, "/user?act=mvlogin");
}
%>
<%@ include file="/templet/footer.jsp"%>