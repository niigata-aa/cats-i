<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メインメニュー</title>
<link rel ="stylesheet" href="style/menuStyle.css">
</head>
<body>
	<%@ include file="headerLink.jsp"%>
	
	<%=session.getAttribute("LoginID")%>さんようこそ。

<div class="move">
	<form action="goSearchKeeper" method="post">
		<input type="submit" value="飼育員検索画面へ" class="button"><br>
	</form></div>

<div class="move"><form action="goKarteHome" method="post">
		<input type="submit" value="カルテホーム画面へ" class="button">
	</form></div>

	<div class="move"><%
	String idhead = (String) session.getAttribute("postID");
	if (idhead.equals("10")) {
	%>
	<form action="goRegistKeeper" method="post">
		<input type="submit" value="飼育員登録画面へ" class="button">
	</form>
	<%
	}
	%></div>
</body>
</html>
