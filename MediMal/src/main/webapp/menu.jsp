<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メインメニュー</title>
</head>
<body>
	<%=session.getAttribute("LoginID") %>さんようこそ。
	
	
	<form action="goSearchKeeperServlet" method="post">
		<input type="submit" value="飼育員検索">
	</form>
	
</body>
</html>