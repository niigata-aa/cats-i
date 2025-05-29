<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カルテホーム画面</title>
</head>
<body>
	<%@ include file="headerLink.jsp"%>
	<form action="goSearchAnimalServlet" method="post">
		<input type="submit" value="動物検索画面へ">
	</form>

	<%
	String idhead = (String) session.getAttribute("postID");
	if (idhead.equals("20")) {
	%>
	<form action="goRegistAnimal" method="post">
		<input type="submit" value="動物登録画面へ">
	</form>
	<%
	}
	%>
</body>
</html>