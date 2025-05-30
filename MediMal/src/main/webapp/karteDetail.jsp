<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カルテ詳細画面</title>
</head>
<body>

	<%@include file="headerLink.jsp" %>
	<h1>カルテ詳細画面</h1>

	<form action="goInputWeight" method="post">
	<input type="submit" value="体重記録ボタン">
	</form>
	
	<form action="goInputFeed" method="post">
	<input type="submit" value="食事記録ボタン">
	</form>
	
	<form action="goInputComment" method="post">
	<input type="submit" value="コメント記入ボタン">
	</form>
	
<!--	<form action="goInputKarte" method="post">-->
<!--	<input type="submit" value="カルテ情報(投薬・出産)記録ボタン">-->
<!--	</form>-->

	<form action="goInputFeed" method="post">
	<input type="submit" value="記録食事記録ボタン">
	</form>
</body>
</html>