<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メインメニュー</title>
</head>
<body>
	<%@ include file="headerLink.jsp"%>
	
	<%=session.getAttribute("LoginID")%>さんようこそ。


	<form action="goSearchKeeper" method="post">
		<input type="submit" value="飼育員検索画面へ"><br>
	</form>

	<form action="goKarteHome" method="post">
		<input type="submit" value="カルテホーム画面へ">
	</form>

	<%
	String idhead = (String) session.getAttribute("postID");
	if (idhead.equals("10")) {
	%>
	<form action="goRegistKeeper" method="post">
		<input type="submit" value="飼育員登録画面へ">
	</form>
	<%
	}
	%>
</body>
</html>
