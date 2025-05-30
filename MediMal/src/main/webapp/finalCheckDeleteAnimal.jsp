<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.AnimalBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物削除（最終確認画面）</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<p>※【最終確認】動物情報を削除しますか？</p>
	<form action="finalDeleteAnimalCheck" method="post">
		<input type="submit" value="はい">
	</form>
	<form action="updateKeeper.jsp" method="post">
		<input type="submit" value="いいえ">
	</form>
</body>
</html>