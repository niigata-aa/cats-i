<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト確認画面</title>
</head>
<body>
	ログアウト確認画面<br>
	<h1>ログアウト</h1><hr>
	ログアウトしますか?<br>
	<form action="logout" method="post">
		<input type="submit" value="はい">
	</form>
	<form action="return" method="post">
		<input type="submit" value="いいえ">
	</form>
</body>
</html>