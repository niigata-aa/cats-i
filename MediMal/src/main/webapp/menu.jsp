<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メインメニュー</title>
</head>
<body>
	<%@ include file="header.jsp" %>

	<%=session.getAttribute("LoginID") %>さんようこそ。
	
	
	<form action="goSearchKeeperServlet" method="post">
		<input type="submit" value="飼育員検索画面へ"><br>
	</form>
	
	<form action="goKarteHomeServlet" method="post">
		<input type="submit" value="カルテホーム画面へ">
	</form>	
</body>
</html>