<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		var aArr = $("nav>ul>li>a");
		$(aArr).click(function() {
			var vurl = $(this).attr("href");
			if (vurl == "logout") {
				$.ajax({
					url:vurl,
					method:"get",
					success:function(result){
						location.href="semantic.jsp";
					}
				});
			} else {
			$.ajax({
				url:vurl,
				method:"get",
				success:function(result){
					$("section").html(result);
				}
			});
			}
			return false;
		});
		
	});
</script>
<style>
header {
	background-image:
		url(https://t1.daumcdn.net/cfile/tistory/9966974B5B400C8328);
	color: white;
}

nav>ul {
	list-style: none;
	padding:0;
	
}
ul>li {
	
	display:inline-block;
}
footer{
	position: fixed;
	bottom: 0px; 
	width: 100%;
	background-color: gray;
}
</style>
</head>
<body>
	<header>
		<h1>타노스</h1>
	</header>
	<nav>MANU
	<jsp:include page="menu.jsp"/>

	</nav>
	<section>본문</section>
	<footer>사업자등록</footer>
</body>
</html>