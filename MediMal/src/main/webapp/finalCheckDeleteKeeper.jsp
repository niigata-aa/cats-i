<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員削除（最終確認画面）</title>
</head>
<body>
	<p>※【最終確認】従業員情報を削除しますか？</p>
	<form action="finalDeleteKeeperCheck" method="post">
	<input type="submit" value="はい">
	</form>
	<form action="updateKeeper.jsp" method="post">
	<input type="submit" value="いいえ">
	</form>
</body>
</html>