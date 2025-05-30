<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飼育員検索画面</title>
</head>
<body>
	<%@ include file="headerLink.jsp"%>
	<h1>飼育員検索画面</h1>
	
	<form action="searchAllKeeper" method="post">
		<input type="submit" value="一覧表示">
	</form>
	
	<form action="SearchKeeper" method="post">
		飼育員ID :
		<input type="text" name="empID" placeholder="キーワードを入力"><br>
		性 :
		<input type="text" name="keeperLastName" placeholder="キーワードを入力"><br>
		名 :
		<input type="text" name="keeperFirstName" placeholder="キーワードを入力"><br>
		担当エリア :
		<input type="text" name="areaName" placeholder="キーワードを入力"><br>
		担当動物種族 :
		<input type="text" name="animalType" placeholder="キーワードを入力">
		<input type="submit" value="検索">
	</form>	
</body>
</html>