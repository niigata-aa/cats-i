<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カルテホーム画面</title>
<link rel ="stylesheet" href="style/karteHomeStyle.css">
</head>
<body>
	<%@ include file="headerLink.jsp"%>
	<div class="move">
	<form action="goSearchAnimal" method="post">
		<input type="submit" value="動物検索画面へ" class="button">
	</form></div>

	<%
	String idhead = (String) session.getAttribute("postID");
	if (idhead.equals("20")) {
	%>
	<div class="move">
	<form action="goRegistAnimal" method="post">
		<input type="submit" value="動物登録画面へ" class="button">
	</form></div>
	<%
	}
	%>
	<%
		String returnURL = "karteHome.jsp";
		session.setAttribute("returnURL", returnURL);
	%>
</body>
</html>