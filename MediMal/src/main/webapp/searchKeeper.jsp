<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飼育員検索画面</title>
</head>
<body>
	<%@ include file="header.jsp" %>>

	<form action="searchKeeper" method="post">
		<input type="submit" value="一覧表示">
	</form>
	
	<form action="searchKeeper" method="post">
		飼育員ID :
		<input type="text" name="empID">キーワードを入力してください<br>
		性 :
		<input type="text" name="keeperLastName">キーワードを入力してください<br>
		名 :
		<input type="text" name="keeperFirstName">キーワードを入力してください<br>
		担当エリア :
		<input type="text" name="areaName">キーワードを入力してください<br>
		担当動物種族 :
		<input type="text" name="animalType">キーワードを入力してください
		<input type="submit" value="検索">
	</form>	
</body>
</html>