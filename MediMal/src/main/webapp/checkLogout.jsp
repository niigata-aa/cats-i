<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト確認画面</title>
<link rel ="stylesheet" href="style/checkLogoutStyle.css">
</head>
<body>
<div class="logout">
	<div class="lo"><h1>ログアウト</h1>
	ログアウトしますか?<br></div>
	<form action="logout" method="post">
		<input type="submit" value="はい" class="yn1">
	</form>
	<form action="return" method="post">
		<input type="submit" value="いいえ" class="yn2">
	</form></div>
</body>
</html>